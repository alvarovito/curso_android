package com.example.vito.openwebinarscurse.entities;

public class Breakdown {
    private String name;
    private String description;
    private String carBrand;
    private String urlImage;
    private int numBudget;

    public Breakdown(){

    }

    public Breakdown(String name, String description, String carBrand, String urlImage, int numBudget){
        this.name = name;
        this.description = description;
        this.carBrand = carBrand;
        this.urlImage = urlImage;
        this.numBudget = numBudget;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCarBrand() {
        return carBrand;
    }

    public void setCarBrand(String carBrand) {
        this.carBrand = carBrand;
    }

    public String getUrlImage() {
        return urlImage;
    }

    public void setUrlImage(String urlImage) {
        this.urlImage = urlImage;
    }

    public int getNumBudget() {
        return numBudget;
    }

    public void setNumBudget(int numBudget) {
        this.numBudget = numBudget;
    }
}
