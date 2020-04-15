package com.example.kays;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class shiftsAdapter extends RecyclerView.Adapter<shiftsAdapter.MyViewHolder> {

    List shiftsList;
    public shiftsAdapter(List shiftsList) {
        this.shiftsList=shiftsList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.shifts_list, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull shiftsAdapter.MyViewHolder viewHolder, int i) {
        availableShifts data= (availableShifts) shiftsList.get(i);
        viewHolder.startTime.setText(data.startTime);
        viewHolder.endTime.setText(data.endTime);
    }

    @Override
    public int getItemCount() {
        return shiftsList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView startTime;
        TextView endTime;
        CardView parent;
        public MyViewHolder(View itemView) {
            super(itemView);
            parent = itemView.findViewById(R.id.shifts_card_view);
            startTime = itemView.findViewById(R.id.startTime);
            endTime = itemView.findViewById(R.id.endTime);

        }
    }
}

