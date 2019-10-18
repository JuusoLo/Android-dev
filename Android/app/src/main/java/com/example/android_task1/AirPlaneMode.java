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

//    private static class Task extends AsyncTask<String, Integer, String> {
//
//        private final PendingResult pendingResult;
//        private final Intent intent;
//
//        private Task(PendingResult pendingResult, Intent intent) {
//            this.pendingResult = pendingResult;
//            this.intent = intent;
//        }
//
//
//        @Override
//        protected String doInBackground(String... strings) {
//            StringBuilder sb = new StringBuilder();
//            sb.append("Action: " + intent.getAction() + "\n");
//            sb.append("URI: " + intent.toUri(Intent.URI_INTENT_SCHEME).toString() + "\n");
//            String log = sb.toString();
//            Log.d(TAG, log);
//            return log;
//        }
//        @Override
//        protected void onPostExecute(String s) {
//            super.onPostExecute(s);
//            pendingResult.finish();
//        }
//    }
}
