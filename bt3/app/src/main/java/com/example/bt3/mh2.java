package com.example.bt3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class mh2 extends MainActivity {
    Button btnDong;
    TextView tvNghiemPT;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mh2);
        btnDong = (Button) findViewById((R.id.btnDong));
        tvNghiemPT = (TextView) findViewById(R.id.tvNghiemPT);
        Intent callerIntent = getIntent();
        Bundle packageFormCaller = callerIntent.getBundleExtra("bt32");
        float a = packageFormCaller.getFloat("soa2");
        float b = packageFormCaller.getFloat("sob2");
        float c = packageFormCaller.getFloat("soc2");
        tvNghiemPT.setText(GiaiPTBat2(a,b,c));
        btnDong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

}