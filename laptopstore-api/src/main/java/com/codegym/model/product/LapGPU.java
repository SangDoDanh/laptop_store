package com.codegym.model.product;

import javax.persistence.*;
import java.util.Set;

@Entity
public class LapGPU {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Boolean isRemove;
    private String name;
    private int qualityCore;
    private int qualityThread;
    @ManyToOne
    @JoinColumn(name = "producer_id", referencedColumnName = "id")
    private Producer producer;

    @OneToMany(mappedBy = "lapGPU")
    private Set<Product> products;
    public LapGPU() {
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

    public int getQualityCore() {
        return qualityCore;
    }

    public void setQualityCore(int qualityCore) {
        this.qualityCore = qualityCore;
    }

    public int getQualityThread() {
        return qualityThread;
    }

    public void setQualityThread(int qualityThread) {
        this.qualityThread = qualityThread;
    }

    public Producer getProducer() {
        return producer;
    }

    public void setProducer(Producer producer) {
        this.producer = producer;
    }
}
