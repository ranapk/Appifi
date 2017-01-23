package com.example.patrick.appify;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText ed1;
    Button b1;
    public static final String URL = "url" ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        final SharedPreferences pref = getSharedPreferences("name", Context.MODE_PRIVATE);
        b1=(Button)findViewById(R.id.b1);
        ed1=(EditText)findViewById(R.id.ed1);
        String val = pref.getString("URL",null);

        if(val!=null)
        {
            Intent intent = new Intent(MainActivity.this, loader.class);
            intent.putExtra("URL",val);
            startActivity(intent);
            finish();
        }
        else
        {
            b1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String s  = ed1.getText().toString();
                    SharedPreferences.Editor ed = pref.edit();
                    ed.putString("URL", s);
                    ed.commit();
                    Intent intnt = new Intent(MainActivity.this, loader.class);
                    intnt.putExtra("URL",s);
                    startActivity(intnt);
                }
            });
        }
    }
}
