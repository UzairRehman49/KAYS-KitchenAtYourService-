package com.example.kays;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class SelectKitchenActivity extends AppCompatActivity {


    private RecyclerView recyclerView;
    private chefSelectionAdapter chefAdapter;
    private List<chefData> chefDataList = new ArrayList<>();


    private void ChefDummyData(){
        chefData data = new chefData("Ali");
        chefDataList.add(data);
        chefData data1 = new chefData("Ahmed");
        chefDataList.add(data1);
        chefData data2 = new chefData("Ayesha");
        chefDataList.add(data2);
        chefData data3 = new chefData("Imran");
        chefDataList.add(data3);
        chefData data4 = new chefData("Saad");
        chefDataList.add(data4);
        chefData data5 = new chefData("Sana");
        chefDataList.add(data5);

//            Collections.sort(studentDataList, new Comparator() {
//                @Override
//                public int compare(studentData o1, studentData o2) {
//                    return o1.name.compareTo(o2.name);
//                }
//            });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_kitchen);


        recyclerView = (RecyclerView) findViewById(R.id.select_chef_recyclerview);
        chefAdapter = new chefSelectionAdapter(chefDataList,getApplicationContext());
        RecyclerView.LayoutManager manager;
        manager = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL ,false );
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(chefAdapter);
        ChefDummyData();
        Log.i("selectK","About to end");
        // Inflate the layout for this fragment

    }
}
