package com.example.cinemaapp;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);

        getSupportActionBar().setCustomView(R.layout.tootbar_title);

        setContentView(R.layout.activity_main);

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