package com.shop.backend.dto;

import com.shop.backend.model.Product;

import java.util.List;

/**
 * Data Transfer Object for a Product    .
 */
public class ProductDto {
    /**
     * internal id of Product .
     */
    private Long id;

    /**
     * productId of this Product .
     */
    private String productId;
    /**
     * name of this Product .
     */
    private String name;

    /**
     * Base price of this product .
     */
    private Integer basePrice;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getBasePrice() {
        return basePrice;
    }

    public void setBasePrice(Integer basePrice) {
        this.basePrice = basePrice;
    }
}
