package com.example.eventhub;

import android.os.Bundle;

import androidx.fragment.app.FragmentActivity;

import com.example.eventhub.databinding.ActivityMapsBinding;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap myMap;
    private ActivityMapsBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMapsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }
    @Override
    public void onMapReady(GoogleMap googleMap) {
        myMap = googleMap;

        // Add a marker in Selangor and move the camera
        LatLng selangor = new LatLng(3.3490, 101.5870);
        myMap.addMarker(new MarkerOptions().position(selangor).title("Marker in Selangor"));
        myMap.moveCamera(CameraUpdateFactory.newLatLngZoom(selangor, 10));  // You can adjust the zoom level as needed
    }
}