package com.example.mealmate.Model;

import android.net.Uri;

public class Grocery {
    private String id;
    private String name;
    private String description;
    private double price;
    private Uri imageUri;
    private boolean purchased;
    private String location;
    private String imagePath;

    public Grocery(String id, String name, String description, double price, Uri imageUri, boolean purchased, String location, String imagePath) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.imageUri = imageUri;
        this.purchased = purchased;
        this.location = location;
        this.imagePath = imagePath;
    }

    // Getters and Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }

    public Uri getImage() { return imageUri; }
    public void setImage(Uri imageUri) { this.imageUri = imageUri; }

    public boolean isPurchased() { return purchased; }
    public void setPurchased(boolean purchased) { this.purchased = purchased; }

    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }

    public String getImagePath() { return imagePath; }
    public void setImagePath(String imagePath) { this.imagePath = imagePath; }
}
