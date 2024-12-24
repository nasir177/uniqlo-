package com.example.uniqlo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class notification extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_notification);


        // Reference to the Notification Icon
        ImageView homeIcon = findViewById(R.id.homeIcon);

        // Set OnClickListener to open MainActivity from NotificationActivity
        homeIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Intent to start MainActivity
                Intent intent = new Intent(notification.this, MainActivity.class);
                startActivity(intent);
                finish(); // Optional: Closes NotificationActivity if you don't want to keep it in the back stack
            }
        });

    }
}