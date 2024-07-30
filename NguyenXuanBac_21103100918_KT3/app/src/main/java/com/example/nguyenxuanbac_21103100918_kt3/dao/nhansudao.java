package com.example.nguyenxuanbac_21103100918_kt3.dao;

import static androidx.constraintlayout.helper.widget.MotionEffect.TAG;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.nguyenxuanbac_21103100918_kt3.database.DbHelper;
import com.example.nguyenxuanbac_21103100918_kt3.model.nhansu;

import java.util.ArrayList;

public class nhansudao {
    private final DbHelper dbhelper;

    public nhansudao(Context context) {
        dbhelper = new DbHelper(context);
    }


    public ArrayList<nhansu> selectAll() {
        ArrayList<nhansu> list = new ArrayList<>();
        SQLiteDatabase db = dbhelper.getReadableDatabase();

        db.beginTransaction();
        try {

            Cursor cs = db.rawQuery("select * from nhansu", null);
            if (cs.getCount() > 0) {
                cs.moveToFirst();
                while (!cs.isAfterLast()) {
                    nhansu ns = new nhansu();
                    ns.setMans_0918(cs.getInt(0));
                    ns.setHoten_0918(cs.getString(1));
                    ns.setLuong_0918(cs.getString(2));
                    list.add(ns);
                    cs.moveToNext();
                }
                db.setTransactionSuccessful();
            }

        } catch (Exception e) {
            Log.e(TAG, "Lỗi" + e);
        } finally {
            db.endTransaction();
        }
        return list;
    }
    public boolean delete(int id){
        SQLiteDatabase db=dbhelper.getWritableDatabase();
        long row=db.delete("nhansu","mans_0918=?",new String[]{String.valueOf(id)});
        return (row>0);
    }
}
