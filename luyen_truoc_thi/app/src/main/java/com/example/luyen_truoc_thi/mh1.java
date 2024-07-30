package com.example.luyen_truoc_thi;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class mh1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_mh1);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        EditText user = findViewById(R.id.user);
        EditText pass = findViewById(R.id.pass);
        Button dn =findViewById(R.id.dn);
        dn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user_ = user.getText().toString();
                String pass_ = pass.getText().toString();
                if(user_.equals("kan") && pass_.equals("1128")){
                    Intent intent = new Intent(mh1.this, mh2.class);
                    startActivity(intent);
                }
            }
        });
    }
}