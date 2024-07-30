package com.example.lab1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class bai2 extends AppCompatActivity {
    Button btnhq;
    EditText txthq;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_bai2);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        btnhq = findViewById(R.id.btnhoaqua);
        txthq = findViewById(R.id.hoa_qua);
        btnhq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String strhoaqua = txthq.getText().toString();
                AppUtil.hoaqua = strhoaqua;
                Intent intent = new Intent(bai2.this,bai_gia.class);
                startActivity(intent);
            }
        });
    }


}