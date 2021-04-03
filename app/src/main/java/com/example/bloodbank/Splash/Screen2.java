package com.example.bloodbank.Splash;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.bloodbank.Login.SignInContainer;
import com.example.bloodbank.R;


public class Screen2 extends Fragment {

    //variable declaration
    private Button startbtn;


    public Screen2() {
        // Required empty public constructor
    }

    @Override
    public void onViewCreated(@NonNull  View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        startbtn = view.findViewById(R.id.startbtn);
        startbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //sending user to login screen
                Intent intent = new Intent(getActivity(), SignInContainer.class);
                startActivity(intent);
                //handle backspace
                getActivity().finish();
            }
        });

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_screen2, container, false);
    }
}