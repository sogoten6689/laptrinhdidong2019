package com.example.on_giua_ki;

import java.util.ArrayList;

public class PhongBan {
    private int id;
    private String name;
    private ArrayList<NhanVien> danhSachNv;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<NhanVien> getDanhSachNv() {
        return danhSachNv;
    }

    public void setDanhSachNv(ArrayList<NhanVien> danhSachNv) {
        this.danhSachNv = danhSachNv;
    }

    public void addNhanVien (NhanVien nhanVien){
        if (this.danhSachNv == null) {
            this.danhSachNv = new ArrayList<NhanVien>();
        }
        nhanVien.setPhongBan(this);
        this.danhSachNv.add(nhanVien);
    }

    public PhongBan(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

}
