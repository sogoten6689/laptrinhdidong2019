package com.example.on_giua_ki;

public class NhanVien {
    private int id;
    private String name;
    private int gioitinh;
    private PhongBan phongBan;

    public NhanVien(int id, String name, int gioitinh, PhongBan phongBan) {
        this.id = id;
        this.name = name;
        this.gioitinh = gioitinh;
        this.phongBan = phongBan;
    }
    public NhanVien(int id, String name, int gioitinh) {
        this.id = id;
        this.name = name;
        this.gioitinh = gioitinh;
    }

    public NhanVien() {
    }

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

    public int getGioitinh() {
        return gioitinh;
    }

    public void setGioitinh(int gioitinh) {
        this.gioitinh = gioitinh;
    }

    public PhongBan getPhongBan() {
        return phongBan;
    }

    public void setPhongBan(PhongBan phongBan) {
        this.phongBan = phongBan;
    }


}
