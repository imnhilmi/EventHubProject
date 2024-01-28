package com.example.eventhub;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class Profile extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        // Set the page title at the very top
        setTitle("Profile");
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