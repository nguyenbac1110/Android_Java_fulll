
package com.example.nguyenxuanbac_21103100918_kt3;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class caua extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_caua);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        EditText txtuser = findViewById(R.id.txtuser);
        EditText txtpass = findViewById(R.id.txtpass);
        Button btndn = findViewById(R.id.btndn);
        Button btnthoat = findViewById(R.id.btnthoat);

        btndn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String tk = txtuser.getText().toString();
                String mk = txtpass.getText().toString();
                if(tk.equals("cnttk15hn") && mk.equals("cnttk15")){
                    Intent intent = new Intent(caua.this, cauc.class);
                    startActivity(intent);
                }
                else {
                    Toast.makeText(caua.this,"Nhập lại",Toast.LENGTH_SHORT).show();
                }
            }
        });
        btnthoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}