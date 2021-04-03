package com.example.bloodbank.NavFragment;

import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.bloodbank.Adapter.SliderAdapter;
import com.example.bloodbank.Model.SliderItem;
import com.example.bloodbank.R;
import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;
import com.smarteist.autoimageslider.IndicatorView.animation.type.IndicatorAnimationType;
import com.smarteist.autoimageslider.IndicatorView.draw.controller.DrawController;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderView;

import org.jetbrains.annotations.NotNull;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;


public class HomeScreen extends Fragment {

    SliderView sliderView;
    private SliderAdapter adapter;
    private GraphView graphView;


    public HomeScreen() {
        // Required empty public constructor
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //finding view by id
        sliderView = view.findViewById(R.id.imageSlider);
        graphView = view.findViewById(R.id.graph);
        //setting up slider
        adapter = new SliderAdapter(getContext());
        sliderView.setSliderAdapter(adapter);
        sliderView.setIndicatorAnimation(IndicatorAnimationType.WORM); //set indicator animation by using SliderLayout.IndicatorAnimations. :WORM or THIN_WORM or COLOR or DROP or FILL or NONE or SCALE or SCALE_DOWN or SLIDE and SWAP!!
        sliderView.setSliderTransformAnimation(SliderAnimations.SIMPLETRANSFORMATION);
        sliderView.setAutoCycleDirection(SliderView.AUTO_CYCLE_DIRECTION_BACK_AND_FORTH);
        sliderView.setIndicatorSelectedColor(Color.parseColor("#c70100"));
        sliderView.setIndicatorUnselectedColor(Color.GRAY);
        sliderView.setScrollTimeInSec(3);
        sliderView.setAutoCycle(true);
        sliderView.startAutoCycle();

        //renew items
        renewItems(view);

        //adding dummy data to statistics
        LineGraphSeries<DataPoint> series = new LineGraphSeries<DataPoint>(new DataPoint[] {
                new DataPoint(0, 20),
                new DataPoint(1, 25),
                new DataPoint(2, 15),
                new DataPoint(3, 12),
                new DataPoint(4, 32),
                new DataPoint(5, 25),
                new DataPoint(6, 10),
                new DataPoint(8, 35),
                new DataPoint(9, 20),
                new DataPoint(10, 25),
                new DataPoint(11, 15),
                new DataPoint(12, 12),
                new DataPoint(13, 32),
                new DataPoint(14, 25),
                new DataPoint(15, 10),
                new DataPoint(16, 35)
        });
        graphView.addSeries(series);

        //json request load data from json keeper
        RequestQueue requestQueue = Volley.newRequestQueue(getContext());
        String url = "https://jsonkeeper.com/b/E7E0";
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    Log.d("my_app",""+response.getString("title"));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("my_app",""+error.getMessage());
            }
        });
        requestQueue.add(jsonObjectRequest);
    }

    public void renewItems(View view) {
        List<SliderItem> sliderItemList = new ArrayList<>();
        //dummy data
        for (int i = 0; i < 5; i++) {
            SliderItem sliderItem = new SliderItem();
            sliderItem.setDescription("Slider Item " + i);
            sliderItem.setAdmin("by Admin");
            sliderItem.setMinute("1 minute ago");
            if (i % 2 == 0) {
                sliderItem.setImageUrl("https://firebasestorage.googleapis.com/v0/b/ecommerce-demo-679fa.appspot.com/o/2.jpeg?alt=media&token=e798d9d2-ca9c-42d2-a3cf-ac73f70c581b");
            } else {
                sliderItem.setImageUrl("https://firebasestorage.googleapis.com/v0/b/ecommerce-demo-679fa.appspot.com/o/4.jpg?alt=media&token=8355f14e-3b03-4144-9555-f5df7ad87c54");
            }
            sliderItemList.add(sliderItem);
        }
        adapter.renewItems(sliderItemList);
    }

    public void removeLastItem(View view) {
        if (adapter.getCount() - 1 >= 0)
            adapter.deleteItem(adapter.getCount() - 1);
    }

    public void addNewItem(View view) {
        SliderItem sliderItem = new SliderItem();
        sliderItem.setDescription("Slider Item Added Manually");
        sliderItem.setImageUrl("https://firebasestorage.googleapis.com/v0/b/ecommerce-demo-679fa.appspot.com/o/5.jpg?alt=media&token=8208bcf0-63e1-4cb1-ac02-bed29a299683");
        adapter.addItem(sliderItem);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home_screen, container, false);
    }
}