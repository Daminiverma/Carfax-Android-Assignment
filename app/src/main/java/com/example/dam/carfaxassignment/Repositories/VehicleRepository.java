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
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

@Singleton
public class VehicleRepository {

    @Inject
    public VehicleRepository() {
    }

    public LiveData<ArrayList<VehicleListing>> getVehicleListings() {

        final LiveData<ArrayList<VehicleListing>> vehicleListings = new MutableLiveData<>();

        VehicleService vehicleService = RetrofitClient.getClient().create(VehicleService.class);
        vehicleService.getVehicleDetails().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<VehicleResponse>() {
                    @Override
                    public void onCompleted() {
                        Log.d("01","Response Successfully Completed");
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d("02",e.getMessage());
                    }

                    @Override
                    public void onNext(VehicleResponse vehicleResponse) {
                        ((MutableLiveData<ArrayList<VehicleListing>>) vehicleListings).setValue(vehicleResponse.getVehicleListings());
                    }
                });
        return vehicleListings;
    }
}
