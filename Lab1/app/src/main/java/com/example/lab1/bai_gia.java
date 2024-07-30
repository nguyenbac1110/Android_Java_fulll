package com.example.lab1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class bai_gia extends AppCompatActivity {
    Button btngia;
    EditText txtgia;
    TextView lblhq;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_bai_gia);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        lblhq =  findViewById(R.id.lblhq);
        lblhq.setText(AppUtil.hoaqua);
        btngia = findViewById(R.id.btngia);
        txtgia = findViewById(R.id.txtgia);
        btngia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int intgia = Integer.parseInt(txtgia.getText().toString());
                AppUtil.gia = intgia;
                Intent intent = new Intent(bai_gia.this,TT_qua.class);
                startActivity(intent);
            }
        });
    }


}