package com.app.heartrate.adapters;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.app.heartrate.R;

public class TypeRecyclerViewHolder extends RecyclerView.ViewHolder {

    TextView tvTarget;
    TextView tvCreatedOn;
    CardView cvBelow;

    public TypeRecyclerViewHolder(@NonNull View itemView) {
        super(itemView);

        tvTarget = itemView.findViewById(R.id.tv_target);
        tvCreatedOn = itemView.findViewById(R.id.tv_created);
        cvBelow = itemView.findViewById(R.id.cv_below);
    }

}


