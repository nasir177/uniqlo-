package com.example.uniqlo;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class cart extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_cart);
        ImageView backIcon = findViewById(R.id.imageBack);

        // Set OnClickListener to open backActivity
        backIcon.setOnClickListener(v -> {
            Intent intent = new Intent(cart.this, MainActivity.class);
            startActivity(intent);
        });
    }
}
