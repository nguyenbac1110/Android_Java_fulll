package com.example.lab1;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Vidu3 extends AppCompatActivity {
    Button btnbai5;
    TextView txtbai5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_vidu3);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        btnbai5 = findViewById(R.id.btnbai5);
        txtbai5 = findViewById(R.id.txtbai5);
        btnbai5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // gan menu vao ung dung
                PopupMenu popup = new PopupMenu(Vidu3.this,txtbai5);
                popup.getMenuInflater().inflate(R.menu.option_menu,popup.getMenu());
                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem menuItem) {
                        if(menuItem.getItemId() == R.id.view){
                            Toast.makeText(Vidu3.this,"view",Toast.LENGTH_SHORT).show();
                        } else if (menuItem.getItemId() == R.id.save) {
                            Toast.makeText(Vidu3.this,"save",Toast.LENGTH_SHORT).show();
                        } else if (menuItem.getItemId() == R.id.edit) {
                            Toast.makeText(Vidu3.this,"edit",Toast.LENGTH_SHORT).show();
                        } else if (menuItem.getItemId() == R.id.add) {
                            Toast.makeText(Vidu3.this,"add",Toast.LENGTH_SHORT).show();
                        }
                        return false;
                    }
                });
                popup.show();
            }
        });
    }
}