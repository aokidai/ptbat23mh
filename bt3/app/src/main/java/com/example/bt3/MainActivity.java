package com.example.bt3;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btnNhap, btnKQ;
    double a,b,c;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnNhap = (Button) findViewById(R.id.btnNhap);
        btnKQ = (Button) findViewById(R.id.btnKQ);

        btnNhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this,mh1.class);
                startActivityForResult(i,999);

            }
        });


        btnKQ = (Button) findViewById(R.id.btnKQ);
        btnKQ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // tinh kq ()


                //gfoij hamf tinhs

                String kq=giaiPTBac2(a,b,c);


                //
                Intent i = new Intent(MainActivity.this, mh2.class);
                i.putExtra("KQ",kq);
                startActivity(i);
            }
        });
    }

    ////
    public String giaiPTBac2(double a, double b, double c) {
        // kiểm tra các hệ số
        if (a == 0) {
            if (b == 0) {
                return "Phương trình vô nghiệm!";
            } else {
                return "Phương trình có một nghiệm: "   + "x = " + (-c / b);
            }

        }
        // tính delta
        double delta = b*b - 4*a*c;
        double x1;
        double x2;
        // tính nghiệm
        if (delta > 0) {
            x1 = (float) ((-b + Math.sqrt(delta)) / (2*a));
            x2 = (float) ((-b - Math.sqrt(delta)) / (2*a));
            return "Phương trình có 2 nghiệm là: "  + "x1 = " + x1 + " và x2 = " + x2;
        } else if (delta == 0) {
            x1 = (-b / (2 * a));
            return "Phương trình có nghiệm kép: "  + "x1 = x2 = " + x1;
        } else {
            return "Phương trình vô nghiệm!";
        }
    }
    ////

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 999) {

            // resultCode được set bởi DetailActivity
            // RESULT_OK chỉ ra rằng kết quả này đã thành công
            if (resultCode == Activity.RESULT_OK) {
                // Nhận dữ liệu từ Intent trả về
                a = data.getDoubleExtra("a",0);
                b = data.getDoubleExtra("b",0);
                c = data.getDoubleExtra("c",0);
                // Sử dụng kết quả result bằng cách hiện Toast
                TextView view = (TextView) findViewById(R.id.txtpt);
                String pt = a + "X2 + " +  b + "X + " + c + " = 0";
                view.setText(pt);

            } else {
                Toast.makeText(this, "Result: Loi nhap ", Toast.LENGTH_LONG).show();
            }
        }
    }
}