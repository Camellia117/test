package com.example.finaldemo.db;

import java.util.ArrayList;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.finaldemo.model.Message;

public class Controller {

    public ArrayList<Message> selectM(String sql){
        ArrayList<Message> am=new ArrayList<Message>();
        Database db=new Database();
        SQLiteDatabase sd=db.getConnection();
        //select * from tb_m
        //Cursor c=sd.query("tb_m", null, null, null, null, null, null);
        Cursor c=sd.rawQuery(sql, null);
        while(c.moveToNext()){
            Message m=new Message();
            m.setMtitle(c.getString(0));
//            m.setMcontent(c.getString(1));
//            m.setMtime(c.getString(2));
            am.add(m);
        }
        return am;
    }
    public boolean insertM(String t){
        boolean f=false;
        Database db=new Database();
        SQLiteDatabase sd=db.getConnection();
        //insert into biao values(,,)
        ContentValues con=new ContentValues();
        con.put("kinds", t);
//        con.put("t_con", c);
//        con.put("t_time", ti);
        long m=sd.insert("tb_m",null,con);
        if(m>0)f=true;
        return f;
    }
    public boolean deleteM(String t){
        boolean f=false;
        Database db=new Database();
        SQLiteDatabase sd=db.getConnection();
        //delete from tb_m where t_title=5522 and t_con=5656
        int m=sd.delete("tb_m", "kinds=?", new String[]{t});
        if(m>0)f=true;
        return f;
    }
    public boolean updateM(String t,String c,String ti){
        boolean f=false;
        Database db=new Database();
        SQLiteDatabase sd=db.getConnection();
        ContentValues con=new ContentValues();
        con.put("t_con", c);
        con.put("t_time", ti);
        //update tb_m set t_con=c,t_time=ti where t_title=t
        int m=sd.update("tb_m",con,"t_title=?", new String[]{t});
        if(m>0)f=true;
        return f;
    }
}






