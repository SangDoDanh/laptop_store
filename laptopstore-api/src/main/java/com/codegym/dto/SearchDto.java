package com.codegym.dto;

import java.util.List;

public class SearchDto {
    private String producer;
    private String nameSearch;
    private List<String> priceSearch;
    private List<String> inchSearch;

    public SearchDto() {
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public String getNameSearch() {
        return nameSearch;
    }

    public void setNameSearch(String nameSearch) {
        this.nameSearch = nameSearch;
    }

    public List<String> getPriceSearch() {
        return priceSearch;
    }

    public void setPriceSearch(List<String> priceSearch) {
        this.priceSearch = priceSearch;
    }

    public List<String> getInchSearch() {
        return inchSearch;
    }

    public void setInchSearch(List<String> inchSearch) {
        this.inchSearch = inchSearch;
    }
}
