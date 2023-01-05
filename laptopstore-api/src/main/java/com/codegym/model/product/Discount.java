package com.codegym.model.product;

public class Discount {
    private Integer id;
    private Boolean isRemove;
    private String name;
    private String startDay;
    private String endDay;
    private Integer discountVal;

    public Discount() {
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

    public String getStartDay() {
        return startDay;
    }

    public void setStartDay(String startDay) {
        this.startDay = startDay;
    }

    public String getEndDay() {
        return endDay;
    }

    public void setEndDay(String endDay) {
        this.endDay = endDay;
    }

    public Integer getDiscountVal() {
        return discountVal;
    }

    public void setDiscountVal(Integer discountVal) {
        this.discountVal = discountVal;
    }
}
