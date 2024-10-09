package com.example.crud.product;

import java.time.LocalDate;

public class Product {
    private Long id;
    private String name;
    private float price;
    private LocalDate date;
    private int antiguedad;

    public Product(){

    }

    public Product(
        Long id,
        String name,
        float price,
        LocalDate date,
        int antiguedad
    ) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.date = date;
        this.antiguedad = antiguedad;
    }

    public Product(
        String name,
        float price,
        LocalDate date,
        int antiguedad
    ) {
        this.name = name;
        this.price = price;
        this.date = date;
        this.antiguedad = antiguedad;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public int getAntiguedad() {
        return antiguedad;
    }

    public void setAntiguedad(int antiguedad) {
        this.antiguedad = antiguedad;
    }


}
