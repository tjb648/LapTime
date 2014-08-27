package com.example.LapTime;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class TimerActivity extends Activity {

    /**
     * Called when the activity is first created.
     */
    @Override


    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);


        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        TimerFragment fragment = new TimerFragment();
        fragmentTransaction.add(R.id.timeFrame, fragment).commit();


    }

}



