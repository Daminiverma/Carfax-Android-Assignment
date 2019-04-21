package com.example.dam.carfaxassignment.Models;

import android.media.Image;

public class VehicleInfoModel {

    String image;
    int year;
    String make, model, trim, milage, location;
    double price;

    public VehicleInfoModel(String image, int year, String make, String model, String trim, String milage, String location, double price) {
        this.image = image;
        this.year = year;
        this.make = make;
        this.model = model;
        this.trim = trim;
        this.milage = milage;
        this.location = location;
        this.price = price;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getTrim() {
        return trim;
    }

    public void setTrim(String trim) {
        this.trim = trim;
    }

    public String getMilage() {
        return milage;
    }

    public void setMilage(String milage) {
        this.milage = milage;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
