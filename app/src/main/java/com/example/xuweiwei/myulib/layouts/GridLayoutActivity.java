package com.example.xuweiwei.myulib.layouts;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.xuweiwei.myulib.R;

public class GridLayoutActivity extends AppCompatActivity {
    private static final String LOG_TAG = "GridLayoutActivity";
    private Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_layout);
        btn = (Button) findViewById(R.id.button78);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(GridLayoutActivity.this, Excel2DemoActivity.class);
                startActivity(intent);
            }
        });
    }
}
