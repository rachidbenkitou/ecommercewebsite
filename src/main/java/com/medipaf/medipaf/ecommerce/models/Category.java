package com.medipaf.medipaf.ecommerce.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table
@Schema(name = "Category Controller") // This annotation helps to customise the entity name in swagger 3 (openApi)
public class Category implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    // We can customise the field in swagger 3 or openApi.
    private String name;
    @OneToMany(mappedBy = "category")
    @JsonIgnore
    private List<Product> products;
    @OneToMany(mappedBy = "category")
    @JsonIgnore
    private List<SubCategory> subCategories;

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

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public List<SubCategory> getSubCategories() {
        return subCategories;
    }

    public void setSubCategories(List<SubCategory> subCategories) {
        this.subCategories = subCategories;
    }
}
