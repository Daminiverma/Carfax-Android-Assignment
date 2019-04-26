package com.example.dam.carfaxassignment.Presenters;

import android.Manifest;
import android.arch.lifecycle.Observer;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.dam.carfaxassignment.Interfaces.DaggerVehicleComponent;
import com.example.dam.carfaxassignment.Interfaces.VehicleComponent;
import com.example.dam.carfaxassignment.Models.VehicleListing;
import com.example.dam.carfaxassignment.Modules.VehicleModule;
import com.example.dam.carfaxassignment.R;
import com.example.dam.carfaxassignment.ViewModels.VehicleListingViewModel;

import java.util.List;

import butterknife.ButterKnife;

public class HomeActivity extends AppCompatActivity {

    RecyclerView vehicleInfoRecyclerView;
    RecyclerView.LayoutManager layoutManager;
    RecyclerView.Adapter adapter;
    VehicleListingViewModel vehicleListingViewModel;
    static final Integer CALL = 0x2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        vehicleInfoRecyclerView = (RecyclerView) findViewById(R.id.vehicle_info_recycler_view);
        layoutManager = new LinearLayoutManager(this);
        vehicleInfoRecyclerView.setLayoutManager(layoutManager);
        vehicleInfoRecyclerView.setHasFixedSize(true);

        ButterKnife.bind(this);
        MyApp.app().vehicleComponent().inject(this);

        VehicleComponent vehicleComponent = DaggerVehicleComponent.builder().vehicleModule(new VehicleModule(this)).build();
        vehicleListingViewModel = vehicleComponent.getVehicleListingViewModel();

        vehicleListingViewModel.getVehicleListings().observe(this, new Observer<List<VehicleListing>>() {
            @Override
            public void onChanged(@Nullable List<VehicleListing> vehicleListing) {
                adapter = new VehicleInfoRecyclerAdapter(vehicleListing, HomeActivity.this);
                adapter.notifyDataSetChanged();
                vehicleInfoRecyclerView.setAdapter(adapter);
            }
        });
    }

    public void InitiateCall(String phoneNumber) {
        if (ActivityCompat.checkSelfPermission(HomeActivity.this, Manifest.permission.CALL_PHONE)
                != PackageManager.PERMISSION_GRANTED) {
            //Permission Not granted Request Permission
            ActivityCompat.requestPermissions(HomeActivity.this, new String[]{Manifest.permission.CALL_PHONE}, CALL);
        } else {
            // Permission has already been granted
            Intent callIntent = new Intent(Intent.ACTION_CALL);
            callIntent.setData(Uri.parse("tel:" + phoneNumber));
            if (callIntent.resolveActivity(this.getPackageManager()) != null) {
                this.startActivity(callIntent);
            }
        }
    }

    private boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(this.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    private void showAlertAndExit() {
        new AlertDialog.Builder(this)
                .setTitle("Error")
                .setMessage("Your device seems to be offline." +
                        " Please connect to internet once to fetch the data.")
                .setNegativeButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        onBackPressed();
                    }
                })
                .setIcon(android.R.drawable.ic_dialog_alert)
                .show();
    }
}
