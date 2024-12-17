package com.example.finaldemo.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.finaldemo.page2;

public class Database extends SQLiteOpenHelper {
    static Context context;

    public static void setContext(Context context) {
        Database.context = context;
    }

    public Database() {
        super(context,"xm.db", null, 1);
        // TODO Auto-generated constructor stub
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // TODO Auto-generated method stub
        String sql="create table tb_m ( kinds varchar(20) )";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // TODO Auto-generated method stub

    }
    public SQLiteDatabase getConnection(){
        return getWritableDatabase();
    }
    public void close(SQLiteDatabase db){
        db.close();
    }
}
