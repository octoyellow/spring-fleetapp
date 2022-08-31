package com.plotnikov.fleetapp.models;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import com.plotnikov.fleetapp.security.models.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class User {
		
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
	private int id;

    private String firstname;

    private String lastname;

	private String username;

	private String password;

	@ManyToMany(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
            @JoinTable(
                    name = "user_role",
                    joinColumns = {@JoinColumn(name = "user_id")},
                    inverseJoinColumns = {@JoinColumn(name = "role_id")}
            )
	Set<Role> roles = new HashSet<>();
}
