package com.example.bai1_file;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final EditText editTextName = (EditText)findViewById(R.id.edit_text_name);
        final EditText editTextContent = (EditText)findViewById(R.id.edit_content);

        Button bt_moi = (Button)findViewById(R.id.button_clear);
        Button bt_luu = (Button)findViewById(R.id.button_save);
        Button bt_mo = (Button)findViewById(R.id.button_open);

        bt_moi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editTextName.setText("");
                editTextContent.setText("");
            }
        });
        final ArrayList<String> filenamelist = new ArrayList<String>();
        filenamelist.add("Choose file name");

        final Spinner sp_filename = (Spinner) findViewById(R.id.spinner);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_single_choice, filenamelist);
        sp_filename.setAdapter(adapter);
        sp_filename.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (filenamelist.get(i).toString().equalsIgnoreCase("Choose file name")){
                    Toast.makeText(MainActivity.this, "Please choose file name!", Toast.LENGTH_LONG).show();
                    editTextName.setText("");
                }
                else{
                    editTextName.setText(filenamelist.get(i).toString());

                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });



        bt_luu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                for(String ten : filenamelist){
                    if (ten.equalsIgnoreCase(editTextName.getText().toString().trim())){
                        Toast.makeText(MainActivity.this, "Ten trung", Toast.LENGTH_LONG).show();
                        return;

                    }
                }
                if (editTextName.getText().toString().trim().equalsIgnoreCase("") || editTextContent.getText().toString().trim().equalsIgnoreCase("")){
                    Toast.makeText(MainActivity.this, "Vui long nhap file name va noi dung", Toast.LENGTH_LONG).show();
                }
                else {
                    String filename = editTextName.getText().toString();
                    filenamelist.add(filename);
                    try {
//                        FileOutputStream fout = openFileOutput(filename, Context.MODE_PRIVATE);
//                        fout.write(editTextContent.getText().toString().getBytes());
//                        fout.close();

                        SharedPreferences pref = getApplicationContext().getSharedPreferences(filename,0);
                        SharedPreferences.Editor editor = pref.edit();
                        editor.putString("content", editTextContent.getText().toString().trim());
                        editor.commit();
//                        pref.c
                        editTextName.setText("");
                        editTextContent.setText("");
                        Toast.makeText(MainActivity.this, "okkk", Toast.LENGTH_LONG).show();

                    } catch (Exception e) {
                        Toast.makeText(MainActivity.this, "Loi! khong them dc", Toast.LENGTH_LONG).show();
                    }

                }
            }
        });

        bt_mo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String filename = editTextName.getText().toString();
                StringBuffer buffer = new StringBuffer();
                String line = null;
                try {
//                    FileInputStream fin = openFileInput(filename);
//                    BufferedReader br = new BufferedReader(new InputStreamReader(fin));
//                    while ((line = br.readLine()) != null)
//                        buffer.append(line).append("\n");
//                    editTextContent.setText(buffer.toString());

                    SharedPreferences pref = getApplicationContext().getSharedPreferences(filename,0);
                    editTextContent.setText(pref.getString("content",null));

                } catch (Exception e) {
                    Toast.makeText(MainActivity.this, "Loi! khong doc duoc!", Toast.LENGTH_LONG).show();

                }

            }
        });

    }
}
