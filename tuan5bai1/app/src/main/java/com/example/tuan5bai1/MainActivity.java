package com.example.tuan5bai1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Gallery;
import android.widget.ImageView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<Integer> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        list.add(R.drawable.house1);
        list.add(R.drawable.house2);
        list.add(R.drawable.house3);
        list.add(R.drawable.house4);
        list.add(R.drawable.house5);
        list.add(R.drawable.house6);
        final ImageView imageView = (ImageView) findViewById(R.id.image_house);
        Gallery gallery = (Gallery)findViewById(R.id.gallery_house);
        MyAdapter adapter = new MyAdapter(list, MainActivity.this);

        gallery.setAdapter(adapter);
        gallery.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                imageView.setImageResource(list.get(i));
            }
        });
    }
}
