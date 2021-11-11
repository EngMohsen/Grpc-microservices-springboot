package com.volvo.demogateway.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class User {

	private String firstName;
	private String sureName;
	private Integer age;
	private String email;
	private String address;
	private String userName;
	private Integer password;

}
