package com.formagrid.hellotest;

import android.app.Application;
import android.content.Context;

import com.jakewharton.picasso.OkHttp3Downloader;
import com.squareup.picasso.Picasso;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;

public class HelloApp extends Application {

    private Picasso picasso;

    @Override
    public void onCreate() {
        super.onCreate();
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(logging)
                .build();

        picasso = new Picasso.Builder(this)
                .downloader(new OkHttp3Downloader(okHttpClient))
                .loggingEnabled(true)
                .indicatorsEnabled(true)
                .build();
    }

    public static HelloApp get(Context context) {
        return (HelloApp) context.getApplicationContext();
    }

    public Picasso getPicasso() {
        return picasso;
    }
}
