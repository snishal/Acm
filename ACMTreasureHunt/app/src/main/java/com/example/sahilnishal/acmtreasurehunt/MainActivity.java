package com.example.sahilnishal.acmtreasurehunt;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText editText;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = (EditText)findViewById(R.id.editText);
        button = (Button)findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String team_id = editText.getText().toString();
                if(team_id.length()>0){
                    Intent i = new Intent(getApplicationContext(),Question.class);
                    i.putExtra("team_id",team_id);
                    startActivity(i);
                }
                else{
                    Toast.makeText(getApplicationContext(),"Enter Team ID",Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
