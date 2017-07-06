package mae.fhdo.appgebrueht.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import mae.fhdo.appgebrueht.R;
import mae.fhdo.appgebrueht.activities.adapter.ImageAdapter;
import mae.fhdo.appgebrueht.db.RezeptManager;
import mae.fhdo.appgebrueht.entities.Rezept;

public class ActivityRezeptDetailansicht extends AppCompatActivity {

    private Rezept rezept;
    private RezeptManager rezeptManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rezept_detailansicht);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        Intent intent = this.getIntent();
        int rezeptId = intent.getIntExtra("rezeptId", -1);

        if (rezeptId < 0) {
            Toast.makeText(this, "Rezept-ID ist ungültig - kehre zur Rezeptliste zurück", Toast.LENGTH_SHORT).show();
            this.finish();
        } else {

            // Rezeptdaten aus der DB holen
            this.rezeptManager = RezeptManager.getInstance(this);
            this.rezept = rezeptManager.getRezeptById(rezeptId);

            // Rezept-Entity-Attribute auf der Oberfläche anzeigen
            this.rezeptAnzeigen();
        }

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
                startActivity(new Intent(this, ActivityHotOrNot.class));
                //Toast.makeText(ActivityRezeptUebersicht.this, "Hot or Not ist ausgewählt", Toast.LENGTH_SHORT).show();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }





    public void onFoto(View view) {
        // TODO Start Kamera
        Toast.makeText(this, "Foto wurde eingestellt", Toast.LENGTH_SHORT).show();
        this.rezeptManager.updateRezept(this.rezept);
    }

    public void onLike(View view) {
        Toast.makeText(this, "Wurde gelikt", Toast.LENGTH_SHORT).show();
        this.rezept.setLikes(this.rezept.getLikes() + 1);
        this.rezeptManager.updateRezept(this.rezept);
        this.rezeptAnzeigen();
    }


    private void rezeptAnzeigen(){
        // Rezeptdaten auf View-Komponenten setzen

        // Rezept-Fotos
        // HIER NUR BEISPIELHAFT - TODO Implementierung
        int[] fotos = new int[]{
                R.drawable.first,
                R.drawable.second,
                R.drawable.third,
                R.drawable.fourth
        };
        ViewPager rezeptFotos = (ViewPager) findViewById(R.id.rezeptFotos);
        ImageAdapter adapter = new ImageAdapter(this, fotos);
        rezeptFotos.setAdapter(adapter);

        // Rezept-Titel
        TextView rezeptTitel = (TextView) findViewById(R.id.rezeptTitel);
        rezeptTitel.setText(rezept.getTitel());

        // Rezept-Likes
        TextView rezeptLikes = (TextView) findViewById(R.id.rezeptLikes);
        rezeptLikes.setText("Likes: " + rezept.getLikes());

        // Rezept-Beschreibung
        TextView rezeptBeschreibung = (TextView) findViewById(R.id.rezeptBeschreibung);
        rezeptBeschreibung.setText(rezept.getBeschreibung());
    }


}
