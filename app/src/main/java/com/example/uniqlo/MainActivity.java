package com.example.uniqlo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private LinearLayout scrollIndicator;
    private View blackLine;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Reference to the icons in the UI
        ImageView notificationIcon = findViewById(R.id.notificationIcon);
        ImageView searchIcon = findViewById(R.id.searchIcon);
        ImageView wishListIcon = findViewById(R.id.WishListIcon);
        ImageView membershipIcon = findViewById(R.id.profileIcon);
        ImageView cartIcon = findViewById(R.id.cartIcon);

        // Initialize RecyclerView and scroll indicator
        recyclerView = findViewById(R.id.recyclerView);
        scrollIndicator = findViewById(R.id.scrollIndicator);
        blackLine = findViewById(R.id.blackLine);

        // Set LayoutManager for RecyclerView
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Add 12 dots dynamically for scroll indicator
        for (int i = 0; i < 12; i++) {
            ImageView dot = new ImageView(this);
            dot.setImageResource(R.drawable.scroll_dot);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(16, 16); // Adjust size as needed
            params.setMargins(4, 4, 4, 4); // Margin for spacing
            dot.setLayoutParams(params);
            scrollIndicator.addView(dot);
        }

        // Set RecyclerView scroll listener
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);

                // Get scroll metrics
                int extent = recyclerView.computeVerticalScrollExtent();
                int range = recyclerView.computeVerticalScrollRange();
                int offset = recyclerView.computeVerticalScrollOffset();

                if (extent == 0 || range == 0) return; // Prevent division by zero

                // Calculate scroll progress proportion
                float proportion = (float) offset / (range - extent);

                // Calculate the translation of the scroll indicator
                int indicatorHeight = scrollIndicator.getHeight();
                int blackLineHeight = blackLine.getHeight();
                int maxTranslationY = indicatorHeight - blackLineHeight;

                // Apply translation to the black line
                blackLine.setTranslationY(proportion * maxTranslationY);
            }
        });

        // Set OnClickListener for icons
        notificationIcon.setOnClickListener(v -> openActivity(notification.class));
        searchIcon.setOnClickListener(v -> openActivity(search.class));
        wishListIcon.setOnClickListener(v -> openActivity(wish_list.class));
        membershipIcon.setOnClickListener(v -> openActivity(membership.class));
        cartIcon.setOnClickListener(v -> openActivity(cart.class));

        // Get Retrofit instance and API interface
        ClothingApi api = RetrofitClient.getInstance().create(ClothingApi.class);

        // Fetch clothing items
        api.getClothingItems().enqueue(new Callback<List<ClothingItem>>() {
            @Override
            public void onResponse(@NonNull Call<List<ClothingItem>> call, @NonNull Response<List<ClothingItem>> response) {
                if (response.isSuccessful() && response.body() != null && !response.body().isEmpty()) {
                    List<ClothingItem> clothingItems = response.body();
                    ClothingAdapter adapter = new ClothingAdapter(MainActivity.this, clothingItems);
                    recyclerView.setAdapter(adapter); // Set the adapter to RecyclerView
                } else {
                    Toast.makeText(MainActivity.this, "No items found", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(@NonNull Call<List<ClothingItem>> call, @NonNull Throwable t) {
                Toast.makeText(MainActivity.this, "Network Error: " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    // Helper method to open an activity
    private void openActivity(Class<?> activityClass) {
        Intent intent = new Intent(MainActivity.this, activityClass);
        startActivity(intent);
    }
}
