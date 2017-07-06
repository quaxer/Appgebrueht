package mae.fhdo.appgebrueht.activities;

/**
 * Created by Marvin Jakob.
 */

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;

import mae.fhdo.appgebrueht.R;
import mae.fhdo.appgebrueht.activities.adapter.RezeptListAdapter;
import mae.fhdo.appgebrueht.db.RezeptManager;
import mae.fhdo.appgebrueht.entities.Rezept;

public class ActivityRezeptUebersicht extends AppCompatActivity {
    RezeptListAdapter rezeptAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rezept_uebersicht);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        ListView rezepteListView = (ListView) findViewById(R.id.RezeptList);
        setSupportActionBar(toolbar);

        RezeptManager rezeptManager = RezeptManager.getInstance(getApplicationContext());

        rezeptAdapter = new RezeptListAdapter(getApplicationContext(), R.layout.list_item_rezept_uebersicht, rezeptManager.getAllRezept());
        rezepteListView.setAdapter(rezeptAdapter);

        // Event Handler
        // -------------------
        rezepteListView.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {

                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        Rezept rezept = (Rezept) parent.getItemAtPosition(position);

                        Intent i = new Intent(view.getContext(), ActivityRezeptDetailansicht.class);
                        i.putExtra("rezeptId", rezept.getId());
                        startActivity(i);
                    }
                }
        );
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (rezeptAdapter != null)
        rezeptAdapter.notifyDataSetChanged();
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
                if(this.getClass() != ActivityRezeptUebersicht.class){
                    startActivity(new Intent(this, ActivityRezeptUebersicht.class));
                }
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

}
