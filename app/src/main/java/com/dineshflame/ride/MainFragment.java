package com.dineshflame.ride;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;

import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import android.widget.DatePicker;
import android.widget.EditText;

import java.util.Calendar;



public class MainFragment extends Fragment {


    private DatePicker datePicker;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstance) {

        final View view = inflater.inflate(R.layout.activity_main_fragment, container, false);

        Button button = (Button) view.findViewById(R.id.confirm1);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                datePicker = (DatePicker) getActivity().findViewById(R.id.datePicker);

                SharedPreferences prefs = getActivity().getSharedPreferences("myPref", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = prefs.edit();
                editor.putString("Day", String.valueOf((datePicker.getDayOfMonth())));
                editor.putString("Month", String.valueOf(datePicker.getMonth() + 1));
                editor.putString("Year", String.valueOf(datePicker.getYear()));
                editor.apply();


                Intent intent = new Intent(getActivity(), CarActivity.class);
                startActivity(intent);



            }
        });

        return view;
    }

}
