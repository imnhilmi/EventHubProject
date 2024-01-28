package com.example.eventhub;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class FindEvent extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_event);

        // Set the page name at the very top
        setTitle("Find Event");
    }

    // Button click events for the events
    public void openEvent1(View view) {
        startActivity(new Intent(this, Event1.class));
    }

    public void openEvent2(View view) {
        startActivity(new Intent(this, Event2.class));
    }

    public void openEvent3(View view) {
        startActivity(new Intent(this, Event3.class));
    }

    public void openEvent4(View view) {
        startActivity(new Intent(this, Event4.class));
    }

    // Button click event for the floating action button
    public void openQRScanner(View view) {
        startActivity(new Intent(this, QRScanner.class));
    }

    // Button click event for navigation to Homepage
    public void openHomepage(View view) {
        startActivity(new Intent(this, Homepage.class));
    }

    // Button click event for navigation to Profile page
    public void openProfile(View view) {
        startActivity(new Intent(this, Profile.class));
    }
}
