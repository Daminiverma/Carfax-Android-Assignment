package com.example.dam.carfaxassignment.Interfaces;

import com.example.dam.carfaxassignment.ViewModels.VehicleListingViewModel;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component
public interface VehicleListingVMComponent {
    VehicleListingViewModel getVehicleListingViewModel();
}
