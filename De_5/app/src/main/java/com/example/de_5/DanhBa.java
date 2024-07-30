package com.example.de_5;

public class DanhBa {
    private String ten;
    private String dienthoai;

    public DanhBa() {
    }

    public DanhBa(String ten, String dienthoai) {
        this.ten = ten;
        this.dienthoai = dienthoai;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getDienthoai() {
        return dienthoai;
    }

    public void setDienthoai(String dienthoai) {
        this.dienthoai = dienthoai;
    }
}
