package com.example.elijahslaptop.infoweather.ui.weatherday;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.elijahslaptop.infoweather.R;

public class WeatherDayFragment extends Fragment {

    private WeatherDayViewModel mViewModel;

    public static WeatherDayFragment newInstance() {
        return new WeatherDayFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.weather_day_fragment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(WeatherDayViewModel.class);
        // TODO: Use the ViewModel
    }

}
