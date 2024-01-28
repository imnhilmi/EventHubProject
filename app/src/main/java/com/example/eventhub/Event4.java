package com.example.eventhub;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class Event4 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event4);

        // Set the page title at the very top
        setTitle("Event Details");
    }

    // Button click event for "Locate Me"
    public void locateMe(View view) {
        startActivity(new Intent(this, EventLocator.class));
    }

    // Button click event for "Attend Event"
    public void attendEvent(View view) {
        startActivity(new Intent(this, Profile.class));
    }

    // Button click event for navigation to Homepage
    public void openHomepage(View view) {
        startActivity(new Intent(this, Homepage.class));
    }

    // Button click event for navigation to Find Event page
    public void openFindEvent(View view) {
        startActivity(new Intent(this, FindEvent.class));
    }

    // Button click event for navigation to Profile page
    public void openProfile(View view) {
        startActivity(new Intent(this, Profile.class));
    }
}