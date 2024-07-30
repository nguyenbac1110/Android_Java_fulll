package com.example.luyen_truoc_thi;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;

public class mh4 extends AppCompatActivity {
    ArrayList<SinhVien> sinhvienlist;
    SinhVienAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_mh4);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        ListView lst = findViewById(R.id.lst);
        sinhvienlist = new ArrayList<>();
        adapter = new SinhVienAdapter(mh4.this,sinhvienlist);
        lst.setAdapter(adapter);
        Button btn_hien = findViewById(R.id.btn_hien);
        btn_hien.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String jsdata ="[{\"ten\":\"nguyen van a\",\"diem\":\"19\"},{\"ten\":\"nguyen van b\",\"diem\":\"20\"}]";
                try {
                    JSONArray jsonArray = new JSONArray(jsdata);
                    sinhvienlist.clear();
                    for (int i = 0; i < jsonArray.length();i++){
                        String ten = jsonArray.getJSONObject(i).getString("ten");
                        String diem = jsonArray.getJSONObject(i).getString("diem");
                        SinhVien sv = new SinhVien(ten,diem);
                        sinhvienlist.add(sv);
                    }
                    adapter.notifyDataSetChanged();
                } catch (JSONException e) {
                    throw new RuntimeException(e);
                }
            }
        });
    }
}