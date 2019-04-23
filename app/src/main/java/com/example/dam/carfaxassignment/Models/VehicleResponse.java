package com.example.dam.carfaxassignment.Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class VehicleResponse {

    @SerializedName("listings")
    @Expose
    ArrayList<VehicleListing> vehicleListings = null;

    public ArrayList<VehicleListing> getVehicleListings() {
        return vehicleListings;
    }

    public void setVehicleListings(ArrayList<VehicleListing> vehicleListings) {
        this.vehicleListings = vehicleListings;
    }
}
