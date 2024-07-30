package com.example.luyen.de2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.luyen.R;

public class de2_mh1 extends AppCompatActivity {
    private EditText txtten,txtpass;
    private Button btnDangNhap,btnKetThuc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_de2_mh1);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        txtten = findViewById(R.id.txtten);
        txtpass = findViewById(R.id.txtpass);
        btnDangNhap = findViewById(R.id.btnDangNhap);
        btnKetThuc = findViewById(R.id.btnKetThuc);
        btnDangNhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String strten = txtten.getText().toString();
                Integer strpass = Integer.parseInt(txtpass.getText().toString());
                if(strten.equals("Kan") && strpass == 1128){
                    Intent intent = new Intent(de2_mh1.this, de2_mh2.class);
                    startActivity(intent);
                }
                else {
                    Toast.makeText(de2_mh1.this,"Nhập lại",Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}