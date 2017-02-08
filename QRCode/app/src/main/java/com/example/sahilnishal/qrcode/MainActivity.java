package com.example.sahilnishal.qrcode;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.SparseArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.vision.Frame;
import com.google.android.gms.vision.barcode.Barcode;
import com.google.android.gms.vision.barcode.BarcodeDetector;

public class MainActivity extends AppCompatActivity {

    ImageView i;
    TextView t;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        i = (ImageView)findViewById(R.id.imageView);
        t = (TextView)findViewById(R.id.textView);

    }

    public void click(View v){

        t.setText("hello");

        Bitmap mybitmap = BitmapFactory.decodeResource(getApplicationContext().getResources(),R.drawable.text);
        i.setImageBitmap(mybitmap);

        BarcodeDetector detector = new BarcodeDetector.Builder(getApplicationContext()).setBarcodeFormats(Barcode.QR_CODE).build();
        if(!detector.isOperational()){
            t.setText("Could not setu the detector");
            return;
        }

        Frame frame = new Frame.Builder().setBitmap(mybitmap).build();
        SparseArray<Barcode> barcodes = detector.detect(frame);

        Barcode thisCode = barcodes.valueAt(0);
        t.setText(thisCode.rawValue);
    }

}
