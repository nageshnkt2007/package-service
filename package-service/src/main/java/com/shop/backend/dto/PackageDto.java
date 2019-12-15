package com.shop.backend.dto;


import java.util.List;

/**
 * Data Transfer Object for a package .
 */
public class PackageDto {
    /**
     * id of package .
     */
    private Long id;
    /**
     * name of this package .
     */
    private String name;
    /**
     * decription of this package .
     */
    private String description;

    /**
     * List of Products related to this package;
     */
    private List<ProductDto> products;

    /**
     * Total Price of this package (Addition of total base price of all products).
     */
    private Float totalPrice;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<ProductDto> getProducts() {
        return products;
    }

    public void setProducts(List<ProductDto> products) {
        this.products = products;
    }

    public Float getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Float totalPrice) {
        this.totalPrice = totalPrice;
    }
}
