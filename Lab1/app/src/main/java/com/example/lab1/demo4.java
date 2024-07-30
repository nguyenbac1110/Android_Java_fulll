package com.example.lab1;


import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class demo4 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_demo4);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        //anh xa cac ưidge
        EditText txtmon = findViewById(R.id.txtmon);
        RadioButton rdonam = findViewById(R.id.rdonam);
        RadioButton rdonu= findViewById(R.id.rdonu);

        Button btnsubmit = findViewById(R.id.btnsubmit);
        //xu ly su kien

        btnsubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String mon = String.valueOf(txtmon.getText());
                String ketqua ="";
                if (rdonam.isChecked()){

                }
                Toast.makeText(demo4.this,"Ban chon mon: "+mon,Toast.LENGTH_SHORT).show();
            }
        });
        btnsubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String mon = String.valueOf(txtmon.getText());
                String ketqua ="";
                if (rdonam.isChecked()){
                    ketqua = "Nam";
                }else if(rdonu.isChecked()){
                    ketqua = "Khac";
                }
                Toast.makeText(demo4.this,"Ban chon mon: "+mon+"Gioitinh"+ketqua,Toast.LENGTH_SHORT).show();
            }
        });
    }
}