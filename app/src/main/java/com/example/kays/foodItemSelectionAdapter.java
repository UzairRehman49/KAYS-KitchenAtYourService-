package com.example.kays;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class foodItemSelectionAdapter  extends RecyclerView.Adapter<foodItemSelectionAdapter.MyViewHolder> {

    List foodList;
    public foodItemSelectionAdapter(List foodList) {
        this.foodList= foodList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.order_food_item_list, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder viewHolder, int i) {
        foodItemsData data= (foodItemsData) foodList.get(i);
        viewHolder.name.setText(data.foodName);
        viewHolder.price.setText( data.foodPrice);
        //viewHolder.image.setImageURI();
        //viewHolder.checkBox.setChecked(data.isChecked);
    }

    @Override
    public int getItemCount() {

        return foodList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView name;
        TextView price;
        //ImageView image;
        CardView parent;
        //CheckBox checkBox;
        public MyViewHolder(View itemView) {
            super(itemView);
            parent = itemView.findViewById(R.id.food_card_view);
            name = itemView.findViewById(R.id.foodName);
            price = itemView.findViewById(R.id.food_price);
          //  image = (ImageView) itemView.findViewById(R.id.food_image);
            //checkBox = (CheckBox) itemView.findViewById(R.id.foodSelection);

        }
    }
}

