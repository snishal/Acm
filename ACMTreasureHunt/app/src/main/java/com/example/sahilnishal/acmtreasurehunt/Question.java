package com.example.sahilnishal.acmtreasurehunt;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
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
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == question) {
            if (resultCode == answer) {
                final String qr_code = data.getExtras().getString("code");
                if (qr_code.length() > 0) {
                    if(current_question==4 && qr_code.equals("Finish")){
                        Intent i = new Intent(this,Final.class);
                        startActivity(i);
                    }
                    else if (qr_code.equals(questions[team_id][current_question+1])) {
                        current_question++;
                        textView.setText(questions[team_id][current_question]);
                        t = new Time();
                        t.setToNow();
                        time += t.toString().substring(0,15) + "\n\n";
                        Toast.makeText(getApplicationContext(), "Congrats Next Level", Toast.LENGTH_SHORT).show();
                    } else
                        Toast.makeText(getApplicationContext(), "Wrong Location", Toast.LENGTH_SHORT).show();
                }
            }
        }

        else if(requestCode==first)

        {
            if (resultCode == answer) {
                current_question = 0;
                team_id = data.getExtras().getInt("team_id");
                textView.setText(questions[team_id][current_question]);
                t = new Time();
                t.setToNow();
                time = team_id + "\n\n" + t.toString().substring(0, 15) + "\n\n";
                SharedPreferences prefs = this.getPreferences(Context.MODE_PRIVATE);
                SharedPreferences.Editor edit = prefs.edit();
                edit.putInt(getString(R.string.td),team_id);
                edit.putString(getString(R.string.time),time);
                edit.commit();

            }
        }

}

    @Override
    protected void onResume() {
        super.onResume();
        if (team_id == -2) {
            Intent i = new Intent(this, MainActivity.class);
            startActivityForResult(i, first);
        }else{
            textView.setText(questions[team_id][current_question]);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(final MenuItem item) {

        final AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setTitle("Key");
        alert.setMessage("Enter key if you wish to continue");
        final EditText key = new EditText(this);
        alert.setView(key);
        alert.setPositiveButton("OK", new DialogInterface.OnClickListener(){
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // TODO Auto-generated method stub
                if(key.getText().toString().equals("admin")){
                    int id = item.getItemId();
                    if (id == R.id.time) {
                        Intent i = new Intent(getBaseContext(),Result.class);
                        i.putExtra("timings", time);
                        startActivity(i);
                    } else if (id == R.id.reset) {
                        team_id = -2;
                        finish();
                    }
                }
            }
        });
        alert.show();

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
