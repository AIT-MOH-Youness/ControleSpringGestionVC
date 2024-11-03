package com.isic.services;

import com.isic.entities.Assignation;
import com.isic.entities.Conducteur;
import com.isic.entities.Vehicule;
import com.isic.repositories.AssignationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

@Service
public class AssignationService {

    @Autowired
    private AssignationRepository assignationRepository;

    public List<Assignation> getAllAssignations() {
        return (List<Assignation>) assignationRepository.findAll(Sort.by(Sort.Direction.ASC, "pk.dateDebut"));
    }

    public List<Assignation> getAssignationsNotEnded() {
        List<Assignation> assignations = new ArrayList<Assignation>();
        for(Assignation a : this.getAllAssignations()){
            if (a.getDateFin()==null){
                assignations.add(a);
            }
        }
        return assignations;
    }


    public List<Assignation> getLastAssignations(int i) {
        List<Assignation> assignations = this.getAllAssignations();
        if(assignations.size()<i){
            i=assignations.size();
        }
        List<Assignation> as = new ArrayList<Assignation>();
        for(int j=1;j<=i;j++){
            as.add(assignations.get(assignations.size()-j));
        }
        return as;
    }


    public Assignation getAssignationById(Long id) {
        return assignationRepository.findById(id).orElse(null);
    }

    public Assignation getAssignationByVehiculeId(Long id) {
        List<Assignation> assignations = getAllAssignations();
        for(Assignation a : assignations){
            if (a.getVehicule().getId()==id && a.getDateFin()==null)
                return a;
        }
        return null;
    }


    public void saveAssignation(Assignation assignation) {
        assignationRepository.save(assignation);
    }
}
