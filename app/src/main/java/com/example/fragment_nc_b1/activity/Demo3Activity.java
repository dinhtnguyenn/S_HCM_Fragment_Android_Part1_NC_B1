package com.example.fragment_nc_b1.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.fragment_nc_b1.R;
import com.example.fragment_nc_b1.fragment.Demo2_Fragment1;
import com.example.fragment_nc_b1.fragment.Demo2_Fragment2;
import com.example.fragment_nc_b1.fragment.Demo3_Fragment;

/*
 * truyền đữ liệu từ act -> frag và frag -> act
 * */
public class Demo3Activity extends AppCompatActivity {

    private EditText edtEmail;
    private Button btnSendData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo3);

        edtEmail = findViewById(R.id.edtEmail);
        btnSendData = findViewById(R.id.btnSendData);

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        Demo3_Fragment fragment = new Demo3_Fragment();
        transaction.add(R.id.fragment, fragment);
        transaction.commit();

        btnSendData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Demo3_Fragment fragment2 = (Demo3_Fragment) getSupportFragmentManager().findFragmentById(R.id.fragment);
                if (fragment2 != null) {
                    fragment2.setDataFragment(edtEmail.getText().toString());
                }

                //áp dụng với trường hợp tạo fragment khi click
//                FragmentManager fragmentManager = getSupportFragmentManager();
//                FragmentTransaction transaction = fragmentManager.beginTransaction();
//                Demo3_Fragment fragment = new Demo3_Fragment();
//
//                Bundle bundle = new Bundle();
//                bundle.putString("hoten", "Nguyen Van A");
//
//                fragment.setArguments(bundle);
//
//                transaction.add(R.id.fragment, fragment);
//                transaction.commit();

                //bên Fragment chỉ cần gọi trong onCreateView
//                Bundle bundle = getArguments();
//
//                if(bundle !=null){
//                    txtData.setText(bundle.getString("hoten"));
//                }
            }
        });
    }

    public void setDataActitivy(String email) {
        edtEmail.setText(email);
    }
}