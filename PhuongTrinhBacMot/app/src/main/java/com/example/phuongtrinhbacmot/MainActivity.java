package com.example.phuongtrinhbacmot;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    TextView ketqua;
    EditText so_a, so_b;
    Button submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        submit = findViewById(R.id.submit);
        so_a = findViewById(R.id.so_a);
        so_b = findViewById(R.id.so_b);
        ketqua = findViewById(R.id.ketqua);

        submit.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                int giatri_a = Integer.parseInt(so_a.getText().toString());
                int giatri_b = Integer.parseInt(so_b.getText().toString());
                String giatriketqua = giaiphuongtrinhbac1(giatri_a,giatri_b);
                ketqua.setText(giatriketqua);

            }

        });
    }

    public String giaiphuongtrinhbac1(int aNumber, int bNumber){
        double nghiem;
        String ketqua="";
        DecimalFormat decimalFormat = new DecimalFormat("#.##");    // làm tròn đến 2 chữ số thập phân

        if (aNumber == 0) {
            if (bNumber == 0) {
                ketqua = "Phương trình này có vô số nghiệm.";
            } else {
                ketqua = "Phương trình vô nghiệm.";
            }
        } else {
            nghiem = (double) -bNumber / aNumber;   // ép kiểu để cho ra kết quả chính xác
            ketqua = "Phương trình có nghiệm x = " + decimalFormat.format(nghiem) + ".";
        }
        return ketqua;
    }
}
