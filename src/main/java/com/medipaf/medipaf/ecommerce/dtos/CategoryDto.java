package com.medipaf.medipaf.ecommerce.dtos;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.medipaf.medipaf.ecommerce.models.Product;
import com.medipaf.medipaf.ecommerce.models.SubCategory;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
public class CategoryDto {

    private Long id;
    private String name;
    @JsonIgnore
    private List<Product> products;
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
