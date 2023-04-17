package com.graphql.demo.model;

import java.util.List;

public class Owners {
	private List<Emails> emails;
	private List<Address> addresses;
	private List<String> names;
	private String userId;
	private List<Phone> phoneNumbers;

	public List<Emails> getEmails(){
		return emails;
	}

	public List<Address> getAddresses(){
		return addresses;
	}

	public List<String> getNames(){
		return names;
	}

	public String getUserId(){
		return userId;
	}

	public List<Phone> getPhoneNumbers(){
		return phoneNumbers;
	}
}