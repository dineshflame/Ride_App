package com.dineshflame.ride;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

public class CheckoutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout);

        ViewPager vp = (ViewPager) findViewById(R.id.checkoutViewPager);
        Communicator communicator = new Communicator(getSupportFragmentManager());
        vp.setAdapter(communicator);
        vp.setCurrentItem(3);
    }
}