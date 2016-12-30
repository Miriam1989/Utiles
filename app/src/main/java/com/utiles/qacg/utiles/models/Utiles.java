package com.utiles.qacg.utiles.models;

import android.widget.TextView;

import com.orm.SugarRecord;

/**
 * Created by QACG on 27/12/2016.
 */



public class Utiles extends SugarRecord {


    private Long id;
    private String name;
    private String brand;
    private String color;
    private Double price;
    private String sizeUtils;

    public Utiles() {
    }

    public Utiles(Long id, String name, String brand, String color, Double price, String sizeUtils) {
        this.id = id;
        this.name = name;
        this.brand = brand;
        this.color = color;
        this.price = price;
        this.sizeUtils = sizeUtils;
    }

    public Utiles( String name, String brand, String color, Double price, String sizeUtils) {
        this.name = name;
        this.brand = brand;
        this.color = color;
        this.price = price;
        this.sizeUtils = sizeUtils;
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getSizeUtils() {
        return sizeUtils;
    }

    public void setSizeUtils(String sizeUtils) {
        this.sizeUtils = sizeUtils;
    }
}
