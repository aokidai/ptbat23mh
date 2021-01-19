package com.example.bt3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class mh1 extends AppCompatActivity {
    float a, b, c;
    EditText hsa, hsb, hsc;
    Button btnDong;
    Button btnGiai;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mh1);
        btnDong = (Button) findViewById((R.id.btnDong));
        btnGiai = (Button) findViewById(R.id.btnGiai);
        hsa = (EditText) findViewById(R.id.txtA);
        hsb = (EditText) findViewById(R.id.txtB);
        hsc = (EditText) findViewById(R.id.txtC);
        btnGiai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(mh1.this, MainActivity.class);
                //Intent myIntent = getIntent();
                Bundle bundle = new Bundle();
                a = Float.parseFloat(hsa.getText().toString());
                b = Float.parseFloat(hsb.getText().toString());
                c = Float.parseFloat(hsc.getText().toString());
                bundle.putFloat("soas", a);
                bundle.putFloat("sob", b);
                bundle.putFloat("soc", c);
                myIntent.putExtra("bt3", bundle);
                setResult(MainActivity.NHAPHS_RESULTCODE, myIntent);
                startActivityForResult(myIntent, MainActivity.NHAPHS_RESULTCODE);
                //finish();
            }
        });
        btnDong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
