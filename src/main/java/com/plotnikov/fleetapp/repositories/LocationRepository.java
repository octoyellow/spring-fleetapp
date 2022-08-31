package com.plotnikov.fleetapp.repositories;

import com.plotnikov.fleetapp.models.Location;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocationRepository extends JpaRepository<Location, Integer> {
}
