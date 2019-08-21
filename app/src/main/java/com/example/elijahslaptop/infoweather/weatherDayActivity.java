package com.example.elijahslaptop.infoweather;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.elijahslaptop.infoweather.ui.weatherday.WeatherDayFragment;

public class weatherDayActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.weather_day_activity);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, WeatherDayFragment.newInstance())
                    .commitNow();
        }
    }
}
