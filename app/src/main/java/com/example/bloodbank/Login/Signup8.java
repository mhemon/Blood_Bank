package com.example.bloodbank.Login;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.bloodbank.MainActivity;
import com.example.bloodbank.R;
import com.github.dhaval2404.imagepicker.ImagePicker;

import java.util.Objects;


public class Signup8 extends Fragment {

    private Button nextbtn;
    private AppCompatImageButton place_holder;


    public Signup8() {
        // Required empty public constructor
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        nextbtn = view.findViewById(R.id.NextScreen8);
        place_holder = view.findViewById(R.id.place_holder);
        //opening galary for images...

        place_holder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ImagePicker.Companion.with(getActivity())
                        .galleryOnly()
                        // Image resolution will be less than 1080 x 1920
                        .maxResultSize(1080, 1920)
                        .crop()
                        .start();
            }
        });


        //sending user to next Activity
        nextbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), MainActivity.class);
                startActivity(intent);
                getActivity().finish();
            }
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_signup8, container, false);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        //set images from the picker
        if (requestCode == Activity.RESULT_OK) {
            place_holder.setImageURI(data.getData());
            Toast.makeText(getContext(), "Success", Toast.LENGTH_SHORT).show();
        }
    }
}