package com.example.bai2_tach_luu_file_activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.icu.text.Edits;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class KetQuaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ket_qua);

        Button buttonMo = (Button)findViewById(R.id.buttonOpen);
        Button buttonThoat = (Button)findViewById(R.id.buttonExit);

        final EditText editTextContentResutl = (EditText)findViewById(R.id.editTextContentKetQua);

        final ArrayList<String> list = getIntent().getExtras().getStringArrayList("filenamelist");

        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.select_dialog_singlechoice, list);

        final Spinner spinnerDanhSach = (Spinner)findViewById(R.id.spinnerList);

        spinnerDanhSach.setAdapter(arrayAdapter);

        spinnerDanhSach.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (list.get(i).toString().equalsIgnoreCase("Choose file name")){
                    Toast.makeText(KetQuaActivity.this, "Please choose file name!", Toast.LENGTH_LONG).show();
                }
                else{
                    String filename = list.get(i).toString();
                    StringBuffer buffer = new StringBuffer();
                    String line = null;
                    try {

                        SharedPreferences pref = getApplicationContext().getSharedPreferences(filename,0);
                        editTextContentResutl.setText(pref.getString("content",null));

                    } catch (Exception e) {
                        Toast.makeText(KetQuaActivity.this, "Loi! khong doc duoc!", Toast.LENGTH_LONG).show();

                    }

                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        buttonThoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });


    }

}
