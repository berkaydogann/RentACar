package com.springExample.rentACar.dataAccess.abstracts;

import com.springExample.rentACar.entities.concretes.Brand;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BrandRepository extends JpaRepository<Brand, Integer> {
    boolean existsByName(String name);

}
