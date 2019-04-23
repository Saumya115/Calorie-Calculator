package com.sau.calcal;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

public class Registration extends AppCompatActivity {
 TextView t1;
 EditText e1,e2,e3,e4,e5,e6,e7,e8,e9;
 Button b1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        t1=findViewById(R.id.t1);
        e1=findViewById(R.id.e1);
        e2=findViewById(R.id.e2);
        e3=findViewById(R.id.e3);
        e4=findViewById(R.id.e4);
        e5=findViewById(R.id.e5);
        e6=findViewById(R.id.e6);
        e7=findViewById(R.id.e7);
        e8=findViewById(R.id.e8);
        e9=findViewById(R.id.e9);
        b1=findViewById(R.id.b1);
    }
        public void pickdate(View view) {
        Calendar c=Calendar.getInstance();
        int c_year=c.get(Calendar.YEAR);
        int c_month=c.get(Calendar.MONTH);
        int c_day=c.get(Calendar.DAY_OF_MONTH);
        DatePickerDialog dpd=new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int dayofmonth, int month, int year) {
                e9.setText(dayofmonth + "/" + (month + 1) + "/" + year);
            }
        },c_year,c_month,c_day);
        DatePicker dp=dpd.getDatePicker();
        dp.setMaxDate(System.currentTimeMillis());
        dpd.show();
    }


    public void Register(View view) {
        String Name=e1.getText().toString().trim();
        String Emailid=e2.getText().toString().trim();
        String Contactno=e3.getText().toString().trim();
        String Password=e4.getText().toString().trim();
        String Age=e5.getText().toString().trim();
        String Height=e6.getText().toString().trim();
        String Weight=e7.getText().toString().trim();
        String Gender=e8.getText().toString().trim();
        String DOB=e9.getText().toString();
        if(Name.isEmpty() || Emailid.isEmpty() || Contactno.isEmpty() || Password.isEmpty() || Age.isEmpty() || Height.isEmpty() || Weight.isEmpty() || Gender.isEmpty() || DOB.isEmpty())
        {
            Toast.makeText(this, "please fill all the information", Toast.LENGTH_SHORT).show();
        }
        else
        {
            int Weight1=Integer.parseInt(Weight);
            int Height1=Integer.parseInt(Height);
            int Age1=Integer.parseInt(Age);
            int BMR;
            int Calories;
            if (Gender.equals('M'))
            {
                BMR= (int) (66.4730 + (13.7516 * Weight1) + (5.0033 * Height1) - (6.7550 * Age1));
                Calories= (int) (BMR*1.375);
            }
            else
            {
                BMR= (int) (65.0955 + (9.5634 * Weight1) + (1.8496 * Height1) - (4.6756 * Age1));
                Calories= (int) (BMR*1.375);
            }
            Database1 db=new Database1(this);
            SQLiteDatabase md=db.getWritableDatabase();
            md.execSQL("insert into Register values('"+Name+"','"+Emailid+"','"+Contactno+"','"+Password+"',"+Age+","+Height+","+Weight+",'"+Gender+"','"+DOB+"',"+Calories+")");
            Toast.makeText(this,"Registered",Toast.LENGTH_SHORT).show();
            Intent i=new Intent(this,HomeActivity.class);
           Bundle bundle=new Bundle();
            bundle.putInt("k1",Calories);
            i.putExtra("user",Name);
            i.putExtra("pass",Password);
        startActivity(i);
    }   }


}
