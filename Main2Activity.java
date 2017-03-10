

        package com.example.mahe.lab4;

        import android.app.Activity;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.Button;
        import android.widget.EditText;
        import android.widget.Toast;

public class Main2Activity extends Activity {
    EditText e2,e3;
    Button add;
    DatabaseHelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        db=new DatabaseHelper(this);
        e2 = (EditText) findViewById(R.id.editText2);
        e3 = (EditText) findViewById(R.id.editText3);
        add=(Button)findViewById(R.id.Add);
        AddData();
    }
    public void AddData()
    {
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                String name = e2.getText().toString();
                Integer marks = Integer.parseInt(e3.getText().toString());
                boolean result=db.insertData(name, marks);
                if(result==true)
                    Toast.makeText(getApplicationContext(),"Data Inserted Succesfully.",Toast.LENGTH_LONG).show();
                else
                    Toast.makeText(getApplicationContext(),"Data Not Inserted.",Toast.LENGTH_LONG).show();
            }
        });
    }
}