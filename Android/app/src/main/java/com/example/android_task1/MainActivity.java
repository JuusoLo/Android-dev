package com.example.android_task1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;



public class MainActivity extends AppCompatActivity {

    private static final String TAG = "Logcat viesti:";
    public void onButtonClick(View v){
        Intent myIntent = new Intent(getBaseContext(),   Game.class);
        startActivity(myIntent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final ImageView imageView = findViewById(R.id.Läpsy);

       

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

        Log.d(TAG, " Vamos a la playa.");
        Log.e(TAG, "Cama or Vama?");



    }
}
