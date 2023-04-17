package com.graphql.demo.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Offer{
	private int id;
	private String offerName;
	private String offerType;
	private boolean status;
	private String promoCode;
	private String offerKey;
	private OfferDetails offerDetails;

	public String getOfferType(){
		return offerType;
	}

	public String getOfferName(){
		return offerName;
	}

	public String getOfferKey(){
		return offerKey;
	}

	public OfferDetails getOfferDetails(){
		return offerDetails;
	}

	public String getPromoCode(){
		return promoCode;
	}

	public int getId(){
		return id;
	}

	public boolean isStatus(){
		return status;
	}
}
