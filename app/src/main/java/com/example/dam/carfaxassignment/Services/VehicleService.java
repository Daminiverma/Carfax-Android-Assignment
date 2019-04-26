package com.example.dam.carfaxassignment.Services;

import com.example.dam.carfaxassignment.Interfaces.IVehicleService;
import com.example.dam.carfaxassignment.Models.VehicleResponse;

import javax.inject.Inject;

import rx.Observable;

public class VehicleService implements IVehicleService {

    @Inject
    public VehicleService() {
    }

    @Override
    public Observable<VehicleResponse> getVehicleDetails() {
        return null;
    }
}
