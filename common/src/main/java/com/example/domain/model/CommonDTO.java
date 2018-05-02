package com.example.domain.model;

import lombok.*;

import java.util.List;

@Value
@Builder
public class CommonDTO {

    Long id;

    @Singular("addNested")
    List<NestedDTO> nesteds;

    @Value
    @Builder
    public static class NestedDTO {

        String status;

        String string;
    }
}
