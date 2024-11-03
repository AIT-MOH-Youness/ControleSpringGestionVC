package com.isic.controllers;

import com.isic.entities.Assignation;
import com.isic.entities.Conducteur;
import com.isic.entities.ConducteurVehiculePK;
import com.isic.entities.Vehicule;
import com.isic.repositories.AssignationRepository;
import com.isic.repositories.ConducteurRepository;
import com.isic.repositories.VehiculeRepository;
import com.isic.services.AssignationService;
import com.isic.services.ConducteurService;
import com.isic.services.VehiculeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

@Controller
public class AssignationController {

    @Autowired
    private AssignationService aService;

    @Autowired
    private VehiculeService vService;

    @Autowired
    private ConducteurService cService;

    @GetMapping("/toutAssignations")
    public String toutAssignation(Assignation assignation, Model model) {
        model.addAttribute("vehicles", vService.getNonAssignedVehicules());
        model.addAttribute("drivers", cService.getAllConducteurs());
        model.addAttribute("conducteurs", cService.getLastConducteurs(2));
        model.addAttribute("vehicules", vService.getLastVehicules(2));
        model.addAttribute("assignations", aService.getAllAssignations());
        return "all-assignations";
    }


    @GetMapping("/setAssignation")
    public String showAssignationParam(Assignation assignation, Model model) {
        model.addAttribute("vehicles", vService.getNonAssignedVehicules());
        model.addAttribute("drivers", cService.getAllConducteurs());
        model.addAttribute("conducteurs", cService.getLastConducteurs(2));
        model.addAttribute("vehicules", vService.getLastVehicules(2));
        model.addAttribute("assignations", aService.getLastAssignations(3));
        return "create-assignation";
    }

    @GetMapping("/setCustomAssignation")
    public String customAssignationParam(Assignation assignation, Model model) {
        model.addAttribute("vehicles", vService.getNonAssignedVehicules());
        model.addAttribute("drivers", cService.getAllConducteurs());
        model.addAttribute("conducteurs", cService.getLastConducteurs(2));
        model.addAttribute("vehicules", vService.getLastVehicules(2));
        model.addAttribute("assignations", aService.getLastAssignations(3));
        return "create-custom-assignation";
    }

    @PostMapping("/addAssignation")
    public String addAssignation(@RequestParam("vehicleId") Long vehicleId,
                                 @RequestParam("driverId") Long driverId, Model model) {

        ConducteurVehiculePK pk = new ConducteurVehiculePK() ;
        pk.setDateDebut(new Date());
        pk.setVehicule(vehicleId);
        pk.setConducteur(driverId);
        Vehicule vehicule = vService.getVehiculeById(vehicleId);
        Conducteur conducteur = cService.getConducteurById(driverId);
        conducteur.addVehiculeAssigne(vehicule);
        vehicule.setConducteur(conducteur);
        vehicule.setEtat("assigné");
        Assignation assignation = new Assignation(pk,vehicule,conducteur,null);
        aService.saveAssignation(assignation);
        model.addAttribute("conducteurs", cService.getLastConducteurs(2));
        model.addAttribute("vehicules", vService.getLastVehicules(2));
        model.addAttribute("assignations", aService.getLastAssignations(3));
        return "index";
    }

    @PostMapping("/addCustomAssignation")
    public String addCustomAssignation(@RequestParam("vehicleId") Long vehicleId,
                                       @RequestParam("driverId") Long driverId,
                                       @RequestParam("dateDebut") String dD,
                                       @RequestParam("dateFin") String dF,
                                       Model model) {

        ConducteurVehiculePK pk = new ConducteurVehiculePK();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date dateDebut = null;
        try {
            dateDebut = formatter.parse(dD);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        Date dateFin = null;
        try {
            dateFin = formatter.parse(dF);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        pk.setDateDebut(dateDebut);
        pk.setVehicule(vehicleId);
        pk.setConducteur(driverId);
        Vehicule vehicule = vService.getVehiculeById(vehicleId);
        Conducteur conducteur = cService.getConducteurById(driverId);
        conducteur.addVehiculeAssigne(vehicule);
        vehicule.setEtat("assigné dernierement (custom)");
        Assignation assignation = new Assignation(pk,vehicule,conducteur,dateFin);
        aService.saveAssignation(assignation);
        model.addAttribute("conducteurs", cService.getLastConducteurs(2));
        model.addAttribute("vehicules", vService.getLastVehicules(2));
        model.addAttribute("assignations", aService.getLastAssignations(3));
        return "index";
    }

    @GetMapping("/suppAssignation")
    public String suppUneAssignation(Assignation assignation, Model model) {
        model.addAttribute("assignations", aService.getAssignationsNotEnded());
        model.addAttribute("vehicles", vService.getAssignedVehicules());
        model.addAttribute("conducteurs", cService.getLastConducteurs(2));
        model.addAttribute("vehicules", vService.getLastVehicules(2));
        return "end-assignation";
    }

    @PostMapping("/deleteAssignation")
    public String dltAssignation(@RequestParam("vehiId") Long vehiId,
                                 @RequestParam("cdId") Long cdId, Model model) {

        Assignation a = aService.getAssignationByVehiculeId(vehiId);
        a.setDateFin(new Date());
        a.getConducteur().getVehiculeAssigne().remove(a.getConducteur().getVehiculeAssigneById(vehiId));
        a.getVehicule().setEtat("non assigné");
        aService.saveAssignation(a);
        model.addAttribute("conducteurs", cService.getLastConducteurs(2));
        model.addAttribute("vehicules", vService.getLastVehicules(2));
        model.addAttribute("assignations", aService.getLastAssignations(3));
        return "index";
    }





}