package com.codegym.model.product;

public class LapMemory {
    private Integer id;
    private Boolean isRemove;
    private String name;
    private int memoryVal;
    private Producer producer;
    private LapMemoryType lapMemoryType;

    public LapMemory() {
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
