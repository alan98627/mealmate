package com.example.mealmate;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;

public class LoginPage extends AppCompatActivity {

    private EditText editTextEmail, editTextPassword;
    private Button buttonLogin;
    private TextView buttonSignUp, buttonForgetPassword;
    FirebaseAuth mAuth;
    FirebaseFirestore db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login_page);

        // Initialize Views
        editTextEmail = findViewById(R.id.editTextEmail);
        editTextPassword = findViewById(R.id.editTextPassword);
        buttonLogin = findViewById(R.id.buttonLogin);
        buttonSignUp = findViewById(R.id.buttonSignUp);
        buttonForgetPassword = findViewById(R.id.buttonForgetPassword);

        // Initialize FirebaseAuth and Firebase
        mAuth = FirebaseAuth.getInstance();
        db = FirebaseFirestore.getInstance();

        buttonForgetPassword.setOnClickListener(this::startPasswordRecoveryProcess);
        buttonSignUp.setOnClickListener(this::startSignUpActivity);
        buttonLogin.setOnClickListener(this::login);
        // todo: change this to login
    }

    private void byPass(View view) {
        startActivity( new Intent(getApplicationContext(), MainActivity.class));
    }

        private void login(View view) {
            String email = editTextEmail.getText().toString().trim();
            String password = editTextPassword.getText().toString().trim();
            if (email.isEmpty()) {
                Toast.makeText(LoginPage.this, "Enter Email", Toast.LENGTH_SHORT).show();
                editTextEmail.requestFocus();
                return;
            }
            if (password.isEmpty()) {
                Toast.makeText(LoginPage.this, "Enter Password", Toast.LENGTH_SHORT).show();
                editTextPassword.requestFocus();
                return;
            }

            mAuth.signInWithEmailAndPassword(email, password)
                    .addOnCompleteListener(task -> {
                        if (task.isSuccessful()) {
                            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                            startActivity(intent);
                            Toast.makeText(LoginPage.this, "Login Successful", Toast.LENGTH_SHORT).show();
                            finish();
                        } else {
                            Toast.makeText(LoginPage.this, "Login Failed", Toast.LENGTH_SHORT).show();
                        }
                    });

        }

        private void startPasswordRecoveryProcess(View view) {
            Intent intent = new Intent(getApplicationContext(), ForgetPassword.class);
            startActivity(intent);
        }

        private void startSignUpActivity(View view) {
            Intent intent = new Intent(getApplicationContext(), SignupPage.class);
            startActivity(intent);
        }
    }