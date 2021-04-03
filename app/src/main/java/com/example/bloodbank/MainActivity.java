package com.example.bloodbank;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.widget.FrameLayout;


import com.example.bloodbank.NavFragment.HomeScreen;
import com.example.bloodbank.NavFragment.MapScreen;
import com.example.bloodbank.NavFragment.NotificationScreen;
import com.example.bloodbank.NavFragment.ProfileScreen;
import com.example.bloodbank.Adapter.SliderAdapter;
import com.fxn.BubbleTabBar;
import com.fxn.OnBubbleClickListener;
import com.smarteist.autoimageslider.SliderView;


public class MainActivity extends AppCompatActivity {

    private FrameLayout frameLayout;
    private BubbleTabBar bubbleTabBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //finding views by ID
        frameLayout = findViewById(R.id.frame_layout_main);
        bubbleTabBar = findViewById(R.id.bubbleTabBar);

        //set default screen
        setFragmentNAV(new HomeScreen());

        //change screen when click an item on bottom nav
        bubbleTabBar.addBubbleListener(new OnBubbleClickListener() {
            @Override
            public void onBubbleClick(int id) {
                switch (id){
                    case R.id.home:
                        setFragmentNAV(new HomeScreen());
                        break;
                    case R.id.map:
                        setFragmentNAV(new MapScreen());
                        break;
                    case R.id.notification:
                        setFragmentNAV(new NotificationScreen());
                        break;
                    case R.id.profile:
                        setFragmentNAV(new ProfileScreen());
                        break;
                }
            }
        });

    }

    public void setFragmentNAV(Fragment fragment){
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        ((FragmentTransaction) fragmentTransaction).replace(frameLayout.getId(),fragment);
        fragmentTransaction.commit();
    }
}