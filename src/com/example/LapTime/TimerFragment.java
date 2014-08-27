package com.example.LapTime;


import android.app.Fragment;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.os.Handler;



/**
 * Created by Tyson on 8/26/2014.
 */
public class TimerFragment extends Fragment {

   private Button btnSS;
   private TextView timerValue;
   private long stTime = 0L;
   long miliSecs = 0L;
   long timeBuff = 0L;
   long timeUpdate = 0L;

   int btCheck = 0;


  private Handler someHandler = new Handler();


    @Override

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.timerfrag, container, false);

        timerValue = (TextView) rootView.findViewById(R.id.timer);
        btnSS = (Button) rootView.findViewById(R.id.BTstart);


        btnSS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               if(btCheck == 0) {
                   stTime = SystemClock.uptimeMillis();
                   someHandler.postDelayed(upDateTimer, 0);
                   btCheck++;
                   timerButton();
               }else if (btCheck == 1){
                   timeBuff += miliSecs;
                   someHandler.removeCallbacks(upDateTimer);
                   btCheck++;
                   timerButton();
               }else if (btCheck == 2){

                    System.out.println(timerValue.getText());



                   stTime = 0L;
                   miliSecs = 0L;
                   timeBuff = 0L;
                   timeUpdate = 0L;
                   btCheck = 0;
                   timerButton();

               }
            }
        });






        return rootView;

    }



    public void timerButton() {

        if (btnSS.getText() == "Start") {
            btnSS.setText("Stop");
        } else if (btnSS.getText() == "Stop") {
            btnSS.setText("Reset");
        } else if (btnSS.getText() == "Reset") {
            btnSS.setText("Start");
        }
    }

    private Runnable upDateTimer = new Runnable() {

        public void run() {
            miliSecs = SystemClock.uptimeMillis() - stTime;

            timeUpdate = timeBuff + miliSecs;

            int sec = (int) (timeUpdate / 1000);
            int min = sec / 60;
            sec = sec % 60;
            int milsec = (int) (timeUpdate % 1000);

            timerValue.setText("" + min + ":" + String.format("%02d", sec) + ":"
                    + String.format("%01d", milsec/100));

            someHandler.postDelayed(this, 0);

        }
    };

}