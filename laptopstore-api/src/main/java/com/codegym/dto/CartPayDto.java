package com.codegym.dto;

public class CartPayDto {
    private String  name;
    private String  id;
    private String  ordersId;
    private String  urlImgs;
    private String  price;
    private String  color;
    private String  discountName;
    private String  discountVal;
    private String  endDay;
    private String  quality;
    private String  ram;
    private String  cpu;
    private String  memory;
    private String  memtype;
    private String  ssdVal;
    private Double weight;
    private String ordersDay;
    private String productGroupId;
    private String locationShip;

    public CartPayDto() {
    }

    public CartPayDto(String name, String id, String ordersId, String urlImgs, String price, String color, String discountName, String discountVal, String endDay, String quality, String ram, String cpu, String memory, String memtype, String ssdVal, Double weight, String ordersDay, String productGroupId, String locationShip) {
        this.name = name;
        this.id = id;
        this.ordersId = ordersId;
        this.urlImgs = urlImgs;
        this.price = price;
        this.color = color;
        this.discountName = discountName;
        this.discountVal = discountVal;
        this.endDay = endDay;
        this.quality = quality;
        this.ram = ram;
        this.cpu = cpu;
        this.memory = memory;
        this.memtype = memtype;
        this.ssdVal = ssdVal;
        this.weight = weight;
        this.ordersDay = ordersDay;
        this.productGroupId = productGroupId;
        this.locationShip = locationShip;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public String getOrdersDay() {
        return ordersDay;
    }

    public void setOrdersDay(String ordersDay) {
        this.ordersDay = ordersDay;
    }

    public String getProductGroupId() {
        return productGroupId;
    }

    public void setProductGroupId(String productGroupId) {
        this.productGroupId = productGroupId;
    }

    public String getLocationShip() {
        return locationShip;
    }

    public void setLocationShip(String locationShip) {
        this.locationShip = locationShip;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOrdersId() {
        return ordersId;
    }

    public void setOrdersId(String ordersId) {
        this.ordersId = ordersId;
    }

    public String getUrlImgs() {
        return urlImgs;
    }

    public void setUrlImgs(String urlImgs) {
        this.urlImgs = urlImgs;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getDiscountName() {
        return discountName;
    }

    public void setDiscountName(String discountName) {
        this.discountName = discountName;
    }

    public String getDiscountVal() {
        return discountVal;
    }

    public void setDiscountVal(String discountVal) {
        this.discountVal = discountVal;
    }

    public String getEndDay() {
        return endDay;
    }

    public void setEndDay(String endDay) {
        this.endDay = endDay;
    }

    public String getQuality() {
        return quality;
    }

    public void setQuality(String quality) {
        this.quality = quality;
    }

    public String getRam() {
        return ram;
    }

    public void setRam(String ram) {
        this.ram = ram;
    }

    public String getCpu() {
        return cpu;
    }

    public void setCpu(String cpu) {
        this.cpu = cpu;
    }

    public String getMemory() {
        return memory;
    }

    public void setMemory(String memory) {
        this.memory = memory;
    }

    public String getMemtype() {
        return memtype;
    }

    public void setMemtype(String memtype) {
        this.memtype = memtype;
    }

    public String getSsdVal() {
        return ssdVal;
    }

    public void setSsdVal(String ssdVal) {
        this.ssdVal = ssdVal;
    }
}
