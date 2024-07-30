package com.example.lab1;

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

public class RegisterFacebook extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_register_facebook);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        EditText txtuser = findViewById(R.id.email_input);
        EditText txtsdt = findViewById(R.id.sdt_input);
        EditText txtpass =findViewById(R.id.password_input);
        EditText txtrepass = findViewById(R.id.re_password_input);
        Button btnback = findViewById(R.id.back);
        Button btnsignup = findViewById(R.id.register_button);
        btnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RegisterFacebook.this,LoginFaceBook.class);
                startActivity(intent);
            }
        });

        btnsignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = txtuser.getText().toString();
                String phoneNumber = txtsdt.getText().toString();
                String password = txtpass.getText().toString();
                String repass = txtrepass.getText().toString();
                if (UserInformation.tontaiUser(username)) {
                    Toast.makeText(RegisterFacebook.this, "User Name đã tồn tại", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (phoneNumber.isEmpty() || password.isEmpty() || repass.isEmpty()) {
                    Toast.makeText(RegisterFacebook.this, "Vui lòng điền đầy đủ thông tin", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (!password.equals(repass)) {
                    Toast.makeText(RegisterFacebook.this, "Mật khẩu và xác nhận mật khẩu không giống nhau", Toast.LENGTH_SHORT).show();
                    txtpass.setText("");
                    txtrepass.setText("");
                    return;
                }
                User user = new User(username, phoneNumber, password);
                UserInformation.themUser(user);
                Intent intent = new Intent(RegisterFacebook.this, LoginFaceBook.class);
                startActivity(intent);
                Toast.makeText(RegisterFacebook.this, "Đăng ký thành công", Toast.LENGTH_SHORT).show();



//                if (phoneNumber.isEmpty() || password.isEmpty() || repass.isEmpty()) {
//                    Toast.makeText(RegisterFacebook.this, "Vui lòng điền đầy đủ thông tin", Toast.LENGTH_SHORT).show();
//                }else{
//                    if (password.equals(repass)) {
//                  Toast.makeText(RegisterFacebook.this, "Mật khẩu và xác nhận mật khẩu không giống nhau", Toast.LENGTH_SHORT).show();
//                        Intent intent = new Intent(RegisterFacebook.this, LoginFaceBook.class);
//                        startActivity(intent);
//                        Bundle bundle = new Bundle();
//                        bundle.putString("Username",username);
//                        bundle.putString("Pass",password);
//                        intent.putExtras(bundle);
//                        startActivity(intent);
//                    } else {
//                        Toast.makeText(RegisterFacebook.this, "Mật khẩu và xác nhận mật khẩu không giống nhau", Toast.LENGTH_SHORT).show();
//
//                    }
//                }
                }

        });
    }
}