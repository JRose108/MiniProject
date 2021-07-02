package com.example.miniproject;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;


import androidx.appcompat.app.AppCompatActivity;

import android.view.View;

import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import androidmads.library.qrgenearator.QRGContents;
import androidmads.library.qrgenearator.QRGEncoder;

public class MainActivity extends AppCompatActivity {
    EditText qrvalue;
    Button generatebtn, scanbtn;
    ImageView qrImage;

@Override
    protected void onCreate(Bundle savedInstanceState){
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    qrvalue = findViewById(R.id.qrinput);
    generatebtn = findViewById(R.id.generate);
    scanbtn = findViewById(R.id.scan);
    qrImage = findViewById(R.id.qrimageView);

    generatebtn.setOnClickListener(new View.OnClickListener(){
        @Override
        public void onClick(View v){
            String data = qrvalue.getText().toString();
            QRGEncoder qrgEncoder = new QRGEncoder(data,null, QRGContents.Type.TEXT,10);
            try{
                Bitmap qrbits = qrgEncoder.getBitmap();
                qrImage.setImageBitmap(qrbits);
            }catch (Exception e){
                e.printStackTrace();
            }

        }


        });
    scanbtn.setOnClickListener(new View.OnClickListener(){
        @Override
        public void onClick(View v){
            startActivity(new Intent(getApplicationContext(),Scanner.class));
        }
    });
}
}