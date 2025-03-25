package com.example.mealmate.Model;

import android.net.Uri;
import androidx.annotation.NonNull;

public class Grocery {
    private String id;
    private String name;
    private String description;
    private double price;
    private Uri image;
    private boolean purchased;
    private String location; // Added field for location
    private String imagePath; // Added field for image path

    public Grocery(String id, String name, String description, double price, Uri image, boolean purchased, String location, String imagePath) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.image = image;
        this.purchased = purchased;
        this.location = location;
        this.imagePath = imagePath;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }

    public Uri getImage() {
        return image;
    }

    public boolean isPurchased() {
        return purchased;
    }

    // Getter for location
    public String getLocation() {
        return location;
    }

    // Getter for image path
    public String getImagePath() {
        return imagePath;
    }

    @NonNull
    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", image=" + image +
                ", price=" + price +
                ", purchased=" + purchased +
                '}';
    }
}