package mae.fhdo.appgebrueht.activities;

/**
 * Created by Marvin Jakob.
 */

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import mae.fhdo.appgebrueht.R;
import mae.fhdo.appgebrueht.db.RezeptManager;
import mae.fhdo.appgebrueht.entities.Rezept;

public class ActivityRezeptUebersicht extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rezept_uebersicht);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        ListView foodListView = (ListView) findViewById(R.id.foodList);
        setSupportActionBar(toolbar);

        RezeptManager rezeptManager = RezeptManager.getInstance(this);
        List<String> foods = new ArrayList<String>();

        for(Rezept rezept :rezeptManager.getAllRezept()) {
            foods.add(rezept.getTitel());
        }

        ListAdapter foodAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, foods);
        foodListView.setAdapter(foodAdapter);



        // Event Handler
        // -------------------
        foodListView.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {

                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        String food = String.valueOf(parent.getItemAtPosition(position));
                        Toast.makeText(ActivityRezeptUebersicht.this, food, Toast.LENGTH_SHORT).show();
                    }
                }
        );
    }

}
