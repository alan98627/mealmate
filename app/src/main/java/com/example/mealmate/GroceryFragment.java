package com.example.mealmate;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mealmate.Adapter.GroceryAdapter;
import com.example.mealmate.DatabaseHelper.Grocery_Database_Helper;
import com.example.mealmate.Model.Grocery;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class GroceryFragment extends Fragment {

    private RecyclerView recyclerView;
    private GroceryAdapter adapter;
    private Grocery_Database_Helper databaseHelper;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_grocery, container, false);

        recyclerView = view.findViewById(R.id.recyclerView);
        databaseHelper = new Grocery_Database_Helper(requireContext());

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new GroceryAdapter(requireContext(), new ArrayList<>());
        recyclerView.setAdapter(adapter);

        loadGroceries();
        return view;
    }

    private void loadGroceries() {
        adapter.setGroceryList(databaseHelper.getAllGroceries());
    }
}
