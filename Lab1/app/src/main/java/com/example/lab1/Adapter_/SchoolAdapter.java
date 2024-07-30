package com.example.lab1.Adapter_;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.lab1.R;
import com.example.lab1.model_.school;

import java.util.ArrayList;

public class SchoolAdapter extends BaseAdapter {
    private final Context context;
    private final ArrayList<school> list;

    public SchoolAdapter(Context context, ArrayList<school> list) {
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
        LayoutInflater infl = ((Activity) context).getLayoutInflater();

        view = infl.inflate(R.layout.itembai1,viewGroup,false);

        ImageView imghinh = view.findViewById(R.id.imghinh);
        TextView txtten = view.findViewById(R.id.txtcon);
        imghinh.setImageResource(list.get(i).getHinh());
        txtten.setText("Kan"+list.get(i).getTen());
        return view;
    }
}
