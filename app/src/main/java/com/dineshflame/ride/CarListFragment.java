package com.dineshflame.ride;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.Button;
import android.widget.ExpandableListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CarListFragment extends Fragment{

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstance){
        View v = inflater.inflate(R.layout.activity_car_list_fragment, container, false);

        final ExpandableListView elv = (ExpandableListView) v.findViewById(R.id.expandableListView1);
        elv.setAdapter(new CustomAdapter());

        elv.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {

                SharedPreferences prefs = getActivity().getSharedPreferences("myPref3", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = prefs.edit();
                editor.putString("Type",String.valueOf(groupPosition));
                editor.putString("Car", String.valueOf(childPosition));
                editor.apply();

                Intent intent = new Intent(getActivity(), CustomerDetailActivity.class);
                startActivity(intent);

                return false;
            }
        });


        return v;
    }



    public class CustomAdapter extends BaseExpandableListAdapter {

        private String[] types = { "SUV", "Sedan", "Hatchback"};
        private String[][] cars = {
                {"Honda CR-V", "Ford Escape", "MazdaCX-5"},
                {"Honda City", "Toyota Vios", "Mazda 2"},
                {"Proton Iriz", "Perodua Myvi", "Perodua Axia"}
        };

        @Override
        public int getGroupCount() {
            return types.length;
        }

        @Override
        public int getChildrenCount(int groupPos) {
            return cars[groupPos].length;
        }

        @Override
        public Object getGroup(int groupPos) {
            return types[groupPos];
        }

        @Override
        public Object getChild(int groupPos, int childPos) {
            return cars[groupPos][childPos];
        }

        @Override
        public long getGroupId(int groupPos) {
            return groupPos;
        }

        @Override
        public long getChildId(int groupPos, int childPos) {
            return childPos;
        }

        @Override
        public boolean hasStableIds() {
            return true;
        }

        @Override
        public View getGroupView(int groupPos, boolean isExpanded, View convertView, ViewGroup parent) {


            TextView textView = new TextView(CarListFragment.this.getActivity());
            textView.setText(getGroup(groupPos).toString());
            return textView;
        }

        @Override
        public View getChildView(int groupPos, int childPos, boolean isLastChild, View convertView, ViewGroup parent) {

            TextView textView = new TextView(CarListFragment.this.getActivity());
            textView.setText(getChild(groupPos,childPos).toString());

            return textView;
        }

        @Override
        public boolean isChildSelectable(int groupPosition, int childPosition) {
            return true;
        }
    }



}
