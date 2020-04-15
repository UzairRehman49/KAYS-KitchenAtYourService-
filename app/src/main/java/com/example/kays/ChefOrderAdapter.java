package com.example.kays;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class ChefOrderAdapter extends RecyclerView.Adapter<ChefOrderAdapter.MyViewHolder> {
    ArrayList<ChefOrderData> list=null;
    Context context;
    public ChefOrderAdapter (ArrayList<ChefOrderData>i,Context context)
    {
        //list=new ArrayList<ChefOrderData>();
        list=i;
        this.context = context;
    }
    public static class MyViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView items,status;
        CardView card;
        public MyViewHolder(View itemView ) {
            super(itemView);
            items= itemView.findViewById(R.id.items);
            status= itemView.findViewById(R.id.status);
            card = itemView.findViewById(R.id.card_view);
        }
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v =  LayoutInflater.from(parent.getContext())
                .inflate(R.layout.order_row, parent, false);
        MyViewHolder vh = new MyViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        holder.items.setText(list.get(position).items.get(0));
        holder.status.setText(list.get(position).Status);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }


}
