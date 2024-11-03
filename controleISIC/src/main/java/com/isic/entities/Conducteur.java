package com.isic.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import java.util.List;

@Entity
@Table(name = "Conducteur")
public class Conducteur {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank(message = "Name is mandatory")
    private String nom;

    private String permis;

    @OneToMany(mappedBy="conducteur",cascade = CascadeType.ALL)
    private List<Vehicule> vehiculeAssigne;

    @OneToMany(mappedBy="conducteur",cascade = CascadeType.ALL)
    private List<Assignation> assignation;


    public Conducteur() {
        super();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public @NotBlank(message = "Name is mandatory") String getNom() {
        return nom;
    }

    public void setNom(@NotBlank(message = "Name is mandatory") String nom) {
        this.nom = nom;
    }

    public String getPermis() {
        return permis;
    }

    public void setPermis( String permis) {
        this.permis = permis;
    }

    public List<Vehicule> getVehiculeAssigne() {
        return vehiculeAssigne;
    }

    public Vehicule getVehiculeAssigneById(Long id) {
        for(Vehicule v : this.getVehiculeAssigne()){
            if(v.getId()==id){
                return v;
            }
        }
        return null;
    }

    public void setVehiculeAssigne(List<Vehicule> vehiculeAssigne) {
        this.vehiculeAssigne = vehiculeAssigne;
    }

    public void addVehiculeAssigne(Vehicule vehiculeAssigne) {
        this.vehiculeAssigne.add(vehiculeAssigne);
    }

    public List<Assignation> getAssignation() {
        return assignation;
    }

    public void setAssignation(List<Assignation> assignation) {
        this.assignation = assignation;
    }

    public void addAssignation(Assignation assignation) {
        this.assignation.add(assignation);
    }
}