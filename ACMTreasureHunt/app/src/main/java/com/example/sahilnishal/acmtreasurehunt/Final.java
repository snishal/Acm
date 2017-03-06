package com.example.sahilnishal.acmtreasurehunt;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;

public class Final extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final);
        ImageView i = (ImageView)findViewById(R.id.imageView2);
        i.setImageResource(R.drawable.acm_logo);
    }
}
