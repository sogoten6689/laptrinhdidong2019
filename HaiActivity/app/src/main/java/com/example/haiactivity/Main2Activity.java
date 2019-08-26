package com.example.haiactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Calendar;

public class Main2Activity extends AppCompatActivity {
    TextView tv_ketqua;
    Button bt_thoat;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        String hoten = getIntent().getExtras().getString("ht");
        String namsinh = getIntent().getExtras().getString("ns");
        String ketqua = "Họ và tên: "+hoten;
        ketqua += "\n Năm sinh: " + namsinh;
        Calendar calendar = Calendar.getInstance();
        ketqua += "\n Tuổi: "+ (calendar.getTime().getYear()+1900 - Integer.parseInt(namsinh));
        tv_ketqua = findViewById(R.id.ketqua);
        tv_ketqua.setText(ketqua);
        bt_thoat = findViewById(R.id.buttonback);
        bt_thoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}
