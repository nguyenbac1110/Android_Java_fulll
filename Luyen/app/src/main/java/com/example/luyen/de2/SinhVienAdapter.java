package com.example.luyen.de2;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.luyen.R;

import java.util.ArrayList;

public class SinhVienAdapter extends BaseAdapter {
    private final Context context;
    private final ArrayList<SinhVien> list;

    public SinhVienAdapter(Context context, ArrayList<SinhVien> list) {
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
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater infl = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view = infl.inflate(R.layout.item_sv, viewGroup, false);

        TextView txtId = view.findViewById(R.id.Id);
        TextView txtten = view.findViewById(R.id.ten);
        TextView txttuoi = view.findViewById(R.id.tuoi);
        txtId.setText(list.get(i).getId());
        txtten.setText(list.get(i).getTen());
        txttuoi.setText(list.get(i).getTuoi());
        return view;
    }
}
