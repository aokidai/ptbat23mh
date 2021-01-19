package com.example.bt3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public static final int NHAPHS_REQUESTCODE = 111;
    public static final int NHAPHS_RESULTCODE = 112;
    Button btnDong;
    Button btnGiai;
    Button btnNHS;
    float a, b, c;
    float x1, x2;
    EditText txtpt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnGiai = (Button) findViewById((R.id.btnGiai));
        btnDong = (Button) findViewById((R.id.btnDong));
        btnNHS = (Button) findViewById(R.id.btnNHS);
        txtpt = (EditText) findViewById(R.id.txtpt);
        btnDong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        btnNHS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent1 = new Intent(MainActivity.this, mh1.class);
                startActivityForResult(myIntent1, MainActivity.NHAPHS_REQUESTCODE);
            }
        });
        btnGiai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent call=getIntent();
                Bundle bun1=call.getBundleExtra("bt3");
                final float a=bun1.getFloat("soa");
                final float b=bun1.getFloat("sob");
                final float c=bun1.getFloat("soc");
                Intent intent = new Intent(MainActivity.this,mh2.class);
                Bundle bun =new Bundle();
                bun.putFloat("soa2", a);
                bun.putFloat("sob2", b);
                bun.putFloat("soc2", c);
                intent.putExtra("bt32", bun);
                //startActivity(intent);
                startActivityForResult(intent, MainActivity.NHAPHS_RESULTCODE);
                //GiaiPTBat2(a,b,c);
                //Intent myIntent1 = new Intent(MainActivity.this, mh2.class);
                //startActivityForResult(myIntent1, MainActivity.NHAPHS_RESULTCODE);
            }
        });
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        // TODO Auto-generated method stub
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == MainActivity.NHAPHS_REQUESTCODE && resultCode == MainActivity.NHAPHS_RESULTCODE)
        {
            Bundle bundle = data.getExtras();
            a = bundle.getFloat("soa");
            b = bundle.getFloat("sob");
            c = bundle.getFloat("soc");

            String str = a + "x^2 + " + b + " x + " + c + " = 0";
            txtpt.setText(str);

            btnGiai.setEnabled(true);
        }
    }
    public String GiaiPTBat2(float a, float b, float c)
    {
        float Denta = b*b - 4*a*c;
        double x1, x2;
        String kq;
        if(Denta<0)
        {
            kq = "Phuong trinh vo nghiem";
        }
        else if(Denta == 0)
        {
            x1 = (-b)/2/a;
            kq = "PT co nghiem kep x1 = x2 = "+x1;
        }
        else
        {
            x1 = (-b + Math.sqrt(Denta))/2/a;
            x2 = (-b - Math.sqrt(Denta))/2/a;
            kq = "PT co 2 nghiem phan biet: x1= "+x1 +"\n va x2= "+x2;
        }
        return kq;
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
}