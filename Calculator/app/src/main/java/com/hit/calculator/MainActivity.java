package com.hit.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;


public class MainActivity extends AppCompatActivity {
    TextView enterScreen, screen;
    Button bt1, bt2, bt3, bt4, bt5, bt6, bt7, bt8, bt9, bt0;
    Button btPlus, btMultiplied, btIsEqualTo, c, dot;
    ImageButton delete, btMinus, btDividedBy, am, binhphuong, canBac2, oneChiaX;
    private String number;
    private double val1 = Double.NaN, val2 = Double.NaN;
    private char enforcement;
    private final char PLUS = '+';
    private final char MINUS = '-';
    private final char MUL = '*';
    private final char DIV = '/';
    private final char EQUAL = '0';

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        defineId();
        DecimalFormatSymbols decimalFormatSymbols = new DecimalFormatSymbols();
        decimalFormatSymbols.setDecimalSeparator('.');
        decimalFormatSymbols.setGroupingSeparator(',');
        DecimalFormat formatter = new DecimalFormat("###,###,###.############", decimalFormatSymbols);
        DecimalFormat formatterInt = new DecimalFormat("###.############", decimalFormatSymbols);

        // (kết quả) =
        btIsEqualTo.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View view) {
                calculate();
                enforcement = EQUAL;
                if (Double.isNaN(val2)) {
                    enterScreen.setText(val1 + " =");
                } else if (enterScreen.getText().toString().contains("(")) {
                    enterScreen.setText(enterScreen.getText().toString() + " =");
                } else {
                    enterScreen.setText(enterScreen.getText().toString() + " " + formatterInt.format(val2) + " =");
                }
                screen.setText(formatter.format(val1));
            }
        });

        // cộng
        btPlus.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View view) {
                calculate();
                enforcement = PLUS;
                phepTinh("+");
            }
        });
        // trừ
        btMinus.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View view) {
                calculate();
                enforcement = MINUS;
                phepTinh("-");
            }
        });
        // Nhân
        btMultiplied.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View view) {
                calculate();
                enforcement = MUL;
                phepTinh("x");
            }
        });
        // chia
        btDividedBy.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View view) {
                calculate();
                enforcement = DIV;
                phepTinh("/");
            }
        });

        // Xóa 1 số
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CharSequence enterNumber = screen.getText().toString();
                screen.setText(enterNumber.subSequence(0, enterNumber.length()-1));
                if (screen.getText().length() == 0) {
                    screen.setText("0");
                }
            }
        });
        // clear
        c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                enterScreen.setText("");
                screen.setText("0");
                val1 = Double.NaN;
                val2 = Double.NaN;
            }
        });

        bt1.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View view) {
                setScreen();
                number = screen.getText().toString();
                screen.setText(number + "1");
            }
        });
        bt2.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View view) {
                setScreen();
                number = screen.getText().toString();
                screen.setText(number + "2");
            }
        });
        bt3.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View view) {
                setScreen();
                number = screen.getText().toString();
                screen.setText(number + "3");
            }
        });
        bt4.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View view) {
                setScreen();
                number = screen.getText().toString();
                screen.setText(number + "4");
            }
        });
        bt5.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View view) {
                setScreen();
                number = screen.getText().toString();
                screen.setText(number + "5");
            }
        });
        bt6.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View view) {
                setScreen();
                number = screen.getText().toString();
                screen.setText(number + "6");
            }
        });
        bt7.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View view) {
                setScreen();
                number = screen.getText().toString();
                screen.setText(number + "7");
            }
        });
        bt8.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View view) {
                setScreen();
                number = screen.getText().toString();
                screen.setText(number + "8");
            }
        });
        bt9.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View view) {
                setScreen();
                number = screen.getText().toString();
                screen.setText(number + "9");
            }
        });
        bt0.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View view) {
                setScreen();
                number = screen.getText().toString();
                screen.setText(number + "0");
            }
        });
        dot.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View view) {
                if(!screen.getText().toString().contains(".")) {
                    number = screen.getText().toString();
                    screen.setText(number + ".");
                }
            }
        });
        am.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View view) {
                if(!screen.getText().toString().contains("-")) {
                    screen.setText("-" + screen.getText().toString());
                }
            }
        });
        binhphuong.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View view) {
                double val = Double.parseDouble(screen.getText().toString());
                 if(Double.isNaN(val1)) {
                    val1 = Double.parseDouble(screen.getText().toString()) * Double.parseDouble(screen.getText().toString());
                    screen.setText(formatter.format(val1));
                    enterScreen.setText("sqr("+formatter.format(val)+")");
                } else {
                    val2 = Double.parseDouble(screen.getText().toString()) * Double.parseDouble(screen.getText().toString());
                    screen.setText(formatter.format(val2));
                    enterScreen.setText(enterScreen.getText().toString() + " sqr("+formatter.format(val)+")");
                }
            }
        });
        canBac2.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View view) {
                double val = Double.parseDouble(screen.getText().toString());
                if(Double.isNaN(val1)) {
                    val1 = Math.sqrt(Double.parseDouble(screen.getText().toString()));
                    screen.setText(formatter.format(val1));
                    enterScreen.setText("sqrt("+formatter.format(val)+")");
                } else {
                    val2 = Math.sqrt(Double.parseDouble(screen.getText().toString()));
                    screen.setText(formatter.format(val2));
                    enterScreen.setText(enterScreen.getText().toString() + " sqrt("+formatter.format(val)+")");
                }
            }
        });
        oneChiaX.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View view) {
                double val = Double.parseDouble(screen.getText().toString());
                if(Double.isNaN(val1)) {
                    val1 = 1 / (Double.parseDouble(screen.getText().toString()));
                    screen.setText(formatter.format(val1));
                    enterScreen.setText("1/("+formatter.format(val)+")");
                } else {
                    val2 = 1 / (Double.parseDouble(screen.getText().toString()));
                    screen.setText(formatter.format(val2));
                    enterScreen.setText(enterScreen.getText().toString() + " 1/("+formatter.format(val)+")");
                }
            }
        });
    }

    private void setScreen() {
        String str = enterScreen.getText().toString();
        if(enterScreen.length() > 0 && str.charAt(str.length() - 1) == '=') {
            enterScreen.setText("");
            screen.setText("0");
            val1 = Double.NaN;
            val2 = Double.NaN;
        }
        if(screen.getText().equals("0")) {
            screen.setText(null);
        }
    }

    @SuppressLint("SetTextI18n")
    private void phepTinh(String str) {
        DecimalFormatSymbols decimalFormatSymbols = new DecimalFormatSymbols();
        decimalFormatSymbols.setDecimalSeparator('.');
        decimalFormatSymbols.setGroupingSeparator(',');
        DecimalFormat formatterInt = new DecimalFormat("###.############", decimalFormatSymbols);
        if(screen.getText().toString().equals("0")) {
            enterScreen.setText("0 "+ str);
            screen.setText("0");
        } else {
            enterScreen.setText(formatterInt.format(val1) + " " + str);
            screen.setText(null);
        }
    }

    private void calculate() {
        if(!Double.isNaN(val1)) {
            val2 = Double.parseDouble(screen.getText().toString());
            switch (enforcement){
                case PLUS:
                    val1 = val1 + val2;
                    break;
                case MINUS:
                    val1 = val1 - val2;
                    break;
                case MUL:
                    val1 = val1 * val2;
                    break;
                case DIV:
                    val1 = val1 / val2;
                    break;
                case EQUAL:
                    break;
            }
        } else {
            val1 = Double.parseDouble(screen.getText().toString());
        }
    }

    private void defineId() {
        enterScreen = findViewById(R.id.enterScreen);
        screen = findViewById(R.id.screen);
        bt1 = findViewById(R.id.bt1);
        bt2 = findViewById(R.id.bt2);
        bt3 = findViewById(R.id.bt3);
        bt4 = findViewById(R.id.bt4);
        bt5 = findViewById(R.id.bt5);
        bt6 = findViewById(R.id.bt6);
        bt7 = findViewById(R.id.bt7);
        bt8 = findViewById(R.id.bt8);
        bt9 = findViewById(R.id.bt9);
        bt0 = findViewById(R.id.bt0);
        btPlus = findViewById(R.id.btPlus);
        btMinus = findViewById(R.id.btMinus);
        btDividedBy = findViewById(R.id.btDividedBy);
        btMultiplied = findViewById(R.id.btMultiplied);
        btIsEqualTo = findViewById(R.id.btIsEqualTo);
        delete = findViewById(R.id.delete);
        c = findViewById(R.id.c);
        dot = findViewById(R.id.dot);
        am = findViewById(R.id.am);
        binhphuong = findViewById(R.id.binhphuong);
        canBac2 = findViewById(R.id.canBac2);
        oneChiaX = findViewById(R.id.oneChiaX);
    }
}