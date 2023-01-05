package com.codegym.model.product;

public class Product {
    private Integer id;
    private Boolean isRemove;
    private Double price;
    private String color;
    private Boolean isFingerprint;
    private Integer qualityUseRam;
    private Integer qualityAllRam;
    private Integer sizeRamMax;
    private Discount discount;
    private ProductGroup productGroup;
    private DisplayTech displayTech;
    private SizeInch sizeInch;
    private Resolution resolution;
    private LapCPU lapCPU;
    private LapGPU lapGPU;
    private LapRam lapRam;
    private LapMemory lapMemorySSD;
    private LapMemory getLapMemoryHDD;
    private ScreenRatio screenRatio;

    public Product() {
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

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Boolean getFingerprint() {
        return isFingerprint;
    }

    public void setFingerprint(Boolean fingerprint) {
        isFingerprint = fingerprint;
    }

    public Integer getQualityUseRam() {
        return qualityUseRam;
    }

    public void setQualityUseRam(Integer qualityUseRam) {
        this.qualityUseRam = qualityUseRam;
    }

    public Integer getQualityAllRam() {
        return qualityAllRam;
    }

    public void setQualityAllRam(Integer qualityAllRam) {
        this.qualityAllRam = qualityAllRam;
    }

    public Integer getSizeRamMax() {
        return sizeRamMax;
    }

    public void setSizeRamMax(Integer sizeRamMax) {
        this.sizeRamMax = sizeRamMax;
    }

    public Discount getDiscount() {
        return discount;
    }

    public void setDiscount(Discount discount) {
        this.discount = discount;
    }

    public ProductGroup getProductGroup() {
        return productGroup;
    }

    public void setProductGroup(ProductGroup productGroup) {
        this.productGroup = productGroup;
    }

    public DisplayTech getDisplayTech() {
        return displayTech;
    }

    public void setDisplayTech(DisplayTech displayTech) {
        this.displayTech = displayTech;
    }

    public SizeInch getSizeInch() {
        return sizeInch;
    }

    public void setSizeInch(SizeInch sizeInch) {
        this.sizeInch = sizeInch;
    }

    public Resolution getResolution() {
        return resolution;
    }

    public void setResolution(Resolution resolution) {
        this.resolution = resolution;
    }

    public LapCPU getLapCPU() {
        return lapCPU;
    }

    public void setLapCPU(LapCPU lapCPU) {
        this.lapCPU = lapCPU;
    }

    public LapGPU getLapGPU() {
        return lapGPU;
    }

    public void setLapGPU(LapGPU lapGPU) {
        this.lapGPU = lapGPU;
    }

    public LapRam getLapRam() {
        return lapRam;
    }

    public void setLapRam(LapRam lapRam) {
        this.lapRam = lapRam;
    }

    public LapMemory getLapMemorySSD() {
        return lapMemorySSD;
    }

    public void setLapMemorySSD(LapMemory lapMemorySSD) {
        this.lapMemorySSD = lapMemorySSD;
    }

    public LapMemory getGetLapMemoryHDD() {
        return getLapMemoryHDD;
    }

    public void setGetLapMemoryHDD(LapMemory getLapMemoryHDD) {
        this.getLapMemoryHDD = getLapMemoryHDD;
    }

    public ScreenRatio getScreenRatio() {
        return screenRatio;
    }

    public void setScreenRatio(ScreenRatio screenRatio) {
        this.screenRatio = screenRatio;
    }
}
