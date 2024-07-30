package com.example.de_5;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class manhinh3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_manhinh3);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        TextView ten = findViewById(R.id.ten);
        TextView sdt = findViewById(R.id.sdt);

        String ten_ = getIntent().getStringExtra("ten");
        String sdt_ = getIntent().getStringExtra("sdt");

        ten.setText("ten: "+ten_);
        sdt.setText("sdt:"+sdt_);
        final String phoneNumber = sdt_;
        Button btnQuayve = findViewById(R.id.btnQuayVe);
        btnQuayve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(manhinh3.this,manhinh2.class);
                startActivity(intent);
            }
        });
        Button btnGoiDien = findViewById(R.id.btnGoiDien);
        btnGoiDien.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:"+phoneNumber));
                startActivity(intent);
            }
        });
    }
}