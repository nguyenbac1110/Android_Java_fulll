package com.example.luyen_truoc_thi;

public class SinhVien {
    private String ten;
    private String diem;

    public SinhVien() {
    }

    public SinhVien(String ten, String diem) {
        this.ten = ten;
        this.diem = diem;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getDiem() {
        return diem;
    }

    public void setDiem(String diem) {
        this.diem = diem;
    }
}
