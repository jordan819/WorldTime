package com.example.czas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.TimeZone;

public class TimeActivity extends AppCompatActivity {

    TextView textView1;
    TextView textView2;
    TextView textView3;
    TextView textView4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time);

        textView1 = findViewById(R.id.textView1);
        textView2 = findViewById(R.id.textView2);
        textView3 = findViewById(R.id.textView3);
        textView4 = findViewById(R.id.textView4);

        timeUpdate();
    }

    private void timeUpdate(){

        //local time
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss");
        String actualTime = simpleDateFormat.format(calendar.getTime());
        textView1.setText(actualTime);

        // Washington time
        TimeZone tz = TimeZone.getTimeZone("GMT-5");
        simpleDateFormat.setTimeZone(tz);
        actualTime = simpleDateFormat.format(calendar.getTime());
        textView2.setText(actualTime);

        // Moscow time
        tz = TimeZone.getTimeZone("GMT+3");
        simpleDateFormat.setTimeZone(tz);
        actualTime = simpleDateFormat.format(calendar.getTime());
        textView3.setText(actualTime);

        // Beijing time
        tz = TimeZone.getTimeZone("GMT+8");
        simpleDateFormat.setTimeZone(tz);
        actualTime = simpleDateFormat.format(calendar.getTime());
        textView4.setText(actualTime);


        refresh();
    }

    private void refresh() {

        int miliseconds = 1000;
        final Handler handler = new Handler();

        final Runnable runnable = new Runnable() {
            @Override
            public void run() {
                timeUpdate();
            }
        };
        handler.postDelayed(runnable, miliseconds);
    }
}