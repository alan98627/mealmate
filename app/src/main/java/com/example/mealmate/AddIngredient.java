package com.example.mealmate;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class AddIngredient extends AppCompatActivity {

    private ImageView imageView;

    EditText txt_name, txt_description, txt_price;
    Button addIngredientButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_ingredient);

        imageView = findViewById(R.id.ingredients_image);
        txt_name = findViewById(R.id.ingredients_name);
        txt_description = findViewById(R.id.ingredients_description);
        addIngredientButton = findViewById(R.id.btn_submit);

        imageView.setOnClickListener(this::AddGroceryImage);
        addIngredientButton.setOnClickListener(this::AddGroceryButton);
    }

    private void AddGroceryButton(View view) {
        // Handle button click
    }

    private void AddGroceryImage(View view) {
        ImagePickerUtility.pickImage(view, AddIngredient.this);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK && data != null) {
            // Declare the imageUri variable
            Uri imageUri = data.getData(); // Get the image URI from the result
            imageView.setImageURI(imageUri); // Set the image to the ImageView
        }
    }
}