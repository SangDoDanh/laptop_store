package com.codegym.model.product;

import javax.persistence.*;
import java.util.Set;

@Entity
public class ProductGroup {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Boolean isRemove;
    private String description;
    private String name;
    private Double price;
    private Integer size;
    private String urlImg;
    private Double weight;
    private Boolean isFingerprint;

    @ManyToOne
    @JoinColumn(name = "sizeInch_id", referencedColumnName = "id")
    private SizeInch sizeInch;


    @ManyToOne
    @JoinColumn(name = "producer_id", referencedColumnName = "id")
    private Producer producer;

    @ManyToOne
    @JoinColumn(name = "warranty_id", referencedColumnName = "id")
    private Warranty warranty;

    @ManyToOne
    @JoinColumn(name = "category_id", referencedColumnName = "id")
    private Category category;

    @OneToMany(mappedBy = "productGroup")
    private Set<Product> products;


    public ProductGroup() {
    }

    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Boolean getFingerprint() {
        return isFingerprint;
    }

    public void setFingerprint(Boolean fingerprint) {
        isFingerprint = fingerprint;
    }

    public SizeInch getSizeInch() {
        return sizeInch;
    }

    public void setSizeInch(SizeInch sizeInch) {
        this.sizeInch = sizeInch;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getUrlImg() {
        return urlImg;
    }

    public void setUrlImg(String urlImg) {
        this.urlImg = urlImg;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
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

    public Producer getProducer() {
        return producer;
    }

    public void setProducer(Producer producer) {
        this.producer = producer;
    }

    public Warranty getWarranty() {
        return warranty;
    }

    public void setWarranty(Warranty warranty) {
        this.warranty = warranty;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
