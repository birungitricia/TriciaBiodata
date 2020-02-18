package com.example.triciabiodata;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class mac extends AppCompatActivity {
    Button stop;
    Button play;
    MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mac);
        play=findViewById(R.id.play);
        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer=MediaPlayer.create(getApplicationContext(),R.raw.nekwatako);
               mediaPlayer.start();
            }
        });
        stop=(Button) findViewById(R.id.stop);
        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mediaPlayer != null && mediaPlayer.isPlaying()){
                    mediaPlayer.stop();
                }
            }
        });
    }

}
