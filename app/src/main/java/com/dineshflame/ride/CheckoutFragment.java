package com.dineshflame.ride;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class CheckoutFragment extends Fragment {

    private String CarType;
    private String CarName;
    private int CarPrice;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstance) {
        View v = inflater.inflate(R.layout.activity_checkout_fragment, container, false);


        Button button = (Button) v.findViewById(R.id.checkButton);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SharedPreferences prefs = getActivity().getSharedPreferences("myPref2", Context.MODE_PRIVATE);
                SharedPreferences prefs2 = getActivity().getSharedPreferences("myPref", Context.MODE_PRIVATE);
                SharedPreferences prefs3 = getActivity().getSharedPreferences("myPref3", Context.MODE_PRIVATE);


                TextView name = (TextView) getActivity().findViewById(R.id.checkout_name);
                TextView phone = (TextView) getActivity().findViewById(R.id.checkout_phone);
                TextView email = (TextView) getActivity().findViewById(R.id.checkout_email);
                TextView date = (TextView) getActivity().findViewById(R.id.checkout_date);
                TextView car = (TextView) getActivity().findViewById(R.id.carTest);
                TextView type = (TextView) getActivity().findViewById(R.id.typeTest);
                TextView price = (TextView) getActivity().findViewById(R.id.carPrice);

                CarType = carType(Integer.parseInt(prefs3.getString("Type", "")));
                CarName = carName(Integer.parseInt(prefs3.getString("Type", "")), Integer.parseInt(prefs3.getString("Car", "")));
                CarPrice = bookPrice(Integer.parseInt(prefs3.getString("Type", "")));


                name.setText(  "Name          :"+ (prefs.getString("Name", "")));
                phone.setText( "Phone No.  :"+ prefs.getString("Phone", ""));
                email.setText( "E-Mail          :"+ prefs.getString("Email", ""));
                date.setText(  "Date             :"+ (prefs2.getString("Day", "") +"/"+ prefs2.getString("Month","") + "/"+ prefs2.getString("Year", "")));
                type.setText(  "Car Type     :"+CarType);
                car.setText(   "Car               :"+CarName);
                price.setText( "Rental fee  :"+"RM "+ String.valueOf(CarPrice) +"/day");

                Toast.makeText(getActivity(),"Changes can be made now if required!", Toast.LENGTH_LONG).show();

            }
        });

        Button button2 = (Button) v.findViewById(R.id.confirmButton);

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(),"Booking Successful !", Toast.LENGTH_LONG).show();
            }
        });


        return v;
    }

    public int bookPrice(int t){
        int price = 0;

        if (t == 0){ price = 300;}
        else if (t == 1){ price = 160;}
        else if (t == 2){price = 90;}

        return price;
    }

    public String carType(int t) {

        String type = "";

        if (t == 0) {
            type = "SUV";
        } else if (t == 1) {
            type = "Sedan";
        } else if (t == 2) {
            type = "Hatchback";
        }

        return type;
    }

    public String carName(int t, int n) {

        String name = "";

        if (t == 0) {
            if (n == 0) {
                name = "Honda CR-V";
            } else if (n == 1) {
                name = "Ford Escape";
            } else if (n == 2) {
                name = "Mazda CX-5";
            }
        }

        if (t == 1) {
            if (n == 0) {
                name = "Honda City";
            } else if (n == 1) {
                name = "Toyota Vios";
            } else if (n == 2) {
                name = "Mazda 2";
            }
        }

        if (t == 2) {
            if (n == 0) {
                name = "Proton Iriz";
            } else if (n == 1) {
                name = "Perodua Myvi";
            } else if (n == 2) {
                name = "Perodua Axia";
            }
        }


        return name;
    }
}