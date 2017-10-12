package com.example.android.lifecircle;

import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    MediaPlayer player;
    int postion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.e("mainActivity", "OnCreate");
        player = MediaPlayer.create(this, R.raw.song);
        player.seekTo(postion);

    }

    @Override
    protected void onStart() {
        super.onStart();
        player.start();
    }


    @Override
    protected void onPause() {
        super.onPause();
        Log.e("mainActivity", "OnPause");
        player.pause();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        postion = player.getCurrentPosition();
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(MainActivity.this);
        SharedPreferences.Editor editor = preferences.edit();
        editor.apply();
        player.release();

    }
}
