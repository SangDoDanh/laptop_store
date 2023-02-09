package com.codegym.model.ship;

import com.codegym.model.orders.OrdersDetail;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Ship {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Boolean isRemove;
    private String name;
    private Double fareSize;
    private Double fareWeight;
    private String urlImage;

    @OneToMany(mappedBy = "ship")
    private Set<OrdersDetail> ordersDetails;

    public Ship() {
    }

    public String getUrlImage() {
        return urlImage;
    }

    public void setUrlImage(String urlImage) {
        this.urlImage = urlImage;
    }

    public Set<OrdersDetail> getOrdersDetails() {
        return ordersDetails;
    }

    public void setOrdersDetails(Set<OrdersDetail> ordersDetails) {
        this.ordersDetails = ordersDetails;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Boolean getRemove() {
        return isRemove;
    }

    public void setRemove(Boolean remove) {
        isRemove = remove;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getFareSize() {
        return fareSize;
    }

    public void setFareSize(Double fareSize) {
        this.fareSize = fareSize;
    }

    public Double getFareWeight() {
        return fareWeight;
    }

    public void setFareWeight(Double fareWeight) {
        this.fareWeight = fareWeight;
    }
}
