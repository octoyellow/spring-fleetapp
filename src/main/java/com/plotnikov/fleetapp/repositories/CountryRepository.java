package com.plotnikov.fleetapp.repositories;

import com.plotnikov.fleetapp.models.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<Country, Integer> {

}
