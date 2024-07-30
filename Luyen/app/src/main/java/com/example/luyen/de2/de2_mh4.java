package com.example.luyen.de2;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.luyen.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class de2_mh4 extends AppCompatActivity {
    private ListView lst;
    private Button btnHien;
    private SinhVienAdapter adapter;
    private ArrayList<SinhVien> SinhVienList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_de2_mh4);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        lst = findViewById(R.id.lst);
        btnHien = findViewById(R.id.btnHien);
        SinhVienList = new ArrayList<>();

        adapter = new SinhVienAdapter(this, SinhVienList);
        lst.setAdapter(adapter);

        btnHien.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String jsondata = "[{\"ma\":\"SV001\",\"ten\":\"Nguyen Van A\",\"tuoi\":\"1\"}]";
                try {
                    JSONArray jsonArray = new JSONArray(jsondata);
                    SinhVienList.clear();
                    for (int i = 0; i<jsonArray.length();i++){
                        String ma = jsonArray.getJSONObject(i).getString("ma");
                        String ten = jsonArray.getJSONObject(i).getString("ten");
                        String tuoi = jsonArray.getJSONObject(i).getString("tuoi");
                        SinhVien sv = new SinhVien(ma,ten,tuoi);
                        SinhVienList.add(sv);
                    }
                    adapter.notifyDataSetChanged();
                } catch (JSONException e) {
                    throw new RuntimeException(e);
                }

            }
        });
    }
}