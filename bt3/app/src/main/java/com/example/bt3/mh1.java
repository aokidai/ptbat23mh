package com.example.bt3;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.net.SocketAddress;

public class mh1 extends AppCompatActivity {
    double a,b,c;
    EditText Soa,Sob,Soc;
    Button btnOK;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mh1);

        btnOK = (Button) findViewById(R.id.btnOK);
        btnOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent();
                Bundle bundle = new Bundle();
                Soa=(EditText)findViewById(R.id.txtSoa);
                Sob=(EditText)findViewById(R.id.txtSob);
                Soc=(EditText)findViewById(R.id.txtSoc);
                a= Double.parseDouble(String.valueOf(Soa.getText()));
                b= Double.parseDouble(String.valueOf(Sob.getText()));
                c= Double.parseDouble(String.valueOf(Soc.getText()));

                i.putExtra("a",a);
                i.putExtra("b",b);
                i.putExtra("c",c);
                setResult(Activity.RESULT_OK, i);
                finish();
            }
        });
    }
}
