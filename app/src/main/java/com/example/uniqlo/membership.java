package com.example.uniqlo;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class membership extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_membership);

        // Reference to the Notification Icon
        ImageView notificationIcon = findViewById(R.id.notificationIcon);
        ImageView searchIcon = findViewById(R.id.searchIcon);
        ImageView membershipIcon = findViewById(R.id.profileIcon);
        ImageView cartIcon = findViewById(R.id.cartIcon);
        ImageView wishListIcon = findViewById(R.id.heartIcon);
        ImageView homeIcon = findViewById(R.id.homeIcon);




        // Set OnClickListener to open cartActivity
        cartIcon.setOnClickListener(v -> {
            Intent intent = new Intent(membership.this, cart.class);
            startActivity(intent);
        });

        // Set OnClickListener to open wishlistActivity
        wishListIcon.setOnClickListener(v -> {
            Intent intent = new Intent(membership.this, wish_list.class);
            startActivity(intent);
        });

        // Set OnClickListener to open notificationActivity
        notificationIcon.setOnClickListener(v -> {
            Intent intent = new Intent(membership.this, notification.class);
            startActivity(intent);
        });

        // Set OnClickListener to open homescreenActivity
        homeIcon.setOnClickListener(v -> {
            Intent intent = new Intent(membership.this, MainActivity.class);
            startActivity(intent);
        });

        // Set OnClickListener to open searchActivity
        searchIcon.setOnClickListener(v -> {
            Intent intent = new Intent(membership.this, search.class);
            startActivity(intent);
        });

        // Set OnClickListener to open searchActivity
        membershipIcon.setOnClickListener(v -> {
            Intent intent = new Intent(membership.this, membership.class);
            startActivity(intent);
        });
    }

}