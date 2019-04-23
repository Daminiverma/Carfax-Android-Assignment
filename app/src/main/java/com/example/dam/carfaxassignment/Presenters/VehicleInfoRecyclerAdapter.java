package com.example.dam.carfaxassignment.Presenters;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import com.example.dam.carfaxassignment.Models.VehicleListing;
import com.example.dam.carfaxassignment.R;
import com.squareup.picasso.Picasso;
import java.util.ArrayList;

public class VehicleInfoRecyclerAdapter extends RecyclerView.Adapter<VehicleInfoRecyclerViewHolder> {

    Context context;
    ArrayList<VehicleListing> vehicleListings = new ArrayList<>();

    public VehicleInfoRecyclerAdapter(ArrayList<VehicleListing> vehicleListing, Context context) {
        this.vehicleListings = vehicleListing;
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
    public void onBindViewHolder(@NonNull final VehicleInfoRecyclerViewHolder holder, final int position) {

        VehicleListing vehicleInfoList = vehicleListings.get(position);

        String yearMakeModelTrim = vehicleInfoList.getYear() + " " + vehicleInfoList.getMake() + " " + vehicleInfoList.getModel() + " " + ((vehicleInfoList.getTrim().equals("Unspecified")) ? "" : vehicleInfoList.getTrim()) ;
        holder.vehicleInfoYearMakeModelTrimTextView.setText(yearMakeModelTrim);

        String imageUrl = "https://www.carfax.com/uclassets/images/vdp-noimage.png";
        if (vehicleInfoList.getImages() != null) {
            imageUrl = vehicleInfoList.getImages().getFirstPhoto().getLarge();
        }
        Picasso.get().load(imageUrl).into(holder.vehicleInfoImageView);
        holder.vehicleInfoPriceTextView.setText("$ " +  vehicleInfoList.getCurrentPrice());
        holder.vehicleInfoMilageTextView.setText(vehicleInfoList.getMilage().toString()+" mi");
        holder.vehicleInfoLocationTextView.setText(vehicleInfoList.getVehicleDealer().getCity() + ", " + vehicleInfoList.getVehicleDealer().getState());
        holder.vehicleInfoCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context,DetailsActivity.class);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return vehicleListings.size();
    }
}
