package com.example.evaluacion2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.MediaController;
import android.widget.VideoView;

public class InfoAct extends AppCompatActivity {

    private VideoView vV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        vV = (VideoView)findViewById(R.id.vdv);
        String ruta = "android.resource://" + getPackageName() + "/" + R.raw.video;
        Uri uri = Uri.parse(ruta);
        vV.setVideoURI(uri);

        MediaController mediaController = new MediaController(this);
        vV.setMediaController(mediaController);

    }

    public void Maps (View v)
    {
        Intent i = new Intent(this, MapsAct.class);
        startActivity(i);
    }
}