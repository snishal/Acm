package com.example.sahilnishal.acmtreasurehunt;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends Activity {

    EditText editText;
    Button button;
    ImageView i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        i = (ImageView)findViewById(R.id.imageView);
        i.setImageResource(R.drawable.acm_logo);
        editText = (EditText)findViewById(R.id.editText);
        final Intent intent = getIntent();
        this.setResult(1,intent);
        button = (Button)findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String team_id = editText.getText().toString();
                if(team_id.length()>0){
                    int team = Integer.parseInt(team_id.substring(6));
                    intent.putExtra("team_id",team);
                    finish();
                }
                else{
                    Toast.makeText(getApplicationContext(),"Enter Team ID",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

}
