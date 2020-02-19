package com.example.triciabiodata;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.AssetManager;
import android.os.Bundle;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;

public class taso extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_taso);
        TextView textView=findViewById(R.id.btnrun);
        AssetManager assetManager=getAssets();
        InputStream files;
        {
            try {

               files=assetManager.open("Android programing is good.c");
            }catch (IOException e){
             e.printStackTrace();
            }
           // textView.setText((CharSequence) files);

        }
    }
}
