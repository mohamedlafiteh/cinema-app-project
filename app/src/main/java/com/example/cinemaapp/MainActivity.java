package com.example.cinemaapp;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import java.text.DateFormatSymbols;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

   Spinner cinemaSpinner,dateSpinner,filmSpinner;
   Button searchButton;
   String[] months;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.tootbar_title);
        setContentView(R.layout.activity_main);

        cinemaSpinner=findViewById(R.id.spinner_id);
        dateSpinner=findViewById(R.id.date_spinner_id);
        filmSpinner=findViewById(R.id.film_spinner_id);
        searchButton=findViewById(R.id.search_button_id);

        populateCinema();
        populateDate();
        populateFilm();

        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String months= dateSpinner.getSelectedItem().toString();
                String cinema= cinemaSpinner.getSelectedItem().toString();
                String film= filmSpinner.getSelectedItem().toString();

                Toast.makeText(MainActivity.this,months + ", " + cinema + "," + film, Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void populateCinema() {
        ArrayAdapter<String> cinemaAdapter = new ArrayAdapter<>(this,android.R.layout.simple_spinner_item,getResources().getStringArray(R.array.cinemaList));
        cinemaAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        cinemaSpinner.setAdapter(cinemaAdapter);
    }

    private void  populateDate() {
        months=new DateFormatSymbols().getMonths();
        ArrayAdapter<String>monthsAdapter = new ArrayAdapter<>(this,android.R.layout.simple_spinner_item,months);
        monthsAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        dateSpinner.setAdapter(monthsAdapter);

    }

    private void populateFilm() {
        ArrayAdapter<String> filmAdapter = new ArrayAdapter<>(this,android.R.layout.simple_spinner_item,getResources().getStringArray(R.array.filmsSpinnerList));
        filmAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        filmSpinner.setAdapter(filmAdapter);
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

}