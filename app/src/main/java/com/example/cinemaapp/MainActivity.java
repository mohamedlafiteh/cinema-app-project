package com.example.cinemaapp;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Spinner cinemaSpinner;

        super.onCreate(savedInstanceState);
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.tootbar_title);

        setContentView(R.layout.activity_main);

    }

    /**
     * Lunch the login page activity .
     */
    public void lunchLoginActivity(View v){
        // lunch the activity
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }

    /**
     * Lunch the account page activity .
     */
    public void lunchAccountActivity(View v){
        // lunch the activity
        Intent intent = new Intent(this, AccountActivity.class);
        startActivity(intent);
    }

//    private void showList(){
//       Spinner s = findViewById(R.id.spinner);
//        spinner = findViewById(R.id.spinner);
//
//        s.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                String cName = spinner.getSelectedItem().toString();
//                Toast.makeText(MainActivity.this,cName,Toast.LENGTH_LONG).show();
//            }
//        });

//
//    }

}