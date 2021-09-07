package com.example.fragment_nc_b1.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.fragment_nc_b1.R;
import com.example.fragment_nc_b1.activity.Demo3Activity;
import com.example.fragment_nc_b1.activity.MainActivity;


public class Demo3_Fragment extends Fragment {

    private EditText edtEmailFrag;
    private Button btnSendDataFrag;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_demo3, container, false);

        edtEmailFrag = view.findViewById(R.id.edtEmailFrag);
        btnSendDataFrag = view.findViewById(R.id.btnSendDataFrag);

        btnSendDataFrag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Demo3Activity demo3Activity = ((Demo3Activity) getActivity());
                if(demo3Activity != null){
                    demo3Activity.setDataActitivy(edtEmailFrag.getText().toString());
                }
            }
        });

        return view;
    }

    public void setDataFragment(String email) {
        edtEmailFrag.setText(email);
    }
}