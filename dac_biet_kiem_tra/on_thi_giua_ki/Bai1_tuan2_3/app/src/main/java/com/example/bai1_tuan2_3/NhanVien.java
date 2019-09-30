package com.example.bai1_tuan2_3;

public class NhanVien {
    private String id;
    private String name;
    private int gioiTinh;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(int gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public NhanVien(String id, String name, int gioiTinh) {
        this.id = id;
        this.name = name;
        this.gioiTinh = gioiTinh;
    }

    @Override
    public String toString() {
        return name;
    }
}
