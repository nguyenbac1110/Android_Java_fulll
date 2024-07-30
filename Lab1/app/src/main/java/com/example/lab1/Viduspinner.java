package com.example.lab1;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class Viduspinner extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_viduspinner);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        Spinner spnnvidu2 = findViewById(R.id.spnnvidu2);
        //tao du lieu de do len spn
        String [] list = new String[]{"C#","Java","Tin hoc","LT Mobile"};
        // tao doi tuong adapter
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item,list);
        spnnvidu2.setAdapter(arrayAdapter);
        ListView lstvd2 = findViewById(R.id.lstvd2);

//listview, recycle view,grid view

        // tao danh sach
        ArrayList<String> list1 = new ArrayList<>();
        list1.add("Nguyen Van A");
        list1.add("Nguyen Van B");
        list1.add("Nguyen Van C");
        list1.add("Nguyen Van D");
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,list1);
        lstvd2.setAdapter(adapter); // do du lieu len listview
        // su ly su kien khi click chon item tren listview
        lstvd2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(Viduspinner.this, list1.get(i), Toast.LENGTH_SHORT).show();
            }
        });

    }
}