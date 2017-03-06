package com.dineshflame.ride;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class CustomerDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_detail_activity);


        ViewPager vp = (ViewPager) findViewById(R.id.customerViewPager);
        Communicator communicator = new Communicator(getSupportFragmentManager());
        vp.setAdapter(communicator);
        vp.setCurrentItem(2);
    }
}
