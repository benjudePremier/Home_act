package com.example.home_act;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.MediaController;
import android.widget.VideoView;

public class Menu_act extends AppCompatActivity {
    // Declaraciones de Variables
    private VideoView videoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_act);
        // Aqui llomo el elemento por id
        videoView = (VideoView) findViewById(R.id.vd);


        videoView.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.video)); // ruta del video
        // control de la navigacion
        MediaController media = new MediaController(this);
        videoView.setMediaController(media);
        videoView.start();
    }

    public void Promociones(View v){
        Intent i = new Intent(this,firebase_act.class);
        startActivity(i);

    }
    }

