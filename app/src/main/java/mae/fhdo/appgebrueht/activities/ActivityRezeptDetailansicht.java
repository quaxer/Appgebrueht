package mae.fhdo.appgebrueht.activities;

/**
 * Created by Luca Bormann.
 */

import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import mae.fhdo.appgebrueht.R;
import mae.fhdo.appgebrueht.adapter.ImageAdapter;
import mae.fhdo.appgebrueht.db.RezeptManager;
import mae.fhdo.appgebrueht.entities.Rezept;


public class ActivityRezeptDetailansicht extends AppCompatActivity {


    private Rezept rezept;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rezept_detailansicht);


        Intent intent = this.getIntent();
        int rezeptId = intent.getIntExtra("rezeptId", -1);

        if (rezeptId < 0) {
            Toast.makeText(this, "Rezept-ID ist ungültig - kehre zur Rezeptliste zurück", Toast.LENGTH_SHORT).show();
            this.finish();
        } else {

            // Rezeptdaten aus der DB holen
            this.rezept = RezeptManager.getInstance(this).getRezeptById(rezeptId);


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

    public void onFoto(View view) {
        // TODO Start Kamera
        Toast.makeText(this, "Foto wurde eingestellt", Toast.LENGTH_SHORT).show();
    }

    public void onLike(View view) {
        Toast.makeText(this, "Wurde gelikt", Toast.LENGTH_SHORT).show();
        this.rezept.setLikes(this.rezept.getLikes() + 1);
    }

    public void onDislike(View view) {
        Toast.makeText(this, "Wurde gedisliked", Toast.LENGTH_SHORT).show();
        this.rezept.setLikes(this.rezept.getLikes() - 1);
    }


}
