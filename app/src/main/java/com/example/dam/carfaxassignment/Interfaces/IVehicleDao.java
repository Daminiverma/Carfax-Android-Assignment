package com.example.dam.carfaxassignment.Interfaces;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.example.dam.carfaxassignment.Models.VehicleListing;

import java.util.List;

import javax.inject.Singleton;

@Dao
@Singleton
public interface IVehicleDao {

    @Insert
    void insert(VehicleListing vehicleListing);

    @Query("Select * from vehicle_details_table")
    List<VehicleListing> getAllVehicles();

    @Query("Select * from vehicle_details_table where vin = :vinNumber")
    VehicleListing getOneVehicle(String vinNumber);

    @Query("SELECT COUNT(*) from vehicle_details_table")
    int count();

}
