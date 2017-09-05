package com.soloprogrammer.noughtsandcrosses;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ThirdActivity extends AppCompatActivity {

    public void playAgain(View view){
        Intent newGame = new Intent(getApplicationContext(),SecondActivity.class);
        startActivity(newGame);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        MediaPlayer mediaPlayer = MediaPlayer.create(this,R.raw.win);

        mediaPlayer.start();

        Intent iThird = getIntent();
        String winner  = iThird.getStringExtra("winner");
        TextView myWinner = (TextView) findViewById(R.id.myWinner);
        myWinner.setText(winner+" has Won!");






    }
}
