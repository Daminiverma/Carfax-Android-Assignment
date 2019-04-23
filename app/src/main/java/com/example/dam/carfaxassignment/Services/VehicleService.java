package com.example.dam.carfaxassignment.Services;

import com.example.dam.carfaxassignment.Models.VehicleResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface VehicleService {
    @GET("/assignment.json")
    Call<VehicleResponse> getVehicleDetails();
}
