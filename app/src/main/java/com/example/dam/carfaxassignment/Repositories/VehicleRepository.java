package com.example.dam.carfaxassignment.Repositories;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.util.Log;

import com.example.dam.carfaxassignment.Models.VehicleListing;
import com.example.dam.carfaxassignment.Models.VehicleResponse;
import com.example.dam.carfaxassignment.Services.RetrofitClient;
import com.example.dam.carfaxassignment.Services.VehicleService;

import java.util.ArrayList;

import javax.inject.Inject;
import javax.inject.Singleton;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

@Singleton
public class VehicleRepository {

    @Inject
    public VehicleRepository() {
    }

    public LiveData<ArrayList<VehicleListing>> getVehicleListings() {

        final LiveData<ArrayList<VehicleListing>> vehicleListings = new MutableLiveData<>();

        VehicleService vehicleService = RetrofitClient.getClient().create(VehicleService.class);
        vehicleService.getVehicleDetails().enqueue(new Callback<VehicleResponse>() {
            @Override
            public void onResponse(Call<VehicleResponse> call, Response<VehicleResponse> response) {
                ((MutableLiveData<ArrayList<VehicleListing>>) vehicleListings).setValue(response.body().getVehicleListings());
            }

            @Override
            public void onFailure(Call<VehicleResponse> call, Throwable t) {
                Log.d("Error", t.getMessage());
            }
        });
        return vehicleListings;
    }
}
