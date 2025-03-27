package com.example.mealmate;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {

    private NavigationView navigationView;
    private FloatingActionButton floatingActionButton;
    private DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        // Initialize all views
        initializeViews();

        // Setup FAB click listener
        floatingActionButton.setOnClickListener(v -> {
            startActivity(new Intent(MainActivity.this, AddRecipe.class));
        });

        // Setup navigation drawer
        setupNavigationDrawer();
    }

    private void initializeViews() {
        // Initialize with null checks
        navigationView = findViewById(R.id.navigation); // Make sure this ID exists in your layout
        floatingActionButton = findViewById(R.id.fab);
        drawerLayout = findViewById(R.id.main);

        if (navigationView == null) {
            Toast.makeText(this, "NavigationView not found!", Toast.LENGTH_SHORT).show();
            finish();
        }
    }

    private void setupNavigationDrawer() {
        navigationView.setNavigationItemSelectedListener(item -> {
            int id = item.getItemId();

            if (id == R.id.home_menu) {
                Toast.makeText(MainActivity.this, "Home", Toast.LENGTH_SHORT).show();
                // Don't restart same activity, just close drawer
                drawerLayout.closeDrawer(GravityCompat.START);
            }
            else if (id == R.id.about_menu) {
                startActivity(new Intent(this, AboutPage.class));
            }
            else if (id == R.id.week_menu) {
                startActivity(new Intent(this, Weeks.class));
            }
            else if (id == R.id.recipe_menu) {
                startActivity(new Intent(this, AddRecipe.class));
            }

            drawerLayout.closeDrawer(GravityCompat.START);
            return true;
        });

        findViewById(R.id.imagemenu).setOnClickListener(v -> {
            drawerLayout.openDrawer(GravityCompat.START);
        });
    }
}