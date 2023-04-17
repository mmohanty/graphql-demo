package com.graphql.demo.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Transaction {
	private String date;
	private String number;
	private double amount;
	private String description;
	private String currency;
	private String id;
	private TransactionType typeCode;

}
