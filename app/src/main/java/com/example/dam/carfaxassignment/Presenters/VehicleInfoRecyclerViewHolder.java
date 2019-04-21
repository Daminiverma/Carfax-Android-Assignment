package com.example.dam.carfaxassignment.Presenters;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.dam.carfaxassignment.R;

public class VehicleInfoRecyclerViewHolder extends RecyclerView.ViewHolder {

    CardView vehicleInfoCardView;
    ImageView vehicleInfoImage;
    TextView vehicleInfoYearMakeModelTrim, vehicleInfoPrice, vehicleInfoMilage, vehicleInfoLocation;
    Button vehicleInfoCallDealerButton;

    public VehicleInfoRecyclerViewHolder(View itemView) {
        super(itemView);

        vehicleInfoImage = (ImageView) itemView.findViewById(R.id.vehicle_info_image);
        vehicleInfoYearMakeModelTrim = (TextView) itemView.findViewById(R.id.vehicle_info_year_make_model_trim);
        vehicleInfoPrice = (TextView) itemView.findViewById(R.id.vehicle_info_price);
        vehicleInfoMilage = (TextView) itemView.findViewById(R.id.vehicle_info_milage);
        vehicleInfoLocation = (TextView) itemView.findViewById(R.id.vehicle_info_location);
        vehicleInfoCallDealerButton = (Button) itemView.findViewById(R.id.vehicle_info_call_dealer_button);
        vehicleInfoCardView = (CardView) itemView.findViewById(R.id.vehicle_info_card_view);
    }
}
