package com.example.dam.carfaxassignment.Interfaces;

import com.example.dam.carfaxassignment.Models.VehicleResponse;

import retrofit2.http.GET;
import rx.Observable;

public interface IVehicleService {
    @GET("/assignment.json")
    Observable<VehicleResponse> getVehicleDetails();
}
