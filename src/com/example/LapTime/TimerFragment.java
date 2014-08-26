package com.example.LapTime;


import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by Tyson on 8/26/2014.
 */
public class TimerFragment extends Fragment {

    private Button btnSS;
    private double time;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.timerfrag, container, false);

        initFrag();


       return rootView;

      // return inflater.inflate(R.layout.timerfrag, container, false);

    }


    public void initFrag()
    {
        time = 00.00;
    //    (Button) getView().findViewById(R.id.timer) = time;
        btnSS = (Button) getView().findViewById(R.id.BTstart);
        btnSS.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                timerButton();
            }
        });

    }

    public void timerButton(){

        if(btnSS.getText()== "Start")
            btnSS.setText("Stop");
            else if(btnSS.getText()=="Stop")
                btnSS.setText("Start");
            else if(btnSS.getText()=="Stop")
                btnSS.setText("Reset");
    }

}