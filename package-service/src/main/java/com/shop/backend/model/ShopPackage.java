package com.shop.backend.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name="package")
public class ShopPackage implements Serializable {


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
    @Column(name="name")
    private String name;

    /**
     * description of this package.
     */
    @Column(name="description")
    private String description;

    @OneToMany(mappedBy = "shopPackage")
    private List<Product> products;

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

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
