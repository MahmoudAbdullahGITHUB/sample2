package com.examples.youtubeapidemo;

import android.app.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerFragment;
import com.google.android.youtube.player.YouTubePlayerView;

public class MyActivity extends YouTubeBaseActivity
        implements YouTubePlayer.OnInitializedListener {

    private static String VID = "F_dwxC-DtIc";
    private static String VID2 = "W4hTJybfU7s";
    private static final int rec = 1;

    YouTubePlayerFragment myYouTubePlayerFragment;
    YouTubePlayerFragment myYouTubePlayerFragment2;

    ImageView im1;
    ImageView im2;
    TextView tx1;
    TextView tx2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);

        myYouTubePlayerFragment = (YouTubePlayerFragment) getFragmentManager()
                .findFragmentById(R.id.frg1);
        myYouTubePlayerFragment.initialize(DeveloperKey.DEVELOPER_KEY,this);

        myYouTubePlayerFragment2 = (YouTubePlayerFragment) getFragmentManager()
                .findFragmentById(R.id.frg2);
        myYouTubePlayerFragment2.initialize(DeveloperKey.DEVELOPER_KEY,this);

        im1 = findViewById(R.id.im1);
        im2 = findViewById(R.id.im2);
        tx1 = findViewById(R.id.tx1);
        tx2 = findViewById(R.id.tx2);

        tx1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                VID = "AmnXOwjMWKg";
                System.out.println("VID "+VID);

            }
        });
    }

    @Override
    public void onInitializationSuccess(YouTubePlayer.Provider provider
            ,YouTubePlayer youTubePlayer, boolean b) {

        if(!b){
            youTubePlayer.cueVideo(VID);
            
        }
    }

    @Override
    public void onInitializationFailure(YouTubePlayer.Provider provider
            , YouTubeInitializationResult youTubeInitializationResult) {
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == rec){
            getYoutubePlayerProvider().initialize(DeveloperKey.DEVELOPER_KEY,this);

            YouTubePlayer.Provider provider = new YouTubePlayerFragment();
            YouTubePlayer.Provider provider2 = new YouTubePlayerFragment();

            provider =  findViewById(R.id.frg1);
            provider2 =  findViewById(R.id.frg2);

            provider.initialize(DeveloperKey.DEVELOPER_KEY,this);
            provider2.initialize(DeveloperKey.DEVELOPER_KEY,this);


        }
    }

    protected YouTubePlayer.Provider getYoutubePlayerProvider(){
        return (YouTubePlayerView)findViewById(R.id.frg1);
    }

}