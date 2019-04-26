package com.example.dam.carfaxassignment.Repositories;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;

import com.example.dam.carfaxassignment.Interfaces.IVehicleDao;
import com.example.dam.carfaxassignment.Interfaces.IVehicleService;
import com.example.dam.carfaxassignment.Models.VehicleListing;
import com.example.dam.carfaxassignment.Models.VehicleResponse;
import com.example.dam.carfaxassignment.Services.RetrofitClient;

import java.util.List;
import java.util.concurrent.Executor;

import javax.inject.Inject;
import javax.inject.Singleton;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

@Singleton
public class VehicleRepository {

    IVehicleDao vehicleDao;
    LiveData<List<VehicleListing>> vehicleListings = new MutableLiveData<>();
    List<VehicleListing> list;
    IVehicleService vehicleService;
    Executor executor;

    @Inject
    public VehicleRepository(IVehicleService vehicleService, IVehicleDao vehicleDao, Executor executor) {
        this.vehicleService = vehicleService;
        this.vehicleDao = vehicleDao;
        this.executor = executor;
    }

    public LiveData<List<VehicleListing>> getVehicleListings() {
        executor.execute(new Runnable() {
            @Override
            public void run() {
                if (vehicleDao.count() == 0) {
                    getVehicleListingsFromService();
                } else {
                    list = vehicleDao.getAllVehicles();
                    Handler handler = new Handler(Looper.getMainLooper());
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            ((MutableLiveData<List<VehicleListing>>) vehicleListings).setValue(list);
                        }
                    });
                }
            }
        });

        return vehicleListings;
    }

    private void getVehicleListingsFromService() {
        vehicleService = RetrofitClient.getClient().create(IVehicleService.class);
        vehicleService.getVehicleDetails().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<VehicleResponse>() {
                    @Override
                    public void onCompleted() {
                    }

                    @Override
                    public void onError(Throwable e) {
                        if (e.getMessage().contains("Unable to resolve host")) {
                            Log.d("404", "Internet not available");
                            return;
                            //Internet Connection is not available.
                        } else {
                            //Unknown error occured.
                            Log.d("401", "Unknown error occured");
                        }
                    }

                    @Override
                    public void onNext(VehicleResponse vehicleResponse) {
                        ((MutableLiveData<List<VehicleListing>>) vehicleListings).setValue(vehicleResponse.getVehicleListings());

                        executor.execute(new Runnable() {
                            @Override
                            public void run() {
                                for (VehicleListing listing : vehicleListings.getValue()) {
                                    vehicleDao.insert(listing);
                                    Log.d("101", "Data Successfully Inserted");
                                }
                            }
                        });
                    }
                });
    }
}
