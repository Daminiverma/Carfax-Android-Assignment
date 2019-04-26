package com.example.dam.carfaxassignment.Presenters;

import android.app.Application;

import com.example.dam.carfaxassignment.Interfaces.DaggerVehicleComponent;
import com.example.dam.carfaxassignment.Interfaces.VehicleComponent;
import com.example.dam.carfaxassignment.Modules.VehicleModule;


public class MyApp extends Application {
    private static MyApp app;
    private VehicleComponent vehicleComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        app = this;
        vehicleComponent = DaggerVehicleComponent.builder()
                .vehicleModule(new VehicleModule(getApplicationContext())).build();
    }

    public static MyApp app() {
        return app;
    }

    public VehicleComponent vehicleComponent() {
        return vehicleComponent;
    }
}