package com.example.demo.auth.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "role")
@Data
@NoArgsConstructor
public class Role {
	@Id
	@GeneratedValue(strategy =  GenerationType.AUTO)
	private Long id;
	
	private String name;
	
	@ManyToMany(mappedBy = "roles")
	private Set<User> users;
}
