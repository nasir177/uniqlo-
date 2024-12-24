package com.example.uniqlo;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ClothingApi {
    // Adjust the path to point to your Firebase database's clothing.json endpoint
    @GET("clothing_item.json")
    Call<List<ClothingItem>> getClothingItems();
}
