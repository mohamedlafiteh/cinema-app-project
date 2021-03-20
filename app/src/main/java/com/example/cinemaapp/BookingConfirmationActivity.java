package com.example.cinemaapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class BookingConfirmationActivity extends AppCompatActivity {

    String selectSeatPassed;

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

        Button butt = findViewById(R.id.cancel_button_id);

        butt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }

    public void lunchSeatSelectActivity(View v) {
        // lunch the activity
        Intent i= new Intent(this, SeatSelectActivity.class);
        startActivityForResult(i, 1);
    }



    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1) {
            if(resultCode == RESULT_OK) {
                String strEditText = data.getStringExtra("seat");
                TextView t=findViewById(R.id.textView11);
                t.setText(strEditText);
            }
        }
    }

    public void lunchConfirmShowActivity(View v) {
        // lunch the activity
        Intent i= new Intent(this, ConfirmedShowActivity.class);
        startActivityForResult(i, 1);
    }
}