package com.codegym.model.orders;

import com.codegym.model.orders.Orders;
import com.codegym.model.product.Product;
import com.codegym.model.ship.Ship;

import javax.persistence.*;
import java.util.Set;

@Entity
public class OrdersDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Boolean isRemove;
    private String note;
    private String locationShip;
    private Integer quality;

    @OneToMany(mappedBy = "ordersDetail")
    private Set<WarrantyOrdersDetail> warrantyOrdersDetails;

    @ManyToOne
    @JoinColumn(name = "orders_id", referencedColumnName = "id")
    private Orders orders;

    @ManyToOne
    @JoinColumn(name = "product_id", referencedColumnName = "id")
    private Product product;
    private Boolean payStatus;

    @ManyToOne
    @JoinColumn(name = "ship_id", referencedColumnName = "id")
    private Ship ship;


    public OrdersDetail() {
    }

    public Set<WarrantyOrdersDetail> getWarrantyOrdersDetails() {
        return warrantyOrdersDetails;
    }

    public void setWarrantyOrdersDetails(Set<WarrantyOrdersDetail> warrantyOrdersDetails) {
        this.warrantyOrdersDetails = warrantyOrdersDetails;
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

    public Orders getOrders() {
        return orders;
    }

    public void setOrders(Orders orders) {
        this.orders = orders;
    }

    public Integer getQuality() {
        return quality;
    }

    public void setQuality(Integer quality) {
        this.quality = quality;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Boolean getPayStatus() {
        return payStatus;
    }

    public void setPayStatus(Boolean payStatus) {
        this.payStatus = payStatus;
    }

    public Ship getShip() {
        return ship;
    }

    public void setShip(Ship ship) {
        this.ship = ship;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getLocationShip() {
        return locationShip;
    }

    public void setLocationShip(String locationShip) {
        this.locationShip = locationShip;
    }
}
