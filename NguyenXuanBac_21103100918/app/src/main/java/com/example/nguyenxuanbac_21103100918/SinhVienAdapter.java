package com.example.nguyenxuanbac_21103100918;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class SinhVienAdapter{
    public static ArrayList<SinhVien> sv_ = new ArrayList<>();

    static {
        khoiTaoUser();
    }

    private static void khoiTaoUser() {
        sv_= new ArrayList<>();
        sv_.add(new SinhVien("21103100918", 8, "Nam",20));
        sv_.add(new SinhVien("SV02", 8, "Nữ",19));
        sv_.add(new SinhVien("SV03", 8, "Nam",23));
    }
    public static void themUser(SinhVien sv) {
        sv_.add(sv);
    }
    public static boolean tontaiSV(String tenNguoiDung) {
        for (SinhVien sv : sv_) {
            if (sv.getMaSinhVien().equals(tenNguoiDung)) {
                return true;
            }
        }
        return false;
    }

}
