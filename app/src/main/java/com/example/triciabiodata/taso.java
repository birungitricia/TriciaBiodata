package com.example.triciabiodata;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.AssetManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;

public class taso extends AppCompatActivity {
     TextView cprogram;
     Button read;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_taso);
        cprogram=findViewById(R.id.btnrun);
        read=findViewById(R.id.btnrun);
        read.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String c="";
                try {

                    InputStream inputStream=getAssets().open("cprog.c");
                    int cp=inputStream.available();
                    byte[] program=new byte[cp];
                    inputStream.read(program);
                    inputStream.close();
                    c=new String(program);
                }catch (IOException e){
                    e.printStackTrace();
                }
                cprogram.setText((CharSequence) c);

            }

        });


}}
