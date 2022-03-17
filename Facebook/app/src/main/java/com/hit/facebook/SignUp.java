package com.hit.facebook;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

public class SignUp extends AppCompatActivity {
    EditText lastName, name, username, pass, confirmPass, day, month, year;
    Button signUp;
    CheckBox check;
    TextView backLogin;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_up);
        getId();

        backLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SignUp.this, MainActivity.class);
                startActivity(intent);
            }
        });

        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(pass.getText().toString().equals(confirmPass.getText().toString())) {
                    Intent intent = new Intent(SignUp.this, HomePage.class);
                    User user = new User(username.getText().toString(), pass.getText().toString());
                    intent.putExtra("User", (Parcelable) user);
                    intent.putExtra("name", name.getText().toString());
                    intent.putExtra("lastName", lastName.getText().toString());
                    intent.putExtra("day", day.getText().toString());
                    intent.putExtra("month", month.getText().toString());
                    intent.putExtra("year", year.getText().toString());
                    startActivity(intent);
                } else {
                    confirmPass.setText(null);
                    confirmPass.setHint("Mật khẩu không khớp");
                }
        }
        });
    }

    private void getId() {
        lastName = findViewById(R.id.lastName);
        name = findViewById(R.id.name);
        username = findViewById(R.id.user);
        pass = findViewById(R.id.pass);
        confirmPass = findViewById(R.id.confirmPass);
        day = findViewById(R.id.day);
        month = findViewById(R.id.month);
        year = findViewById(R.id.year);
        signUp = findViewById(R.id.signUp);
        check = findViewById(R.id.check);
        backLogin = findViewById(R.id.backLogin);
    }
}