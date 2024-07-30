package com.example.a21130100918_nguyenxuanbac_ktlan2;

public class CanBo {
    private String macb;
    private String hoten;

    public CanBo() {
    }

    public CanBo(String macb, String hoten) {
        this.macb = macb;
        this.hoten = hoten;
    }

    public String getMacb() {
        return macb;
    }

    public void setMacb(String macb) {
        this.macb = macb;
    }

    public String getHoten() {
        return hoten;
    }

    public void setHoten(String hoten) {
        this.hoten = hoten;
    }

    @Override
    public String toString() {
        return "CanBo{" +
                "macb='" + macb + '\'' +
                ", hoten='" + hoten + '\'' +
                '}';
    }
}
