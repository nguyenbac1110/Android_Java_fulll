package com.example.luyen.de5;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.luyen.R;

import java.util.ArrayList;

public class de5_mh2 extends AppCompatActivity {
     EditText baihat, casy;
     Button them,xoa,sua,chitiet;
     ListView lst;
     ArrayList<String> baihatlist;
     ArrayAdapter<String> adapter;
    int selectedIndex = -1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_de5_mh2);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        baihat = findViewById(R.id.baihat);
        casy = findViewById(R.id.casy);
        lst = findViewById(R.id.lst);
        them = findViewById(R.id.them);
        xoa = findViewById(R.id.xoa);
        sua = findViewById(R.id.sua);
        baihatlist = new ArrayList<>();
        chitiet = findViewById(R.id.chitiet);
        baihatlist.add("Bài hát 1 - 0394127239");
        baihatlist.add("Bài hát 2 - 0395245977");
        baihatlist.add("Bài hát 3 - 2543747877");
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, baihatlist);
        lst.setAdapter(adapter);
        them.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String tenBaiHat = baihat.getText().toString();
                String tenCaSi = casy.getText().toString();
                if (!tenBaiHat.isEmpty() && !tenCaSi.isEmpty()) {
                    baihatlist.add(tenBaiHat + " - " + tenCaSi);
                    adapter.notifyDataSetChanged();
                    Toast.makeText(de5_mh2.this, "Thêm thành công bài hát: " + tenBaiHat, Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(de5_mh2.this, "Vui lòng nhập đầy đủ thông tin", Toast.LENGTH_SHORT).show();
                }
            }
        });
        lst.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                selectedIndex = position;
                String selectedItem = baihatlist.get(position);
                String[] parts = selectedItem.split(" - ");
                String soDienThoai = parts[1];

                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:" + soDienThoai));
                startActivity(intent);
                return true;
            }
        });
        lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                selectedIndex = position;
                String selectedItem = baihatlist.get(position);
                String[] parts = selectedItem.split(" - ");
                baihat.setText(parts[0]);
                casy.setText(parts[1]);
            }
        });
        chitiet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (selectedIndex != -1) {
                    String selectedItem = baihatlist.get(selectedIndex);
                    String[] parts = selectedItem.split(" - ");
                    Intent intent = new Intent(de5_mh2.this, de5_mh3.class);
                    intent.putExtra("tenBaiHat", parts[0]);
                    intent.putExtra("tenCaSi", parts[1]);
                    startActivity(intent);
                } else {
                    Toast.makeText(de5_mh2.this, "Vui lòng chọn bài hát để xem chi tiết", Toast.LENGTH_SHORT).show();
                }
            }
        });
        xoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (selectedIndex != -1) {
                    baihatlist.remove(selectedIndex);
                    adapter.notifyDataSetChanged();
                    baihat.setText("");
                    casy.setText("");
                    selectedIndex = -1;
                    Toast.makeText(de5_mh2.this, "Xóa thành công", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(de5_mh2.this, "Vui lòng chọn bài hát để xóa", Toast.LENGTH_SHORT).show();
                }
            }
        });
        sua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (selectedIndex != -1) {
                    String tenBaiHat = baihat.getText().toString();
                    String tenCaSi = casy.getText().toString();
                    if (!tenBaiHat.isEmpty() && !tenCaSi.isEmpty()) {
                        baihatlist.set(selectedIndex, tenBaiHat + " - " + tenCaSi);
                        adapter.notifyDataSetChanged();
                        baihat.setText("");
                        casy.setText("");
                        selectedIndex = -1;
                        Toast.makeText(de5_mh2.this, "Sửa thành công", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(de5_mh2.this, "Vui lòng nhập đầy đủ thông tin", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(de5_mh2.this, "Vui lòng chọn bài hát để sửa", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}