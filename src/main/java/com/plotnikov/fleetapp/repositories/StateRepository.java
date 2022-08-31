package com.plotnikov.fleetapp.repositories;

import com.plotnikov.fleetapp.models.State;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StateRepository extends JpaRepository<State, Integer> {
}
