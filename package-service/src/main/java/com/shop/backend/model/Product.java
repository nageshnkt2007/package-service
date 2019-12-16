package com.shop.backend.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="product")
public class Product implements Serializable {
    

    private static final long serialVersionUID = 1L;

    /**
     * Automatically generated ID of this Package .
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * name of package .
     */
    @Column(name="productId")
    private String productId;

    /**
     * name of package .
     */
    @Column(name="name")
    private String name;

    /**
     * description of this package.
     */
    @Column(name="base_price")
    private Integer basePrice;


    @ManyToOne
    @JoinColumn(name = "package_id")
    private ShopPackage shopPackage;


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
