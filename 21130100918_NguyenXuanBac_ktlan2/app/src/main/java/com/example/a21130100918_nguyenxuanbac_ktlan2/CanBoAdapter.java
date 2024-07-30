package com.example.a21130100918_nguyenxuanbac_ktlan2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class CanBoAdapter extends BaseAdapter {
    private final Context context;
    private final ArrayList<CanBo> list;

    public CanBoAdapter(Context context, ArrayList<CanBo> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.item_cb, viewGroup, false);
        }

        CanBo canbo = list.get(i);

        TextView txtMaGV = view.findViewById(R.id.txtmacb);
        TextView txtHoTen = view.findViewById(R.id.txthoten);

        txtMaGV.setText("Mã CB: " + canbo.getMacb());
        txtHoTen.setText("Họ tên: " + canbo.getHoten());

        return view;
    }
}
