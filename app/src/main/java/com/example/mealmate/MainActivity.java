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

    NavigationView navigationView;
    FloatingActionButton floatingActionButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);



//        Click To Floating Button
        floatingActionButton=findViewById(R.id.fab);

        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent recipeIntent=new Intent(getApplicationContext(),AddRecipe.class);
                startActivity(recipeIntent);
            }
        });

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();

                if (id == R.id.home_menu) {
                    Toast.makeText(MainActivity.this, "Click To Home Items ", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(getApplicationContext(), MainActivity.class));
                } else if (id == R.id.about_menu) {
                    Toast.makeText(MainActivity.this, "Click To About Items ", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(getApplicationContext(), AboutPage.class));
                } else if (id == R.id.week_menu) {
                    Toast.makeText(MainActivity.this, "Click To Week Items ", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(getApplicationContext(), Weeks.class));
                } else if (id == R.id.recipe_menu) {
                    Toast.makeText(MainActivity.this, "Click To Recipe Items ", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(getApplicationContext(), AddRecipe.class));
                }

                return true; // Return true to indicate item selection handled
            }
        });

        final DrawerLayout drawerLayout=findViewById(R.id.main);
        findViewById(R.id.imagemenu).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.openDrawer(GravityCompat.START);
            }
        });

    }
}