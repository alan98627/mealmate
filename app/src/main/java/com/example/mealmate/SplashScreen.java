package com.example.mealmate;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.imageview.ShapeableImageView;

@SuppressLint("CustomSplashScreen")
public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_splash_screen);

        ShapeableImageView imageView = findViewById(R.id.splaceImage);
        TextView textView = findViewById(R.id.splaceText);

        // Load animation
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.animation);
        imageView.startAnimation(animation);
        textView.startAnimation(animation);

        // Use Handler instead of Thread for smoother execution
        new Handler().postDelayed(() -> {
            Intent intent = new Intent(SplashScreen.this, LoginPage.class);
            startActivity(intent);
            finish(); // Finish splash activity so it doesn’t stay in the back stack
        }, 3000); // 3 seconds delay
    }
}
