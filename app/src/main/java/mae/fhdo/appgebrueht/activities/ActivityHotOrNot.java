package mae.fhdo.appgebrueht.activities;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

import mae.fhdo.appgebrueht.R;
import mae.fhdo.appgebrueht.db.FotoManager;
import mae.fhdo.appgebrueht.entities.*;
import mae.fhdo.appgebrueht.db.RezeptManager;

public class ActivityHotOrNot extends AppCompatActivity {

    Button btnHot;
    Button btnNot;
    ImageView img;
    List<Rezept> rezepte ;
    int ID_idx;
    RezeptManager rman;
    Rezept aRezept;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hot_or_not);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



        btnHot = (Button) findViewById(R.id.btnHot);
        btnNot = (Button) findViewById(R.id.btnNot);
        img = (ImageView) findViewById(R.id.rezeptImage);

        rman = RezeptManager.getInstance(this);
        rezepte = rman.getAllRezept();

        ID_idx = -1;
        rezeptAktualisieren();
    }

    private void rezeptAktualisieren() {
        ID_idx = (ID_idx + 1) % rezepte.size();
        aRezept = rezepte.get(ID_idx);
        FotoManager fMan = FotoManager.getInstance(this);

        Drawable img = (fMan.getFirstFoto(aRezept)).getDrawable(this);

        ((EditText) findViewById(R.id.rezName)).setText(aRezept.getTitel());
        ((ImageView) findViewById(R.id.rezeptImage)).setImageDrawable(img);
    }

    public void onClick (View btn) {
        if(btn.getId() == R.id.btnHot) {
                int likes = aRezept.getLikes();
                likes++;
                aRezept.setLikes(likes);
                rman.updateRezept(aRezept);
        }
        rezeptAktualisieren();
    }

}
