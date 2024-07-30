package com.example.luyen.de5;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.widget.Toast;

import android.view.MenuItem;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.luyen.R;

public class de5_mh1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_de5_mh1);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        Toolbar toolbar = findViewById(R.id.toolbarvd1);
        setSupportActionBar(toolbar);

        getSupportActionBar().setTitle("Kan");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.option_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    // import android.view.MenuItem;
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == R.id.view1){
            Toast.makeText(this,"Chuc nang dang cap nhap",Toast.LENGTH_SHORT).show();
        } else if (item.getItemId() == R.id.view3) {
            Toast.makeText(this,"Chuc nang dang cap nhap",Toast.LENGTH_SHORT).show();
        } else if (item.getItemId() == R.id.view4) {
            finish();
        } else if (item.getItemId() == R.id.view2) {
            Intent intent = new Intent(de5_mh1.this, de5_mh2.class);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }
}