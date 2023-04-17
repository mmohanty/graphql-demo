package com.graphql.demo.query;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.graphql.demo.model.Transaction;
import com.graphql.demo.model.TransactionType;
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
public class TransactionQueryResolver {

    @DgsQuery
    public CompletableFuture<List<Transaction>> transactions(){
        return CompletableFuture.supplyAsync(() -> {
            List<Transaction> transactions = new ArrayList<>();
            try{
                ObjectMapper objectMapper = new ObjectMapper();
                List<LinkedHashMap> mapList = objectMapper.readValue(
                        new ClassPathResource("./data/transactions.json").getFile(), List.class);
                mapList.forEach(record ->{
                    Transaction transaction = Transaction.builder()
                            .id(record.get("id").toString())
                            .number(record.get("number").toString())
                            .date(record.get("date").toString())
                            .typeCode(TransactionType.valueOf(record.get("typeCode").toString()))
                            .amount(Double.parseDouble(record.get("amount").toString()))
                            .description(record.get("description").toString())
                            .currency(record.get("currency").toString()).build();
                    transactions.add(transaction);

                });
            }catch (Exception e){
                log.error("Failed to fetch transactions ", e);
                throw new RuntimeException(e);
            }
            return transactions;
        });
    }
}
