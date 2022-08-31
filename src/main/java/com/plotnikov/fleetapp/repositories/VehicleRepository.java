package com.plotnikov.fleetapp.repositories;

import com.plotnikov.fleetapp.models.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehicleRepository extends JpaRepository<Vehicle, Integer> {
}
