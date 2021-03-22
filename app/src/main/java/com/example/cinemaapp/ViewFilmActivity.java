package com.example.cinemaapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class ViewFilmActivity extends AppCompatActivity {
    String c;
    String s;
    String f;

    ImageView imageView;
    TextView movieName;
    TextView desMovie;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_film);

        imageView=findViewById(R.id.img2_id);
        movieName=findViewById(R.id.img2_text_id);
        desMovie=findViewById(R.id.textView2);

        //Get the values passed from the results page
        Intent intent =getIntent();
        imageView.setImageResource(intent.getIntExtra("image",0));
        movieName.setText(intent.getStringExtra("name"));
        desMovie.setText(intent.getStringExtra("des"));


        c = intent.getStringExtra("cinemaN");
         s = intent.getStringExtra("dateC");
         f=intent.getStringExtra("name");

    }

    /**
     * Lunch the bookingConfirmation page activity .
     */
    public void lunchBookingConfirmationActivity(View v) {
        // lunch the activity

        try {
            if(c != null && s != null) {
                // pass the values to the BookingConfirmationActivity
                Intent in = new Intent(this, BookingConfirmationActivity.class);
                in.putExtra("cc2",c);
                in.putExtra("ss2",s);
                in.putExtra("ff2",f);
                startActivity(in);
            }else{
                throw new NullPointerException("error here ");
            }
        }catch (NullPointerException e){
            System.out.println("Exception error");
        }

    }

}



