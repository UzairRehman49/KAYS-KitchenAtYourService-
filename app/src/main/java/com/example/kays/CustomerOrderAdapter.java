package com.example.kays;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CustomerOrderAdapter extends RecyclerView.Adapter<CustomerOrderAdapter.CustomerViewHolder> {
    ArrayList<CustomerOrderData> list=null;
    Context context;
    public CustomerOrderAdapter (ArrayList<CustomerOrderData>i,Context context)
    {
        //list=new ArrayList<ChefOrderData>();
        list=i;
        this.context = context;
    }

    @NonNull
    @Override
    public CustomerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v =  LayoutInflater.from(parent.getContext())
                .inflate(R.layout.order_row, parent, false);
        CustomerOrderAdapter.CustomerViewHolder vh = new CustomerOrderAdapter.CustomerViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull CustomerViewHolder holder, int position) {
        holder.items.setText(list.get(position).items.get(0));
        holder.status.setText(list.get(position).Status);
    }

    @Override
    public int getItemCount() {

            return list.size();

    }

    public static class CustomerViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView items,status;
        CardView card;
        public CustomerViewHolder(View itemView ) {
            super(itemView);
            items= itemView.findViewById(R.id.items);
            status= itemView.findViewById(R.id.status);
            card = itemView.findViewById(R.id.card_view);
        }
    }



}
