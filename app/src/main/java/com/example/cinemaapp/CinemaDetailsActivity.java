package com.example.cinemaapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class CinemaDetailsActivity extends AppCompatActivity {
    String [] cinemaAddresses= {"G4-Argyle street","G5-Strath street","G6-Clyde street","G10-Home street","G12-Train street","G9-CC street"};
    int[] randomCinemaImages = {R.drawable.cc1,R.drawable.cc2,R.drawable.cc3,R.drawable.cc4,R.drawable.cc5,R.drawable.cc6};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cinema_details);

        TextView c = findViewById(R.id.cin_dets_id);
        Intent in = getIntent();
        String name= in.getStringExtra("name");
        c.setText(name);

        int r1 = new Random().nextInt(cinemaAddresses.length);
        int r2 = new Random().nextInt(randomCinemaImages.length);

        TextView add = findViewById(R.id.textView3);
        ImageView im = findViewById(R.id.imageView5);

        String s =  cinemaAddresses[r1];
        int img=  randomCinemaImages[r2];

        add.setText(s);
        im.setImageResource(img);

    }
}