package com.example.kays;

import android.app.Dialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import java.util.Calendar;

public class TimePicker2 extends DialogFragment {


    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {

        Calendar c= Calendar.getInstance();
        int hour= c.get(Calendar.HOUR_OF_DAY);
        int minute= c.get(Calendar.MINUTE);


        return new TimePickerDialog(getActivity(), new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(android.widget.TimePicker view, int hourOfDay, int minute) {


                String hour;
                String min;
                view.setIs24HourView(false);
                TextView txt= getActivity().findViewById(R.id.txtEndTime);

                if(hourOfDay<10) {
                    String x = Integer.toString(hourOfDay);
                    hour= "0"+x;

                }
                else {
                    hour= Integer.toString(hourOfDay);
                }

                if(minute<10)
                {
                    String y= Integer.toString(minute);
                    min= "0"+y;
                }
                else
                {
                    min= Integer.toString(minute);
                }



                txt.setText(hour +":"+ min);



            }
        }, hour, minute, false);


    }
}

