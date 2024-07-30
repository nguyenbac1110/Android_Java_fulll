package com.example.de_5;

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
        danhbalist.add(new DanhBa("Nguyen Van A","0394127739"));
        adapter = new DanhBaAdapter(this,danhbalist);
        lst.setAdapter(adapter);
        lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                selectedIndex = i;
                selectedItem = danhbalist.get(i);
                ten.setText(selectedItem.getTen());
                sdt.setText(selectedItem.getDienthoai());
            }
        });
        lst.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                //xoa khi an giu
//                danhbalist.remove(i);
//                adapter.notifyDataSetChanged();
//                ten.setText("");
//                sdt.setText("");
//                selectedIndex = -1;
//                Toast.makeText(manhinh2.this, "Xoa thanh cong", Toast.LENGTH_SHORT).show();

                // an giu chuyen sang cuoc goi
               String soDienThoai = danhbalist.get(i).getDienthoai();
               Intent intent = new Intent(Intent.ACTION_DIAL);
               intent.setData(Uri.parse("tel:"+soDienThoai));
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
                    Toast.makeText(manhinh2.this, "Them thanh cong", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(manhinh2.this, "Nhap day du thong tin", Toast.LENGTH_SHORT).show();
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
                        ten.setText("");
                        sdt.setText("");
                        selectedIndex = -1;
                        Toast.makeText(manhinh2.this, "Sua thanh cong", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(manhinh2.this, "Hay chon vi tri can sua", Toast.LENGTH_SHORT).show();
                }
            }
        });
        xoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(selectedIndex != -1){
                    danhbalist.remove(selectedIndex);
                    adapter.notifyDataSetChanged();
                    ten.setText("");
                    sdt.setText("");
                    selectedIndex = -1;
                    Toast.makeText(manhinh2.this, "Xoa thanh cong", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(manhinh2.this, "Hay chon o can xoa", Toast.LENGTH_SHORT).show();
                }
            }
        });
        chitiet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (selectedIndex != -1){
                    selectedItem = danhbalist.get(selectedIndex);
                    Intent intent = new Intent(manhinh2.this, manhinh3.class);
                    intent.putExtra("ten",selectedItem.getTen());
                    intent.putExtra("sdt",selectedItem.getDienthoai());
                    startActivity(intent);
                }else {
                    Toast.makeText(manhinh2.this, "Hay chon item can xem chi tiet", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}