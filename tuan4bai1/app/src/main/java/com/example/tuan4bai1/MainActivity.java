package com.example.tuan4bai1;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView tv_ketqua;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AlertDialog.Builder mydialog = new AlertDialog.Builder(this);
        mydialog.setTitle("Message");
        mydialog.setIcon(R.drawable.lam);
//        mydialog.setMessage("chay duoc roi ne!");
        tv_ketqua = (TextView) findViewById(R.id.textView_ketqua);
        final CharSequence[] items = {"Red", "Yellow", "Blue"};
        final boolean[] arraycheck = {false, false, false};

        mydialog.setMultiChoiceItems(items, arraycheck, new DialogInterface.OnMultiChoiceClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i, boolean b) {
                arraycheck[i] = b;
            }
        });

        mydialog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                String st = "";
                for (int j = 0; j < items.length; j++) {
                    if(arraycheck[j]){
                        st+= items[j].toString()+"\n";
                    }
                }
                tv_ketqua.setText(st);
            }
        });
        mydialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });

//        mydialog.setItems(items, new DialogInterface.OnClickListener() {
//                        @Override
//            public void onClick(DialogInterface dialogInterface, int i) {
//                tv_ketqua.setText(items[i].toString());
//            }
//        });
        // bai 1
//        mydialog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialogInterface, int i) {
//                tv_ketqua.setText("You Choice yes");
//            }
//        });
        AlertDialog alertDialog = mydialog.create();
        alertDialog.show();

    }
}
