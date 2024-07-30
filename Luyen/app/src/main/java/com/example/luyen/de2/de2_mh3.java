package com.example.luyen.de2;

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

public class de2_mh3 extends AppCompatActivity {
    private TextView nhap_a,nhap_b;
    private Button btn_cong;
    private TextView ket_qua;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_de2_mh3);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        nhap_a = findViewById(R.id.nhap_a);
        nhap_b = findViewById(R.id.nhap_b);
        ket_qua = findViewById(R.id.ket_qua);

        btn_cong = findViewById(R.id.btn_cong);

        btn_cong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Integer txta = Integer.parseInt(nhap_a.getText().toString());
                Integer txtb = Integer.parseInt(nhap_b.getText().toString());
                Integer txtkq = txta + txtb;
                String kq = txtkq.toString();
                ket_qua.setText(kq);
            }
        });
    }
}