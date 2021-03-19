package com.example.cinemaapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class BookingConfirmationActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking_confirmation);
        Intent intent = getIntent();
        try {
            TextView cinemaView = findViewById(R.id.c_t_id);
            TextView dateView = findViewById(R.id.textView5);
            TextView filmView = findViewById(R.id.textView);
            if (intent.getStringExtra("cc2") != null && intent.getStringExtra("ss2") != null && intent.getStringExtra("ff2") != null) {

                filmView.setText(intent.getStringExtra("ff2"));
                cinemaView.setText(intent.getStringExtra("cc2"));
                dateView.setText(intent.getStringExtra("ss2"));
            } else {
                throw new NullPointerException("error here ");
            }
        } catch (NullPointerException e) {
            System.out.println("Exception error");
        }

    }
}