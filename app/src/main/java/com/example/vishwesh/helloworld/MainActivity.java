package com.example.vishwesh.helloworld;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {
private VideoView mvideoView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setContentView(R.layout.activity_main);
        mvideoView=(VideoView)findViewById(R.id.v_guideline1);
        Uri uri=Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.bgvideo);
        mvideoView.setVideoURI(uri);
        mvideoView.start();
        mvideoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                mp.setLooping(true);
            }
        });
        ImageView location=findViewById(R.id.logoLocation);
        TextView textLocation=findViewById(R.id.textLocation);
    }

    public void onAddress(View view) {
        String url=getString(R.string.firstLine);
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("geo:37.7749,-122.4192?q="+Uri.encode(url)));
        startActivity(intent);

    }

    public void onMap(View view) {
        String url=getString(R.string.firstLine);
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("geo:37.7749,-122.4192?q="+Uri.encode(url)));
        startActivity(intent);
    }

    public void onDial(View view) {
        String url=getString(R.string.number);
        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:"+url));
        startActivity(intent);
    }

    public void onweb(View view) {
        String url=getString(R.string.web);
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("http://"+url));
        startActivity(intent);
    }

}
