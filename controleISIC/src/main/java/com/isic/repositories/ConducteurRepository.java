package com.isic.repositories;

import com.isic.entities.Conducteur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface ConducteurRepository extends JpaRepository<Conducteur,Long> {
}
