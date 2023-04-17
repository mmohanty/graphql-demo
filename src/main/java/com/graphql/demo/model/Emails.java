package com.graphql.demo.model;

public class Emails {
	private String address;
	private String type;
	private boolean primary;

	public String getAddress(){
		return address;
	}

	public String getType(){
		return type;
	}

	public boolean isPrimary(){
		return primary;
	}
}
