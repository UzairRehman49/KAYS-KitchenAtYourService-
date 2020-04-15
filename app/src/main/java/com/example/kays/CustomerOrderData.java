package com.example.kays;


import android.content.Context;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class CustomerOrderData {
    ArrayList<String> items=null;
    String Status;
    public CustomerOrderData(ArrayList<CustomerOrderData> items, Context c)
    {}
    public CustomerOrderData(ArrayList<String>items, String status)
    {
        this.items=items;
        this.Status=status;
    }
}
