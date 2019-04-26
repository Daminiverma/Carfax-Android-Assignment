package com.example.dam.carfaxassignment.Database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import com.example.dam.carfaxassignment.Interfaces.IVehicleDao;
import com.example.dam.carfaxassignment.Models.VehicleListing;

@Database(entities = {VehicleListing.class}, version = 1, exportSchema = false)
public abstract class VehicleRoomDatabase extends RoomDatabase {
    public abstract IVehicleDao vehicleDao();
}
