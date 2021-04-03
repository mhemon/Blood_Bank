package com.example.bloodbank.Login;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.bloodbank.R;

import java.util.Objects;


public class Signup1 extends Fragment {

    private Button nextbtn;

    public Signup1() {
        // Required empty public constructor
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        nextbtn = view.findViewById(R.id.NextScreen1);
        //send user to next screen
        //also getting data from user & save it to send database
        //backend code here....
        nextbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //send user to next screen
                ((SignInContainer) Objects.requireNonNull(getActivity())).setFragmentSignIN(new Signup2());
            }
        });

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_signup1, container, false);
    }
}