package com.example.mealmate;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapActivity extends AppCompatActivity implements OnMapReadyCallback {
    private GoogleMap mMap;
    private LatLng selectedLatLng;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);

        // Initialize the map fragment safely
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);

        if (mapFragment != null) {
            mapFragment.getMapAsync(this);
        } else {
            Toast.makeText(this, "Error: Map fragment not found!", Toast.LENGTH_LONG).show();
            finish(); // Close activity if map fragment is missing
            return;
        }

        Button btnSelectLocation = findViewById(R.id.btnSelectLocation);
        btnSelectLocation.setOnClickListener(v -> {
            if (selectedLatLng != null) {
                Intent intent = new Intent();
                intent.putExtra("selected_location", selectedLatLng.latitude + ", " + selectedLatLng.longitude);
                setResult(RESULT_OK, intent);
                finish();
            } else {
                Toast.makeText(this, "Please select a location first!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {
        mMap = googleMap;

        // Set a default location (Sydney)
        LatLng defaultLocation = new LatLng(-34, 151);
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(defaultLocation, 10f));

        // Handle map clicks
        mMap.setOnMapClickListener(latLng -> {
            mMap.clear();
            mMap.addMarker(new MarkerOptions().position(latLng).title("Selected Location"));
            selectedLatLng = latLng;
        });
    }
}
