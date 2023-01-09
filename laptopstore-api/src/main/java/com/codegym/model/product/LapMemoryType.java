package com.codegym.model.product;

import javax.persistence.*;
import java.util.Set;

@Entity
public class LapMemoryType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Boolean isRemove;
    private String name;
    @OneToMany(mappedBy = "lapMemoryType")
    private Set<LapMemory> lapMemories;

    public LapMemoryType() {
    }

    public Set<LapMemory> getLapMemories() {
        return lapMemories;
    }

    public void setLapMemories(Set<LapMemory> lapMemories) {
        this.lapMemories = lapMemories;
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
}
