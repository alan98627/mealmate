package com.example.mealmate.Adapter;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.mealmate.Model.Grocery;
import com.example.mealmate.R;
import java.util.ArrayList;
import java.util.List;

public class GroceryAdapter extends RecyclerView.Adapter<GroceryAdapter.ViewHolder> {
    private List<Grocery> groceries;
    private final Context context;

    public GroceryAdapter(Context context, List<Grocery> groceries) {
        this.context = context;
        this.groceries = (groceries != null) ? groceries : new ArrayList<>();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_grocery, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Grocery grocery = groceries.get(position);
        holder.name.setText(grocery.getName());
        holder.price.setText("$" + grocery.getPrice());
        holder.description.setText(grocery.getDescription());
        holder.location.setText(grocery.getLocation());

        // Check for null or empty image path
        if (grocery.getImagePath() != null && !grocery.getImagePath().isEmpty()) {
            holder.image.setImageURI(Uri.parse(grocery.getImagePath()));
        } else {
            holder.image.setImageResource(R.drawable.placeholder_img); // Use default placeholder image
        }
    }

    @Override
    public int getItemCount() {
        return groceries.size();
    }

    // Method to update the grocery list dynamically
    public void setGroceryList(List<Grocery> newGroceries) {
        this.groceries = (newGroceries != null) ? newGroceries : new ArrayList<>();
        notifyDataSetChanged();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView name, price, description, location;
        ImageView image;

        public ViewHolder(View view) {
            super(view);
            name = view.findViewById(R.id.grocery_name);
            price = view.findViewById(R.id.grocery_price);
            description = view.findViewById(R.id.grocery_description);
            location = view.findViewById(R.id.grocery_location);
            image = view.findViewById(R.id.grocery_image);
        }
    }
}
