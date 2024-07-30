package com.example.luyen.de2;

public class SinhVien {
    private String Id;
    private String ten;
    private String tuoi;

    public SinhVien() {
    }

    public SinhVien(String id, String ten, String tuoi) {
        Id = id;
        this.ten = ten;
        this.tuoi = tuoi;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getTuoi() {
        return tuoi;
    }

    public void setTuoi(String tuoi) {
        this.tuoi = tuoi;
    }
}
