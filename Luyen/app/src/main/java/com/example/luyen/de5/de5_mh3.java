package com.example.luyen.de5;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.luyen.R;

public class de5_mh3 extends AppCompatActivity {
    private TextView tvTenBaiHat, tvTenCaSi;
    private Button btnQuayVe;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_de5_mh3);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        tvTenBaiHat = findViewById(R.id.tvTenBaiHat);
        tvTenCaSi = findViewById(R.id.tvTenCaSi);
        btnQuayVe = findViewById(R.id.btnQuayVe);

        String tenBaiHat = getIntent().getStringExtra("tenBaiHat");
        String tenCaSi = getIntent().getStringExtra("tenCaSi");

        tvTenBaiHat.setText("Tên bài hát: "+tenBaiHat);
        tvTenCaSi.setText("Ca sĩ: " + tenCaSi);

        btnQuayVe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}