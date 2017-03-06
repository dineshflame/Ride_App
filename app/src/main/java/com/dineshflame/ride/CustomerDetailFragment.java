package com.dineshflame.ride;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import static com.dineshflame.ride.R.string.name;

public class CustomerDetailFragment extends Fragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstance){
        View v = inflater.inflate(R.layout.activity_customer_detail_fragment, container, false);

        Button button = (Button) v.findViewById(R.id.customer_confirm);

        final EditText editName =(EditText) v.findViewById(R.id.cust_name);
        final EditText editPhone =(EditText) v.findViewById(R.id.cust_phone);
        final EditText editEmail =(EditText) v.findViewById(R.id.cust_email);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                SharedPreferences pref = getActivity().getSharedPreferences("myPref2", Context.MODE_PRIVATE);

                SharedPreferences.Editor editor = pref.edit();

                editor.putString("Name", (editName.getText().toString()));
                editor.putString("Phone",(editPhone.getText().toString()));
                editor.putString("Email",(editEmail.getText().toString()));
                editor.apply();

                Intent intent = new Intent(getActivity(), CheckoutActivity.class);
                startActivity(intent);



            }
        });
        return v;
    }
}
