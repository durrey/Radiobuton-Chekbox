package com.example.radibuttons;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    RadioGroup radiogroup1;
    RadioGroup radiogroup2;
    RadioButton radioButton1;
    RadioButton radioButton2;
    String result;
    CheckBox cb_1,cb_2,cb_3,cb_4,cb;
    Button btn2, btsubmit;
    Button startbtn;
    TextView txt1,txt2,displayy;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        radiogroup1 = findViewById(R.id.radiogroup1);
        txt1 = findViewById(R.id.txt1);
        radiogroup2 = findViewById(R.id.radiogroup2);
        txt1 = findViewById(R.id.txt1);
        Button buttonClick = findViewById(R.id.btn1);
        buttonClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int radioId = radiogroup1.getCheckedRadioButtonId();
                radioButton1 = findViewById(radioId);
                int radioId2 = radiogroup2.getCheckedRadioButtonId();
                radioButton2 = findViewById(radioId2);
                txt1.setText("G-1 : " + radioButton1.getText() + " , G-2 : " + radioButton2.getText());
            }
        });

        cb_1 = findViewById(R.id.cb1);
        cb_2 = findViewById(R.id.cb2);
        cb_3 = findViewById(R.id.cb3);
        cb_4 = findViewById(R.id.cb4);

        startbtn = (Button) findViewById(R.id.next); //casting
        startbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String str1=radioButton1.getText().toString();
                String str2=radioButton2.getText().toString();
                Intent intent=new Intent(MainActivity.this, MainActivity2.class);
                //intent.putExtra(radioButton1: "keybutton" , str1);
                intent.putExtra( "r1",str1);
                intent.putExtra("r2",str2);
                intent.putExtra("cb",result);
                startActivity(intent);
            }
        });

    }//bundle end
    public void checkButton(View v) {
        int radioId = radiogroup1.getCheckedRadioButtonId();
        radioButton1 = findViewById(radioId);
        Toast.makeText(this, "Selected Radio Button from G1: " + radioButton1.getText(),
                Toast.LENGTH_SHORT).show();
    }
    public void checkButton2(View v) {
        int radioId = radiogroup2.getCheckedRadioButtonId();
        radioButton2 = findViewById(radioId);
        Toast.makeText(this, "Selected Radio Button from G2: " + radioButton2.getText(),
                Toast.LENGTH_SHORT).show();
    }
    public void onCheckboxClicked(View v) {
         result = "Checked Boxes : ";
        displayy = findViewById(R.id.displayy);
        if(cb_1.isChecked()){
            result += "\nBook";
        }
        if(cb_2.isChecked()){
            result += "\nMagazine";
        }
        if(cb_3.isChecked()){
            result += "\nInternet";
        }
        if(cb_4.isChecked()){
            result += "\nNewspaper";
        }
        Toast.makeText(getApplicationContext(), result, Toast.LENGTH_SHORT).show();
        displayy.setText(result);
       // String str3=radioButton1.getText().toString();
    }



    }


