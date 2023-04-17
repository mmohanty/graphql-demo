package com.graphql.demo.query;

import com.netflix.dgs.codegen.generated.types.Comment;
import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsQuery;

import java.security.SecureRandom;
import java.util.*;
import java.util.concurrent.CompletableFuture;

@DgsComponent
public class Query {

    private final Map<Long, List<Comment>> map = new HashMap<>();
    public Query(){
        List<Comment> comments1 = new ArrayList<>();
        comments1.add(Comment.newBuilder().id(UUID.randomUUID().toString()).description("Good").build());
        comments1.add(Comment.newBuilder().id(UUID.randomUUID().toString()).description("Nice").build());

        List<Comment> comments2 = new ArrayList<>();
        comments2.add(Comment.newBuilder().id(UUID.randomUUID().toString()).description("Better").build());
        comments2.add(Comment.newBuilder().id(UUID.randomUUID().toString()).description("OK").build());

        map.put(1L, comments1);
        map.put(2L, comments2);
    }

    @DgsQuery
    CompletableFuture<List<Comment>> comments(Long postId){
        return CompletableFuture.supplyAsync(() ->{
            return postId % 2 == 0 ? map.get(2L) : map.get(1L);
        });
    }
}
