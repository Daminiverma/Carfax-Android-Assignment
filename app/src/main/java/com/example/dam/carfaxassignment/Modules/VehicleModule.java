package com.example.dam.carfaxassignment.Modules;

import android.arch.persistence.room.Room;
import android.content.Context;

import com.example.dam.carfaxassignment.Database.VehicleRoomDatabase;
import com.example.dam.carfaxassignment.Interfaces.IVehicleDao;
import com.example.dam.carfaxassignment.Interfaces.IVehicleService;
import com.example.dam.carfaxassignment.Services.VehicleService;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class VehicleModule {
    private Context context;

    public VehicleModule(Context context) {
        this.context = context;
    }

    @Provides
    public IVehicleService provideVehicleService(VehicleService vehicleService) {
        return vehicleService;
    }

    @Singleton
    @Provides
    public Context provideContext() {
        return context;
    }

    @Singleton
    @Provides
    public VehicleRoomDatabase provideMyDatabase(Context context) {
        return Room.databaseBuilder(context, VehicleRoomDatabase.class, "vehicle_room").build();
    }

    @Provides
    public Executor provideExecutors() {
        return Executors.newSingleThreadExecutor();
    }

    @Singleton
    @Provides
    public IVehicleDao provideUserDao(VehicleRoomDatabase myDatabase) {
        return myDatabase.vehicleDao();
    }
}