package com.example.android_task1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.util.Random;

public class Game extends AppCompatActivity {

    private int count = 0;
    private int r1, r2;
    private ProgressBar progressBar;
    private int progressStatus = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game2);

    }

    private void giveNewRandom(){
        if(count==5){
            count=0;
            Toast.makeText(this, "You won the game!", Toast.LENGTH_SHORT).show();
        }
        else {
            Random rand = new Random();
            r1 = rand.nextInt(15);
            while (true) {
                r2 = rand.nextInt(15);
                if (r1 != r2) break;
            }
        }
        Button b = (Button) findViewById(R.id.buttonV);
        b.setText(Integer.toString(r1));
        Button b2 = (Button) findViewById(R.id.buttonO);
        b2.setText(Integer.toString(r2));

    }

    public void onClickOikea(View view) {

        if(r1 < r2)
            count++;
        else
            count--;
        TextView txt = (TextView) findViewById(R.id.textView3);

        txt.setText("Points: "+count);
        giveNewRandom();
    }

    public void onClickVasen(View view) {

        if(r1 > r2)
            count++;
        else
            count--;
        TextView txt = (TextView) findViewById(R.id.textView3);
        txt.setText("Points: "+count);
        giveNewRandom();
    }

    public void onClickNew(View view) {
        finish();
        startActivity(getIntent());
    }
}
