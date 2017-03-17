package com.example.sahilnishal.acm_treasurehunt;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.text.format.Time;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Question extends Activity {

    Time t;
    TextView textView;
    Button button;

    private TextView timerValue;
    private long startTime = 0L;
    private Handler customHandler = new Handler();
    long timeInMilliseconds = 0L;
    long timeSwapBuff = 0L;
    long updatedTime = 0L;
    static int question = 1;
    static int answer = 1;
    static int first = 2;
    int current_question;
    String time;
    int team_id;
    static final String questions[][] = {{"Set1Question1", "Set1Question2", "Set1Question3", "Set1Question4", "Set1Question5"},
            {"Set2Question1", "Set2Question2", "Set2Question3", "Set2Question4", "Set2Question5"},
            {"Set3Question1", "Set3Question2", "Set3Question3", "Set3Question4", "Set3Question5"}};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);

        timerValue = (TextView) findViewById(R.id.timer);
        startTime = SystemClock.uptimeMillis();
        customHandler.postDelayed(updateTimerThread, 0);


        textView = (TextView) findViewById(R.id.question);
        button = (Button) findViewById(R.id.scan);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), Scan.class);
                startActivityForResult(i, question);
            }
        });
        SharedPreferences pref = this.getPreferences(Context.MODE_PRIVATE);
        current_question = pref.getInt(getString(R.string.cq),-1);
        team_id = pref.getInt(getString(R.string.td),-2);
        time = pref.getString(getString(R.string.time),"0");

        if (team_id == -2) {
            Intent i = getIntent();
            current_question = 0;
            team_id = i.getExtras().getInt("team_ID") - 1;
            Toast.makeText(this,""+team_id,Toast.LENGTH_SHORT).show();
            textView.setText(questions[team_id][current_question]);
            t = new Time();
            t.setToNow();
            time = team_id + "\n\n" + t.toString().substring(0, 15) + "\n\n";
            SharedPreferences prefs = this.getPreferences(Context.MODE_PRIVATE);
            SharedPreferences.Editor edit = prefs.edit();
            edit.putInt(getString(R.string.td), team_id);
            edit.putString(getString(R.string.time), time);
            edit.commit();
        }else{
            textView.setText(questions[team_id][current_question]);
        }

    }

    private Runnable updateTimerThread = new Runnable() {
        public void run() {
            timeInMilliseconds = SystemClock.uptimeMillis() - startTime;
            updatedTime = timeSwapBuff + timeInMilliseconds;
            int secs = (int) (updatedTime / 1000);
            int mins = secs / 60;
            secs = secs % 60;
            int milliseconds = (int) (updatedTime % 1000);
            timerValue.setText("" + mins + ":"
                            + String.format("%02d", secs) + ":"
                            + String.format("%03d", milliseconds));
            customHandler.postDelayed(this, 0);
        }
    };


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == question) {
            if (resultCode == answer) {
                final String qr_code = data.getExtras().getString("code");
                if (qr_code.length() > 0) {
                    if (current_question == 4 && qr_code.equals("Finish")) {
                        Intent i = new Intent(getBaseContext(), Final.class);
                        startActivity(i);
                    } else if (qr_code.equals(questions[team_id][current_question + 1])) {
                        current_question++;
                        textView.setText(questions[team_id][current_question]);
                        t = new Time();
                        t.setToNow();
                        time += t.toString().substring(0, 15) + "\n\n";
                        Toast.makeText(getApplicationContext(), "Congrats Next Level", Toast.LENGTH_SHORT).show();
                    } else
                        Toast.makeText(getApplicationContext(), "Wrong Location", Toast.LENGTH_SHORT).show();
                }
            }
        }
        if(requestCode == 2){
            final String qr_code = data.getExtras().getString("code");
            if(qr_code.length() > 0){
                Toast.makeText(getApplicationContext(),"QR Scanner Working properly",Toast.LENGTH_SHORT).show();
            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(final MenuItem item) {

        int item_id = item.getItemId();
        if(item_id == R.id.time || item_id == R.id.reset) {
            final AlertDialog.Builder alert = new AlertDialog.Builder(this);
            alert.setTitle("Key");
            alert.setMessage("Enter key if you wish to continue");
            final EditText key = new EditText(this);
            alert.setView(key);
            alert.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    // TODO Auto-generated method stub
                    if (key.getText().toString().equals("admin")) {
                        int id = item.getItemId();
                        if (id == R.id.time) {
                            Intent i = new Intent(getBaseContext(), Result.class);
                            i.putExtra("timings", time);
                            startActivity(i);
                        } else if (id == R.id.reset) {
                            SharedPreferences sharedPreferences = getSharedPreferences("ActivityPREF", Context.MODE_PRIVATE);
                            SharedPreferences.Editor ed = sharedPreferences.edit();
                            ed.putBoolean("welcome_executed", false);
                            ed.commit();
                            team_id = -2;
                            finish();
                        }

                    }
                }
            });
            alert.show();
        }

        else if(item_id == R.id.contact){
            final AlertDialog.Builder alert = new AlertDialog.Builder(this);
            alert.setTitle("Contact Us");
            alert.setMessage("Sahil : 9467918415 \n\n Rashad : 7289975258");
            alert.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                }
            });
            alert.show();
        }

        else if(item_id == R.id.testscan){
            Intent intent_scan = new Intent(getBaseContext(), Scan.class);
            startActivityForResult(intent_scan, 2);
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onPause() {
        super.onPause();
        SharedPreferences prefs = this.getPreferences(Context.MODE_PRIVATE);
        SharedPreferences.Editor edit = prefs.edit();
        edit.putInt(getString(R.string.td),team_id);
        edit.putInt(getString(R.string.cq),current_question);
        edit.putString(getString(R.string.time),time);
        edit.commit();
    }

}
