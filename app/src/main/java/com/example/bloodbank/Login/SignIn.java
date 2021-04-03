package com.example.bloodbank.Login;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.bloodbank.R;
import com.example.bloodbank.Splash.Container;
import com.example.bloodbank.Splash.Screen1;
import com.example.bloodbank.Splash.Screen2;

import java.util.Objects;

public class SignIn extends Fragment {

    private Button loginbtn;
    private TextView forgottxt,signuptxt;
    private EditText username,password;

    public SignIn() {
        // Required empty public constructor
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //find views by ID
        loginbtn = view.findViewById(R.id.user_login_btn);
        forgottxt = view.findViewById(R.id.forgot_password_txt);
        signuptxt = view.findViewById(R.id.signup_text);

        //setText for forgot & signup text
        forgottxt.setText(Html.fromHtml(getString(R.string.forgot_string)));
        signuptxt.setText(Html.fromHtml("Don't have an account?"+getString(R.string.account_string)));

        //handle click listeners
        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //handle backend code here
                //verify user input and check database for available user
                //if user input is correct then send to HomeScreen.
            }
        });

        //handle forgot password
        forgottxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //maybe designer forgot to design this screen
                Toast.makeText(getContext(), "Clicked!", Toast.LENGTH_SHORT).show();
            }
        });

        //handle new user
        signuptxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //send user to signup screen1
                ((SignInContainer) Objects.requireNonNull(getActivity())).setFragmentSignIN(new Signup1());
            }
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_sign_in, container, false);
    }
}