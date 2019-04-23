package com.sau.calcal;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Database2 extends SQLiteOpenHelper{
    public static final String DBNAME="foods";
    public static final int VERSION=1;
    public  Database2 (Context context)
    {
        super(context,DBNAME,null,1);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table fooddetails(Date date,Food text,Calories number)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
