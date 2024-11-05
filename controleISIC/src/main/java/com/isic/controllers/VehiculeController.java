package com.isic.controllers;

import com.isic.entities.Assignation;
import com.isic.entities.AssignationPK;
import com.isic.entities.Conducteur;
import com.isic.entities.Vehicule;
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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class VehiculeController {

    @Autowired
    private VehiculeService vService;

    @Autowired
    private AssignationService aService;

    @Autowired
    private ConducteurService cService;


    @GetMapping("/ajouterVehicule")
    public String showSignUpForm(Vehicule vehicule, Model model) {
        model.addAttribute("conducteurs", cService.getLastConducteurs(2));
        model.addAttribute("vehicules", vService.getLastVehicules(2));
        model.addAttribute("assignations", aService.getLastAssignations(3));
        return "add-vehicule";
    }

    @GetMapping("/toutLesVehicules")
    public String showAllVehicules(Conducteur conducteur, Model model) {
        model.addAttribute("conducteurs", cService.getAllConducteurs());
        model.addAttribute("vehicules", vService.getAllVehicules());
        model.addAttribute("assignations", aService.getLastAssignations(3));
        return "all-vehicules";
    }

    @PostMapping("/addVehicule")
    public String addVehicule(@Validated Vehicule vehicule, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "add-vehicule";
        }
        vehicule.setEtat("non assigné");
        vService.saveVehicule(vehicule);
        model.addAttribute("conducteurs", cService.getLastConducteurs(2));
        model.addAttribute("vehicules", vService.getLastVehicules(2));
        model.addAttribute("assignations", aService.getLastAssignations(3));
        return "redirect:/toutLesVehicules";
    }


    @GetMapping("/editVehicule/{id}")
    public String editVehicule(@PathVariable("id")long id, Model model) {
        Vehicule vehicule = vService.getVehiculeById(id);
        model.addAttribute("vehicule", vehicule);
        model.addAttribute("conducteurs", cService.getLastConducteurs(2));
        model.addAttribute("vehicules", vService.getLastVehicules(2));
        model.addAttribute("assignations", aService.getLastAssignations(3));
        return "update-vehicule";
    }


    @PostMapping("/updateVehicule/{id}")
    public String updateVehicule(@PathVariable("id") long id, @Validated Vehicule vehicule, BindingResult result, Model model) {
        if (result.hasErrors()) {
            vehicule.setId(id);
            return "update-vehicule";
        }
        vehicule.setEtat(vService.getVehiculeById(id).getEtat());
        vService.saveVehicule(vehicule);
        model.addAttribute("vehicules", vService.getAllVehicules());
        model.addAttribute("conducteurs", cService.getLastConducteurs(2));
        model.addAttribute("vehicules", vService.getLastVehicules(2));
        model.addAttribute("assignations", aService.getLastAssignations(3));
        return "redirect:/toutLesVehicules";
    }


    @GetMapping("/deleteVehicule/{id}")
    public String deleteVehicule(@PathVariable("id") long id, Model model) {
        Vehicule vehicule = vService.getVehiculeById(id);
        vService.deleteVehicule(vehicule);
        model.addAttribute("vehiculers", cService.getAllConducteurs());
        model.addAttribute("conducteurs", cService.getLastConducteurs(2));
        model.addAttribute("vehicules", vService.getLastVehicules(2));
        model.addAttribute("assignations", aService.getLastAssignations(3));
        return "redirect:/toutLesVehicules";
    }





}