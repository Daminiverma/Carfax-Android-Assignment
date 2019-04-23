package com.example.dam.carfaxassignment.Presenters;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.Observer;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import com.example.dam.carfaxassignment.Interfaces.DaggerVehicleListingVMComponent;
import com.example.dam.carfaxassignment.Interfaces.VehicleListingVMComponent;
import com.example.dam.carfaxassignment.Models.VehicleListing;
import com.example.dam.carfaxassignment.R;
import com.example.dam.carfaxassignment.ViewModels.VehicleListingViewModel;
import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity {

    RecyclerView vehicleInfoRecyclerView;
    RecyclerView.LayoutManager layoutManager;
    RecyclerView.Adapter adapter;
    VehicleListingViewModel vehicleListingViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        vehicleInfoRecyclerView = (RecyclerView) findViewById(R.id.vehicle_info_recycler_view);
        layoutManager = new LinearLayoutManager(this);
        vehicleInfoRecyclerView.setLayoutManager(layoutManager);
        vehicleInfoRecyclerView.setHasFixedSize(true);

        VehicleListingVMComponent vehicleListingVMComponent = DaggerVehicleListingVMComponent.create();
        vehicleListingViewModel = vehicleListingVMComponent.getVehicleListingViewModel();

        vehicleListingViewModel.getVehicleListings().observe(this, new Observer<ArrayList<VehicleListing>>() {
            @Override
            public void onChanged(@Nullable ArrayList<VehicleListing> vehicleListing) {
                adapter = new VehicleInfoRecyclerAdapter(vehicleListing, HomeActivity.this);
                adapter.notifyDataSetChanged();
                vehicleInfoRecyclerView.setAdapter(adapter);
            }
        });
    }
}
