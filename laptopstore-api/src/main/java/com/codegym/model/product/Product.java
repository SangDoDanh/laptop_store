package com.codegym.model.product;

import com.codegym.model.orders.OrdersDetail;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Boolean isRemove;
    private String color;
    private Integer qualityUseRam;
    private Integer qualityAllRam;
    private Integer sizeRamMax;
    @ManyToOne
    @JoinColumn(name = "discount_id", referencedColumnName = "id")
    private Discount discount;

    @ManyToOne
    @JoinColumn(name = "displayTech_id", referencedColumnName = "id")
    private DisplayTech displayTech;
    @ManyToOne
    @JoinColumn(name = "resolution_id", referencedColumnName = "id")
    private Resolution resolution;
    @ManyToOne
    @JoinColumn(name = "lapCPU_id", referencedColumnName = "id")
    private LapCPU lapCPU;
    @ManyToOne
    @JoinColumn(name = "lapGPU_id", referencedColumnName = "id")
    private LapGPU lapGPU;
    @ManyToOne
    @JoinColumn(name = "lapRam_id", referencedColumnName = "id")
    private LapRam lapRam;
    @ManyToOne
    @JoinColumn(name = "lapMemorySSD_id", referencedColumnName = "id")
    private LapMemory lapMemorySSD;

    @ManyToOne
    @JoinColumn(name = "lapMemoryHD_id", referencedColumnName = "id")
    private LapMemory lapMemoryHDD;
    @ManyToOne
    @JoinColumn(name = "screenRatio_id", referencedColumnName = "id")
    private ScreenRatio screenRatio;

    @ManyToOne
    @JoinColumn(name = "productGroup_id", referencedColumnName = "id")
    private ProductGroup productGroup;

    @OneToMany(mappedBy = "product")
    private Set<OrdersDetail> ordersDetails;

    public Product() {
    }

    public Set<OrdersDetail> getOrdersDetails() {
        return ordersDetails;
    }

    public void setOrdersDetails(Set<OrdersDetail> ordersDetails) {
        this.ordersDetails = ordersDetails;
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

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
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

    public LapMemory getLapMemoryHDD() {
        return lapMemoryHDD;
    }

    public void setLapMemoryHDD(LapMemory lapMemoryHDD) {
        this.lapMemoryHDD = lapMemoryHDD;
    }

    public ScreenRatio getScreenRatio() {
        return screenRatio;
    }

    public void setScreenRatio(ScreenRatio screenRatio) {
        this.screenRatio = screenRatio;
    }
}
