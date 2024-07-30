package com.example.a21130100918_nguyenxuanbac_ktlan2;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ManHinh1 extends AppCompatActivity {
    private EditText txtTenSV;
    private EditText txtMaSV;
    private EditText txtTuoi;
    private RadioButton rbNam;
    private RadioButton rbNu;
    private CheckBox chDaBong;
    private CheckBox chChoiGame;
    private Button btnLuu;
    private Button btnThoat;
    private Button btnNext;
    private TextView txtvHienThi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_man_hinh1);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;

        });

        txtTenSV = findViewById(R.id.txttensv);
        txtMaSV = findViewById(R.id.txtmasv);
        txtTuoi = findViewById(R.id.txttuoi);
        rbNam = findViewById(R.id.rbnam);
        rbNu = findViewById(R.id.rbnu);
        chDaBong = findViewById(R.id.cbdabong);
        chChoiGame = findViewById(R.id.cbchoigame);
        btnLuu = findViewById(R.id.btnLuu);
        btnThoat = findViewById(R.id.btnThoat);
        btnNext = findViewById(R.id.btnNext1);
        txtvHienThi = findViewById(R.id.txtvHienThi);

        txtMaSV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showMaSVDialog();
            }
        });
        btnLuu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hienThiKetQua();
            }
        });

        btnThoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ManHinh1.this, ManHinh2.class);
                startActivity(intent);
            }
        });

    }
    private void showMaSVDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Chọn Mã sinh viên");
        final String[] maSV = {"Mã 1", "Mã 2", "Mã 3"};
        builder.setItems(maSV, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int i) {
                txtMaSV.setText(maSV[i]);
            }
        });
        builder.show();
    }
    private void hienThiKetQua() {
        StringBuilder result = new StringBuilder();
        result.append("Tên SV: ").append(txtTenSV.getText()).append("\n");
        result.append("Mã SV: ").append(txtMaSV.getText()).append("\n");
        result.append("Tuổi: ").append(txtTuoi.getText()).append("\n");

        result.append("Giới tính: ");
        if (rbNam.isChecked()) {
            result.append("Nam");
        } else if (rbNu.isChecked()) {
            result.append("Nữ");
        }
        result.append("\n");

        result.append("Sở thích: ");
        if (chDaBong.isChecked()) {
            result.append("Đá bóng ");
        }
        if (chChoiGame.isChecked()) {
            result.append("Chơi game");
        }

        txtvHienThi.setText(result.toString());
    }

}