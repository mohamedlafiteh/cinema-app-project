package com.example.cinemaapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    Button Register;
    Spinner spinnerYear;
    Spinner spinnerMonth;
    EditText email, password, firstName, lastName, confirmPassword, cardNumber;
    SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        Register = findViewById(R.id.button);
        spinnerYear = findViewById(R.id.SpinnerYear);
        spinnerMonth = findViewById(R.id.spinnerMonth);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.Year, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerYear.setAdapter(adapter);
        spinnerYear.setOnItemSelectedListener(this);
        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this, R.array.Month, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerMonth.setAdapter(adapter2);
        spinnerMonth.setOnItemSelectedListener(this);

        email = findViewById(R.id.emailAddress);
        password = findViewById(R.id.PasswordRegistration);
        confirmPassword = findViewById(R.id.PasswordConfirmation);
        firstName = findViewById(R.id.name);
        lastName = findViewById(R.id.LastName);
        cardNumber = findViewById(R.id.CardNumber);

        preferences = getSharedPreferences("userinfo",0);





        Register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String firstnameValue = firstName.getText().toString();
                String lastnameValue = lastName.getText().toString();
                String EmailValue = email.getText().toString();
                String PasswordValue = password.getText().toString();
                String confirmpasswordValue = confirmPassword.getText().toString();
                String cardnumberValue = cardNumber.getText().toString();
                Toast.makeText(RegisterActivity.this, "Registration completed!", Toast.LENGTH_SHORT).show();
                openRegistrationConfirmation();

                if (EmailValue.length()> 1) {
                    SharedPreferences.Editor editor = preferences.edit();
                    editor.putString("email", EmailValue);
                    editor.putString("firstName", firstnameValue);
                    editor.putString("lastName", lastnameValue);
                    editor.putString("password", PasswordValue);
                    editor.putString("confirmPassword", confirmpasswordValue);
                    editor.putString("cardNumber", cardnumberValue);
                    editor.apply();
                    Toast.makeText(RegisterActivity.this, "User Registered!", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(RegisterActivity.this, "Enter values in fields", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }



    public void openRegistrationConfirmation() {
        Intent intent = new Intent(this, RegistrationConfirmed.class);
        startActivity(intent);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String text = parent.getItemAtPosition(position).toString();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}