package com.example.stylesphere;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import androidx.appcompat.app.AppCompatActivity;
import pl.droidsonroids.gif.GifImageView;

public class splash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Configure the window to full screen
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        // Set the content view to the splash layout with the GIF
        setContentView(R.layout.splash);

        // Get the GifImageView from the layout
        GifImageView gifImageView = findViewById(R.id.idGifLogo);

        // Set the GIF image programmatically
        gifImageView.setImageResource(R.drawable.splash);

        // Delayed intent to start the main activity after 2 seconds
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent(splash.this, MainActivity.class);
                startActivity(i);
                finish(); // Finish the splash activity
            }
        }, 4000); // 2000 milliseconds (2 seconds) delay
    }
}
