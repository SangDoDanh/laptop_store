package com.codegym.model.product;

public class LapRam {
    private Integer id;
    private Boolean isRemove;
    private String name;
    private int ramVal;
    private Producer producer;

    public LapRam() {
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

    public int getRamVal() {
        return ramVal;
    }

    public void setRamVal(int ramVal) {
        this.ramVal = ramVal;
    }

    public Producer getProducer() {
        return producer;
    }

    public void setProducer(Producer producer) {
        this.producer = producer;
    }
}
