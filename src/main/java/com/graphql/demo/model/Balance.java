package com.graphql.demo.model;

public class Balance{
	private String dateTime;
	private String number;
	private int current;
	private double available;
	private String isoCurrencyCode;

	public String getDateTime(){
		return dateTime;
	}

	public String getNumber(){
		return number;
	}

	public int getCurrent(){
		return current;
	}

	public double getAvailable(){
		return available;
	}

	public String getIsoCurrencyCode(){
		return isoCurrencyCode;
	}
}
