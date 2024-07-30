package com.example.nguyenxuanbac_21103100918_kt3.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DbHelper extends SQLiteOpenHelper {
    public static final String DB_NAME="QLNS";

    public DbHelper (Context context){
        super(context,DB_NAME,null,2);
    }
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String tb_nhansu = "CREATE TABLE nhansu(mans_0918 integer primary key, hoten_0918 TEXT, luong_0918 TEXT)";
        sqLiteDatabase.execSQL(tb_nhansu);

        String data = "INSERT INTO nhansu (mans_0918, hoten_0918, luong_0918) VALUES (211914, 'Nguyen Van A', '2000000'), (211456, 'Tran Thi B', '1900000'), (211925, 'Le Van C', '1500000')";
        sqLiteDatabase.execSQL(data);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        if(i!=i1){
            sqLiteDatabase.execSQL("DROP TABLE IF EXISTS nhansu");
            onCreate(sqLiteDatabase);
        }
    }
}
