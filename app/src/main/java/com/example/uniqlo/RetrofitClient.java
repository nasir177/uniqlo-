package com.example.uniqlo;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {

    // Declare a volatile instance for thread safety
    private static volatile Retrofit retrofit = null;

    // Base URL of the Firebase Realtime Database
    private static final String BASE_URL = "https://uniqlo-8aea3-default-rtdb.asia-southeast1.firebasedatabase.app/";

    // Private constructor to prevent instantiation
    private RetrofitClient() {
        // Empty constructor
    }

    // Get the singleton instance of Retrofit
    public static Retrofit getInstance() {
        if (retrofit == null) {
            synchronized (RetrofitClient.class) {
                if (retrofit == null) {
                    retrofit = new Retrofit.Builder()
                            .baseUrl(BASE_URL) // Base URL must end with a '/'
                            .addConverterFactory(GsonConverterFactory.create()) // Convert JSON to Java objects
                            .build();
                }
            }
        }
        return retrofit;
    }
}
