package com.example.cinemaapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class SearchResultsActivity extends AppCompatActivity {

    GridView gridView;
    String [] movies = {"Light","Moon","Castle","Snow","Ghost","Sky"};
    int[] images = {R.drawable.p1,R.drawable.p2,R.drawable.p3,R.drawable.p4,R.drawable.p5,R.drawable.p6};
    ArrayList<String> resultList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_results);
        Intent in = getIntent();

        resultList = in.getStringArrayListExtra("results");
        for (int i =0 ; i < resultList.size();i++){
            resultList.remove("Please select");
        }


         if(resultList.size()==3) {
             TextView cinemaView = findViewById(R.id.cin_type_id);
             TextView dateView = findViewById(R.id.search_date_id);

             for (int i =0 ; i < resultList.size();i++){
                   if(resultList.get(i).startsWith("Cin")) {
                       cinemaView.setText(resultList.get(i));
                   }else if(resultList.get(i).startsWith("2021")){
                       dateView.setText(resultList.get(i));
                   }
             }

         }

         gridView = findViewById(R.id.grid_id_1);

        CustomAdepter customAdepter = new CustomAdepter(SearchResultsActivity.this,
                movies,
                images);

        gridView.setAdapter(customAdepter);

         gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
             @Override
             public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                 Intent intent = new Intent(getApplicationContext(),ViewFilmActivity.class);

                 intent.putExtra("image",images[position]);
                 intent.putExtra("name",movies[position]);
                 startActivity(intent);

             }
         });

    }

    /**
     * Lunch the cinema details page activity .
     */
    public void lunchCinemaDetailsActivity(View v) {
        String s = "";
        Intent intent = new Intent(this, CinemaDetailsActivity.class);
        for (int i =0 ; i < resultList.size();i++){
            if(resultList.get(i).startsWith("Cin")) {
                s = resultList.get(i);
            }
        }
        intent.putExtra("name",s);
        startActivity(intent);

    }


}
