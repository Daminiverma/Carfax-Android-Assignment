package com.example.dam.carfaxassignment.Presenters;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.dam.carfaxassignment.Models.VehicleInfoModel;
import com.example.dam.carfaxassignment.R;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity {

    RecyclerView vehicleInfoRecyclerView;
    RecyclerView.LayoutManager layoutManager;
    RecyclerView.Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        vehicleInfoRecyclerView = (RecyclerView) findViewById(R.id.vehicle_info_recycler_view);
        layoutManager = new LinearLayoutManager(this);
        vehicleInfoRecyclerView.setLayoutManager(layoutManager);
        vehicleInfoRecyclerView.setHasFixedSize(true);

        ArrayList<VehicleInfoModel> vehicleInfoList = new ArrayList<>();
        for(int i=1; i<=25; i++) {
            vehicleInfoList.add(new VehicleInfoModel("",2000 + i, "Volkswagon", "model " + i,"trim ss de nno ooy uu info"+i,""+i*100,"location"+i,255.555 * i ));
        }

        adapter = new VehicleInfoRecyclerAdapter(vehicleInfoList, this);
        vehicleInfoRecyclerView.setAdapter(adapter);

    }
}
