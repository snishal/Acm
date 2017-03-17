package com.example.sahilnishal.acm_treasurehunt;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class Team_ID extends Activity {

    EditText editText;
    Button button;
    ImageView i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_team__id);

        i = (ImageView)findViewById(R.id.imageView);
        i.setImageResource(R.drawable.acm_logo);
        editText = (EditText)findViewById(R.id.editText);

        button = (Button)findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String team_id = editText.getText().toString();
                if(isValid(team_id)){
                    int team = team_id.charAt(7)-48;
                    Intent intent = new Intent(getApplicationContext(),Start.class);
                    Bundle b = new Bundle();
                    b.putInt("team_ID",team);
                    intent.putExtras(b);
                    startActivity(intent);
                    finish();
                }
                else{
                    Toast.makeText(getApplicationContext(),"Enter Valid Team ID",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public boolean isValid(String team_id){
        if(team_id.length() > 7 && team_id.length() < 9){
            if(team_id.substring(0,7).equals("acmth17")){
                if(((team_id.charAt(7)-48) > 0) && ((team_id.charAt(7)-48) < 8) ){
                    return true;
                }
                else return false;
            }
            else return false;
        }
        else return false;
    }
}
