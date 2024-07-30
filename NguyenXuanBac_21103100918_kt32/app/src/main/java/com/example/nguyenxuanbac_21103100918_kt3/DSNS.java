package com.example.nguyenxuanbac_21103100918_kt3;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.nguyenxuanbac_21103100918_kt3.adapter.nhansuadapter;
import com.example.nguyenxuanbac_21103100918_kt3.dao.nhansudao;
import com.example.nguyenxuanbac_21103100918_kt3.model.nhansu;

import java.util.ArrayList;

public class DSNS extends AppCompatActivity {
    ArrayList<nhansu> list=new ArrayList<nhansu>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_dsns);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        RecyclerView rcvns=findViewById(R.id.rcvns);

        nhansudao nsdao=new nhansudao(this);
        list=nsdao.selectAll();
        LinearLayoutManager layout=new LinearLayoutManager(this);

        rcvns.setLayoutManager(layout);
        nhansuadapter adapter=new nhansuadapter(this,list);
        rcvns.setAdapter(adapter);
    }
}