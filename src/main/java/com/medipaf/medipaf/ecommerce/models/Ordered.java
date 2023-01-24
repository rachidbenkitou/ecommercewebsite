package com.medipaf.medipaf.ecommerce.models;



import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Ordered implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long ido;

    private String serie;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "client")
    private Client client;
    @OneToMany(mappedBy = "ordered")
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
