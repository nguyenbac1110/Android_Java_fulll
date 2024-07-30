package com.example.luyen_truoc_thi;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class mh2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_mh2);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        EditText txtten = findViewById(R.id.txtten);
        RadioButton pr1g = findViewById(R.id.pr1g);
        RadioButton pr2g = findViewById(R.id.pr2g);
        RadioButton pr3g = findViewById(R.id.pr3g);
        RadioButton pr4g = findViewById(R.id.pr4g);
        CheckBox xe =findViewById(R.id.xe);
        CheckBox wifi = findViewById(R.id.wifi);
        Button hien = findViewById(R.id.hien);
        Button next =findViewById(R.id.next);
        hien.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                StringBuilder thongbao = new StringBuilder();
                String txtten_ = txtten.getText().toString();
                thongbao.append("Ten: ").append(txtten_).append("\n");
                thongbao.append("Loai phong ngu: ");
                if(pr1g.isChecked()) thongbao.append("Phong rieng 1 giuong,");
                if(pr2g.isChecked()) thongbao.append("Phong rieng 2 giuong,");
                if(pr3g.isChecked()) thongbao.append("Phong rieng 3 giuong,");
                if(pr4g.isChecked()) thongbao.append("Phong rieng 4 giuong,");
                thongbao.append("\n");
                thongbao.append("Dich vu: ");
                if(xe.isChecked()) thongbao.append("Xe,");
                if(wifi.isChecked()) thongbao.append("Wifi,");
                AlertDialog.Builder builder = new AlertDialog.Builder(mh2.this);
                builder.setTitle("Thong bao").setMessage(thongbao.toString()).setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                });
                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mh2.this, mh3.class);
                startActivity(intent);
            }
        });
    }
}