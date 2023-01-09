package com.codegym.model.product;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Warranty {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Boolean isRemove;
    private String name;
    private Integer warrantyMonth;
    @OneToMany(mappedBy = "warranty")
    private Set<ProductGroup> productGroups;

    public Warranty() {
    }

    public Boolean getRemove() {
        return isRemove;
    }

    public void setRemove(Boolean remove) {
        isRemove = remove;
    }

    public Set<ProductGroup> getProductGroups() {
        return productGroups;
    }

    public void setProductGroups(Set<ProductGroup> productGroups) {
        this.productGroups = productGroups;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Boolean getIsRemove() {
        return isRemove;
    }

    public void setIsRemove(Boolean isRemove) {
        this.isRemove = isRemove;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getWarrantyMonth() {
        return warrantyMonth;
    }

    public void setWarrantyMonth(Integer warrantyMonth) {
        this.warrantyMonth = warrantyMonth;
    }
}
