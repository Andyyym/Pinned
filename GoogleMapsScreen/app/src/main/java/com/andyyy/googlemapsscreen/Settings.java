package com.andyyy.googlemapsscreen;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Settings extends AppCompatActivity {


    Button btnSwitchToMetric;
    Button btnHistoricalLandmarkOn;
    Button btnModernLandmarkOn;
    Button btnPopularOn;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);


        btnHistoricalLandmarkOn = findViewById(R.id.histBtn);
        btnModernLandmarkOn = findViewById(R.id.modernBtn);
        btnPopularOn = findViewById(R.id.popBtn);
        btnSwitchToMetric = findViewById(R.id.switch_to_metric);

        btnSwitchToMetric.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //gets method to change from imperial to metric
                //txtDistance.setText("miles");
                Converting();
            }
        });


        btnHistoricalLandmarkOn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //shows all the historical landmarks when turned on (the toggle)
                //txtHistorical.setText(HisLandMrkShow);
            }
        });

        btnModernLandmarkOn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //shows all the modern landmarks when turned on (the toggle)
                //txtModern.setText(ModLandMrkShow);
            }
        });

        btnPopularOn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //shows all the popular landmarks when turned on (the toggle)
                ////txtPopular.setText(PopLandMrkShow);
            }
        });
    }

    private void Converting() {
        //method that converts miles into kilometres
        // double kilometres = miles/1.609;
        // return kilometres

    }

}

