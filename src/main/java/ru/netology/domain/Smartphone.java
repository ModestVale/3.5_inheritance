package ru.netology.domain;

public class Smartphone extends Product {
    private String manufacture;

    public Smartphone(int id, String name, String manufacture) {
        this.setId(id);
        this.setName(name);
        this.manufacture = manufacture;
    }

    public String getManufacture() {
        return manufacture;
    }

    public void setManufacture(String manufacture) {
        this.manufacture = manufacture;
    }

}

