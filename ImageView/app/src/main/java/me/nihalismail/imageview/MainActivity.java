package me.nihalismail.imageview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        VideoView myVideo=(VideoView)findViewById(R.id.videoView);
        myVideo.setVideoPath("android.resource://"+getPackageName()+"/"+R.raw.video);
        MediaController myController=new MediaController(this);
        myController.setAnchorView(myVideo);
        myVideo.setMediaController(myController);
        myVideo.start();
    }
}
