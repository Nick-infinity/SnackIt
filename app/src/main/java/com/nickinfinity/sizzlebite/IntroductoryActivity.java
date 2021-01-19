package com.nickinfinity.sizzlebite;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.airbnb.lottie.LottieAnimationView;

public class IntroductoryActivity extends AppCompatActivity {
    ImageView img_bg;
    TextView tv_name;
    LottieAnimationView lottieAnimationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_introductory);

        // Hooks
        img_bg = findViewById(R.id.img_bg);
        tv_name = findViewById(R.id.tv_name);
        lottieAnimationView = findViewById(R.id.lottie_splash);

        // Animate
        img_bg.animate().translationY(-2900).setDuration(1000).setStartDelay(4000);
        tv_name.animate().translationY(-1400).setDuration(1000).setStartDelay(4000);
        lottieAnimationView.animate().translationY(1400).setDuration(1000).setStartDelay(4000);

    }
}
