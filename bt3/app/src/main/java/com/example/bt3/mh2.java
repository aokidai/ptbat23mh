package com.example.bt3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class mh2 extends AppCompatActivity {
    Button btnOK;
    EditText KetQua;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mh2);
        Bundle bundle = getIntent().getExtras();
        //bundle=getE
        KetQua = (EditText)findViewById(R.id.txtKetQuaHienThi);
        String kq = bundle.getString("KQ");
        KetQua.setText(kq);


    }
}