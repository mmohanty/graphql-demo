package com.graphql.demo.model;

import lombok.Data;

import java.util.List;

@Data
public class Account{
	private String number;
	private String name;
	private String currency;
	private List<Owners> owners;
	private String id;
	private String type;


}