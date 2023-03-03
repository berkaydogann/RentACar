package com.springExample.rentACar.dataAccess.abstracts;

import com.springExample.rentACar.entities.concretes.Model;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ModelRepository extends JpaRepository<Model, Integer> {
}
