package com.example.sahilnishal.acm_treasurehunt;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Start extends Activity {

    Intent intent;
    Button button;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        intent = getIntent();
        textView = (TextView)findViewById(R.id.team_id);
        button = (Button)findViewById(R.id.timestart);

        final Integer team_id = intent.getExtras().getInt("team_ID");
        textView.append(team_id.toString());

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getBaseContext(),Question.class);
                i.putExtra("team_ID",team_id);
                startActivity(i);
            }
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu2, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(final MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.testscan) {
            Intent intent_scan = new Intent(getBaseContext(), Scan.class);
            startActivityForResult(intent_scan, 2);
        }
        if (id == R.id.contact) {
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
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode == 2){
            final String qr_code = data.getExtras().getString("code");
            if(qr_code.length() > 0){
                Toast.makeText(getApplicationContext(),"QR Scanner Working properly",Toast.LENGTH_SHORT).show();
            }
        }
    }
}
