package com.example.luyen_de_5;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.List;

public class manhinh2 extends AppCompatActivity {
    DanhBaAdapter adapter;
    ArrayList<DanhBa> danhbalist;
    int selectedIndex = -1;
    DanhBa selectedItem = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_manhinh2);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        EditText ten = findViewById(R.id.ten);
        EditText sdt = findViewById(R.id.sdt);
        ListView lst = findViewById(R.id.lst);
        danhbalist = new ArrayList<>();
        danhbalist.add(new DanhBa("asrge","1595965"));
        adapter = new DanhBaAdapter(this,danhbalist);
        lst.setAdapter(adapter);
        lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                selectedIndex = i;
                selectedItem = danhbalist.get(i);
                ten.setText(selectedItem.getTen());
                sdt.setText(selectedItem.getSdt());
            }
        });
        
        lst.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                
                // xoa
//                danhbalist.remove(i);
//                adapter.notifyDataSetChanged();
//                Toast.makeText(manhinh2.this, "Xoa thanh cong", Toast.LENGTH_SHORT).show();
//                selectedIndex = -1;

                // goi

                String sdt = danhbalist.get(i).getSdt();
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:"+sdt));
                startActivity(intent);
                return true;
            }
        });
        Button them = findViewById(R.id.them);
        Button sua = findViewById(R.id.sua);
        Button xoa = findViewById(R.id.xoa);
        Button chitiet = findViewById(R.id.chitiet);

        them.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String ten_ = ten.getText().toString();
                String sdt_ = sdt.getText().toString();
                if(!ten_.isEmpty() && !sdt_.isEmpty()){
                    DanhBa db = new DanhBa(ten_,sdt_);
                    danhbalist.add(db);
                    adapter.notifyDataSetChanged();
                    selectedIndex = -1;
                } else {
                    Toast.makeText(manhinh2.this, "Hay nhap day du thong tin", Toast.LENGTH_SHORT).show();
                }
            }
        });
        sua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(selectedIndex != -1){
                    String ten_ = ten.getText().toString();
                    String sdt_ = sdt.getText().toString();
                    if(!ten_.isEmpty() && !sdt_.isEmpty()){
                        DanhBa db = new DanhBa(ten_,sdt_);
                        danhbalist.set(selectedIndex,db);
                        adapter.notifyDataSetChanged();
                        selectedIndex = -1;
                        ten.setText("");
                        sdt.setText("");
                        Toast.makeText(manhinh2.this, "Xoa thanh cong", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(manhinh2.this, "XIn hay nhap day du thong tin", Toast.LENGTH_SHORT).show();
                    }
                }else {
                    Toast.makeText(manhinh2.this, "Hay chon o item", Toast.LENGTH_SHORT).show();
                }
            }
        });
        xoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (selectedIndex != -1){
                    danhbalist.remove(selectedIndex);
                    adapter.notifyDataSetChanged();
                    selectedIndex = -1;
                    ten.setText("");
                    sdt.setText("");
                    Toast.makeText(manhinh2.this, "Xoa thanh cong", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(manhinh2.this, "Hay chon o item", Toast.LENGTH_SHORT).show();
                }
            }
        });
        chitiet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String ten_ = ten.getText().toString();
                String sdt_ = sdt.getText().toString();

                Intent intent = new Intent(manhinh2.this, manhinh3.class);
                intent.putExtra("ten",ten_);
                intent.putExtra("sdt",sdt_);
                startActivity(intent);
            }
        });
    }
}