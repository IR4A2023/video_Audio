package esaip.angers;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.provider.AlarmClock;
import android.view.View;
import android.widget.Toast;

import androidx.core.view.WindowCompat;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import esaip.angers.databinding.ActivityAccueilBinding;

public class Accueil extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accueil);
        //recuperation du message (login)
        Intent i = getIntent();
        String login = i.getStringExtra("msg");
        // Affichage du message de bienvenu
        Toast t = Toast.makeText(Accueil.this, "Bienvenue " + login, Toast.LENGTH_SHORT);
        t.show();
    }

    public void appel(View v) {
        startActivity(new Intent(Intent.ACTION_DIAL, Uri.parse("tel:0612457845")));
        //TODO definir les permission dans le fichier AndroidManifest
        //<uses-permission android:name="android.permission.CALL_PHONE"/>
    }

    public void email(View v) {
        Intent email = new Intent(Intent.ACTION_SEND);
        email.putExtra(Intent.EXTRA_EMAIL, new String[]{"destinataire@free.fr"});
        email.putExtra(Intent.EXTRA_SUBJECT, "sujet du mail");
        email.putExtra(Intent.EXTRA_TEXT, "texte du message");
        email.setType("message/rfc822");
        startActivity(email);
        //TODO definir les permission dans le fichier AndroidManifest
        // <uses-permission android:name="android.permission.INTERNET"/>


    }

    public void alarme(View v) {
        Intent i = new Intent(AlarmClock.ACTION_SET_ALARM);
        i.putExtra(AlarmClock.EXTRA_MESSAGE, "Alamre 19H00");
        i.putExtra(AlarmClock.EXTRA_HOUR, 19);
        i.putExtra(AlarmClock.EXTRA_MINUTES, 00);
    }

    public void esaip(View v) {
      String url = "https://esaip.org";
      Intent i = new Intent(Intent.ACTION_VIEW);
      i.setData(Uri.parse(url));
      startActivity(i);
    }

    public void video(View v) {
    Intent i = new Intent(Accueil.this, Video.class);
    startActivity(i);

    }
    public void sendIntent(String msg){
        //chargement du fichier son
        MediaPlayer mp=MediaPlayer.create(Accueil.this,R.raw.berreta);
        //lecture du fichier
        mp.start();
        //lancement de l'intentpour declencher l'activity jeu
        Intent i=new Intent(Accueil.this,Jeu.class);
        i.putExtra("msg",msg);
        startActivity(i);


    }
    public void actFB(View v){sendIntent("fb");}
    public void actDJ(View v){sendIntent("dj");}
    public void actP4(View v){sendIntent("p4");}
    public void closeAll(View v){
        finishAffinity();
    }
}

