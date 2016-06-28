package me.nihalismail.musicapp;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    MediaPlayer myPlayer;

    public void playMusic(View view)
    {

        if (myPlayer.isPlaying())
            myPlayer.pause();
        else myPlayer.start();

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myPlayer=MediaPlayer.create(this,R.raw.music);
    }
}
