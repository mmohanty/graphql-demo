package com.graphql.demo.query;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.graphql.demo.model.Offer;
import com.graphql.demo.model.OfferDetails;
import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsQuery;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.ClassPathResource;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@DgsComponent
@Slf4j
public class OfferResolver {

    @DgsQuery
    CompletableFuture<List<Offer>> offersByAccount(Long accountId){
        return CompletableFuture.supplyAsync(() ->{
            List<LinkedHashMap<String, Object>> mapList ;
            List<Offer> offers = new ArrayList<>();
            try{
                ObjectMapper  mapper = new ObjectMapper();
                TypeReference<List<LinkedHashMap<String, Object>>> ref = new TypeReference<>() {};
                if(accountId % 2 == 0){
                    mapList = mapper.readValue(new ClassPathResource("data/offers2.json").getFile(), ref);
                }else{
                    mapList = mapper.readValue(new ClassPathResource("data/offers1.json").getFile(), ref);
                }
                mapList.forEach(record ->{
                    LinkedHashMap<String, Object> offerDetailsMap =
                            (LinkedHashMap<String, Object>) record.get("offerDetails");
                    Offer offer = Offer.builder().offerName(getStringValue(record, "offerName"))
                            .id(getIntValue(record, "id"))
                            .offerType(getStringValue(record, "offerType"))
                            .offerKey(getStringValue(record, "offerKey"))
                            .offerName(getStringValue(record, "offerName"))
                            .promoCode(getStringValue(record, "promoCode"))
                            .status(getBooleanValue(record, "status"))
                            .offerDetails(OfferDetails.builder().
                            id(offerDetailsMap.get("id").toString())
                                    .createdOn(offerDetailsMap.get("createdOn").toString())
                                    .validTill(offerDetailsMap.get("validTill").toString()).build()).build();
                    offers.add(offer);
                });
            }catch (Exception e){
                log.error("Exception while reading offers", e);
                throw new RuntimeException(e);
            }
            return offers;
        });
    }

    private String getStringValue(LinkedHashMap<String, Object> record, String key){
        return record.get(key).toString();
    }

    private int getIntValue(LinkedHashMap<String, Object> record, String key){
        return Integer.parseInt(record.get(key).toString());
    }

    private Boolean getBooleanValue(LinkedHashMap<String, Object> record, String key){
        return Boolean.valueOf(record.get(key).toString());
    }
}


