package com.hit.buoi4fragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements FragmentA.SendData {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.add(R.id.fragA, new FragmentA());
        transaction.add(R.id.fragB, new FragmentB());
        transaction.commit();
    }
    @SuppressLint("SetTextI18n")
    @Override
    public void onSendData(User user) {
        FragmentB fragmentB = (FragmentB) getSupportFragmentManager().findFragmentById(R.id.fragB);
        if (fragmentB != null) {
            fragmentB.getUsername.setText("Username: " + user.getUsername());
            fragmentB.getPass.setText("Password: " + user.getPassword());
        } else {
            Toast.makeText(MainActivity.this, "Error", Toast.LENGTH_SHORT).show();
        }
    }
}