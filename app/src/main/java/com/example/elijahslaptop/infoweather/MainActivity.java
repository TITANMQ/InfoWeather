package com.example.elijahslaptop.infoweather;

import android.annotation.SuppressLint;
import android.icu.util.Calendar;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.elijahslaptop.infoweather.ui.weatherday.Day;


public class MainActivity extends AppCompatActivity {

    private TextView mTextMessage;
    private TextView currentTempLbl;
    private ImageView currentWeatherImg;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    mTextMessage.setText(R.string.title_home);
                    return true;
                case R.id.navigation_dashboard:
                    mTextMessage.setText(R.string.title_dashboard);
                    return true;
                case R.id.navigation_notifications:
                    mTextMessage.setText(R.string.title_notifications);
                    return true;
            }
            return false;
        }
    };

    @SuppressLint("NewApi")
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        currentTempLbl = (TextView) findViewById(R.id.temperatureLbl);
        currentWeatherImg = (ImageView) findViewById(R.id.weatherImg);
        mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);


        Day today = new Day(Calendar.getInstance().get(Calendar.DAY_OF_WEEK), getApplicationContext());




        int todayDay = Calendar.DAY_OF_WEEK;

        Log.println(10, "TEST DAY", (7- Calendar.getInstance().get(todayDay ))+ "");



        //prepares all the days into the array in order
        Day[] days = new Day[7];
        int endOfTheWeek = (7- (Calendar.getInstance().get(todayDay)));
        int daysOfNewWeek = 7 -(endOfTheWeek+1);

        int dayIncrementor = 0;
        for(int i= 0; i < 7; i++)
        {


            if(dayIncrementor < endOfTheWeek)
                days[i] = new Day(Calendar.getInstance().get(todayDay )+dayIncrementor++, getApplicationContext());
            else if(dayIncrementor == endOfTheWeek){
                days[i] = new Day(Calendar.getInstance().get(todayDay )+dayIncrementor, getApplicationContext());
                dayIncrementor = -daysOfNewWeek;
            }
//            else
//                days[i] = new Day(Calendar.getInstance().get(todayDay )+dayIncrementor--);
            Log.println(10, "TEST DAY", (i)+ "");
        }

        //current day




        //Seven day forecast temperatures
        TextView day1 = (TextView) findViewById(R.id.day1);
        day1.setText(days[0].getShortDayName().toUpperCase());

        TextView day2 = (TextView) findViewById(R.id.day2);
        day2.setText(days[1].getShortDayName().toUpperCase());

        TextView day3 = (TextView) findViewById(R.id.day3);
        day3.setText(days[2].getShortDayName().toUpperCase());

        TextView day4 = (TextView) findViewById(R.id.day4);
        day4.setText(days[3].getShortDayName().toUpperCase());

        TextView day5 = (TextView) findViewById(R.id.day5);
        day5.setText(days[4].getShortDayName().toUpperCase());

        TextView day6 = (TextView) findViewById(R.id.day6);
        day6.setText(days[5].getShortDayName().toUpperCase());

        TextView day7 = (TextView) findViewById(R.id.day7);
        day7.setText(days[6].getShortDayName().toUpperCase());



        //Seven day forecast weather icons

        //current day
        currentWeatherImg.setImageDrawable(days[0].getWeatherImg());

        ImageView imgday1 = (ImageView) findViewById(R.id.dayImg1);
        imgday1.setImageDrawable(days[0].getWeatherImg());

        ImageView imgday2 = (ImageView) findViewById(R.id.dayImg2);
        imgday2.setImageDrawable(days[1].getWeatherImg());

        ImageView imgday3 = (ImageView) findViewById(R.id.dayImg3);
        imgday3.setImageDrawable(days[2].getWeatherImg());

        ImageView imgday4 = (ImageView) findViewById(R.id.dayImg4);
        imgday4.setImageDrawable(days[3].getWeatherImg());

        ImageView imgday5 = (ImageView) findViewById(R.id.dayImg5);
        imgday5.setImageDrawable(days[4].getWeatherImg());

        //TODO do the following for all of the images
    }

}
