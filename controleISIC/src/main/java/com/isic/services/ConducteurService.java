package com.isic.services;

import com.isic.entities.Conducteur;
import com.isic.entities.Vehicule;
import com.isic.repositories.ConducteurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ConducteurService {

    @Autowired
    private ConducteurRepository conducteurRepository;

    public List<Conducteur> getAllConducteurs() {
        return (List<Conducteur>) conducteurRepository.findAll();
    }

    public List<Conducteur> getLastConducteurs(int i) {
        List<Conducteur> conducteurs = (List<Conducteur>) conducteurRepository.findAll();
        if(conducteurs.size()<i){
            i=conducteurs.size();
        }
        List<Conducteur> cs = new ArrayList<Conducteur>();
        for(int j=1;j<=i;j++){
            cs.add(conducteurs.get(conducteurs.size()-j));
        }

        return cs;
    }

    public Conducteur getConducteurById(Long id) {
        return conducteurRepository.findById(id).orElse(null);
    }

    public void saveConducteur(Conducteur conducteur) {
        conducteurRepository.save(conducteur);
    }

    public void deleteConducteur(Conducteur conducteur) {
        conducteurRepository.delete(conducteur);
    }

}
