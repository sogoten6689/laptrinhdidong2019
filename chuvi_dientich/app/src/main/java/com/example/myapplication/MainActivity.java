package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView ketquachuvi, ketquadientich;
    EditText chieurong, chieudai;
    Button submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        submit = findViewById(R.id.submit);
        chieurong = findViewById(R.id.chieurong);
        chieudai = findViewById(R.id.chieudai);
        ketquachuvi = findViewById(R.id.ketquachuvi);
        ketquadientich = findViewById(R.id.ketquadientich);

        submit.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                int giatrichieurong = Integer.parseInt(chieurong.getText().toString());
                int giatrichieudai = Integer.parseInt(chieudai.getText().toString());
                int giatriketquachuvi = (giatrichieurong+giatrichieudai)*2;
                int giatriketquadientich = giatrichieurong*giatrichieudai;
                ketquachuvi.setText("Chu Vi : " +giatriketquachuvi);
                ketquadientich.setText("Diện tích : " +giatriketquadientich);

            }

        });
    }

}
