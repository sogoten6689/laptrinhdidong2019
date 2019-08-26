package com.example.casestudy3;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    Button btn_nhap;
    TextView ketqua2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_nhap = findViewById(R.id.button123);
        ketqua2 = findViewById(R.id.textView_ketqua);



        btn_nhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                startActivityForResult(intent,888);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 888 && requestCode == RESULT_OK){
            String hoten = getIntent().getExtras().getString("ht");
            String namsinh = getIntent().getExtras().getString("ns");
            String ketqua = "Họ và tên: "+hoten;
            ketqua += "\n Năm sinh: " + namsinh;
            Calendar calendar = Calendar.getInstance();
            ketqua += "\n Tuổi: "+ (calendar.getTime().getYear()+1900 - Integer.parseInt(namsinh));
            ketqua2.setText(ketqua);
        }

    }
}
