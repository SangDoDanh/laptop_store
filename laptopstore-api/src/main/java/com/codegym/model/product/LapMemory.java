package com.codegym.model.product;

import javax.persistence.*;
import java.util.Set;

@Entity
public class LapMemory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Boolean isRemove;
    private String name;
    private int memoryVal;

    @ManyToOne
    @JoinColumn(name = "producer_id", referencedColumnName = "id")
    private Producer producer;

    @ManyToOne
    @JoinColumn(name = "lapMemoryType_id", referencedColumnName = "id")
    private LapMemoryType lapMemoryType;

    @OneToMany(mappedBy = "lapMemorySSD")
    private Set<Product> products;

    @OneToMany(mappedBy = "lapMemoryHDD")
    private Set<Product> productss;


    public LapMemory() {
    }

    public Set<Product> getProductss() {
        return productss;
    }

    public void setProductss(Set<Product> productss) {
        this.productss = productss;
    }

    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
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

    public int getMemoryVal() {
        return memoryVal;
    }

    public void setMemoryVal(int memoryVal) {
        this.memoryVal = memoryVal;
    }

    public Producer getProducer() {
        return producer;
    }

    public void setProducer(Producer producer) {
        this.producer = producer;
    }

    public LapMemoryType getLapMemoryType() {
        return lapMemoryType;
    }

    public void setLapMemoryType(LapMemoryType lapMemoryType) {
        this.lapMemoryType = lapMemoryType;
    }
}
