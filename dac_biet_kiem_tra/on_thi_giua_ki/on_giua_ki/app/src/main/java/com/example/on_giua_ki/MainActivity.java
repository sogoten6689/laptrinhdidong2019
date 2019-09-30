package com.example.on_giua_ki;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ListView listView;
    private Spinner spPhongBan;
    private Button btnThem, btnXoa;

    private ArrayList<PhongBan> pblist = new ArrayList<>();
    private MyArrayAdapter nvAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        PhongBan phongBan = new PhongBan(1, "Kinh doanh");
        PhongBan phongBan1 = new PhongBan(1, "Kế toán");
        PhongBan phongBan2 = new PhongBan(1, "Nhân sự");
        NhanVien nhanVien = new NhanVien(1, "Ngoc Lam",1);
        NhanVien nhanVien1 = new NhanVien(1, "Cong Loi",0);
        NhanVien nhanVien2 = new NhanVien(1, "Thanh Son",0);
        NhanVien nhanVien3 = new NhanVien(1, "Quang Thinh",0);
        NhanVien nhanVien4 = new NhanVien(1, "Lin Khum",1);
        phongBan.addNhanVien(nhanVien);
        phongBan.addNhanVien(nhanVien4);
        phongBan1.addNhanVien(nhanVien1);
        phongBan2.addNhanVien(nhanVien2);
        phongBan2.addNhanVien(nhanVien4);
        pblist.add(phongBan);
        pblist.add(phongBan1);
        pblist.add(phongBan2);

        ArrayAdapter<PhongBan> phongBanArrayAdapter = new ArrayAdapter<PhongBan>(this, android.R.layout.simple_spinner_item, pblist);

        spPhongBan.setAdapter(phongBanArrayAdapter);

        spPhongBan.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                PhongBan phongBanChose = (PhongBan) adapterView.getSelectedItem();
                nvAdapter = new MyArrayAdapter(MainActivity.this, phongBanChose.getDanhSachNv());
                listView.setAdapter(nvAdapter);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        btnThem = (Button) findViewById(R.id.btnThemNV);
        btnThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ThemMoiActivity.class);

                PhongBan pb = (PhongBan) spPhongBan.getSelectedItem();
                intent.putExtra("id", pb.getId() + "");

                //Gửi không cần phản hồi
                MainActivity.this.startActivityForResult(intent, 9999);
            }

        });

    }
}
