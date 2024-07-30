package com.example.luyen_truoc_thi;

import android.content.Intent;
import android.os.Bundle;
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

import java.util.ArrayList;

public class mh3 extends AppCompatActivity {
    ArrayList<String> list = new ArrayList<>();
    String chonItem = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_mh3);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        ListView lst = findViewById(R.id.lst);
        list.add("Ky tuc xa");
        list.add("Json");
        ArrayAdapter<String> adapter = new ArrayAdapter<>(mh3.this, android.R.layout.simple_list_item_1,list);
        lst.setAdapter(adapter);
        lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                chonItem = list.get(i);
                Toast.makeText(mh3.this, "You selected: "+chonItem, Toast.LENGTH_SHORT).show();
                if(chonItem.equals("Ky tuc xa")){
                    Intent intent = new Intent(mh3.this, mh2.class);
                    startActivity(intent);
                    chonItem = null;
                } else if (chonItem.equals("Json")) {
                    Intent intent = new Intent(mh3.this, mh4.class);
                    startActivity(intent);
                    chonItem = null;
                }
            }
        });
        Button btn_next = findViewById(R.id.btn_next);
        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(chonItem.equals("Ky tuc xa")){
                    Intent intent = new Intent(mh3.this, mh2.class);
                    startActivity(intent);
                    chonItem = null;
                } else if (chonItem.equals("Json")) {
                    Intent intent = new Intent(mh3.this, mh4.class);
                    startActivity(intent);
                    chonItem = null;
                }
            }
        });
    }
}