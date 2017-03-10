package com.example.mahe.lab4;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {
    DatabaseHelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        db=new DatabaseHelper(this);
        Button b1,b2,b3,b4;
        b1=(Button)findViewById(R.id.Add);
        b2=(Button)findViewById(R.id.Update);
        b3=(Button)findViewById(R.id.Delete);
        b4=(Button)findViewById(R.id.Display);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent a=new Intent(MainActivity.this,Main2Activity.class);
                startActivity(a);
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent b=new Intent(MainActivity.this,Main3Activity.class);
                startActivity(b);
            }
        });

        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent c=new Intent(MainActivity.this,Main3Activity.class);
                startActivity(c);
            }
        });

        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent d=new Intent(MainActivity.this,Main3Activity.class);
                startActivity(d);
            }
        });

    }
}