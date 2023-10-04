package esaip.angers;

import static android.widget.Toast.LENGTH_SHORT;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
EditText login, mdp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //reupereration des widgets
        login= findViewById(R.id.login);
        mdp=findViewById(R.id.pwd);
    }
    public void clickValider(View v){
        if(login.getText().toString().equals(getResources().getString(R.string.loginok)) &&
        mdp.getText().toString().equals(getResources().getString(R.string.mdpok))){
            Intent i= new Intent(MainActivity.this, Accueil.class);
            i.putExtra("msg",login.getText().toString());
            startActivity(i);
        }
        else {
            Toast t = Toast.makeText(MainActivity.this, "Erreur Authentification", Toast.LENGTH_SHORT);
            t.show();
            this.effacer(v);
        }
    }
    public void effacer(View v){

        //TODO effacer les champs login et pwd
        login.setText("");
        mdp.setText("");
    }
    public void quitter(View v){
        finish();
    }
}