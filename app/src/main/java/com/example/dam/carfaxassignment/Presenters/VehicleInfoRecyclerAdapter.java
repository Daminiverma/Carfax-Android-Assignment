package com.example.dam.carfaxassignment.Presenters;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.dam.carfaxassignment.Models.VehicleInfoModel;
import com.example.dam.carfaxassignment.R;

import java.util.ArrayList;

public class VehicleInfoRecyclerAdapter extends RecyclerView.Adapter<VehicleInfoRecyclerViewHolder> {

    ArrayList<VehicleInfoModel> vehicleInfoList = new ArrayList<>();
    Context context;

    public VehicleInfoRecyclerAdapter(ArrayList<VehicleInfoModel> vehicleInfoList, Context context) {
        this.vehicleInfoList = vehicleInfoList;
        this.context = context;
    }

    @NonNull
    @Override
    public VehicleInfoRecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.vehicle_card_layout,parent,false);
        VehicleInfoRecyclerViewHolder vehicleInfoRecyclerViewHolder = new VehicleInfoRecyclerViewHolder(view);
        return vehicleInfoRecyclerViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull VehicleInfoRecyclerViewHolder holder, final int position) {
        VehicleInfoModel vehicleInfo = vehicleInfoList.get(position);
        String yearMakeModelTrim = vehicleInfo.getYear() + " " + vehicleInfo.getMake() + " " + vehicleInfo.getModel() + " " + vehicleInfo.getTrim();
        holder.vehicleInfoYearMakeModelTrim.setText(yearMakeModelTrim);
        holder.vehicleInfoPrice.setText("$ " +  vehicleInfo.getPrice());
        holder.vehicleInfoMilage.setText("$ " +  vehicleInfo.getMilage());
        holder.vehicleInfoLocation.setText("$ " +  vehicleInfo.getLocation());
        holder.vehicleInfoCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Intent intent = new Intent(context,)
                Toast.makeText(context, "Cklicked " + position, Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return vehicleInfoList.size();
    }
}
