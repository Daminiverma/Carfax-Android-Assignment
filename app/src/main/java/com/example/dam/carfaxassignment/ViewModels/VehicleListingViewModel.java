package com.example.dam.carfaxassignment.ViewModels;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;
import com.example.dam.carfaxassignment.Models.VehicleListing;
import com.example.dam.carfaxassignment.Repositories.VehicleRepository;
import java.util.ArrayList;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class VehicleListingViewModel extends ViewModel {

    private VehicleRepository vehicleRepository;
    public static LiveData<ArrayList<VehicleListing>> vehicleListings;

    @Inject
    public VehicleListingViewModel(VehicleRepository vehicleRepository)
    {
        this.vehicleRepository = vehicleRepository;
    }

    public LiveData<ArrayList<VehicleListing>> getVehicleListings()
    {
        vehicleListings = vehicleRepository.getVehicleListings();
        return vehicleListings;
    }

    public VehicleListing getVehicleListingAtPosition(int position)
    {
        if(vehicleListings != null || vehicleListings.getValue().get(position) != null)
        {
            return vehicleListings.getValue().get(position);
        }
        return null;
    }
}
