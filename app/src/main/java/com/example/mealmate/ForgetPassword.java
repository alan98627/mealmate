package com.example.mealmate;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ForgetPassword extends AppCompatActivity {

    private EditText editTextEmail;
    private Button buttonSubmit;
    private TextView textViewSignIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget_password);

        // Initialize Views
        editTextEmail = findViewById(R.id.txt_email);
        buttonSubmit = findViewById(R.id.btn_submit);
        textViewSignIn = findViewById(R.id.txt_signin);

        // Set OnClickListener for Submit Button
        buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = editTextEmail.getText().toString();

                if (email.isEmpty()) {
                    // Show error message
                } else {
                    // Handle password reset (e.g., send email for reset link)
                }
            }
        });

        // Navigate back to Login Page
        textViewSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(com.example.mealmate.ForgetPassword.this, LoginPage.class);
                startActivity(intent);
                finish();
            }
        });
    }
}

