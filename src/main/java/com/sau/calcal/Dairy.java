package com.sau.calcal;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Calendar;
import java.util.jar.Attributes;

public class Dairy extends AppCompatActivity {
EditText e1,e2,e3;
Button b1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dairy);
        e1=findViewById(R.id.e1);
        e2=findViewById(R.id.e2);
        e3=findViewById(R.id.e3);
        b1=findViewById(R.id.b1);
    }

    public void Date(View view) {
        Calendar c=Calendar.getInstance();
        int c_year=c.get(Calendar.YEAR);
        int c_month=c.get(Calendar.MONTH);
        int c_day=c.get(Calendar.DAY_OF_MONTH);
        DatePickerDialog dpd=new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int dayofmonth, int month, int year) {
                e1.setText(dayofmonth + "/" + (month + 1) + "/" + year);
            }
        },c_year,c_month,c_day);
        DatePicker dp=dpd.getDatePicker();
        dp.setMaxDate(System.currentTimeMillis());
        dpd.show();
    }

    public void Submit(View view) {
        String Date=e1.getText().toString().trim();
        String Food=e2.getText().toString().trim();
        String Calories=e3.getText().toString().trim();
        Database2 db=new Database2(this);
        SQLiteDatabase md=db.getWritableDatabase();
        md.execSQL("insert into fooddetails values("+Date+",'"+Food+"',"+Calories+")");
        Toast.makeText(this,"Submitted",Toast.LENGTH_SHORT).show();
      //  int Calories1=Integer.parseInt(Calories);
       /* Intent i=new Intent(this,HomeActivity.class);
        i.putExtra("k3",Calories1);
        startActivity(i); */
    }
}
