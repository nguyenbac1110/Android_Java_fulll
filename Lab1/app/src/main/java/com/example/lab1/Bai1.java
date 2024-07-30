package com.example.lab1;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.lab1.Adapter_.SchoolAdapter;
import com.example.lab1.model_.school;

import java.util.ArrayList;

public class Bai1 extends AppCompatActivity {
    Spinner sp;
    //String item
    private ArrayList<school> list = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_bai1);
        sp = findViewById(R.id.spnbai1);
        list.add(new school(R.drawable.baseline_add_to_photos_24,"Kan"));
        list.add(new school(R.drawable.baseline_add_to_photos_24,"Kan"));
        list.add(new school(R.drawable.baseline_add_to_photos_24,"Kan"));
        list.add(new school(R.drawable.baseline_add_to_photos_24,"Kan"));
        list.add(new school(R.drawable.baseline_add_to_photos_24,"Kan"));
        list.add(new school(R.drawable.baseline_add_to_photos_24,"Kan"));
        list.add(new school(R.drawable.baseline_add_to_photos_24,"Kan"));
        SchoolAdapter adapter = new SchoolAdapter(this,list);
        sp.setAdapter(adapter);

//        ListView lstvd2 = findViewById(R.id.lstvd2);
//        ArrayAdapter<String> _adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,list1);
        //lstvd2.setAdapter(_adapter);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

    }
}