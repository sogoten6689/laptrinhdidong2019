package com.example.tuan4bai2;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AnalogClock;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        doWork();

    }
    public void doWork()
    {
        Button b1 =(Button) findViewById(R.id.btnAnaloClock);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AnalogClock analog = new AnalogClock(MainActivity.this);
                ((LinearLayout)findViewById(R.id.mylayout)).addView(analog);
            }
        });

        Button b2 =(Button) findViewById(R.id.btnChronometer);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Chronometer cro = new Chronometer(MainActivity.this);
                ((LinearLayout)findViewById(R.id.mylayout)).addView(cro);
            }
        });
    }
}
