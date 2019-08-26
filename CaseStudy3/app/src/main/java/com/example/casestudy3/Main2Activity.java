package com.example.casestudy3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Main2Activity extends AppCompatActivity {
        Button submit;
        EditText name,birthday;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        name = (EditText) findViewById(R.id.editTextName);
        birthday = (EditText)findViewById(R.id.editTextBirthday);
        submit = (Button)findViewById(R.id.button);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2 = new Intent();
                String hoten = name.getText().toString();
                String namsinh = birthday.getText().toString();
                intent2.putExtra("ht",new String(hoten));
                intent2.putExtra("ns",namsinh);
                setResult(RESULT_OK,intent2);
                finish();

            }
        });

    }
}
