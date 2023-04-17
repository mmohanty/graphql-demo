package com.graphql.demo.model;

import lombok.Data;

@Data
public class Address {
	private String country;
	private String city;
	private String street;
	private String postalCode;
	private String region;
	private boolean primary;


}
