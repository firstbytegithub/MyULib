package com.example.xuweiwei.myulib.software;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.AnimationUtils;

import com.example.xuweiwei.myulib.R;

public class DemoAnimation extends Activity implements View.OnClickListener {

    private View t;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo_animation);
        t = findViewById(R.id.editText);

        View v = findViewById(R.id.button6);
        v.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Log.d("xxx", "shake3");
        t.startAnimation(AnimationUtils.loadAnimation(DemoAnimation.this, R.anim.shake));
//        t.startAnimation(AnimationUtils.loadAnimation(DemoAnimation.this, R.anim.translate));
        v.startAnimation(AnimationUtils.loadAnimation(DemoAnimation.this, R.anim.shake));
    }
}
