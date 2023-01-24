package com.medipaf.medipaf.ecommerce.dtos;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.medipaf.medipaf.ecommerce.models.Client;
import com.medipaf.medipaf.ecommerce.models.ProductOrder;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
public class OrderedDto {

    private Long ido;

    private String serie;


    private Client client;
    @JsonIgnore
    private Set<ProductOrder> productOrders = new HashSet<ProductOrder>();

    public Long getIdo() {
        return ido;
    }

    public void setIdo(Long ido) {
        this.ido = ido;
    }

    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Set<ProductOrder> getProductOrders() {
        return productOrders;
    }

    public void setProductOrders(Set<ProductOrder> productOrders) {
        this.productOrders = productOrders;
    }
}
