package com.example.de_5;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class DanhBaAdapter extends BaseAdapter {
    private final Context context;
    private final ArrayList<DanhBa> list;

    public DanhBaAdapter(Context context, ArrayList<DanhBa> list) {
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
        view = infl.inflate(R.layout.item_db,viewGroup,false);
        TextView ten = view.findViewById(R.id.ten);
        TextView sdt = view.findViewById(R.id.sdt);
        ten.setText(list.get(i).getTen());
        sdt.setText(list.get(i).getDienthoai());
        return view;
    }
}
