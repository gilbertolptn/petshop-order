package com.example.petshop.order.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class OrderDetails {
    private Long productId;
    private Long accountId;
    private int quantity;

    @JsonCreator
    public OrderDetails(@JsonProperty("productId") Long productId,
                        @JsonProperty("accountId") Long accountId,
                        @JsonProperty("quantity") int quantity) {
        this.productId = productId;
        this.accountId = accountId;
        this.quantity = quantity;
    }

    public int getQuantity() {
        return quantity;
    }

    public Long getProductId() {
        return productId;
    }

    public Long getAccountId() {
        return accountId;
    }
}
