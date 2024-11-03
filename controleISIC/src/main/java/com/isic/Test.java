package com.isic;

import com.isic.entities.Assignation;
import com.isic.entities.Vehicule;
import com.isic.services.AssignationService;
import com.isic.services.VehiculeService;

import java.util.List;

public class Test {

    public static void main(String[] args) {
        AssignationService aService = new AssignationService();
        VehiculeService vService = new VehiculeService();
        Assignation a = aService.getAssignationByVehiculeId(1L);
        List<Vehicule> vehicules = vService.getAssignedVehicules();

        System.out.println(a);
    }

}
