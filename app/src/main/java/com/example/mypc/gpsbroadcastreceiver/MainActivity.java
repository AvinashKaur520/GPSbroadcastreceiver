package com.example.mypc.gpsbroadcastreceiver;

import android.app.Activity;
import android.content.Context;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {

    Button button;
    TextView textview;
    Context context;
    LocationManager locationManager ;
    boolean GpsStatus ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = (Button)findViewById(R.id.button1);
        textview = (TextView)findViewById(R.id.textView1);

        context = getApplicationContext();

        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub

                CheckGpsStatus() ;

                if(GpsStatus == true)
                {
                    textview.setText("Location Services Is Enabled");
                }else {
                    textview.setText("Location Services Is Disabled");
                }

            }
        });
    }

    public void CheckGpsStatus(){

        locationManager = (LocationManager)context.getSystemService(Context.LOCATION_SERVICE);

        GpsStatus = locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER);
    }



}