package com.example.mahe.lab4;

import android.app.Activity;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.support.v7.appcompat.*;


public class Main3Activity extends Activity {
    DatabaseHelper db;
    Button b1, b2, b3;
    EditText e1, e2, e3,e4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        db = new DatabaseHelper(this);
        b1 = (Button) findViewById(R.id.Display);
        b2 = (Button) findViewById(R.id.Update);
        b3 = (Button) findViewById(R.id.Delete);
        e1 = (EditText) findViewById(R.id.editText);
        e2 = (EditText) findViewById(R.id.editText2);
        e3 = (EditText) findViewById(R.id.editText3);

        dispdata();
        updateData();
        delData();
    }

    public void dispdata() {
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Cursor cur = db.dispData();
                if (cur.getCount() == 0) {
                    showMessage("Error","Data Not Found.");
                    return;
                }
                StringBuffer buffer=new StringBuffer();
                while(cur.moveToNext()) {
                    buffer.append("Roll No:"+cur.getString(0)+"\n");
                    buffer.append("Name:"+cur.getString(1)+"\n");
                    buffer.append("Marks:"+cur.getString(2)+"\n\n");

                }
                showMessage("Data",buffer.toString());
            }
        });
    }

    public void updateData()
    {
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean isupdate=db.updateData(Integer.parseInt(e1.getText().toString()),e2.getText().toString(),Integer.parseInt(e3.getText().toString()));
                if(isupdate==true)
                    Toast.makeText(getApplicationContext(),"Data is Updated.",Toast.LENGTH_LONG).show();
                else
                    showMessage("ALERT.","NO ROWS ARE UPDATED.");
            }
        });
    }

    public  void delData()
    {
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int result=db.deleteData(Integer.parseInt(e1.getText().toString()));
                if(result==0)
                    showMessage("ALERT.","NO ROWS ARE DELETED.");
                else
                    Toast.makeText(getApplicationContext(),"Data is Deleted.",Toast.LENGTH_LONG).show();

            }
        });
    }

    public void showMessage(String title, String message) {
        AlertDialog.Builder alertBulider=new AlertDialog.Builder(this);
        alertBulider.setCancelable(true);
        alertBulider.setTitle(title);
        alertBulider.setMessage(message);
        alertBulider.show();
    }



}


