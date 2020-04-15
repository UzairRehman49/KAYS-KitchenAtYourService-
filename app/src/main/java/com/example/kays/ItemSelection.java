package com.example.kays;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public class ItemSelection extends AppCompatActivity {
    private RecyclerView recyclerView;
    private foodItemSelectionAdapter foodAdapter;
    private List<foodItemsData> foodDataList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_selection);
        Log.i("Orders","on Create view called");

        recyclerView = (RecyclerView) findViewById(R.id.order_foodItems_recyclerview);
        foodAdapter = new foodItemSelectionAdapter(foodDataList);
        RecyclerView.LayoutManager manager;
        manager = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL ,false );
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(foodAdapter);
        foodDummyData();
    }
    private void foodDummyData() {
        Log.i("Orders","on food dummy called");
        foodItemsData data = new foodItemsData("Burger", "200");
        foodDataList.add(data);
        foodItemsData data1 = new foodItemsData("Fries", "100");
        foodDataList.add(data1);
        foodItemsData data2 = new foodItemsData("Cake", "500");
        foodDataList.add(data2);
    }


}


