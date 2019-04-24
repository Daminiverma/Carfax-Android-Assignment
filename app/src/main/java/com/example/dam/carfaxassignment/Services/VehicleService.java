package com.example.dam.carfaxassignment.Services;

import com.example.dam.carfaxassignment.Models.VehicleResponse;
import retrofit2.http.GET;
import rx.Observable;

public interface VehicleService {
    @GET("/assignment.json")
    Observable<VehicleResponse> getVehicleDetails();
}
