package com.example.tuan5bai2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.mexemds:
                Toast.makeText(this, "xem danh sach", Toast.LENGTH_LONG).show();
                return true;
            case R.id.menuxemdssv:
                Toast.makeText(this, "Xem danh sach sinh vien", Toast.LENGTH_LONG).show();
                return true;
            case R.id.menusuads:
                Toast.makeText(this, "Sua danh sach sinh vien", Toast.LENGTH_LONG).show();
                return true;
            case R.id.menuxoads:
                Toast.makeText(this, "Xoa danh sach sinh vien", Toast.LENGTH_LONG).show();
                return true;
            case R.id.menuinds:
                Toast.makeText(this, "in danh sach sinh vien", Toast.LENGTH_LONG).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);


        }


    }
}
