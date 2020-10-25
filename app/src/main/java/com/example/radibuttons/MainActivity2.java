package com.example.radibuttons;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {
Button back, data;
    TextView display;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        display = findViewById(R.id.display);
        data=(Button) findViewById(R.id.data);
        data.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle extras = getIntent().getExtras();
                if (extras != null) {
                    String message=("G-1: " + extras.getString("r1" ));
                    message +=(", G-2: " + extras.getString("r2" ));
                    message += (",\n "+ extras.getString("cb" ));
                    Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
                    display.setText(message);
                }
            }
        });


        back=(Button) findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             //   String s= getIntent().getStringExtra();

                Intent intent=new Intent(MainActivity2.this , MainActivity.class );
                startActivity(intent);
            }
        });


    }
}