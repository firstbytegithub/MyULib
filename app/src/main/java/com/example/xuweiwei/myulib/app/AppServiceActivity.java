package com.example.xuweiwei.myulib.app;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.xuweiwei.myulib.R;
import com.example.xuweiwei.myulib.app.AppService01;
import com.example.xuweiwei.myulib.app.AppService01.LocalBinder;

public class AppServiceActivity extends AppCompatActivity {

    private final String LOG_TAG = "AppServiceActivity";
    private AppService01 mService;

    private ServiceConnection mConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            Log.d(LOG_TAG, "onServiceConnected");
            mService = ((LocalBinder)service).getService();
            Log.d(LOG_TAG, "service return " + mService.getYourSecret());
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            Log.d(LOG_TAG, "onServiceDisconnected");
            mService = null;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app_service);

        initServiceButtons();
    }

    private void initServiceButtons() {
        ((Button)findViewById(R.id.button24)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(LOG_TAG, "start service");
                Intent intent = new Intent();
                intent.setAction("com.example.xuweiwei.myulib.app.ACTION01");
                intent.setPackage(getPackageName());
                startService(intent);
            }
        });
        ((Button)findViewById(R.id.button25)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(LOG_TAG, "stop service");
                Intent intent = new Intent();
                intent.setAction("com.example.xuweiwei.myulib.app.ACTION01");
                intent.setPackage(getPackageName());
                stopService(intent);
            }
        });
        ((Button)findViewById(R.id.button26)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(LOG_TAG, "bind service");
                Intent intent = new Intent();
                intent.setAction("com.example.xuweiwei.myulib.app.ACTION01");
                intent.setPackage(getPackageName());
                bindService(intent, mConnection, BIND_AUTO_CREATE);
            }
        });
        ((Button)findViewById(R.id.button27)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(LOG_TAG, "unbind service");
                if (mConnection != null) {
                    unbindService(mConnection);
                    mConnection = null;
                }
            }
        });
    }
}
