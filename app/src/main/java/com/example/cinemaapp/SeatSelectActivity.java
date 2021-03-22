package com.example.cinemaapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.ls.LSOutput;

public class SeatSelectActivity extends AppCompatActivity {
    //Is seat booked? for each seat
    boolean seatA1Booked;
    boolean seatA2Booked;
    boolean seatB1Booked;
    boolean seatB2Booked;
    boolean seatB3Booked;

    //Image buttons for each seat
    ImageButton seatA1Button;
    ImageButton seatA2Button;
    ImageButton seatB1Button;
    ImageButton seatB2Button;
    ImageButton seatB3Button;

    //Text view to display selected seat
    TextView seatNumberText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seat_select);

        //Initial 'booked' or 'not booked' status for each seat
        seatA1Booked = false;
        seatA2Booked = true;
        seatB1Booked = false;
        seatB2Booked = true;
        seatB3Booked = false;

        //Initialising TextView to display selected seat
        seatNumberText = (TextView) findViewById(R.id.seatNumberText);

        //Initialising ImageButton variables to seat buttons
        seatA1Button = (ImageButton)findViewById(R.id.seatA1Button);
        seatA2Button = (ImageButton)findViewById(R.id.seatA2Button);
        seatB1Button = (ImageButton)findViewById(R.id.seatB1Button);
        seatB2Button = (ImageButton)findViewById(R.id.seatB2Button);
        seatB3Button = (ImageButton)findViewById(R.id.seatB3Button);

        /**
         Runs function which checks each seat's booking status
         and displays correct booked or not booked graphic
         **/
        imageUpdater();

        Button butt = findViewById(R.id.search_button_id4);


        butt.setOnClickListener(new View.OnClickListener() {
            TextView s = findViewById(R.id.textView11);

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),BookingConfirmationActivity.class);
                TextView t=findViewById(R.id.seatNumberText);
                String seatNumber = t.getText().toString();
                if(seatNumber.length()==0) {
                    Toast.makeText(SeatSelectActivity.this,
                            "Please select seat before confirm", Toast.LENGTH_LONG).show();
                } else {
                    intent.putExtra("seat",seatNumberText.getText().toString());
                    setResult(RESULT_OK, intent);
                    finish();
                }
            }
        });

        Button CancelButt = findViewById(R.id.cancel_seatBook_button_id);

        CancelButt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }

    /**
     * Function to check each seats booking status and update graphics accordingly
     */
    public void imageUpdater(){
        if (seatA1Booked){
            seatA1Button.setImageResource(R.drawable.seatnotavailable);
        }
        if (!seatA1Booked){
            seatA1Button.setImageResource(R.drawable.seatavailable);
        }
        if (seatA2Booked){
            seatA2Button.setImageResource(R.drawable.seatnotavailable);
        }
        if (!seatA2Booked){
            seatA2Button.setImageResource(R.drawable.seatavailable);
        }
        if (seatB1Booked){
            seatB1Button.setImageResource(R.drawable.seatnotavailable);
        }
        if (!seatB1Booked){
            seatB1Button.setImageResource(R.drawable.seatavailable);
        }
        if (seatB2Booked){
            seatB2Button.setImageResource(R.drawable.seatnotavailable);
        }
        if (!seatB2Booked){
            seatB2Button.setImageResource(R.drawable.seatavailable);
        }
        if (seatB3Booked){
            seatB3Button.setImageResource(R.drawable.seatnotavailable);
        }
        if (!seatB3Booked){
            seatB3Button.setImageResource(R.drawable.seatavailable);
        }
    }


    public void seatA1(View view){
        //Save text currently in 'selected seat' box (to know if were clicking same button again to deselect it)
        CharSequence c = seatNumberText.getText();

        //If seat is currently booked, pop up error message shows
        if(seatA1Booked){
            Toast.makeText(this, "Seat already booked!", Toast.LENGTH_SHORT).show();
        }

        //If seat is available for booking, 'seatSelected' graphic is used and any other seat selections are cleared
        if(!seatA1Booked){
            seatA1Button.setImageResource(R.drawable.seatselected);
            if(!seatA2Booked){seatA2Button.setImageResource(R.drawable.seatavailable);}
            if(!seatB1Booked){seatB1Button.setImageResource(R.drawable.seatavailable);}
            if(!seatB2Booked){seatB2Button.setImageResource(R.drawable.seatavailable);}
            if(!seatB3Booked){seatB3Button.setImageResource(R.drawable.seatavailable);}
            seatNumberText.setText("A1");
        }

        //If selected seat is clicked again, the 'selected seat' box is cleared and selected graphic cleared
        if(c.equals("A1")){
            seatA1Button.setImageResource(R.drawable.seatavailable);
            seatNumberText.setText("");
        }
    }

    public void seatA2(View view){

        CharSequence c = seatNumberText.getText();
        if(seatA2Booked){
            Toast.makeText(this, "Seat already booked!", Toast.LENGTH_SHORT).show();
        }
        if(!seatA2Booked){
            seatA2Button.setImageResource(R.drawable.seatselected);
            if(!seatA1Booked){seatA1Button.setImageResource(R.drawable.seatavailable);}
            if(!seatB1Booked){seatB1Button.setImageResource(R.drawable.seatavailable);}
            if(!seatB2Booked){seatB2Button.setImageResource(R.drawable.seatavailable);}
            if(!seatB3Booked){seatB3Button.setImageResource(R.drawable.seatavailable);}
            seatNumberText.setText("A2");
        }
        if(c.equals("A2")){
            seatA2Button.setImageResource(R.drawable.seatavailable);
            seatNumberText.setText("");
        }
    }

    public void seatB1(View view){
        CharSequence c = seatNumberText.getText();
        if(seatB1Booked){
            Toast.makeText(this, "Seat already booked!", Toast.LENGTH_SHORT).show();
        }
        if(!seatB1Booked){
            seatB1Button.setImageResource(R.drawable.seatselected);
            if(!seatA1Booked){seatA1Button.setImageResource(R.drawable.seatavailable);}
            if(!seatA2Booked){seatA2Button.setImageResource(R.drawable.seatavailable);}
            if(!seatB2Booked){seatB2Button.setImageResource(R.drawable.seatavailable);}
            if(!seatB3Booked){seatB3Button.setImageResource(R.drawable.seatavailable);}
            seatNumberText.setText("B1");
        }
        if(c.equals("B1")){
            seatB1Button.setImageResource(R.drawable.seatavailable);
            seatNumberText.setText("");
        }
    }

    public void seatB2(View view){
        CharSequence c = seatNumberText.getText();
        if(seatB2Booked){
            Toast.makeText(this, "Seat already booked!", Toast.LENGTH_SHORT).show();
        }
        if(!seatB2Booked){
            seatB2Button.setImageResource(R.drawable.seatselected);
            if(!seatA1Booked){seatA1Button.setImageResource(R.drawable.seatavailable);}
            if(!seatA2Booked){seatA2Button.setImageResource(R.drawable.seatavailable);}
            if(!seatB1Booked){seatB1Button.setImageResource(R.drawable.seatavailable);}
            if(!seatB3Booked){seatB3Button.setImageResource(R.drawable.seatavailable);}
            seatNumberText.setText("B2");
        }
        if(c.equals("B2")){
            seatB2Button.setImageResource(R.drawable.seatavailable);
            seatNumberText.setText("");
        }
    }

    public void seatB3(View view){
        CharSequence c = seatNumberText.getText();
        if(seatB3Booked){
            Toast.makeText(this, "Seat already booked!", Toast.LENGTH_SHORT).show();
        }
        if(!seatB3Booked){
            seatB3Button.setImageResource(R.drawable.seatselected);
            if(!seatA1Booked){seatA1Button.setImageResource(R.drawable.seatavailable);}
            if(!seatA2Booked){seatA2Button.setImageResource(R.drawable.seatavailable);}
            if(!seatB1Booked){seatB1Button.setImageResource(R.drawable.seatavailable);}
            if(!seatB2Booked){seatB2Button.setImageResource(R.drawable.seatavailable);}
            seatNumberText.setText("B3");
        }
        if(c.equals("B3")){
            seatB3Button.setImageResource(R.drawable.seatavailable);
            seatNumberText.setText("");
        }
    }


}