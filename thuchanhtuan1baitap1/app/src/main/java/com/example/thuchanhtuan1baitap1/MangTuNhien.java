package com.example.thuchanhtuan1baitap1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class MangTuNhien {
    ArrayList<Integer> mang;

    MangTuNhien(int solon){
        mang = new ArrayList();
        for(int i = 0; i< solon; i++ ){
            int random = (int)(Math.random() * 50 + 1);
            mang.add(random);
        }
    }

    public  int solonnhat(){
        int solonnhat = this.mang.get(0);
        for(int i= 0;i<this.mang.size(); i++)
        {
            if( solonnhat < this.mang.get(i)){
                solonnhat = this.mang.get(i);
            }
        }
        return  solonnhat;
    }

    public  int sobenhat(){
        int sobenhat = this.mang.get(0);
        for(int i= 0;i<this.mang.size(); i++)
        {
            if( sobenhat > this.mang.get(i)){
                sobenhat = this.mang.get(i);
            }
        }
        return  sobenhat;
    }

    public String xuatnguoc(){
        String ketqua = "";
        for(int i = this.mang.size()-1;i >= 0 ; i--)
        {
            ketqua += this.mang.get(i)+ " ";
        }
        return ketqua;
    }

    public  String xuatmang(){
        String ketqua = "";
        for(int i= 0;i < this.mang.size(); i++)
        {
            ketqua+= this.mang.get(i)+ "   ";
        }
        return ketqua;
    }

    public  int tong(){
        int tong = 0;
        for(int i= 0;i<this.mang.size(); i++)
        {

            tong += this.mang.get(i);
        }
        return  tong;
    }

    public  String tangdan(){
        List<Integer> mangtang = new ArrayList();

        for(int i= 0;i<this.mang.size(); i++)
        {

            mangtang.add(this.mang.get(i));
        }

        Collections.sort(mangtang);

        Iterator itr = mangtang.iterator();
        String ketqua = "";
        while (itr.hasNext()) {
            ketqua += itr.next() + "   ";
        }
        return ketqua;
    }

    public  String giamdan(){
        List<Integer> mangtang = new ArrayList();

        for(int i= 0;i<this.mang.size(); i++)
        {

            mangtang.add(this.mang.get(i));
        }
        Collections.sort(mangtang);

        Iterator itr = mangtang.iterator();
        String ketqua = "";
        while (itr.hasNext()) {
            ketqua += itr.next() + "   ";
        }
        return ketqua;
    }

}
