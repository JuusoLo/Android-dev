package com.example.android_task1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;
import java.util.List;


public class MainActivity extends AppCompatActivity implements LocationListener{
    public String currentAddress ="";

    private LocationManager locationManager;
    BroadcastReceiver br = new AirPlaneMode();
    private TextView textView;
    private static final int REQUEST_LOCATION = 1;
    TextView addressView;
    Geocoder geocoder;
    

    // Static Latitude and Longitude Data


    

    private static final String TAG = "Logcat viesti:";
    public void onButtonClick(View v) {
        Intent myIntent = new Intent(getBaseContext(), Game.class);
        startActivity(myIntent);
}

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final ImageView imageView = findViewById(R.id.Läpsy);

        getLocation();

                  final Button button = findViewById(R.id.Tuosta);
                  button.setOnClickListener(new View.OnClickListener() {
                      public void onClick(View v) {

                          if (imageView.getVisibility() == View.VISIBLE){
                              imageView.setVisibility(View.GONE);

                          }
                          else { imageView.setVisibility(View.VISIBLE);
                          }


                      }
                  });


        addressView = findViewById(R.id.CurrentLocation);
        geocoder = new Geocoder(this);



        Log.d(TAG, " Vamos a la playa.");
        Log.d(TAG, "Cama or Vama?");


    }


    public void getLocation(){


          if (locationManager == null) {
              locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
          }

          if(ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED)

              ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, REQUEST_LOCATION);

          else {

              locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 5000, 0, (LocationListener) this);


              Location location = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
              location.getLatitude();
              location.getLongitude();




          }





    }



    public void onClickWeb(View view) {
        Intent webView = new Intent(getBaseContext(), WebView.class);
        startActivity(webView);
    }

    public void onResume() {
        super.onResume();
        IntentFilter filter = new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION);
        filter.addAction(Intent.ACTION_AIRPLANE_MODE_CHANGED);
        this.registerReceiver(br,filter);

    }


    @Override

    public void onLocationChanged(Location location) {
        double latitude = location.getLatitude();
        double longitude = location.getLongitude();
        Log.e(TAG, location.getLatitude()+"");
        Log.e(TAG, location.getLongitude()+"");



        try {
            List<Address> addresses = geocoder.getFromLocation(latitude, longitude, 10);




            if (addresses.size()>0){
                String address = addresses.get(0).getAddressLine(0);
                addressView.setText(address);
                currentAddress = address;
            }
//            Log.e(TAG,"Kanapasta");
//            addresses = geocoder.getFromLocation(
//                    location.getLatitude(),
//                    location.getLongitude(),
//                    1);
//

            Log.e(TAG, addresses.toString());

        }catch (IOException ioException){
            ioException.printStackTrace();

        }


        }


    @Override
    public void onStatusChanged(String s, int i, Bundle bundle) {

    }

    @Override
    public void onProviderEnabled(String s) {

    }

    @Override
    public void onProviderDisabled(String s) {

    }

    public void onClickTimer(View view) {
        Intent myIntent = new Intent(getBaseContext(), AlarmTimer.class);
        startActivity(myIntent);

    }
}
