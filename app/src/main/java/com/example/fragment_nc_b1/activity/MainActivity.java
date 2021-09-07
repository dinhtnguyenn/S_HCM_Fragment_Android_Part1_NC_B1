package com.example.fragment_nc_b1.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;


import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.fragment_nc_b1.fragment.Fragment1;
import com.example.fragment_nc_b1.fragment.Fragment2;
import com.example.fragment_nc_b1.R;

/*
* giới thiệu fragment
* */

public class MainActivity extends AppCompatActivity {

    private Button btnAddFragment, btnChhangeFragment, btnRemoveFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnAddFragment = findViewById(R.id.btnAddFragment);
        btnChhangeFragment = findViewById(R.id.btnChhangeFragment);
        btnRemoveFragment = findViewById(R.id.btnRemoveFragment);

        btnAddFragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // add
                FragmentManager fm = getSupportFragmentManager();
                FragmentTransaction ft_add = fm.beginTransaction();
                ft_add.add(R.id.fragment,new Fragment1());
                ft_add.commit();
            }
        });

        btnChhangeFragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // replace
                FragmentManager fm = getSupportFragmentManager();
                FragmentTransaction ft_rep = fm.beginTransaction();
                ft_rep.replace(R.id.fragment, new Fragment2());
                ft_rep.commit();

            }
        });

        btnRemoveFragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // remove
                FragmentManager fm = getSupportFragmentManager();
                Fragment fragment = fm.findFragmentById(R.id.fragment);
                FragmentTransaction ft_remo = fm.beginTransaction();
                ft_remo.remove(fragment);
                ft_remo.commit();
            }
        });
    }
}