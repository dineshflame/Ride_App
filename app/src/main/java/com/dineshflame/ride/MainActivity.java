package com.dineshflame.ride;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;




public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_main);


        ViewPager vp = (ViewPager) findViewById(R.id.mainViewPager);
        Communicator communicator = new Communicator(getSupportFragmentManager());
        vp.setAdapter(communicator);
        vp.setCurrentItem(0);




    }



}
