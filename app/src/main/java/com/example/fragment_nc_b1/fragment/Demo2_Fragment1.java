package com.example.fragment_nc_b1.fragment;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.fragment_nc_b1.R;
import com.example.fragment_nc_b1.activity.Demo2Activity;
import com.example.fragment_nc_b1.inter.FragmentInterface;


public class Demo2_Fragment1 extends Fragment {

    private EditText edtName, edtAge;
    private Button btnSend;
    private FragmentInterface listener;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof Demo2Activity)
            this.listener = (FragmentInterface) context;
        else
            throw new RuntimeException(context.toString() + "must implement onViewSelected!");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_demo2_1, container, false);
        edtName = view.findViewById(R.id.edtName);
        edtAge = view.findViewById(R.id.edtAge);
        btnSend = view.findViewById(R.id.btnSend);

        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = edtName.getText().toString().trim();
                String age = edtAge.getText().toString().trim();

                listener.sendData(name, age);
            }
        });

        return view;
    }
}