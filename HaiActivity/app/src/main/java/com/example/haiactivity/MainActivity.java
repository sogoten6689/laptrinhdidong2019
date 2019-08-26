package com.example.haiactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button submit;
    EditText name,birthday;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = (EditText) findViewById(R.id.editTextName);
        birthday = (EditText)findViewById(R.id.editTextBirthday);
        submit = (Button)findViewById(R.id.button);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                String hoten = name.getText().toString();
                String namsinh = birthday.getText().toString();
                intent.putExtra("ht",new String(hoten));
                intent.putExtra("ns",namsinh);
                startActivity(intent);

            }
        });

    }
}
