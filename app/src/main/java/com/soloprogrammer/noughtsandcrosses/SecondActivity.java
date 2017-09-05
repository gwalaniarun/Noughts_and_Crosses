package com.soloprogrammer.noughtsandcrosses;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.GridLayout;
import android.widget.ImageView;


public class SecondActivity extends AppCompatActivity {

    MediaPlayer mediaPlayer;

    int myActivePlayer = 0;
    // 0 for cross and 1 for circle
    int[] myGameState = {2,2,2,2,2,2,2,2,2};
    int [][] winningPostions = {{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};




    public void imageTapped(View view) {

        ImageView imageView = (ImageView) view;
        int imageTappedValue = Integer.parseInt(imageView.getTag().toString());
        Log.i("Tapped Value", "Tapped value is " + imageView.getTag().toString());

        mediaPlayer.start();


        if (myGameState[imageTappedValue] == 2) {

            if (myActivePlayer == 0) {

                imageView.setImageResource(R.drawable.cross);
                imageView.animate().rotationBy(360f).setDuration(1000);
                myGameState[imageTappedValue] = myActivePlayer;
                myActivePlayer = 1;

            } else {
                imageView.animate().alphaBy(1).setDuration(500);
                imageView.setImageResource(R.drawable.noughts);
                imageView.animate().alphaBy(1).setDuration(500);
                myGameState[imageTappedValue] = myActivePlayer;
                myActivePlayer = 0;

            }

        } else {
            Log.i("Already Tapped", "Already Tapped on ");
        }


        for (int[] winningPosition : winningPostions) {
            Intent i = new Intent(getApplicationContext(), ThirdActivity.class);

            if (myGameState[winningPosition[0]] == myGameState[winningPosition[1]] &&
                    myGameState[winningPosition[1]] == myGameState[winningPosition[2]] &&
                    myGameState[winningPosition[0]] != 2) {
                if (myGameState[winningPosition[0]] == 1) {

                    i.putExtra("winner", "Circle");

                    startActivity(i);
                }
                    else if (myGameState[winningPosition[0]] == 0) {

                        //cross
                        i.putExtra("winner","Cross");
                        startActivity(i);
                    }

            }


        }
    }

    public void newGame(View view){

        myActivePlayer = 0;
        for (int i=0;i<myGameState.length;i++){
            myGameState[i]=2;
        }
        GridLayout gridLayout = (GridLayout) findViewById(R.id.gridLayout);
        for (int i =0; i < gridLayout.getChildCount(); i++) {
            ((ImageView) gridLayout.getChildAt(i)).setImageResource(R.drawable.tapicon);
        }



    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        mediaPlayer = MediaPlayer.create(this,R.raw.tap);



    }
}
