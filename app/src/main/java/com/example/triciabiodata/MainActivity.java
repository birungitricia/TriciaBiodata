package com.example.triciabiodata;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.provider.Settings;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button startservice,stopservice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final MediaPlayer player =MediaPlayer.create(this, Settings.System.DEFAULT_RINGTONE_URI);
        player.setLooping(true);

        startservice =findViewById(R.id.startservice);
        stopservice =findViewById(R.id.stopservice);
        startservice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                player.start();
            }
        });

        stopservice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                player.stop();
            }
        });
        Button music=(Button)findViewById(R.id.btnmusic);
        music.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,mac.class);
                startActivity(intent);
            }
        });
        Button cro=(Button)findViewById(R.id.btnc);
        cro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,taso.class);
                startActivity(intent);
            }
        });
    }
    public void sendMessage(View view){
        EditText message = (EditText)findViewById(R.id. message);
        Intent intent=new Intent(this,DisplayMessageActivity.class);
        intent.putExtra("MESSAGE",message.getText().toString());
        startActivity(intent);
        message.setText("");

        Toast.makeText(this, "sending message", Toast.LENGTH_SHORT).show();
    }
    public boolean onCreateOptionsMenu(Menu Menu2) {
        MenuInflater inflateMenu = getMenuInflater();
        inflateMenu.inflate(R.menu.information, Menu2);
        return true;
    }
    public boolean onOptionsItemSelected(MenuItem item){


            switch (item.getItemId()){
                case  R.id.btnmarket:
                    startActivity(new Intent(this,menu.class));
                    return true;
                case R.id.btnshop:
                    startActivity(new Intent(this,menu2.class));
                    return true;
                case R.id.hotel:
                    startActivity(new Intent(this,listview.class));
                    return true;

                    default:

            return super.onContextItemSelected(item);
        }

    }
}
