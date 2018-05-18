package com.ts.models.app;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "APP_ROLE")
public @Data class AccessRole {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String name;

	public AccessRole(String name) {
		this.name = name;
	}
	
	public AccessRole() {

	}
}
