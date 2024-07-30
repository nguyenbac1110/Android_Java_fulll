package com.example.lab1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class LoginFaceBook extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login_face_book);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        EditText txtuser = findViewById(R.id.email_input);
        EditText txtpass = findViewById(R.id.password_input);
        Button login = findViewById(R.id.login_button);
        Button create = findViewById(R.id.create_account_button);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = txtuser.getText().toString();
                String password = txtpass.getText().toString();
                if (UserInformation.tontaiUser(username)) {
                    User user = UserInformation.tenUser(username);
                    if (user.getPassword().equals(password)) {
                        Toast.makeText(LoginFaceBook.this, "Đăng nhập thành công!", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(LoginFaceBook.this, lab4.class);
                        startActivity(intent);
                    } else {
                        Toast.makeText(LoginFaceBook.this, "Mật khẩu sai", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(LoginFaceBook.this, "Tài khoản không tồn tại", Toast.LENGTH_SHORT).show();
                }

//                Intent i = getIntent();
//                Bundle bundle = i.getExtras();
//                if(bundle!=null){
//                    String user = bundle.getString("UserName");
//                    String pass = bundle.getString("Pass");
//                    boolean u = user.equals(txtuser.getText().toString());
//                    boolean p = user.equals(txtpass.getText().toString());
//                    if(u&&p){
//                        Toast.makeText(LoginFaceBook.this, "Đăng nhập thành công!", Toast.LENGTH_SHORT).show();
//                    }else{
//                        Toast.makeText(LoginFaceBook.this, "Mật khẩu sai", Toast.LENGTH_SHORT).show();
//                    }
//                }else{
//                    Toast.makeText(LoginFaceBook.this, "Tài khoản không tồn tại", Toast.LENGTH_SHORT).show();
//                }
            }
        });

        create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginFaceBook.this,RegisterFacebook.class);
                startActivity(intent);
            }
        });
    }
}