package com.example.fragment_nc_b1.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.fragment_nc_b1.R;


public class Demo2_Fragment2 extends Fragment {

    private TextView tvName, tvAge;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_demo2_2, container, false);
        tvName = view.findViewById(R.id.tvName);
        tvAge = view.findViewById(R.id.tvAge);
        return view;
    }

    public void showInfo(String name, String age) {
        tvName.setText(name);
        tvAge.setText(age);
    }
}