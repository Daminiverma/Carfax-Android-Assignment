package com.example.dam.carfaxassignment.Models;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Embedded;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Entity(tableName = "vehicle_details_table")

public class VehicleListing {

    @PrimaryKey
    @NonNull
    @SerializedName("vin")
    @Expose
    private String vin;

    @SerializedName("dealer")
    @Expose
    @Embedded
    private VehicleDealer vehicleDealer;

    @SerializedName("year")
    @Expose
    private Integer year;

    @SerializedName("make")
    @Expose
    private String make;

    @SerializedName("model")
    @Expose
    private String model;

    @SerializedName("trim")
    @Expose
    private String trim;

    @SerializedName("mileage")
    @Expose
    private Integer mileage;

    @ColumnInfo(name = "current_price")
    @SerializedName("currentPrice")
    @Expose
    private Double currentPrice;

    @ColumnInfo(name = "exterior_color")
    @SerializedName("exteriorColor")
    @Expose
    private String exteriorColor;

    @SerializedName("interiorColor")
    @Expose
    private String interiorColor;

    @SerializedName("engine")
    @Expose
    private String engine;

    @SerializedName("drivetype")
    @Expose
    private String drivetype;

    @SerializedName("transmission")
    @Expose
    private String transmission;

    @SerializedName("fuel")
    @Expose
    private String fuel;

    @SerializedName("bodytype")
    @Expose
    private String bodytype;

    @SerializedName("images")
    @Expose
    @Embedded
    private VehicleImage images;

    public VehicleDealer getVehicleDealer() {
        return vehicleDealer;
    }

    public void setVehicleDealer(VehicleDealer vehicleDealer) {
        this.vehicleDealer = vehicleDealer;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
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

    public Integer getMileage() {
        return mileage;
    }

    public void setMileage(Integer mileage) {
        this.mileage = mileage;
    }

    public Double getCurrentPrice() {
        return currentPrice;
    }

    public void setCurrentPrice(Double currentPrice) {
        this.currentPrice = currentPrice;
    }

    public String getExteriorColor() {
        return exteriorColor;
    }

    public void setExteriorColor(String exteriorColor) {
        this.exteriorColor = exteriorColor;
    }

    public String getInteriorColor() {
        return interiorColor;
    }

    public void setInteriorColor(String interiorColor) {
        this.interiorColor = interiorColor;
    }

    public String getEngine() {
        return engine;
    }

    public void setEngine(String engine) {
        this.engine = engine;
    }

    public String getDrivetype() {
        return drivetype;
    }

    public void setDrivetype(String drivetype) {
        this.drivetype = drivetype;
    }

    public String getTransmission() {
        return transmission;
    }

    public void setTransmission(String transmission) {
        this.transmission = transmission;
    }

    public String getFuel() {
        return fuel;
    }

    public void setFuel(String fuel) {
        this.fuel = fuel;
    }

    public String getBodytype() {
        return bodytype;
    }

    public void setBodytype(String bodytype) {
        this.bodytype = bodytype;
    }

    public VehicleImage getImages() {
        return images;
    }

    public void setImages(VehicleImage images) {
        this.images = images;
    }
}
