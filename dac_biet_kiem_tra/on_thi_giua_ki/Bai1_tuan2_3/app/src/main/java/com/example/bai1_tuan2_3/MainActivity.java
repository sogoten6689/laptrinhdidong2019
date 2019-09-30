package com.example.bai1_tuan2_3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<NhanVien> nvList = new ArrayList<>();
    private MyArrayAdapter nvAdapter;

    private ListView listView = null;
    private Button btnThem;
    private ImageButton btnXoa;

    private EditText editTextName;
    private EditText editTextId;

    private RadioButton radioButtonBoy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        NhanVien nhanVien = new NhanVien("1", "Ngoc Lam",1);
        NhanVien nhanVien1 = new NhanVien("2", "Cong Loi",0);
        NhanVien nhanVien2 = new NhanVien("3", "Thanh Son",0);
        NhanVien nhanVien3 = new NhanVien("4", "Quang Thinh",0);
        NhanVien nhanVien4 = new NhanVien("5", "Lin Khum",1);
        nvList.add(nhanVien);
        nvList.add(nhanVien1);
        nvList.add(nhanVien2);
        nvList.add(nhanVien3);
        nvList.add(nhanVien4);

        nvAdapter = new MyArrayAdapter(this, R.layout.my_item_layout, nvList);
        listView = (ListView)findViewById(R.id.listView);
        listView.setAdapter(nvAdapter);


        btnThem = (Button)findViewById(R.id.buttonThem);
        btnXoa = (ImageButton) findViewById(R.id.imageButton);

        editTextId = (EditText)findViewById(R.id.editTextMa);
        editTextName = (EditText)findViewById(R.id.editTextTen);
        radioButtonBoy = (RadioButton)findViewById(R.id.radioButtonNam);

        btnThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                xuLyNhap();
            }
        });

        btnXoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                for(int i = listView.getChildCount() - 1; i>=0; i--)
                {
                    View view1 = listView.getChildAt(i);
                    CheckBox checkBox = (CheckBox)view1.findViewById(R.id.chk_item);
                    if (checkBox.isChecked()){
                        nvList.remove(i);
                    }

                }
                nvAdapter.notifyDataSetChanged();
            }
        });

    }
    public void xuLyNhap() {
        String ma = editTextId.getText().toString();
        String ten = editTextName.getText().toString();

        boolean nam = radioButtonBoy.isChecked();

        if(ma.equalsIgnoreCase("") || ten.equalsIgnoreCase("")){
            Toast.makeText(MainActivity.this,"Vui long nhap thông tin!", Toast.LENGTH_LONG).show();
            return;
        }

        NhanVien nhanVien;
        if(nam)
            nhanVien = new NhanVien(ma, ten,1);
        else
            nhanVien = new NhanVien(ma, ten,0);
        nvList.add(nhanVien);
        nvAdapter.notifyDataSetChanged();
        editTextName.setText("");
        editTextId.setText("");
        radioButtonBoy.setChecked(true);

    }
}
