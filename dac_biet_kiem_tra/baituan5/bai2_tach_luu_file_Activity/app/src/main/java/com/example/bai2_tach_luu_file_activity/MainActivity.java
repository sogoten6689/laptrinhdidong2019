package com.example.bai2_tach_luu_file_activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final EditText editTextTen = (EditText)findViewById(R.id.editTextName);
        final EditText editTextNoiDung = (EditText)findViewById(R.id.editTextContent);
        final ArrayList<String> filenamelist = new ArrayList<String>();
        filenamelist.add("Choose name");

        Button buttonLuu = (Button)findViewById(R.id.buttonSubmit);
        Button buttonXem = (Button)findViewById(R.id.buttonView);
        Button buttonMoi = (Button)findViewById(R.id.buttonClear);

        buttonLuu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                for(String ten : filenamelist){
                    if (ten.equalsIgnoreCase(editTextTen.getText().toString().trim())){
                        Toast.makeText(MainActivity.this, "Ten trung", Toast.LENGTH_LONG).show();
                        return;

                    }
                }
                if (editTextTen.getText().toString().trim().equalsIgnoreCase("") || editTextNoiDung.getText().toString().trim().equalsIgnoreCase("")){
                    Toast.makeText(MainActivity.this, "Vui long nhap file name va noi dung", Toast.LENGTH_LONG).show();
                }
                else {
                    String filename = editTextTen.getText().toString();
                    filenamelist.add(filename);
                    try {
                        SharedPreferences pref = getApplicationContext().getSharedPreferences(filename,0);
                        SharedPreferences.Editor editor = pref.edit();
                        editor.putString("content", editTextNoiDung.getText().toString().trim());
                        editor.commit();

                        editTextTen.setText("");
                        editTextNoiDung.setText("");
                        Toast.makeText(MainActivity.this, "okkk", Toast.LENGTH_LONG).show();

                    } catch (Exception e) {
                        Toast.makeText(MainActivity.this, "Loi! khong them dc", Toast.LENGTH_LONG).show();
                    }

                }
            }
        });

        buttonXem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentKetQua = new Intent(MainActivity.this, KetQuaActivity.class);
                intentKetQua.putExtra("filenamelist",filenamelist);
                startActivity(intentKetQua);
            }
        });

        buttonMoi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editTextNoiDung.setText("");
                editTextTen.setText("");
            }
        });


    }
}
