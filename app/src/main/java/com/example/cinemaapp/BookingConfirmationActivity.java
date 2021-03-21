package com.example.cinemaapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class BookingConfirmationActivity extends AppCompatActivity {

    String selectSeatPassed;

    TextView answer;
    TextView tickTotal;
    TextView tickP;


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


        // Views
        answer = (TextView) findViewById(R.id.textView10);
        tickP = (TextView) findViewById(R.id.textView123);
        tickTotal = (TextView) findViewById(R.id.textView4);






        Spinner spinner_convert_from = (Spinner) findViewById(R.id.spinner_ticket_id);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.tickets, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_convert_from.setAdapter(adapter);

        // Add item selected listener
        spinner_convert_from.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View v, int pos,
                                       long id) {

                if (pos == 0) {
                 //  String s1= parent.getSelectedItem().toString();
                    tickTotal.setText("£" + String.valueOf(Double.valueOf(14.5)*1));
                    tickP.setText(parent.getSelectedItem().toString());
                } else if (pos == 1) {
                    tickTotal.setText("£" + String.valueOf(Double.valueOf(14.5)*2));
                    tickP.setText(parent.getSelectedItem().toString());

                } else if (pos == 2) {
                    tickTotal.setText("£" + String.valueOf(Double.valueOf(14.5)*3));
                    tickP.setText(parent.getSelectedItem().toString());

                } else if (pos == 3) {
                    tickTotal.setText("£" + String.valueOf(Double.valueOf(14.5)*4));
                    tickP.setText(parent.getSelectedItem().toString());

                } else if (pos == 4) {
                    tickTotal.setText("£" + String.valueOf(Double.valueOf(14.5)*5));
                    tickP.setText(parent.getSelectedItem().toString());

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

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
    /**
     * Lunch the account page activity .
     */
    public void lunchAccounttActivity(View v) {
        // lunch the activity
        Intent intent = new Intent(this, AccountActivity.class);
        startActivity(intent);
    }
    /**
     * Lunch the login page activity .
     */
    public void lunchLoginnActivity(View v) {
        // lunch the activity
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }

    public void lunchMainActivity(View v) {
        // lunch the activity
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }


}