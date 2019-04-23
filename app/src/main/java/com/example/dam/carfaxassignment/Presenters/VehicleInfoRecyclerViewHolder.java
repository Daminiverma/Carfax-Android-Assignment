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
    ImageView vehicleInfoImageView;
    TextView vehicleInfoYearMakeModelTrimTextView, vehicleInfoPriceTextView, vehicleInfoMilageTextView, vehicleInfoLocationTextView;
    Button vehicleInfoCallDealerButton;

    public VehicleInfoRecyclerViewHolder(View itemView) {
        super(itemView);

        vehicleInfoImageView = (ImageView) itemView.findViewById(R.id.vehicle_info_image);
        vehicleInfoYearMakeModelTrimTextView = (TextView) itemView.findViewById(R.id.vehicle_info_year_make_model_trim);
        vehicleInfoPriceTextView = (TextView) itemView.findViewById(R.id.vehicle_info_price);
        vehicleInfoMilageTextView = (TextView) itemView.findViewById(R.id.vehicle_info_milage);
        vehicleInfoLocationTextView = (TextView) itemView.findViewById(R.id.vehicle_info_location);
        vehicleInfoCallDealerButton = (Button) itemView.findViewById(R.id.vehicle_info_call_dealer_button);
        vehicleInfoCardView = (CardView) itemView.findViewById(R.id.vehicle_info_card_view);
    }
}
