package com.example.a21130100918_nguyenxuanbac_ktlan2;

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
import org.json.JSONObject;

import java.util.ArrayList;

public class ManHinh3 extends AppCompatActivity {
    private ListView list;
    private Button btnHien;
    private CanBoAdapter adapter;
    private ArrayList<CanBo> CanBoList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_man_hinh3);
        list = findViewById(R.id.list);
        btnHien = findViewById(R.id.btnHien);
        CanBoList = new ArrayList<>();

        adapter = new CanBoAdapter(this, CanBoList);
        list.setAdapter(adapter);

        btnHien.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadCanBo();
            }
        });
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

    }
    private void loadCanBo(){
        String jsonData = "[{\"macb\": \"CB001\", \"hoten\": \"Nguyen Van A\"}," +
                "{\"macb\": \"CB002\", \"hoten\": \"Tran Thi B\"}," +
                "{\"macb\": \"CB003\", \"hoten\": \"Le Van C\"}]";

        try {
            JSONArray jsonArray = new JSONArray(jsonData);
            CanBoList.clear();

            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                String macb = jsonObject.getString("macb");
                String hoten = jsonObject.getString("hoten");

                CanBo canbo = new CanBo(macb, hoten);
                CanBoList.add(canbo);
            }

            adapter = new CanBoAdapter(this, CanBoList);
            list.setAdapter(adapter);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
    }
