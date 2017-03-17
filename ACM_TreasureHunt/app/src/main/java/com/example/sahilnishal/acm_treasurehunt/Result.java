package com.example.sahilnishal.acm_treasurehunt;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class Result extends Activity {

    TextView t;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        Intent i = getIntent();
        t = (TextView)findViewById(R.id.result_time);
        t.setText(i.getExtras().getString("timings"));
    }
    
}
