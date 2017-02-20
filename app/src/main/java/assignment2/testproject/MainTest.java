package assignment2.testproject;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import java.util.*;
import java.util.Random;

import static assignment2.testproject.R.id.textView5;
import static assignment2.testproject.R.id.visible;

public class MainTest extends AppCompatActivity {
    int random;
    List<Integer> intlist = new ArrayList<Integer>();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Random r = new Random();
        for(int i = 0; i < 6; i++){
            random = r.nextInt(9); // [0, 9] + 0 => [0, 9]
            intlist.add(random);
        }
        TextView next = new TextView(this);
        //MyCountDown timer = new MyCountDown(5000, 1000);
        next = (TextView)findViewById(textView5);
        next.setText(String.valueOf(intlist));
        //timer.start();
        final TextView finalNext = next;
        next.postDelayed(new Runnable() {
            @Override
            public void run() {
                finalNext.setVisibility(View.INVISIBLE);
            }
        }, 5000);

        

    }

   /* private class MyCountDown extends CountDownTimer {
        long duration, interval;
        public MyCountDown(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);

            start();
        }

        @Override
        public void onFinish() {
            TextView next = new TextView(this);
            next = (TextView)findViewById(textView5);
            textView5.setVisibility(View.INVISIBLE);
        }

        @Override
        public void onTick(long duration) {
            // could set text for a timer here
        }
    }*/


}
