package com.example.xuweiwei.myulib;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.xuweiwei.myulib.app.AppActivity;
import com.example.xuweiwei.myulib.containers.ContainersActivity;
import com.example.xuweiwei.myulib.custom.CustomActivity;
import com.example.xuweiwei.myulib.datetime.DateTimeActivity;
import com.example.xuweiwei.myulib.expert.ExpertActivity;
import com.example.xuweiwei.myulib.hardware.HardwareActivity;
import com.example.xuweiwei.myulib.layouts.LayoutsActivity;
import com.example.xuweiwei.myulib.software.SoftwareActivity;
import com.example.xuweiwei.myulib.textfield.TextFieldsActivity;
import com.example.xuweiwei.myulib.widgets.WidgetsActivity;

public class MainActivity extends AppCompatActivity
        implements AdapterView.OnItemClickListener {

    final private String LOG_TAG = "MainActivity";
    private ListView mListView;

    final private String[] strItems = new String[] {
            "App",
            "Layouts",
            "Widgets",
            "Text Fields",
            "Containers",
            "Date & Time",
            "Expert",
            "Custom",
            "Hardware",
            "Software"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initListView();
    }

    private void initListView() {
        mListView = (ListView) findViewById(R.id.lv);
        mListView.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, strItems));
        mListView.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Log.d(LOG_TAG, "click " + position);
        Intent intent = null;

        switch (position) {
            case 0:
                intent = new Intent(this, AppActivity.class);
                break;
            case 1:
                intent = new Intent(this, LayoutsActivity.class);
                break;
            case 2:
                intent = new Intent(this, WidgetsActivity.class);
                break;
            case 3:
                intent = new Intent(this, TextFieldsActivity.class);
                break;
            case 4:
                intent = new Intent(this, ContainersActivity.class);
                break;
            case 5:
                intent = new Intent(this, DateTimeActivity.class);
                break;
            case 6:
                intent = new Intent(this, ExpertActivity.class);
                break;
            case 7:
                intent = new Intent(this, CustomActivity.class);
                break;
            case 8:
                intent = new Intent(this, HardwareActivity.class);
                break;
            case 9:
                intent = new Intent(this, SoftwareActivity.class);
                break;
        }

        if (intent != null) {
            startActivity(intent);
        }
    }
}
