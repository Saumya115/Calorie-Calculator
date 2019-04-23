package com.sau.calcal;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.textservice.SuggestionsInfo;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class HomeActivity extends AppCompatActivity {
TextView t1,t2;
ProgressBar p1,p2;
Button b1,b2;
int cal2=0;
int cal1=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        t1=findViewById(R.id.t1);
        t2=findViewById(R.id.t2);
        String user = getIntent().getStringExtra("user");
        String pass= getIntent().getStringExtra("pass");
        Database1 db=new Database1(this);
        SQLiteDatabase sd=db.getWritableDatabase();
        Toast.makeText(this, ""+user, Toast.LENGTH_SHORT).show();
        Cursor cursor = sd.rawQuery("select Cal from Register where Name='"+user+"' and Password='"+pass+"'",null);
        if(cursor.moveToFirst()){
          cal2 =cursor.getInt(0);
            t1.setText("/"+cal2);
        }
        Database2 db1=new Database2(this);
        SQLiteDatabase sd1=db1.getWritableDatabase();
        Cursor c=sd1.rawQuery("select Calories from fooddetails where Date="""
        if(c.moveToFirst())
        {
            cal1=c.getInt(0);
            t2.setText(cal1);
        }

    /*    Intent i=getIntent();
        Bundle b=i.getExtras();
        int cal1=b.getInt("k2");
        t2.setText(cal1);

*/
     // t2=t2.findViewById(R.id.t2);
       // p1=p1.findViewById(R.id.p1);
     //   p2=p2.findViewById(R.id.p2);
      //  b1=b1.findViewById(R.id.b1);
       // b2=b2.findViewById(R.id.b2);

        /* Intent i1=getIntent();
          int cal=i1.getIntExtra("k1");
         t1.setText("Calories:"+cal); */


//      if(getIntent().getExtras()!=null)
//      {
//          Bundle bundle=getIntent().getExtras();
//          Double Calories =bundle.getDouble("k1");
//
//
//      }
//      else
//      {
//          Toast.makeText(HomeActivity.this,"Something went wrong",Toast.LENGTH_LONG).show();
//      }
//

    }

        public void Diary(View view) {
            Intent i=new Intent(this,Dairy.class);
            startActivity(i);
        }

        public void suggestion(View view) {
            Intent i=new Intent(this, suggestion.class);
            startActivity(i);
        }
}