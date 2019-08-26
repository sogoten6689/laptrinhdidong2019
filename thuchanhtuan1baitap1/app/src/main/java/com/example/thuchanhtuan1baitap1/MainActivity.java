package com.example.thuchanhtuan1baitap1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText soluong;
    Button nutnhan;
//    Button nutnhanchitiet;
    TextView ketqua;
//    TextView ketquachitiet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        soluong = findViewById(R.id.editTextSoLuong);
        nutnhan = findViewById(R.id.button);
        ketqua = findViewById(R.id.textViewKetQua);
//        ketquachitiet = findViewById(R.id.textViewKetQuaChiTiet);

        nutnhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int soluongactive = Integer.parseInt(soluong.getText().toString());
                MangTuNhien mangTuNhien = new MangTuNhien(soluongactive);
                String ketquane = "";
                ketquane += "Mảng: "+ mangTuNhien.xuatmang()+".\n";
                ketquane += "Số lớn nhất: "+ mangTuNhien.solonnhat()+"\n";
                ketquane += "Số bé nhất: "+ mangTuNhien.sobenhat()+"\n";
                ketquane += "Mảng xuôi: "+ mangTuNhien.xuatmang()+"\n";
                ketquane += "Mảng ngược: "+ mangTuNhien.xuatnguoc()+"\n";
                ketquane += "Mảng mảng tăng dần: "+ mangTuNhien.tangdan()+"\n";
//                ketquane += "Mảng mảng giảm dần: "+ mangTuNhien.xuatmang()+"\n";
                ketquane += "Tính tổng: "+ mangTuNhien.tong()+"\n";
                ketquane += "Số lượng phần từ: "+ mangTuNhien.mang.size()+"\n";
                ketqua.setText(ketquane+" ");
            }
        });
    }
}
