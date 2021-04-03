package com.example.bloodbank.Splash;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import com.example.bloodbank.Adapter.SplashAdapter;

import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.widget.FrameLayout;

import com.example.bloodbank.R;
import com.tbuonomo.viewpagerdotsindicator.DotsIndicator;

public class Container extends AppCompatActivity {

    private FrameLayout frameLayout;
//    private ViewPager viewPager;
//    private DotsIndicator dotsIndicator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_container);
        frameLayout = findViewById(R.id.frame_layout);
        setFragment(new Screen1());
        //just ignoring view pager
//        viewPager = findViewById(R.id.view_pager);
//        dotsIndicator = findViewById(R.id.dots_indicator);
//        viewPager.setAdapter(new SplashAdapter(getSupportFragmentManager()));
//        dotsIndicator.setViewPager(viewPager);
    }


    public void setFragment(Fragment fragment){
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.setCustomAnimations(android.R.anim.slide_in_left,android.R.anim.slide_out_right);
        if (fragment instanceof Screen1 || fragment instanceof Screen2){
            fragmentTransaction.addToBackStack(null);
        }
        ((FragmentTransaction) fragmentTransaction).replace(frameLayout.getId(),fragment);
        fragmentTransaction.commit();
    }
}