package com.formagrid.hellotest;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class HelloActivity extends Activity {

    private static final String IMAGE_URL_BAD = "https://forma_app_filepicker_dev-test-staging.s3.amazonaws.com/profilePics%2FGPeekrQMepSJvusaFOng_66.png?sz=36";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hello);
        ImageView bottomImageView = (ImageView) findViewById(R.id.image_view_bottom);
        Picasso picasso = HelloApp.get(this).getPicasso();
        picasso.load(IMAGE_URL_BAD).into(bottomImageView);
    }

}
