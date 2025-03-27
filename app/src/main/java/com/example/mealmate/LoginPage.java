package com.example.mealmate;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.FirebaseAuthInvalidUserException;
import com.google.firebase.firestore.FirebaseFirestore;

public class LoginPage extends AppCompatActivity {

    private EditText editTextEmail, editTextPassword;
    private Button buttonLogin;
    private TextView buttonSignUp, buttonForgetPassword;
    private FirebaseAuth mAuth;
    private FirebaseFirestore db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);

        // Initialize Views with null checks
        try {
            editTextEmail = findViewById(R.id.editTextEmail);
            editTextPassword = findViewById(R.id.editTextPassword);
            buttonLogin = findViewById(R.id.buttonLogin);
            buttonSignUp = findViewById(R.id.buttonSignUp);
            buttonForgetPassword = findViewById(R.id.buttonForgetPassword);

            // Initialize Firebase
            mAuth = FirebaseAuth.getInstance();
            db = FirebaseFirestore.getInstance();

            // Set click listeners
            buttonForgetPassword.setOnClickListener(this::startPasswordRecoveryProcess);
            buttonSignUp.setOnClickListener(this::startSignUpActivity);
            buttonLogin.setOnClickListener(this::login);

        } catch (Exception e) {
            Toast.makeText(this, "Initialization error", Toast.LENGTH_SHORT).show();
            e.printStackTrace();
            // Fallback to splash screen if initialization fails
            finish();
        }
    }

    private void login(View view) {
        String email = editTextEmail.getText().toString().trim();
        String password = editTextPassword.getText().toString().trim();

        if (email.isEmpty()) {
            editTextEmail.setError("Email is required");
            editTextEmail.requestFocus();
            return;
        }

        if (password.isEmpty()) {
            editTextPassword.setError("Password is required");
            editTextPassword.requestFocus();
            return;
        }

        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(task -> {
                    if (task.isSuccessful()) {
                        startActivity(new Intent(LoginPage.this, MainActivity.class));
                        finish();
                    } else {
                        handleLoginError(task.getException());
                    }
                });
    }

    private void handleLoginError(Exception exception) {
        try {
            throw exception;
        } catch (FirebaseAuthInvalidUserException e) {
            editTextEmail.setError("No user found with this email");
            editTextEmail.requestFocus();
        } catch (FirebaseAuthInvalidCredentialsException e) {
            editTextPassword.setError("Invalid password");
            editTextPassword.requestFocus();
        } catch (Exception e) {
            Toast.makeText(LoginPage.this, "Authentication failed: " + e.getMessage(),
                    Toast.LENGTH_SHORT).show();
        }
    }

    private void startPasswordRecoveryProcess(View view) {
        startActivity(new Intent(this, ForgetPassword.class));
    }

    private void startSignUpActivity(View view) {
        startActivity(new Intent(this, SignupPage.class));
    }
}