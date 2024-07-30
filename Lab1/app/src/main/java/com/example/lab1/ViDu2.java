package com.example.lab1;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class ViDu2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_vi_du2);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        // Anh xa
        ListView lstvidu2 = findViewById(R.id.lstvd2);
        ArrayList<String> list = new ArrayList<>();
        //add du lieu vao doi tuong
        list.add("Kan");
        list.add("Kan");
        list.add("Kan");
        list.add("Kan");
        list.add("Kan");
        list.add("Kan");
        list.add("Kan");
        //tao dioi tuong ArrayList
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,list);
        lstvidu2.setAdapter(adapter);
        //tao context menu
        registerForContextMenu(lstvidu2);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        getMenuInflater().inflate(R.menu.option_menu,menu);
        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == R.id.view){
            Toast.makeText(this,"view",Toast.LENGTH_SHORT).show();
        } else if (item.getItemId() == R.id.save) {
            // do some thing
        }
        return super.onContextItemSelected(item);
    }
}