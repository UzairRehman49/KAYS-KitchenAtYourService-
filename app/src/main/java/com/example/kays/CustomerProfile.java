package com.example.kays;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CustomerProfile#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CustomerProfile extends Fragment {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;
    Context c=getActivity();
    ArrayList<CustomerOrderData> items=new ArrayList<CustomerOrderData>();
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public CustomerProfile() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment CustomerProfile.
     */
    // TODO: Rename and change types and number of parameters
    public static CustomerProfile newInstance(String param1, String param2) {
        CustomerProfile fragment = new CustomerProfile();
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

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_customer_profile, container, false);
        items = OrderDummyData();
        if(items!=null)
            Log.i("selectK","About to end");
        recyclerView =  view.findViewById(R.id.orderlist);
        mAdapter = new CustomerOrderAdapter( items , c);
        recyclerView.setLayoutManager(new LinearLayoutManager(c));
        recyclerView.setAdapter(mAdapter);
        return view;
    }
    public ArrayList<CustomerOrderData> OrderDummyData()
    {
        ArrayList<String> i = new ArrayList<String>();
        i.add("Pizza");
        i.add("Burger");
        ArrayList<CustomerOrderData>temp=new ArrayList<CustomerOrderData>();
        CustomerOrderData c= new CustomerOrderData(i,"Pending");
        CustomerOrderData d= new CustomerOrderData(i,"Complete");
        temp.add(c);
        temp.add(d);
        return temp;
    }
}
