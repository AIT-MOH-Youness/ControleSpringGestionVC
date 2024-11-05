package com.isic.entities;

import jakarta.persistence.Embeddable;

import java.util.Date;

@Embeddable
public class AssignationPK {


    private Date dateDebut;
    private long vehicule;
    private long conducteur;

    public AssignationPK() {
    }

    public AssignationPK(long vehicule, long conducteur, Date dateDebut) {
        this.vehicule = vehicule;
        this.conducteur = conducteur;
        this.dateDebut = dateDebut;
    }

    public long getVehicule() {
        return vehicule;
    }

    public void setVehicule(long vehicule) {
        this.vehicule = vehicule;
    }

    public long getConducteur() {
        return conducteur;
    }

    public void setConducteur(long conducteur) {
        this.conducteur = conducteur;
    }

    public Date getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }
}
