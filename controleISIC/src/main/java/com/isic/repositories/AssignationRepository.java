package com.isic.repositories;

import com.isic.entities.Assignation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface AssignationRepository extends JpaRepository<Assignation,Long> {
}
