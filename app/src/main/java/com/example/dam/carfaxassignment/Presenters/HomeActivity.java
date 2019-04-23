package com.example.dam.carfaxassignment.Presenters;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import com.example.dam.carfaxassignment.Models.VehicleListing;
import com.example.dam.carfaxassignment.Models.VehicleResponse;
import com.example.dam.carfaxassignment.R;
import com.example.dam.carfaxassignment.Services.RetrofitClient;
import com.example.dam.carfaxassignment.Services.VehicleService;
import java.util.ArrayList;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeActivity extends AppCompatActivity {

    RecyclerView vehicleInfoRecyclerView;
    RecyclerView.LayoutManager layoutManager;
    RecyclerView.Adapter adapter;
    ArrayList<VehicleListing> vehicleListing = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        vehicleInfoRecyclerView = (RecyclerView) findViewById(R.id.vehicle_info_recycler_view);
        layoutManager = new LinearLayoutManager(this);
        vehicleInfoRecyclerView.setLayoutManager(layoutManager);
        vehicleInfoRecyclerView.setHasFixedSize(true);

        VehicleService vehicleService = RetrofitClient.getClient().create(VehicleService.class);
        vehicleService.getVehicleDetails().enqueue(new Callback<VehicleResponse>() {
            @Override
            public void onResponse(Call<VehicleResponse> call, Response<VehicleResponse> response) {
                vehicleListing = response.body().getVehicleListings();

                adapter = new VehicleInfoRecyclerAdapter(vehicleListing, HomeActivity.this);
                vehicleInfoRecyclerView.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<VehicleResponse> call, Throwable t) {

            }
        });



    }
}
