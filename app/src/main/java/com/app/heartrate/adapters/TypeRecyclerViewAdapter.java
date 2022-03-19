package com.app.heartrate.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.app.heartrate.R;
import com.app.heartrate.activities.HistoryDetail;
import com.app.heartrate.info.Info;
import com.app.heartrate.mvvm.capsules.Super;
import com.app.heartrate.mvvm.capsules.response.HistoryPojo;
import com.app.heartrate.sigletons.HistorySingleton;

import java.util.List;

public class TypeRecyclerViewAdapter extends RecyclerView.Adapter<TypeRecyclerViewHolder> implements Info {

    Context context;
    List<Super> listInstances;
    int type;

    public TypeRecyclerViewAdapter(Context context, List<Super> listInstances, int type) {
        this.context = context;
        this.listInstances = listInstances;
        this.type = type;
    }

    @NonNull
    @Override
    public TypeRecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater li = LayoutInflater.from(context);
        View view;
        view = li.inflate(R.layout.capture_history, parent, false);

        return new TypeRecyclerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final TypeRecyclerViewHolder holder, int position) {
        initCapture(holder, position);
    }

    private void initCapture(TypeRecyclerViewHolder holder, int position) {
        HistoryPojo historyPojo = (HistoryPojo) listInstances.get(position);
        holder.tvCreatedOn.setText(historyPojo.getCreatedOn());
        holder.tvTarget.setText(String.valueOf(historyPojo.getTarget()));
        holder.cvBelow.setOnClickListener(view -> {
            HistorySingleton.setInstance(historyPojo);
            context.startActivity(new Intent(context, HistoryDetail.class));
        });
    }

    @Override
    public int getItemCount() {
        return listInstances.size();
    }

    @Override
    public int getItemViewType(int position) {
        return 0;
    }
}
