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
        try {
            EdgeToEdge.enable(this);
            setContentView(R.layout.activity_splash_screen);

            ShapeableImageView imageView = findViewById(R.id.splaceImage);
            TextView textView = findViewById(R.id.splaceText);

            Animation animation = AnimationUtils.loadAnimation(this, R.anim.animation);
            if (animation != null) {
                imageView.startAnimation(animation);
                textView.startAnimation(animation);
            }

            new Handler().postDelayed(() -> {
                try {
                    Intent intent = new Intent(SplashScreen.this, LoginPage.class);
                    startActivity(intent);
                    finish();
                } catch (Exception e) {
                    e.printStackTrace();
                    // Fallback to MainActivity if LoginPage fails
                    startActivity(new Intent(SplashScreen.this, MainActivity.class));
                    finish();
                }
            }, 3000);
        } catch (Exception e) {
            e.printStackTrace();
            // Emergency fallback
            startActivity(new Intent(this, MainActivity.class));
            finish();
        }
    }
}