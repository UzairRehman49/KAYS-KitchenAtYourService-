package com.example.kays;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Shifts#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Shifts extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Shifts() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Shifts.
     */
    // TODO: Rename and change types and number of parameters
    public static Shifts newInstance(String param1, String param2) {
        Shifts fragment = new Shifts();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    private RecyclerView recyclerView;
    private shiftsAdapter adapter;
    private List<availableShifts> DataList = new ArrayList<>();

    private void shiftsDummyData()
    {
        availableShifts data = new availableShifts("6:00","8:00");
        DataList.add(data);
        availableShifts data1 = new availableShifts("10:00","11:00");
        DataList.add(data1);
        availableShifts data2 = new availableShifts("12:00","2:00");
        DataList.add(data2);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.i("shifts","Entered in onCreateView");

        View view=inflater.inflate(R.layout.fragment_shifts, container, false);
        recyclerView = (RecyclerView) view.findViewById(R.id.shift_recyclerview);
        adapter = new shiftsAdapter(DataList);
        RecyclerView.LayoutManager manager;
        manager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL ,false );
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(adapter);
        shiftsDummyData();
        Log.i("selectK","About to end");
        // Inflate the layout for this fragment
        return view;

    }
}
