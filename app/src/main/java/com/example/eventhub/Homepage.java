package com.example.eventhub;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Homepage extends AppCompatActivity {

    private Button btnFindEvent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.homepage);

        btnFindEvent = findViewById(R.id.btnFindEvent);
        btnFindEvent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle button click, navigate to FindEvent.java
                Intent intent = new Intent(Homepage.this, FindEvent.class);
                startActivity(intent);
            }
        });

    }

}