package com.example.starwars.activityview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.SeekBar;

import com.example.starwars.PrincipalDrawerNav;
import com.example.starwars.R;

public class FilmeMusica extends AppCompatActivity {
    private MediaPlayer mediaPlayer;
    private SeekBar seekBarVolume;
    private AudioManager audioManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filme_musica);
        getSupportActionBar().hide();
        mediaPlayer = MediaPlayer.create(getApplicationContext(),R.raw.starwarsmusic);
        incializaSeekBar();
    }
    private  void incializaSeekBar(){
        seekBarVolume = findViewById(R.id.seekBarVolume);
        //recupera volume do usuario
        audioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);
        int volumeMaximo = audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
        int volumeAtual = audioManager.getStreamVolume(AudioManager.STREAM_MUSIC);

        seekBarVolume.setMax( volumeMaximo);
        seekBarVolume.setProgress(volumeAtual);
        seekBarVolume.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                audioManager.setStreamVolume(AudioManager.STREAM_MUSIC, i, AudioManager.FLAG_SHOW_UI);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    public void exucutaSom(View view){
        if ( mediaPlayer != null){
            mediaPlayer.start();
        }
    }
    public void pausarMusica(View view){
        if ( mediaPlayer.isPlaying()){
            mediaPlayer.pause();
        }
    }
    public void pararMusica(View view){
            if ( mediaPlayer.isPlaying() ){
                mediaPlayer.stop();
                mediaPlayer = MediaPlayer.create(getApplicationContext(),R.raw.starwarsmusic);
            }
    }
    @Override
    protected void onDestroy(){
        super.onDestroy();
        if(mediaPlayer != null && mediaPlayer.isPlaying()){
            mediaPlayer.stop();
            mediaPlayer.release();
            mediaPlayer = null;
        }

    }
    public void abrirVideo(View view){
        Intent intent = new Intent(FilmeMusica.this, PlayerVideo.class);
        startActivity(intent);
    }
    public  void voltarPrincipal(View view){

        Intent intent = new Intent(FilmeMusica.this, PrincipalDrawerNav.class);
        startActivity(intent);
    }

}