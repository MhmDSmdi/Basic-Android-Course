package com.blucode.mhmd.section3;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity {

    Button btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, call, minus, plus, multiple;
    EditText editText;
    // 0 add
    // 1 minus
    // 2 multiple
    int status = 0;
    int op1 = 0, op2 = 0, res = 0;
    String sOp1 = "", sOp2 = "";
    boolean isOperation = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layout);
        editText = findViewById(R.id.edittext_op2);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        btn5 = findViewById(R.id.btn5);
        btn6 = findViewById(R.id.btn6);
        btn7 = findViewById(R.id.btn7);
        btn8 = findViewById(R.id.btn8);
        btn9 = findViewById(R.id.btn9);
        call = findViewById(R.id.btn_cal);
        minus = findViewById(R.id.btn_minus);
        plus = findViewById(R.id.btn_plus);
        multiple = findViewById(R.id.btn_multiple);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!isOperation)
                    sOp1.concat("1");
                else
                    sOp2.concat("1");
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!isOperation)
                    sOp1.concat("2");
                else
                    sOp2.concat("2");
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!isOperation)
                    sOp1.concat("3");
                else
                    sOp2.concat("3");
            }
        });

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!isOperation)
                    sOp1.concat("4");
                else
                    sOp2.concat("4");
            }
        });

        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!isOperation)
                    sOp1.concat("6");
                else
                    sOp2.concat("3");
            }
        });

    }
}
