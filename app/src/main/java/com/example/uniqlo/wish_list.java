package com.example.uniqlo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class wish_list extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Set the content view to the wish_list layout
        setContentView(R.layout.wish_list);

        // Reference to the Notification Icon
        ImageView notificationIcon = findViewById(R.id.notificationIcon);
        ImageView searchIcon = findViewById(R.id.searchIcon);
        ImageView homeIcon = findViewById(R.id.homeIcon);

        // Set OnClickListener to open NotificationActivity
        notificationIcon.setOnClickListener(v -> {
            // Intent to start NotificationActivity
            Intent intent = new Intent(wish_list.this, notification.class); // Class name corrected
            startActivity(intent);
        });

        // Set OnClickListener to open SearchActivity
        searchIcon.setOnClickListener(v -> {
            // Intent to start SearchActivity
            Intent intent = new Intent(wish_list.this, search.class); // Class name corrected
            startActivity(intent);
        });

        // Set OnClickListener to open MainActivity
        homeIcon.setOnClickListener(v -> {
            // Intent to start MainActivity
            Intent intent = new Intent(wish_list.this, MainActivity.class);
            startActivity(intent);
        });
    }
}
