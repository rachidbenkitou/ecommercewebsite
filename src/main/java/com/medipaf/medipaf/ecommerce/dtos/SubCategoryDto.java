package com.medipaf.medipaf.ecommerce.dtos;

import com.medipaf.medipaf.ecommerce.models.Category;
import com.medipaf.medipaf.ecommerce.models.Product;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import net.minidev.json.annotate.JsonIgnore;

import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
public class SubCategoryDto {


    private Long Id;

    private String name;

    @JsonIgnore
    private List<Product> products;


    private Category category;

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
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

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
