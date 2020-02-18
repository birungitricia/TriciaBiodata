package com.example.triciabiodata;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button music=(Button)findViewById(R.id.btnmusic);
        music.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,mac.class);
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

}
