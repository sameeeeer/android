package com.example.blogging.RetrofitHelper;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Helper {

    public static void StrictMode() {
        android.os.StrictMode.ThreadPolicy policy = new android.os.StrictMode.ThreadPolicy.Builder().permitAll().build();
        android.os.StrictMode.setThreadPolicy(policy);
    }

    private static Retrofit retrofit;

    private static final String BASE_URL = "http://10.0.2.2:3000/";
    public static final String IMAGE_URL = "http://10.0.2.2:3000/image/";
//
//    private static final String BASE_URL = "http://10.0.2.2:3000/";
//    public static final String IMAGE_URL = "http://10.0.2.2:3000/image/";
public static final  String Token = "Bearer ";

    public static Retrofit getInstance() {

        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.level(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(logging)
                .build();

        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build();

        return retrofit;
    }
}
