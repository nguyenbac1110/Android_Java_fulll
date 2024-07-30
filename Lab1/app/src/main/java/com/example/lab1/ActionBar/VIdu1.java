package com.example.lab1.ActionBar;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.lab1.R;

public class VIdu1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_vidu1);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        //anh xa
        Toolbar toolbar = findViewById(R.id.toolbarvd1);
        setSupportActionBar(toolbar); // gan toolbar thay actionbar

        getSupportActionBar().setTitle("LT Mobile");

        getSupportActionBar().setSubtitle("Mobile");
        getSupportActionBar().setLogo(R.drawable.baseline_add_to_photos_24);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //Option Menu
        //Context Menu
        //Popup menu



    }
    //tao option menu ,gan menu len toolbar

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.option_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    //xu ly su kien khi chon item

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        //switch case
        if(item.getItemId() == R.id.view){
            Toast.makeText(this,"view",Toast.LENGTH_SHORT).show();
        } else if (item.getItemId() == R.id.save) {
            // do some thing
        }
        return super.onOptionsItemSelected(item);
    }
}