package com.isic.controllers;

import com.isic.entities.Assignation;
import com.isic.entities.AssignationPK;
import com.isic.entities.Conducteur;
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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ConducteurController {

    @Autowired
    private ConducteurService cService;

    @Autowired
    private AssignationService aService;

    @Autowired
    private VehiculeService vService;

    @GetMapping("/")
    public String allInfo(Model model) {
        model.addAttribute("conducteurs", cService.getLastConducteurs(2));
        model.addAttribute("vehicules", vService.getLastVehicules(2));
        model.addAttribute("assignations", aService.getLastAssignations(3));
        return "index";
    }

    @GetMapping("/toutLesConducteurs")
    public String showAllConducteurs(Conducteur conducteur, Model model) {
        model.addAttribute("conducteurs", cService.getAllConducteurs());
        model.addAttribute("vehicules", vService.getLastVehicules(2));
        model.addAttribute("assignations", aService.getLastAssignations(3));
        return "all-conducteurs";
    }

    @GetMapping("/ajouterConducteur")
    public String showAddConducteur(Conducteur conducteur, Model model) {
        model.addAttribute("conducteurs", cService.getLastConducteurs(2));
        model.addAttribute("vehicules", vService.getLastVehicules(2));
        model.addAttribute("assignations", aService.getLastAssignations(3));
        return "add-conducteur";
    }

    @PostMapping("/addConducteur")
    public String addConducteur(@Validated Conducteur conducteur, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "add-conducteur";
        }
        cService.saveConducteur(conducteur);
        model.addAttribute("conducteurs", cService.getLastConducteurs(2));
        model.addAttribute("vehicules", vService.getLastVehicules(2));
        model.addAttribute("assignations", aService.getLastAssignations(3));
        return "redirect:/toutLesConducteurs";
    }

    @GetMapping("/editConducteur/{id}")
    public String editConducteur(@PathVariable("id")long id, Model model) {
        Conducteur conducteur = cService.getConducteurById(id);
        model.addAttribute("conducteur", conducteur);
        model.addAttribute("conducteurs", cService.getLastConducteurs(2));
        model.addAttribute("vehicles", conducteur.getVehiculeAssigne());
        model.addAttribute("vehicules", vService.getLastVehicules(2));
        model.addAttribute("assignations", aService.getLastAssignations(3));
        return "update-conducteur";
    }
    
    
    @PostMapping("/updateConducteur/{id}")
    public String updateConducteur(@PathVariable("id") long id, @Validated Conducteur conducteur, BindingResult result, Model model) {
        if (result.hasErrors()) {
            conducteur.setId(id);
            return "update-conducteur";
        }
        cService.saveConducteur(conducteur);
        model.addAttribute("conducteurs", cService.getAllConducteurs());
        model.addAttribute("conducteurs", cService.getLastConducteurs(2));
        model.addAttribute("vehicules", vService.getLastVehicules(2));
        model.addAttribute("assignations", aService.getLastAssignations(3));
        return "redirect:/toutLesConducteurs";
    }

    @GetMapping("/vehiculesDeConducteur/{id}")
    public String vehiculesDeConducteur(@PathVariable("id") long id,
                                        Assignation assignation, Model model) {

        Conducteur conducteur = cService.getConducteurById(id);
        model.addAttribute("vehicles", cService.getConducteurById(id).getVehiculeAssigne());
        model.addAttribute("driver", conducteur);
        model.addAttribute("conducteurs", cService.getLastConducteurs(2));
        model.addAttribute("vehicules", vService.getLastVehicules(2));
        model.addAttribute("assignations", aService.getAllAssignations());
        return "vehicules-deconducteur";
    }
    
    
    @GetMapping("/deleteConducteur/{id}")
    public String deleteConducteur(@PathVariable("id") long id, Model model) {
        Conducteur conducteur = cService.getConducteurById(id);
        cService.deleteConducteur(conducteur);
        model.addAttribute("conducteurs", cService.getLastConducteurs(2));
        model.addAttribute("vehicules", vService.getLastVehicules(2));
        model.addAttribute("assignations", aService.getLastAssignations(3));
        return "redirect:/toutLesConducteurs";
    }





}