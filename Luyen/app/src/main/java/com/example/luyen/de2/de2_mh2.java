package com.example.luyen.de2;

import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.luyen.R;

import java.util.ArrayList;

public class de2_mh2 extends AppCompatActivity {
    ListView lst;
    ArrayList<String> list = new ArrayList<>();
    Button btnThucHien,btnThoat;
    String chonItem = null;
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_de2_mh2);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        lst = findViewById(R.id.lst);
        list.add("Kan: Tinh toan Cong");
        list.add("Kan: Dang Ky Mon Hoc");
        list.add("Kan: Json");
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,list);
        lst.setAdapter(adapter);
        lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                 chonItem = list.get(i);
                 Toast.makeText(de2_mh2.this, "You selected: " + chonItem, Toast.LENGTH_SHORT).show();
            }
        });
        btnThucHien = findViewById(R.id.btnThucHien);
        btnThoat = findViewById(R.id.btnThoat);
        btnThucHien.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(chonItem != null && chonItem.equals("Kan: Tinh toan Cong"))
                {
                    intent = new Intent(de2_mh2.this, de2_mh3.class);
                    startActivity(intent);
                    chonItem = null;
                } else if (chonItem != null && chonItem.equals("Kan: Json")) {
                    intent = new Intent(de2_mh2.this, de2_mh4.class);
                    startActivity(intent);
                    chonItem = null;
                } else if (chonItem != null && chonItem.equals("Kan: Dang Ky Mon Hoc")) {
                    intent = new Intent(de2_mh2.this, de2_mh5.class);
                    startActivity(intent);
                    chonItem = null;
                }
            }
        });
        btnThoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }


}