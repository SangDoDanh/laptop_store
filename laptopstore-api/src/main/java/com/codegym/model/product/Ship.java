package com.codegym.model.product;

public class Ship {
    private Integer id;
    private Boolean isRemove;
    private String name;
    private Double fareSize;
    private Double fareWeight;

    public Ship() {
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
