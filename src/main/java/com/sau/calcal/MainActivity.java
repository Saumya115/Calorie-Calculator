package com.sau.calcal;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.V;

public class MainActivity extends AppCompatActivity {

    TextView t1,t2,t3;
    EditText e1,e2;
    Button b1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        t1=findViewById(R.id.t1);
        t2=findViewById(R.id.t2);
        t3=findViewById(R.id.t3);
        e1=findViewById(R.id.e1);
        e2=findViewById(R.id.e2);
        b1=findViewById(R.id.b1);

    }

    public void login(View view) {
        String Uname =e1.getText().toString();
        String Password=e2.getText().toString();
        if(Uname.isEmpty())
        {
          e1.setError("invalid");
          e1.requestFocus();
        }
        else if(Password.isEmpty()){
            e2.setError("invalid");
            e2.requestFocus();
        }
        else{

            Database1 db=new Database1(this);
            SQLiteDatabase sd=db.getWritableDatabase();
          sd.rawQuery("select Name from Register where Name='"+Uname+"' and Password='"+Password+"'",null);

                Intent i = new Intent(this,HomeActivity.class);
                i.putExtra("user",Uname);
               i.putExtra("pass",Password);
                startActivity(i);
    }
}
    public void click(View view) {
        Intent i=new Intent(this,Registration.class);
        startActivity(i);
    }
}
