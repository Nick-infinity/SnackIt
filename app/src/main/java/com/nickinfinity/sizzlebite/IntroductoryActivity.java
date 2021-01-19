package com.nickinfinity.sizzlebite;

import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.airbnb.lottie.LottieAnimationView;

public class IntroductoryActivity extends AppCompatActivity {

    // Variables
    ImageView img_bg;
    TextView tv_name;
    LottieAnimationView lottieAnimationView;
    private static final int NUM_PAGES = 2 ;
    private ViewPager viewPager;
    private ScreenSlidePageAdaper screenSlidePageAdaper;
    Animation anim;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_introductory);

        // Hooks
        img_bg = findViewById(R.id.img_bg);
        tv_name = findViewById(R.id.tv_name);
        lottieAnimationView = findViewById(R.id.lottie_splash);
        viewPager = findViewById(R.id.pager);
        screenSlidePageAdaper = new ScreenSlidePageAdaper(getSupportFragmentManager());
        viewPager.setAdapter(screenSlidePageAdaper);

        //fade anim
        anim = AnimationUtils.loadAnimation(this, R.anim.fade_anim);
        viewPager.startAnimation(anim);

        // Animate
        img_bg.animate().translationY(-2900).setDuration(1000).setStartDelay(4000);
        tv_name.animate().translationY(-1400).setDuration(1000).setStartDelay(4000);
        lottieAnimationView.animate().translationY(1400).setDuration(1000).setStartDelay(4000);

    }

    private class ScreenSlidePageAdaper extends FragmentStatePagerAdapter {
        public ScreenSlidePageAdaper(@NonNull FragmentManager fm) {
            super(fm);
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    OnboardFrag1 tab1 = new OnboardFrag1();
                    return tab1;
                case 1:
                    OnboardFrag2 tab2 = new OnboardFrag2();
                    return tab2;


            }
            return null;
        }

        @Override
        public int getCount() {
            return NUM_PAGES;
        }
    }
}
