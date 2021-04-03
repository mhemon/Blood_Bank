package com.example.bloodbank.Login;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.bloodbank.R;
import com.shawnlin.numberpicker.NumberPicker;

import java.lang.reflect.Array;
import java.util.Objects;


public class Signup7 extends Fragment {


    private NumberPicker numberPicker;
    private Button nextbtn;
    private int selectedmonth;


    public Signup7() {
        // Required empty public constructor
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //handaling java code for showing month list in the picker.
        numberPicker = view.findViewById(R.id.number_picker3);
        nextbtn = view.findViewById(R.id.NextScreen7);
        String[] data ={"JAN","FEB","MAR","APR","MAY","JUN","JULY","AUG","SEPT","OCT","NOV","DEC"};
        numberPicker.setMinValue(1);
        numberPicker.setTextSize(getResources().getDimension(R.dimen.txt_size));
        numberPicker.setSelectedTextSize(getResources().getDimension(R.dimen.txt_size));
        numberPicker.setMaxValue(data.length);
        numberPicker.setDisplayedValues(data);
        numberPicker.setValue(5);
        numberPicker.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
                 selectedmonth = picker.getValue()-1;
                 nextbtn.setEnabled(true);
            }
        });
        numberPicker.setOnScrollListener(new NumberPicker.OnScrollListener() {
            @Override
            public void onScrollStateChange(NumberPicker view, int scrollState) {
                if (scrollState == SCROLL_STATE_IDLE){
                    selectedmonth = view.getValue()-1;
                }
            }
        });
        //how to collect input?
        //here is the soluation
        nextbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "Selected month ="+ Array.get(data,selectedmonth), Toast.LENGTH_SHORT).show();
                //sending user to the nextscreen
                ((SignInContainer) Objects.requireNonNull(getActivity())).setFragmentSignIN(new Signup8());
            }
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_signup7, container, false);
    }
}