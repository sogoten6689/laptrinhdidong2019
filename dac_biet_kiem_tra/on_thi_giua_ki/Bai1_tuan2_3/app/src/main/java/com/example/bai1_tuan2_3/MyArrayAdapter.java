package com.example.bai1_tuan2_3;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MyArrayAdapter extends ArrayAdapter<NhanVien> {
    ArrayList<NhanVien> myArray = new ArrayList<>();
    Activity context;
    int layoutId;


    public MyArrayAdapter(Activity context,int  textViewId, ArrayList<NhanVien> listNV) {
        super(context,textViewId,listNV);
        this.myArray = listNV;
        this.context = context;
        this.layoutId = textViewId;
    }



    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        LayoutInflater layoutInflater = context.getLayoutInflater();
        view = layoutInflater.inflate(layoutId, null);

        if (myArray.size() > 0 && i >= 0) {
            final TextView txtDisplay = (TextView)view.findViewById(R.id.tv_item);
            final NhanVien nv = (NhanVien)myArray.get(i);
            txtDisplay.setText(nv.toString());
            final ImageView imageView = (ImageView)view.findViewById(R.id.img_item);
            if(nv.getGioiTinh()==1){
                imageView.setImageResource(R.drawable.boy);
            }
            else
                imageView.setImageResource(R.drawable.girl);

        }
        return view;
    }
}
