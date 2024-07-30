package com.example.nguyenxuanbac_21103100918;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private EditText edtMaSV;
    private EditText edtDiem;
    private EditText edtTuoi;
    private RadioButton rbNam;
    private RadioButton rbNu;
    private Button btnSubmit;
    private Button btnHuy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtMaSV = findViewById(R.id.edtMaSV);
        edtDiem = findViewById(R.id.edtDiem);
        edtTuoi = findViewById(R.id.edtTuoi);
        rbNam = findViewById(R.id.rbNam);
        rbNu = findViewById(R.id.rbNu);
        btnSubmit = findViewById(R.id.btnSubmit);
        btnHuy = findViewById(R.id.btnHuy);
        btnHuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                edtMaSV.setText("");
                edtDiem.setText("");
                edtTuoi.setText("");
            }
        });
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String ma = edtMaSV.getText().toString();
                String diem = edtDiem.getText().toString();
                String tuoi = edtTuoi.getText().toString();
                String gioiTinh = rbNam.isChecked()? "Nam" : "Nữ";

                if (ma.trim().isEmpty()) {
                    Toast.makeText(MainActivity.this, "Vui lòng nhập mã sinh viên", Toast.LENGTH_SHORT).show();
                    return;
                }

                double diem_;
                try {
                    diem_ = Double.parseDouble(diem);
                    if (diem_ < 0 || diem_ > 10) {
                        Toast.makeText(MainActivity.this, "Điểm phải nằm trong khoảng 0-10", Toast.LENGTH_SHORT).show();
                        return;
                    }
                } catch (NumberFormatException e) {
                    Toast.makeText(MainActivity.this, "Điểm phải là số", Toast.LENGTH_SHORT).show();
                    return;
                }

                int tuoi_;
                try {
                    tuoi_ = Integer.parseInt(tuoi);
                    if (gioiTinh.equals("Nam")) {
                        if (tuoi_ < 20 || tuoi_ > 65) {
                            Toast.makeText(MainActivity.this, "Tuổi phải nằm trong khoảng 20-65", Toast.LENGTH_SHORT).show();
                            return;
                        }
                    } else {
                        if (tuoi_ < 18 || tuoi_ > 60) {
                            Toast.makeText(MainActivity.this, "Tuổi phải nằm trong khoảng 18-60", Toast.LENGTH_SHORT).show();
                            return;
                        }
                    }
                } catch (NumberFormatException e) {
                    Toast.makeText(MainActivity.this, "Tuổi phải là số", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (SinhVienAdapter.tontaiSV(ma)) {
                    Toast.makeText(MainActivity.this, "Đăng nhập thành công!", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(MainActivity.this, HienThi.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(MainActivity.this, "Tài khoản không tồn tại", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}