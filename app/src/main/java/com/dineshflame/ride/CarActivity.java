package com.dineshflame.ride;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.Toast;

import java.util.ArrayList;

public class CarActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_car);


        ViewPager vp = (ViewPager) findViewById(R.id.carViewPager);
        Communicator communicator = new Communicator(getSupportFragmentManager());
        vp.setAdapter(communicator);
        vp.setCurrentItem(1);
    }


}
