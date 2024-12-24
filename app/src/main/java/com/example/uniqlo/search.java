package com.example.uniqlo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class search extends AppCompatActivity {

    // Declare ImageView references
    ImageView homeIcon;
    ImageView closeIcon;
    ImageView notificationIcon;
    ImageView cartIcon;
    ImageView wishlistIcon;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_search);

        // Initialize ImageView references AFTER setContentView
        homeIcon = findViewById(R.id.homeIcon);
        closeIcon = findViewById(R.id.closeIcon);
        notificationIcon = findViewById(R.id.notificationIcon);
        cartIcon = findViewById(R.id.cartIcon);
        wishlistIcon = findViewById(R.id.heartIcon);



        // Set OnClickListener to open homeActivity
        homeIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Intent to start MainActivity
                Intent intent = new Intent(search.this, MainActivity.class);
                startActivity(intent);
            }
        });

        // Set OnClickListener to open homeActivity by closeIcon
        closeIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Intent to start MainActivity
                Intent intent = new Intent(search.this, MainActivity.class);
                startActivity(intent);
            }
        });

        // Set OnClickListener to open homeActivity by closeIcon
        notificationIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Intent to start MainActivity
                Intent intent = new Intent(search.this, notification.class);
                startActivity(intent);
            }
        });

        // Set OnClickListener to open cartActivity
        cartIcon.setOnClickListener(v -> {
            Intent intent = new Intent(search.this, cart.class);
            startActivity(intent);
        });

        // Set OnClickListener to open wishlistActivity
        wishlistIcon.setOnClickListener(v -> {
            Intent intent = new Intent(search.this, wish_list.class);
            startActivity(intent);
        });
    }
}
