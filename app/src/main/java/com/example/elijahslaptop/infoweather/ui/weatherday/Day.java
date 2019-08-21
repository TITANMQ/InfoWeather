package com.example.elijahslaptop.infoweather.ui.weatherday;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.icu.util.Calendar;
import android.os.Build;
import android.support.annotation.RequiresApi;

import com.example.elijahslaptop.infoweather.R;
import com.example.elijahslaptop.infoweather.WeatherType;

public class Day {

    private int overallTemp;
    private WeatherType overallWeather;
    private Days day;
    private String dayName;
    private Drawable weatherImg;


    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public Day(int day, Context context) {

        overallWeather = WeatherType.sunny; //REMOVE LATER TESTING ONLY

        switch (overallWeather)
        {
            case sunny: weatherImg = context.getDrawable(R.drawable.sunny);
                break;
            case rain: weatherImg = context.getDrawable(R.drawable.rain);
                break;
            case snow: weatherImg = context.getDrawable(R.drawable.snow);
                break;
            case heavySnow: weatherImg = context.getDrawable(R.drawable.heavy_snow);
                break;
            case sunnyClouds: weatherImg = context.getDrawable(R.drawable.sunny_clouds);
                break;
            //TODO add more weather types and images
            default: weatherImg = context.getDrawable(R.drawable.sunny);
        }

        switch (day)
        {
            case Calendar.MONDAY: dayName = "Monday";
                break;
            case Calendar.TUESDAY: dayName = "Tuesday";
                break;
            case Calendar.WEDNESDAY: dayName = "Wednesday";
                break;
            case Calendar.THURSDAY:  dayName = "Thursday";
                break;
            case Calendar.FRIDAY: dayName = "Friday";
                break;
            case Calendar.SATURDAY: dayName = "Saturday";
                break;
            case Calendar.SUNDAY: dayName = "Sunday";
                break;
            default: dayName = "Error";
        }


    }



    /**
     * Returns the string value of the day's name
     * @return day's name
     */
    public String getDayName() {
        return dayName;
    }

    /**
     * Returns the three letter version of the day's name
     * @return shortened day name
     */
    public  String getShortDayName()
    {
        return dayName.substring(0, 3);

    }

    /**
     * Gets the current weather icon
     * @return weather image
     */
    public Drawable getWeatherImg() {
        return weatherImg;
    }
}
