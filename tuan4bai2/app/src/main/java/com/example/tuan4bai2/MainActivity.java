package com.example.tuan4bai2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    String arr[] = {"Lam","son","thuy","thao", "ha", "minh", "phung", "ngoc", "tuan", "trong", "binh","truong", "vu", "tai"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final TextView selection = (TextView)findViewById(R.id.selection);
        final GridView gv = (GridView) findViewById(R.id.gridView1);
        ArrayAdapter<String> da = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,arr);
        gv.setAdapter(da);
        gv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                selection.setText(arr[i]);
            }
        });

    }
}
