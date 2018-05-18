package com.ts.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name="user")
@Table(name = "USERS")
public class User {

	@Id
	@Column(name = "USER_NAME")
	private String username;

	@Column(name = "PASSWORD")
	private String password;

}
