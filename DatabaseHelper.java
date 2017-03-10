package com.example.mahe.lab4;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by mahe on 2/18/2017.
 */

public class DatabaseHelper extends SQLiteOpenHelper {

    public static  final String DATABASE_NAME="students.db";
    public static  final String TABLE_NAME="studinfo";
    public static  final String COL1="ROLLNUM";
    public static  final String COL2="NAME";
    public static  final String COL3="MARKS";
    public DatabaseHelper(Context context) {
        super(context,DATABASE_NAME,null,1);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table "+TABLE_NAME+"(ROLLNUM INTEGER PRIMARY KEY AUTOINCREMENT,NAME TEXT,MARKS INTEGER);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        onCreate(db);
    }

    public boolean insertData(String name,Integer marks)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put(COL2,name);
        values.put(COL3,marks);
        long result= db.insert(TABLE_NAME,null,values);
        if(result==-1)
            return false;
        else
            return true;
    }

    public Cursor dispData()
    {
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor res=db.rawQuery("Select * from "+TABLE_NAME,null);
        return res;
    }

    public  boolean updateData(Integer rollnum,String Name,Integer marks)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put(COL1,rollnum);
        values.put(COL2,Name);
        values.put(COL3,marks);
        long result=db.update(TABLE_NAME,values,"ROLLNUM=?",new String[]{rollnum.toString()});
        if(result==-1)
            return false;
        else
            return true;
    }

    public Integer deleteData(Integer rollnum)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        return db.delete(TABLE_NAME,"ROLLNUM=?",new String[]{rollnum.toString()});
    }
}
