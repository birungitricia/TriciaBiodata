package com.example.triciabiodata;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class mac extends AppCompatActivity {

    private static final String FILE_NAME ="example.txt";
    EditText mEditText;
    Button stop;
    Button play;
    MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mac);

        mEditText=findViewById(R.id.storage);

        play=(Button) findViewById(R.id.play);
        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer=MediaPlayer.create(getApplicationContext(),R.raw.nekwatako);
               mediaPlayer.start();
            }
        });
        stop=(Button)findViewById(R.id.stop);
        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                    mediaPlayer.stop();
                }




        });
    }
    public void save(View m){
     String text=mEditText.getText().toString();
        FileOutputStream f=null;
        try {
            f=openFileOutput(FILE_NAME,MODE_PRIVATE);
            f.write(text.getBytes());
            mEditText.getText().clear();
            Toast.makeText(this,"Saved to" + getFilesDir() + "/" + FILE_NAME, Toast.LENGTH_LONG).show();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            if (f!=null){
                try {
                    f.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
    }
    public void load(   View m){
        FileInputStream s=null;
        try {
            s=openFileInput(FILE_NAME);
            InputStreamReader is=new InputStreamReader(s);
            BufferedReader br=new BufferedReader(is);
            StringBuilder sb=new StringBuilder();
            String text;

            while ((text=br.readLine())!=null){
                sb.append(text).append("\n");
            }
            mEditText.setText(sb.toString());

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            if (s!=null){
                try {
                    s.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
