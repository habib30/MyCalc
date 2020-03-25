package com.android.mycalc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private boolean isOpPressed = false;

    private double firstNumber = 0;

    private int secondNumberIndex = 0;

    private char currentOp;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final TextView CalculatorScreen = findViewById(R.id.calculatorScreen_id);
        final Button n0 = (Button) findViewById(R.id.n0);
        final Button n1 = (Button) findViewById(R.id.n1);
        final Button n2 = (Button) findViewById(R.id.n2);
        final Button n3 = (Button) findViewById(R.id.n3);
        final Button n4 = (Button) findViewById(R.id.n4);
        final Button n5 = (Button) findViewById(R.id.n5);
        final Button n6 = (Button) findViewById(R.id.n6);
        final Button n7 = (Button) findViewById(R.id.n7);
        final Button n8 = (Button) findViewById(R.id.n8);
        final Button n9 = (Button) findViewById(R.id.n9);
        final Button dot = (Button) findViewById(R.id.dot);
        final Button equals = (Button) findViewById(R.id.equals);
        final Button addition = (Button) findViewById(R.id.addition);
        final Button subtraction = (Button) findViewById(R.id.subtraction);
        final Button multiplication = (Button) findViewById(R.id.multiplication);
        final Button division = (Button) findViewById(R.id.division);



        final View.OnClickListener calculatorListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final int id = v.getId();
                switch (id){
                    case R.id.n0:
                        CalculatorScreen.append("0");
                        break;
                    case R.id.n1:
                        CalculatorScreen.append("1");
                        break;

                    case R.id.n2:
                        CalculatorScreen.append("2");
                        break;

                    case R.id.n3:
                        CalculatorScreen.append("3");
                        break;

                    case R.id.n4:
                        CalculatorScreen.append("4");
                        break;

                    case R.id.n5:
                        CalculatorScreen.append("5");
                        break;

                    case R.id.n6:
                        CalculatorScreen.append("6");
                        break;

                    case R.id.n7:
                        CalculatorScreen.append("7");
                        break;

                    case R.id.n8:
                        CalculatorScreen.append("8");
                        break;

                    case R.id.n9:
                        CalculatorScreen.append("9");
                        break;

                    case R.id.dot:
                        CalculatorScreen.append(".");
                        break;

                    case R.id.equals:
                        if (isOpPressed){
                            if (currentOp == '+');{
                                String screenContent = CalculatorScreen.getText().toString();
                                String secondNumberString = screenContent.substring(secondNumberIndex,screenContent.length());
                                double secondNumber = Double.parseDouble(secondNumberString);
                                secondNumber += firstNumber;
                                CalculatorScreen.setText(String.valueOf(secondNumber));
                            }
                        }
                        break;

                    case R.id.addition:
                        CalculatorScreen.append("+");
                        isOpPressed = true;
                        String screenContent = CalculatorScreen.getText().toString();
                        firstNumber = Double.parseDouble(screenContent);
                        secondNumberIndex = screenContent.length() + 1;
                        currentOp = '+';
                        break;

                    case R.id.subtraction:
                        CalculatorScreen.append("-");
                        break;

                    case R.id.multiplication:
                        CalculatorScreen.append("*");
                        break;

                    case R.id.division:
                        CalculatorScreen.append("/");
                        break;
                }
            }
        };
        n0.setOnClickListener(calculatorListener);
        n1.setOnClickListener(calculatorListener);
        n2.setOnClickListener(calculatorListener);
        n3.setOnClickListener(calculatorListener);
        n4.setOnClickListener(calculatorListener);
        n5.setOnClickListener(calculatorListener);
        n6.setOnClickListener(calculatorListener);
        n7.setOnClickListener(calculatorListener);
        n8.setOnClickListener(calculatorListener);
        n9.setOnClickListener(calculatorListener);
        dot.setOnClickListener(calculatorListener);
        equals.setOnClickListener(calculatorListener);
        addition.setOnClickListener(calculatorListener);
        subtraction.setOnClickListener(calculatorListener);
        multiplication.setOnClickListener(calculatorListener);
        division.setOnClickListener(calculatorListener);

        final Button delete = findViewById(R.id.del);
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String displayedElements = CalculatorScreen.getText().toString();
                int length = displayedElements.length();
                if(length > 0){
                    displayedElements = displayedElements.substring(0,length-1);
                    CalculatorScreen.setText(displayedElements);
                }
            }
        });

        final Button clearEverything = findViewById(R.id.clear);
        clearEverything.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CalculatorScreen.setText("");
            }
        });
    }
}
