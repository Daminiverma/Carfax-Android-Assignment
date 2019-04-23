package com.example.dam.carfaxassignment.Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class VehicleImage {

    @SerializedName("firstPhoto")
    @Expose
    private VehicleFirstPhoto vehicleFirstPhoto;

    public VehicleFirstPhoto getFirstPhoto() {
        return vehicleFirstPhoto;
    }

    public void setFirstPhoto(VehicleFirstPhoto firstPhoto) {
        this.vehicleFirstPhoto = firstPhoto;
    }

}
