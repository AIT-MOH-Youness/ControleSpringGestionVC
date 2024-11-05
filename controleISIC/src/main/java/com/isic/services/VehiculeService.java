package com.isic.services;

import com.isic.entities.Assignation;
import com.isic.entities.Conducteur;
import com.isic.entities.Vehicule;
import com.isic.repositories.VehiculeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class VehiculeService {

    @Autowired
    private VehiculeRepository vehiculeRepository;

    public List<Vehicule> getAllVehicules() {
        return (List<Vehicule>) vehiculeRepository.findAll();
    }

    public Vehicule getVehiculeById(Long id) {
        return vehiculeRepository.findById(id).orElse(null);
    }

    public void saveVehicule(Vehicule vehicule) {
        vehiculeRepository.save(vehicule);
    }

    public List<Vehicule> getAssignedVehicules() {
        List<Vehicule> vehicules = new ArrayList<Vehicule>();
        for(Vehicule v : vehiculeRepository.findAll()){
            if(v.getEtat().equals("assigné")){
                vehicules.add(v);
            }
        }
        return vehicules;
    }

    public List<Vehicule> getNonAssignedVehicules() {
        List<Vehicule> vehicules = new ArrayList<Vehicule>();
        for(Vehicule v : vehiculeRepository.findAll()){
            if(v.getEtat().equals("non assigné") || v.getEtat().equals("assigné dernierement (custom)")){
                vehicules.add(v);
            }
        }
        return vehicules;
    }

    public List<Vehicule> getLastVehicules(int i) {
        List<Vehicule> vehicules = (List<Vehicule>) vehiculeRepository.findAll();
        if(vehicules.size()<i){
            i=vehicules.size();
        }
        List<Vehicule> as = new ArrayList<Vehicule>();
        for(int j=1;j<=i;j++){
            as.add(vehicules.get(vehicules.size()-j));
        }
        return as;
    }

    public long getConducteurId() {
        Vehicule vehicule = new Vehicule();
        Long l = vehicule.getConducteur().getId();
        return l;
    }

    public List<Vehicule> findByConducteurId(long l) {
        List<Vehicule> vehicules = new ArrayList<>();
        for(Vehicule v : vehiculeRepository.findAll()){
            if(v.getConducteur().getId()==l){
                vehicules.add(v);
            }
        }
        return vehicules;
    }

    public void deleteVehicule(Vehicule vehicule) {
        vehiculeRepository.delete(vehicule);
    }


}
