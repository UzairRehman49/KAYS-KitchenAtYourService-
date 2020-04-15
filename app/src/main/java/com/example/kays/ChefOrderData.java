package com.example.kays;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class ChefOrderData {
    ArrayList<String> items=null;
    String Status;
public ChefOrderData()
{}
    public ChefOrderData(ArrayList<String>items, String status)
    {
        this.items=items;
        this.Status=status;
    }
}
