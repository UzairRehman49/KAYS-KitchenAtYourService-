package com.example.kays;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btnChef;
    Button btnCustomer;
    Button btnSignup;
    TextView txtSignup;
    Button btnLogin;
    RadioButton r1,r2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        r1=findViewById(R.id.radio_customer);
        r2=findViewById(R.id.radio_chef);
        txtSignup= findViewById(R.id.txtSignup);
        btnLogin= findViewById(R.id.btn_login);
        txtSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(getApplicationContext(), Signup.class);

              startActivity(i);


            }
        });

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(r1.isChecked())
                {
                    Intent i = new Intent(getApplicationContext(), CustomerDashboard.class);
                    startActivity(i);
                }
                else if(r2.isChecked())
                {
                    Intent i = new Intent(getApplicationContext(), ChefDashboard.class);
                    startActivity(i);
                }
                else
                {
                    Toast.makeText(MainActivity.this,"Please select accoount type",Toast.LENGTH_LONG).show();
                }

            }
        });


//
//        btnChef= findViewById(R.id.btnChef);
//
//        btnChef.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                Intent i = new Intent(getApplicationContext(), ChefDashboard.class);
//
//                startActivity(i);
//
//
//            }
//
//        });
//
//
//        btnCustomer= findViewById(R.id.btnCustomer);
//
//        btnCustomer.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                Intent i = new Intent(getApplicationContext(), CustomerDashboard.class);
//
//                startActivity(i);
//
//
//            }
//
//        });
//
//        btnSignup= findViewById(R.id.btnSignup);
//
//        btnSignup.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                Intent i = new Intent(getApplicationContext(), Signup.class);
//
//                startActivity(i);
//
//
//            }
//
//        });


    }
}
