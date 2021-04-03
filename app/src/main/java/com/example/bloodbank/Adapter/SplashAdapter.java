package com.example.bloodbank.Adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.example.bloodbank.Splash.Screen1;
import com.example.bloodbank.Splash.Screen2;


public class SplashAdapter extends FragmentStatePagerAdapter {
    public SplashAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    public SplashAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {

        //add fragment

        switch (position) {
            case 0:
                return new Screen1();
            case 1:
                return new Screen2();
            default:
                return new Screen1();
        }
    }

    @Override
    public int getCount() {
        //we don't want to create a model only for two page
        //we have static two pages for onboarding
        return 2;
    }
}
