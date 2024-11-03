package com.isic.entities;

import jakarta.persistence.*;

import java.util.Date;


@Entity
public class Assignation {

    @EmbeddedId
    private ConducteurVehiculePK pk;

    @ManyToOne
    @JoinColumn(name = "vehicule",insertable=false, updatable=false)
    private Vehicule vehicule;

    @ManyToOne
    @JoinColumn(name = "conducteur",insertable=false, updatable=false)
    private Conducteur conducteur;

    private Date dateFin;


    public Assignation() {
    }

    public Assignation(ConducteurVehiculePK pk, Vehicule vehicule, Conducteur conducteur, Date dateFin) {
        this.pk = pk;
        this.vehicule = vehicule;
        this.conducteur = conducteur;
        this.dateFin = dateFin;
    }

    public ConducteurVehiculePK getPk() {
        return pk;
    }

    public void setPk(ConducteurVehiculePK pk) {
        this.pk = pk;
    }

    public Vehicule getVehicule() {
        return vehicule;
    }

    public void setVehicule(Vehicule vehicule) {
        this.vehicule = vehicule;
    }

    public Conducteur getConducteur() {
        return conducteur;
    }

    public void setConducteur(Conducteur conducteur) {
        this.conducteur = conducteur;
    }

    public Date getDateFin() {
        return dateFin;
    }

    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }
}
