package com.example.dam.carfaxassignment.Interfaces;

import com.example.dam.carfaxassignment.Modules.VehicleModule;
import com.example.dam.carfaxassignment.Presenters.HomeActivity;
import com.example.dam.carfaxassignment.ViewModels.VehicleListingViewModel;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {VehicleModule.class})

public interface VehicleComponent {
    void inject(HomeActivity homeActivity);

    VehicleListingViewModel getVehicleListingViewModel();
}
