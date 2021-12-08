package com.example.starwars.activityview;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.MediaController;
import android.widget.VideoView;

import com.example.starwars.R;

public class PlayerVideo extends AppCompatActivity {
    private VideoView videoView;
    String videoUrl2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player_video);
        getSupportActionBar().hide();

        getSupportActionBar().hide();
        videoUrl2 = "https://waie.com.br/starwars/Filmes/VID-20211130-WA0000.mp4";
        videoView = findViewById(R.id.videoView);

        //videoView.setMediaController(new MediaController(this));
        //devine execução de uma url
        videoView.setVideoURI(Uri.parse(videoUrl2));
        videoView.setMediaController(new MediaController(this));
        videoView.requestFocus();
        videoView.start();
        View decorView = getWindow().getDecorView();
        int uiOpton = View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOpton);




        //video local raw
        /*
        videoView = findViewById(R.id.videoView);
        videoView.setMediaController(new MediaController(this));
        videoView.setVideoPath("android.resource://" + getPackageName() + "/" + R.raw.videostar);
        videoView.start();
        View decorView = getWindow().getDecorView();
        int uiOpton = View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOpton);
        */
    }
}