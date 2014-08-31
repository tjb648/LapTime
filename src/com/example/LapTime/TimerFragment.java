package com.example.LapTime;


import android.app.Fragment;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.os.Handler;
import org.w3c.dom.Text;


/**
 * Created by Tyson on 8/26/2014.
 */
public class TimerFragment extends Fragment {
    //Button
   private Button btnSS;
    //TextViews
   private TextView tBest;
   private TextView tWorst;
   private TextView tAve;
   private TextView timerValue;
 //Bar layouts
  LinearLayout layBest = null;
  LinearLayout layWorst = null;
  LinearLayout layAverage = null;
  LinearLayout layCurr = null;
  //Timer longs and ints
   private long stTime = 0L;
   long miliSecs = 0L;
   long timeBuff = 0L;
   long timeUpdate = 0L;
   int btCheck = 0;

    //to work out best average worst maybe concatenate string timervalue into 1 big int and compare
  private Handler someHandler = new Handler();


    @Override

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.timerfrag, container, false);
        btnSS = (Button) rootView.findViewById(R.id.BTstart);
        //Displayed time
        timerValue = (TextView) rootView.findViewById(R.id.timer);

        tBest = (TextView) rootView.findViewById(R.id.best);
        tWorst = (TextView) rootView.findViewById(R.id.worst);
        tAve = (TextView) rootView.findViewById(R.id.average);

        layBest = (LinearLayout) rootView.findViewById(R.id.barBest);

        btnSS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               if(btCheck == 0) {
                   stTime = SystemClock.uptimeMillis();
                   someHandler.postDelayed(upDateTimer, 0);

                   btCheck++;
                   btnSS.setText("Stop");

               }else if (btCheck == 1){
                   timeBuff += miliSecs;
                   someHandler.removeCallbacks(upDateTimer);
                   btCheck++;
                   tBest.setText("Best:" + timerValue.getText());

                   btnSS.setText("Reset");

               }else if (btCheck == 2){

                   stTime = 0L;
                   miliSecs = 0L;
                   timeBuff = 0L;
                   timeUpdate = 0L;
                   btCheck = 0;

                   btnSS.setText("Start");



               }
            }
        });

         return rootView;

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

    public void timeCalc(){

        // should i change variables to global or pull apart string
        String minutes, seconds, tiny_seconds;

        String buffer;

        buffer = timerValue.getText().toString();

        minutes = buffer.substring(0,1);
        seconds = buffer.substring(3, 4);
        tiny_seconds = buffer.substring(6,7);





    }
}