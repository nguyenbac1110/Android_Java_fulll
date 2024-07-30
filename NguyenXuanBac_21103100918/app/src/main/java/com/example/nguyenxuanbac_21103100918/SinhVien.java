package com.example.nguyenxuanbac_21103100918;

public class SinhVien {
    private String maSinhVien;
    private double diem;
    private String gioiTinh;
    private int tuoi;

    // Constructor without parameters
    public SinhVien() {}

    // Constructor with parameters
    public SinhVien(String maSinhVien, double diem, String gioiTinh, int tuoi) {
        this.maSinhVien = maSinhVien;
        this.diem = diem;
        this.gioiTinh = gioiTinh;
        this.tuoi = tuoi;
    }

    // Getters
    public String getMaSinhVien() {
        return maSinhVien;
    }

    public double getDiem() {
        return diem;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public int getTuoi() {
        return tuoi;
    }

    // Setters
    public void setMaSinhVien(String maSinhVien) {
        this.maSinhVien = maSinhVien;
    }

    public void setDiem(double diem) {
        this.diem = diem;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public void setTuoi(int tuoi) {
        this.tuoi = tuoi;
    }
}
