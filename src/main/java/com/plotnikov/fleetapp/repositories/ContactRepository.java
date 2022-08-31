package com.plotnikov.fleetapp.repositories;

import com.plotnikov.fleetapp.models.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactRepository extends JpaRepository<Contact, Integer> {

}
