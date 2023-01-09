package com.codegym.model.product;

import javax.persistence.*;
import java.util.Set;
@Entity
public class Producer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Boolean isRemove;
    private String name;
    @OneToMany(mappedBy = "producer")
    private Set<ProductGroup> productGroups;

    @OneToMany(mappedBy = "producer")
    private Set<LapCPU> lapCPUS;

    @OneToMany(mappedBy = "producer")
    private Set<LapGPU> lapGPUS;

    @OneToMany(mappedBy = "producer")
    private Set<LapRam> lapRams;
    @OneToMany(mappedBy = "producer")
    private Set<LapMemory> lapMemories;

    public Producer() {
    }

    public Set<LapMemory> getLapMemories() {
        return lapMemories;
    }

    public void setLapMemories(Set<LapMemory> lapMemories) {
        this.lapMemories = lapMemories;
    }

    public Set<LapRam> getLapRams() {
        return lapRams;
    }

    public void setLapRams(Set<LapRam> lapRams) {
        this.lapRams = lapRams;
    }

    public Set<LapGPU> getLapGPUS() {
        return lapGPUS;
    }

    public void setLapGPUS(Set<LapGPU> lapGPUS) {
        this.lapGPUS = lapGPUS;
    }

    public Set<LapCPU> getLapCPUS() {
        return lapCPUS;
    }

    public void setLapCPUS(Set<LapCPU> lapCPUS) {
        this.lapCPUS = lapCPUS;
    }

    public Boolean getRemove() {
        return isRemove;
    }

    public void setRemove(Boolean remove) {
        isRemove = remove;
    }

    public Set<ProductGroup> getProductGroups() {
        return productGroups;
    }

    public void setProductGroups(Set<ProductGroup> productGroups) {
        this.productGroups = productGroups;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Boolean getIsRemove() {
        return isRemove;
    }

    public void setIsRemove(Boolean isRemove) {
        this.isRemove = isRemove;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
