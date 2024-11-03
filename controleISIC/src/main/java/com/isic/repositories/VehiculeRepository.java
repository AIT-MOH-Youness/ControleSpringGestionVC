package com.isic.repositories;

import com.isic.entities.Vehicule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface VehiculeRepository extends JpaRepository<Vehicule,Long> {
}
