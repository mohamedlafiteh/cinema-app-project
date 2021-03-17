package com.example.cinemaapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class ViewFilmActivity extends AppCompatActivity {

    ImageView imageView;
    TextView movieName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_film);

        imageView=findViewById(R.id.img2_id);
        movieName=findViewById(R.id.img2_text_id);

        Intent intent =getIntent();
        imageView.setImageResource(intent.getIntExtra("image",0));
        movieName.setText(intent.getStringExtra("name"));

    }

    /**
     * Lunch the bookingConfirmation page activity .
     */
    public void lunchBookingConfirmationActivity(View v) {
        // lunch the activity
        Intent intent = new Intent(this, BookingConfirmationActivity.class);
        startActivity(intent);
    }

}