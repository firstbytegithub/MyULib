package com.example.xuweiwei.myulib.app;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class DemoBroadCastReceiver extends BroadcastReceiver {
    private static final String LOG_TAG = "DemoBroadCastReceiver";

    public DemoBroadCastReceiver() {
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO: This method is called when the BroadcastReceiver is receiving
        // an Intent broadcast.
        if (intent.getAction().equals("com.example.xuweiwei.myulib.app.bc")) {
            Log.d(LOG_TAG, "broadcast received bc:" + intent.getStringExtra("name"));
        } else if (intent.getAction().equals("com.example.xuweiwei.myulib.app.bc2")) {
            Log.d(LOG_TAG, "broadcast received bc2:" + intent.getStringExtra("name"));
        }
    }
}
