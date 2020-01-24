package com.example.android_task1;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.provider.Settings;
import android.util.Log;
import android.widget.Toast;

public class AirPlaneMode extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        if (Settings.System.getInt(context.getContentResolver(),Settings.Global.AIRPLANE_MODE_ON,0)== 0){
            Toast.makeText(context,"FLIGHT MODE STATUS OFF",Toast.LENGTH_LONG).show();
        }
        else {
            Toast.makeText(context,"FLIGHT MODE STATUS ON",Toast.LENGTH_LONG).show();
        }

    }
 }
