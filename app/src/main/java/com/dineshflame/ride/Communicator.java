package com.dineshflame.ride;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;

/**
 * Created by dineshflame on 04/03/2017.
 */

public class Communicator extends FragmentStatePagerAdapter {

    public Communicator(FragmentManager fm){
        super(fm);
    }

    @Override
    public Fragment getItem(int pos){
        switch (pos){
            case 0:
                return new MainFragment();
            case 1:
                return new CarListFragment();
            case 2:
                return new CustomerDetailFragment();
            case 3:
                return new CheckoutFragment();
        }
        return null;
    }

    @Override
    public int getCount(){
        return 4;
    }



}
