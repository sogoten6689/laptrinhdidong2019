package com.example.tachten;

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
    TextView ho,ten;
    Button submit;
    EditText name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        submit = findViewById(R.id.submit);
        name = findViewById(R.id.name);
        ho = findViewById(R.id.ketquaho);
        ten = findViewById(R.id.ketquaten);

        submit.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                String giatri = name.getText().toString();
                String ketquaho = tachho(giatri);
                String ketquaten = tachten(giatri);

                ho.setText(ketquaho);
                ten.setText(ketquaten);

            }

        });

    }

    public String tachho(String name){
        String ketqua = "";
        int i;
        String s1=new String();
        for(i=0;i<=name.length();i++)
        {
            s1=name.substring(i,i+1);
            if(s1.equals(" ")) break;
        }
        ketqua = "Ho: "+ name.substring(0,i);

        return ketqua;
    }

    public String tachten(String name){
        String ketqua = "";
        String s1=new String();
        name=name.trim();// Tac dung la de loai bo hai dau cach dau va cuoi Ten
        int k;
        for(k=name.length()-1;k>=0;k--)
        {
            s1=name.substring(k,k+1);
            if(s1.equals(" ")) break;
        }
        ketqua = "Ten: "+ name.substring(k+1);

        return ketqua;
    }
}