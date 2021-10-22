package com.example.calculatorapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText edt_view;
    String op="-";
    boolean isClicked=true;
    String oldNumber;
    double result=0.0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edt_view=findViewById(R.id.editText);
    }

    public void NumberEvent(View view) {
        if(isClicked){
            edt_view.setText("");
        }
        isClicked=false;

        String number=edt_view.getText().toString();
        switch(view.getId()){
            case R.id.btn9:
                number+="9";
                break;
            case R.id.btn8:
                number+="8";
                break;
            case R.id.btn7:
                number+="7";
                break;
            case R.id.btn6:
                number+="6";
                break;
            case R.id.btn5:
                number+="5";
                break;
            case R.id.btn4:
                number+="4";
                break;
            case R.id.btn3:
                number+="3";
                break;
            case R.id.btn2:
                number+="2";
                break;
            case R.id.btn1:
                number+="1";
                break;
            case R.id.btn0:
                number+="0";
                break;
            case R.id.btnpoint:
                number+=".";
                break;
            case R.id.btnNegative:
                number="-"+number;
                break;
        }
        edt_view.setText(number);
    }


    public void opEvent(View view) {

        oldNumber=edt_view.getText().toString();
        switch(view.getId()){
            case R.id.btnMinus:
                op="-";
                break;
            case R.id.btnplus:
                op="+";
                break;
            case R.id.btnMultiply:
                op="*";
                break;
            case R.id.btnModulus:
                op="%";
                break;
            case R.id.btnDivide:
                op="/";
                break;
        }
        isClicked=true;

    }

    public void equalsEvent(View view) {
        isClicked=true;
        String newNumber=edt_view.getText().toString();
        switch (op){
            case "+":
                result=Double.parseDouble(oldNumber)+Double.parseDouble(newNumber);
                break;
            case "-":
                result=Double.parseDouble(oldNumber)-Double.parseDouble(newNumber);
                break;
            case "%":
                result=Double.parseDouble(oldNumber)%Double.parseDouble(newNumber);
                break;
            case "*":
                result=Double.parseDouble(oldNumber)*Double.parseDouble(newNumber);
                break;
            case "/":
                result=Double.parseDouble(oldNumber)/Double.parseDouble(newNumber);
                break;
        }
        edt_view.setText(result+"");


    }

    public void Clear(View view) {
        edt_view.setText("0");

    }

    public void ansEvent(View view) {
        edt_view.setText(result+"");
    }
}