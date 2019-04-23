package com.sau.calcal;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Database1 extends SQLiteOpenHelper {


    public static final String DBNAME = "RegisterDB" ;
    public static final int VERSION = 1;

    public Database1 (Context context)
    {
        super(context,DBNAME,null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table Register ( Name text,Emailid text,Contactno number,Password password,Age number,Height number,Weight number,Gender text,DOB date,Cal double)");
    }
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
