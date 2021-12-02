package com.example.starwars.activityview;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.MediaController;
import android.widget.VideoView;

import com.example.starwars.R;

public class PlayerVideoUrl extends AppCompatActivity {
    private VideoView videoView2;
    String videoUrl2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player_video);
        getSupportActionBar().hide();
        videoUrl2 = "https://embedvideoonwebsite.github.io/data/images/happyfit2.mp4";
        videoView2 = findViewById(R.id.videoView);

        //videoView.setMediaController(new MediaController(this));
        //devine execução de uma url
        videoView2.setVideoURI(Uri.parse(videoUrl2));
        videoView2.setMediaController(new MediaController(this));
        videoView2.requestFocus();
        videoView2.start();
        View decorView = getWindow().getDecorView();
        int uiOpton = View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOpton);
    /*
      videoView.setVideoPath("android.resource://" + getPackageName() + "/" + R.raw.videostar);
      videoView.start();
        View decorView = getWindow().getDecorView();
        int uiOpton = View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOpton);
*/
    }
}