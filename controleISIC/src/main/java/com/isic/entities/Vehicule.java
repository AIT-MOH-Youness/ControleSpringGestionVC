package com.isic.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import java.util.List;

@Entity
@Table(name = "Vehicule")
public class Vehicule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank
    private String modele;

    private String immatricule;

    private String etat;

    @ManyToOne
    private Conducteur conducteur;

    @OneToMany(mappedBy="vehicule",cascade = CascadeType.ALL)
    private List<Assignation> assignation;

    public Vehicule() {
        super();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getModele() {
        return modele;
    }

    public void setModele(String modele) {
        this.modele = modele;
    }

    public String getImmatricule() {
        return immatricule;
    }

    public void setImmatricule(String immatricule) {
        this.immatricule = immatricule;
    }

    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    public Conducteur getConducteur() {
        return conducteur;
    }

    public void setConducteur(Conducteur conducteur) {
        this.conducteur = conducteur;
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