package com.graphql.demo.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class OfferDetails{
	private String validTill;
	private String id;
	private String createdOn;
}
