package com.example.kays;

import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;
import java.util.Random;

import static androidx.core.content.ContextCompat.startActivity;


class chefSelectionAdapter extends RecyclerView.Adapter<chefSelectionAdapter.MyViewHolder> {

    List availableChefList;
    Context c;

    public chefSelectionAdapter(List availableChefList,Context c) {
        this.availableChefList=availableChefList;
        this.c=c;

    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.available_chef_list, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder viewHolder, int i) {
        chefData data= (chefData) availableChefList.get(i);
        //Random rnd = new Random();
        //int currentColor = Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256));
        //viewHolder.parent.setBackgroundColor(currentColor);
        viewHolder.name.setText(data.name);
        viewHolder.parent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(c,"Hi I am pressed",Toast.LENGTH_LONG).show();
                Intent i = new Intent(c, ItemSelection.class);
                c.startActivity(i);
            }
        });

    }

    @Override
    public int getItemCount() {
        return availableChefList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView name;
        CardView parent;
        public MyViewHolder(View itemView) {
            super(itemView);
            parent = itemView.findViewById(R.id.card_view);
            name = itemView.findViewById(R.id.chef_name);

        }
    }
}
