package com.example.bloodbank;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.bloodbank.Splash.Container;

public class WelcomeActivity extends AppCompatActivity {

    private Button startbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        //finding views by id
        startbtn = findViewById(R.id.start_journey);
        //asign click listener
        startbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //handle onclick
                //open another activity
                //tips:- add some logic like user is first time or not if first time then show splash screen
                //otherwise send user direclty to login screen here can be add more logic like if user alreday sign in or not if sign in then send direclty to home screen.
                Intent intent = new Intent(WelcomeActivity.this, Container.class);
                startActivity(intent);
                finish();
            }
        });
    }
}