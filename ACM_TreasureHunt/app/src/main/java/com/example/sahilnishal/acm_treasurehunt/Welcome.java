package com.example.sahilnishal.acm_treasurehunt;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

public class Welcome extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        Thread timer = new Thread(){
            public void run(){
                try{
                    sleep(5000);
                }
                catch(InterruptedException e){
                }
            }
        };

        SharedPreferences sharedPreferences = getSharedPreferences("ActivityPREF", Context.MODE_PRIVATE);

        if(sharedPreferences.getBoolean("welcome_executed", false) ){
            Intent i = new Intent(getBaseContext(),Question.class);
            startActivity(i);
            finish();
        }
        else {
            timer.start();
            try {
                timer.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            SharedPreferences.Editor ed = sharedPreferences.edit();
            ed.putBoolean("welcome_executed", true);
            ed.commit();
            Intent i = new Intent(getBaseContext(),Team_ID.class);
            startActivity(i);
            finish();
        }

    }
}
