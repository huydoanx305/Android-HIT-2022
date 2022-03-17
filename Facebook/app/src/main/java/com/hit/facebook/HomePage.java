package com.hit.facebook;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class HomePage extends AppCompatActivity {
    TextView getUser, getPass, getName, getDate;
    Button logOut;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_page);
        getId();
        Intent intent = getIntent();
        User user = intent.getParcelableExtra("User");
        getUser.setText("Tên đăng nhập: " + user.getUsername());
        getPass.setText("Mật khẩu: " + user.getPassword());

        String name = intent.getStringExtra("name");
        String lastName = intent.getStringExtra("lastName");
        String day = intent.getStringExtra("day");
        String month = intent.getStringExtra("month");
        String year = intent.getStringExtra("year");
        if(name != null && lastName != null && day != null && month != null && year != null) {
            getName.setText("Họ tên: " + (lastName + " " + name));
            getDate.setText("Ngày sinh: " + (day + "-" + month + "-" + year));
        }

        logOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomePage.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }

    private void getId() {
        logOut = findViewById(R.id.logOut);
        getUser = findViewById(R.id.getUser);
        getPass = findViewById(R.id.getPass);
        getName = findViewById(R.id.getName);
        getDate = findViewById(R.id.getDate);
    }
}