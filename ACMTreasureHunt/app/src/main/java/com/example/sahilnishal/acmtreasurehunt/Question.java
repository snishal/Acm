package com.example.sahilnishal.acmtreasurehunt;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Question extends Activity {

    TextView textView;
    Button button;
    static int question = 1;
    static int answer = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);

        textView = (TextView)findViewById(R.id.question);
        textView.setText(getIntent().getExtras().getString("question"));
        button = (Button)findViewById(R.id.scan);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),Scan.class);
                startActivityForResult(i,question);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == question){
            if(resultCode == answer){
                final String qr_code = data.getExtras().getString("code");
                if(qr_code.length()>0) {
                    final String solution = qr_code.substring(0, 3);
                    final String next_question = qr_code.substring(3);
                    AlertDialog.Builder alert = new AlertDialog.Builder(this);
                    alert.setTitle("Verify");
                    alert.setMessage("Enter your solution");
                    final EditText sol = new EditText(this);
                    alert.setView(sol);
                    alert.setPositiveButton("Submit", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            // TODO Auto-generated method stub
                            if (sol.getText().toString().equals(solution))
                                textView.setText(next_question);
                            else
                                Toast.makeText(getApplicationContext(), "Wrong Answer", Toast.LENGTH_SHORT).show();
                        }
                    });
                    alert.show();
                }
            }
        }
    }
}
