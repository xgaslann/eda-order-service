package com.xgaslan.orderservice.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Order {
    @JsonIgnore
    @Builder.Default
    private String id = UUID.randomUUID().toString();

    private String name;

    private Integer quantity;

    private Double price;
}