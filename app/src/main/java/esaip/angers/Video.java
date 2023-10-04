package esaip.angers;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

public class Video extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);
        // acces au fichier video
        Uri raw_uri = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.bigbunny);
      // recuperation de la widget videoView
        VideoView myVideoView= (VideoView) findViewById(R.id.videoView);
        //affecttion de l'uri à la videoview
        myVideoView.setVideoURI(raw_uri);

        //ajouter un controller
        myVideoView.setMediaController(new MediaController(this));

        //TODO demarrer la video
        myVideoView.start();
        //TODO cabler dans le fichier Accueil le bouton video avec l'activity video
    }
}