package com.example.triciabiodata;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.widget.Button;

public class menu extends AppCompatActivity implements View.OnClickListener {
    private Button start,stop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        start=(Button) findViewById(R.id.btnStart);
        stop=(Button) findViewById(R.id.btnStop);

        start.setOnClickListener(this);
        stop.setOnClickListener(this);


        MediaPlayer player =MediaPlayer.create(this, Settings.System.DEFAULT_RINGTONE_URI);
        player.setLooping(true);
        player.start();


    }

    @Override
    public void onClick(View view) {
     if (view == start){
         startService(new Intent(this,BioService.class));

     }else if (view==stop){
         stopService(new Intent(this,BioService.class));
     }

    }
}
