package com.example.bangcuuchuong;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView ketqua;
    Button submit;
    Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinner = (Spinner) findViewById(R.id.cuuchuong);

        // Spinner Drop down elements
        List<String> categories = new ArrayList<String>();
        categories.add("1");
        categories.add("2");
        categories.add("3");
        categories.add("4");
        categories.add("5");
        categories.add("6");
        categories.add("7");
        categories.add("8");
        categories.add("9");


        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>
                (this, android.R.layout.simple_spinner_item, categories);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);


        // attaching data adapter to spinner
        spinner.setAdapter(dataAdapter);

        submit = findViewById(R.id.submit);
        ketqua = findViewById(R.id.ketqua);

        submit.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                int giatri = Integer.parseInt(spinner.getSelectedItem().toString());
                String giatriketqua = bangcuuchuong(giatri);
                ketqua.setText(giatriketqua);

            }

        });

    }


    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        // On selecting a spinner item
        String item = parent.getItemAtPosition(position).toString();

        // Showing selected spinner item

        Toast.makeText(parent.getContext(), "Selected: " + item, Toast.LENGTH_LONG).show();

    }
    public String bangcuuchuong(int name){
        String ketqua = "Bảng cửu chương " +name+"\n";
        int i = name,num =1;
        while(num<=10){
            ketqua += "\n"+ num+ " * "+i+" = "+ num * i;
            num++;
        }
        return ketqua;
    }
}
