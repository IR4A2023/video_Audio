package esaip.angers;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.Intent;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Toast;

public class Jeu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jeu);

        Intent i = getIntent();
        String games=i.getStringExtra("msg");
        WebView wbJeu= findViewById(R.id.webJeu);
        //activation du javascript
        WebSettings webSettings=wbJeu.getSettings();
        webSettings.setJavaScriptEnabled(true);
        if(games.equals("dj")){
            wbJeu.loadUrl("file:///android_asset/doodleJump/index.html");
        }
        else if(games.equals("fb")){
            wbJeu.loadUrl("file:///android_asset/flappyBird/index.html");
        }
        else if(games.equals("p4")){
            wbJeu.loadUrl("file:///android_asset/puissance4/index.html");
        }
        else {
            Toast.makeText(getApplicationContext(),"Une erreur s'est produite",Toast.LENGTH_SHORT).show();
        }
    }
}