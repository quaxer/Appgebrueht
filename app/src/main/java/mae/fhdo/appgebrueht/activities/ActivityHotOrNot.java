package mae.fhdo.appgebrueht.activities;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import java.util.List;

import mae.fhdo.appgebrueht.R;
import mae.fhdo.appgebrueht.db.FotoManager;
import mae.fhdo.appgebrueht.db.RezeptManager;
import mae.fhdo.appgebrueht.entities.Rezept;

public class ActivityHotOrNot extends AppCompatActivity {


    private List<Rezept> rezepte;
    private int ID_idx;
    private RezeptManager rman;
    private Rezept aRezept;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hot_or_not);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        rman = RezeptManager.getInstance(this);
        rezepte = rman.getAllRezept();

        ID_idx = -1;
        rezeptAktualisieren();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.nav, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        switch (item.getItemId())
        {
            case R.id.menu_rezepte:
                startActivity(new Intent(this, ActivityRezeptUebersicht.class));
                //Toast.makeText(ActivityRezeptUebersicht.this, "Rezept Übersicht ist ausgewählt", Toast.LENGTH_SHORT).show();
                return true;

            case R.id.menu_hot_or_not:
                if(this.getClass() != ActivityHotOrNot.class) {
                    startActivity(new Intent(this, ActivityHotOrNot.class));
                }
                //Toast.makeText(ActivityRezeptUebersicht.this, "Hot or Not ist ausgewählt", Toast.LENGTH_SHORT).show();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }




    private void rezeptAktualisieren() {
        ID_idx = ((ID_idx + 1) % rezepte.size());
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
