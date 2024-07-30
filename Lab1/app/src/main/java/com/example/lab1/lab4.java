package com.example.lab1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.lab1.databinding.ActivityLab4Binding;
import com.example.lab1.databinding.ActivityMainBinding;

public class lab4 extends AppCompatActivity {
 //private ActivityLab4Binding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        //Cach 2
//        binding = ActivityLab4Binding.inflate(getLayoutInflater());
//        View view =binding.getRoot();
//        setContentView(view);
        setContentView(R.layout.activity_lab4);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        // anh xa cac widge

        Button btnbai1 = findViewById(R.id.btnbai1);
        Button btnbai2 = findViewById(R.id.btnbai2);
        Button btnbai3 = findViewById(R.id.btnbai3);

        // xu ly su kien
        btnbai3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(lab4.this,LoginFaceBook.class);
                startActivity(intent);
            }
        });
//        binding.btnbai2.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(lab4.this,LoginFaceBook.class);
//                startActivity(intent);
//            }
//        });
        btnbai2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(lab4.this,bai2.class);
                startActivity(intent);
            }
        });
    }
}