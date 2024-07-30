package com.example.luyen.de2;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.luyen.R;

public class de2_mh5 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_de2_mh5);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        EditText txtten = findViewById(R.id.txtten);
        CheckBox cbJava = findViewById(R.id.cbJava);
        CheckBox cbCS = findViewById(R.id.cbCS);
        CheckBox cbAndroid = findViewById(R.id.cbAndroid);
        RadioButton rbNam = findViewById(R.id.rbNam);
        RadioButton rbNu = findViewById(R.id.rbNu);
        Button btnHienThi = findViewById(R.id.btnHienThi);
        btnHienThi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                StringBuilder thongBao = new StringBuilder();

                String ten = txtten.getText().toString().trim();
                thongBao.append("Tên sinh viên: ").append(ten).append("\n");
                thongBao.append("Môn học: ");
                if (cbJava.isChecked()) thongBao.append("Java ");
                if (cbCS.isChecked()) thongBao.append("C# ");
                if (cbAndroid.isChecked()) thongBao.append("Android ");
                thongBao.append("\n");
                String gioiTinh = rbNam.isChecked() ? "Nam" : "Nữ";
                thongBao.append("Giới tính: ").append(gioiTinh);

                Toast.makeText(de2_mh5.this, thongBao.toString(), Toast.LENGTH_LONG).show();
                AlertDialog.Builder builder = new AlertDialog.Builder(de2_mh5.this);
                builder.setTitle("Thong bao").setMessage(thongBao).setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                });
                AlertDialog dialog = builder.create();
                dialog.show();
            }

        });

    }
}