package com.example.kays;

import android.app.TimePickerDialog;
import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link AddNewShift#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AddNewShift extends Fragment implements TimePickerDialog.OnTimeSetListener, AdapterView.OnItemSelectedListener {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    Button btn;
    TextView txt, txt2;
    Spinner spinner;
    Context context;
    String city;
    GridView gridView;
    String[] FoodNames = {"Chicken Grilled Burger","Noodles","Chicken Karahi","Club Sandwich"};
    int[] foodImages = {R.drawable.burger,R.drawable.nodles,R.drawable.chickenkarahi,R.drawable.sandwich};

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public AddNewShift() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment AddNewShift.
     */
    // TODO: Rename and change types and number of parameters
    public static AddNewShift newInstance(String param1, String param2) {
        AddNewShift fragment = new AddNewShift();
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

       context= container.getContext();




        return inflater.inflate(R.layout.fragment_add_new_shift, container, false);
    }

    @Override
    public void onTimeSet(android.widget.TimePicker view, int hourOfDay, int minute) {


        String hour= Integer.toString(hourOfDay);
        String min= Integer.toString(minute);
        txt.setText("Hour: "+hour +"Minute: "+ min);



    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        txt= view.findViewById(R.id.txtStartTime);
        txt2= view.findViewById(R.id.txtEndTime);

        txt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                DialogFragment timePicker= new TimePicker();
                timePicker.show(getChildFragmentManager(), "time picker");


            }
        });


        txt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                DialogFragment timePicker= new TimePicker2();
                timePicker.show(getChildFragmentManager(), "time picker");

            }
        });

        spinner= view.findViewById(R.id.myspinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(context, R.array.cities, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);





        gridView= view.findViewById(R.id.gridview);

        CustomAdapter customAdapter= new CustomAdapter();
        gridView.setAdapter(customAdapter);






    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        city= parent.getItemAtPosition(position).toString();
        Toast.makeText(context, city, Toast.LENGTH_LONG).show();

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    public class CustomAdapter extends BaseAdapter{


        @Override
        public int getCount() {
            return foodImages.length;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            View view1= getLayoutInflater().inflate(R.layout.row_data, null);

            TextView name= view1.findViewById(R.id.foods);
            ImageView image= view1.findViewById(R.id.images);

            name.setText(FoodNames[position]);
            image.setImageResource(foodImages[position]);

            return  view1;

        }
    }
}
