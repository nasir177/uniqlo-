package com.example.uniqlo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class ClothingAdapter extends RecyclerView.Adapter<ClothingAdapter.ClothingViewHolder> {

    private final Context context;
    private final List<ClothingItem> items; // List of ClothingItem objects

    public ClothingAdapter(Context context, List<ClothingItem> items) {
        this.context = context;
        this.items = items != null ? items : List.of(); // Ensure the list is never null
    }

    @NonNull
    @Override
    public ClothingViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Inflate the layout for individual items
        View view = LayoutInflater.from(context).inflate(R.layout.activity_item_clothing, parent, false); // Ensure XML layout is correct
        return new ClothingViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ClothingViewHolder holder, int position) {
        // Bind the clothing item to the view holder
        ClothingItem item = items.get(position);

        // Set item details
        holder.itemName.setText(item.getName());
        holder.itemPrice.setText(context.getString(R.string.price_format, item.getPrice())); // Format price
        holder.description.setText(item.getDescription());

        // Load media using Glide with placeholder and error handling
        Glide.with(context)
                .load(item.getmedia_url()) // Ensure `getMediaUrl()` matches your `ClothingItem` implementation
                // .placeholder(R.drawable.placeholder_image) // Placeholder image while loading
              //  .error(R.drawable.error_image) // Error image if loading fails
                .into(holder.mediaView);

        // Load brand logo using Glide with placeholder and error handling
        Glide.with(context)
                .load(item.getBrandLogoUrl()) // Ensure `getBrandLogoUrl()` matches your `ClothingItem` implementation
               // .placeholder(R.drawable.placeholder_logo) // Placeholder logo while loading
               // .error(R.drawable.error_logo) // Error logo if loading fails
                .into(holder.brandLogo);
    }

    @Override
    public int getItemCount() {
        // Return the size of the list
        return items.size();
    }

    // ViewHolder class to manage individual item views
    public static class ClothingViewHolder extends RecyclerView.ViewHolder {
        ImageView mediaView, brandLogo;
        TextView itemName, itemPrice, description;

        public ClothingViewHolder(@NonNull View itemView) {
            super(itemView);

            // Initialize all views for the item
            mediaView = itemView.findViewById(R.id.mediaView);
            brandLogo = itemView.findViewById(R.id.brandLogo);
            itemName = itemView.findViewById(R.id.itemName);
            description = itemView.findViewById(R.id.description);
            itemPrice = itemView.findViewById(R.id.itemPrice);
        }
    }
}
