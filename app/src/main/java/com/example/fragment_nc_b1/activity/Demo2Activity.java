package com.example.fragment_nc_b1.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.widget.Toast;

import com.example.fragment_nc_b1.R;
import com.example.fragment_nc_b1.fragment.Demo2_Fragment1;
import com.example.fragment_nc_b1.fragment.Demo2_Fragment2;
import com.example.fragment_nc_b1.fragment.Fragment1;
import com.example.fragment_nc_b1.fragment.Fragment2;
import com.example.fragment_nc_b1.inter.FragmentInterface;

/*
 * truyền dữ liệu từ frag -> frag thông qua act
 * */
public class Demo2Activity extends AppCompatActivity implements FragmentInterface {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo2);

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();

        Demo2_Fragment1 fragment1 = new Demo2_Fragment1();
        transaction.add(R.id.containerTop, fragment1);

        Demo2_Fragment2 fragment2 = new Demo2_Fragment2();
        transaction.add(R.id.containerBottom, fragment2);
        transaction.commit();
    }

    @Override
    public void sendData(String name, String age) {
        Demo2_Fragment2 fragment2 = (Demo2_Fragment2) getSupportFragmentManager().findFragmentById(R.id.containerBottom);
        if (fragment2 != null) {
            fragment2.showInfo(name, age);
        } else {
            Toast.makeText(getApplicationContext(), "Hông có tìm thấy Fragment2 mà đòi truyền", Toast.LENGTH_LONG).show();
        }
    }
}