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

import java.lang.reflect.Array;
import java.text.DateFormatSymbols;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    Spinner cinemaSpinner, dateSpinner, filmSpinner;
    Button searchButton;
   // String[] months;
    ArrayList<String> selectedData = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.tootbar_title);
        setContentView(R.layout.activity_main);

        cinemaSpinner = findViewById(R.id.spinner_id);
        dateSpinner = findViewById(R.id.date_spinner_id);
        filmSpinner = findViewById(R.id.film_spinner_id);
        searchButton = findViewById(R.id.search_button_id);

        populateCinema();
        populateDate();
        populateFilm();


        cinemaSpinner.setOnItemSelectedListener(this);
        dateSpinner.setOnItemSelectedListener(this);
        filmSpinner.setOnItemSelectedListener(this);

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        if (parent.getId() == R.id.spinner_id) {
            String c = parent.getSelectedItem().toString();
            selectedData.add(c);
           // Toast.makeText(MainActivity.this, c, Toast.LENGTH_SHORT).show();
        }else if(parent.getId() == R.id.date_spinner_id) {
            String d = parent.getSelectedItem().toString();
            selectedData.add(d);
           // Toast.makeText(MainActivity.this, d, Toast.LENGTH_SHORT).show();
        }else if(parent.getId() == R.id.film_spinner_id) {
            String f = parent.getSelectedItem().toString();
            selectedData.add(f);
         //   Toast.makeText(MainActivity.this, f, Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    public void lunchSearchResultActivity(View v) {
        // lunch the activity
        Intent intent = new Intent(this, SearchResultsActivity.class);
        intent.putExtra("results", selectedData);
        startActivity(intent);
    }

    private void populateCinema() {
        ArrayAdapter<String> cinemaAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, getResources().getStringArray(R.array.cinemaList));
        cinemaAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        cinemaSpinner.setAdapter(cinemaAdapter);
    }

    private void populateDate() {
      //  months = new DateFormatSymbols().getMonths();
        ArrayAdapter<String> dateAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, getResources().getStringArray(R.array.dateSpinnerList));
        dateAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        dateSpinner.setAdapter(dateAdapter);

    }

    private void populateFilm() {
        ArrayAdapter<String> filmAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, getResources().getStringArray(R.array.filmsSpinnerList));
        filmAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        filmSpinner.setAdapter(filmAdapter);
    }


    /**
     * Lunch the login page activity .
     */
    public void lunchLoginActivity(View v) {
        // lunch the activity
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }

    /**
     * Lunch the account page activity .
     */
    public void lunchAccountActivity(View v) {
        // lunch the activity
        Intent intent = new Intent(this, AccountActivity.class);
        startActivity(intent);
    }


}