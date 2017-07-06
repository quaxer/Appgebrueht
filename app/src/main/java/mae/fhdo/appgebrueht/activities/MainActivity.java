package mae.fhdo.appgebrueht.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import mae.fhdo.appgebrueht.R;
import mae.fhdo.appgebrueht.db.DataGenerator;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Create Test-Data
        DataGenerator dataGenerator = new DataGenerator();
        dataGenerator.generateData();

        // Start Application
        Intent i = new Intent(this, ActivityRezeptUebersicht.class);
        startActivity(i);

        // REZEPTDETAILANSICHT BEISPIEL
        /*
        Intent i = new Intent(this, ActivityRezeptDetailansicht.class);
        i.putExtra("rezeptId", 1);
        startActivity(i);
        */
    }
}
