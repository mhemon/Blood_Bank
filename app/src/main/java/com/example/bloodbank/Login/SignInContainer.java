package com.example.bloodbank.Login;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.widget.FrameLayout;

import com.example.bloodbank.R;
import com.example.bloodbank.Splash.Screen1;
import com.example.bloodbank.Splash.Screen2;

public class SignInContainer extends AppCompatActivity {

    private FrameLayout frameLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in_container);
        frameLayout = findViewById(R.id.frame_layout_signIn);
        setFragmentSignIN(new SignIn());
    }
    public void setFragmentSignIN(Fragment fragment){
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.setCustomAnimations(android.R.anim.slide_in_left,android.R.anim.slide_out_right);
        if (fragment instanceof SignIn || fragment instanceof Signup1 || fragment instanceof Signup2 || fragment instanceof Signup3 || fragment instanceof Signup4 || fragment instanceof Signup5 || fragment instanceof Signup6 || fragment instanceof Signup7 || fragment instanceof Signup8){
            fragmentTransaction.addToBackStack(null);
        }
        ((FragmentTransaction) fragmentTransaction).replace(frameLayout.getId(),fragment);
        fragmentTransaction.commit();
    }
}