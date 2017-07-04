package mae.fhdo.appgebrueht;

import android.os.Bundle;
import android.os.Message;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class RezeptUebersicht extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rezept_uebersicht);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        String[] foods = {"Bacon", "Ham", "Tuna", "Candy", "Meatball", "Potato"};
        ListAdapter foodAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, foods);
        ListView foodListView = (ListView) findViewById(R.id.foodList);
        foodListView.setAdapter(foodAdapter);

        foodListView.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        String food = String.valueOf(parent.getItemAtPosition(position));
                        Toast.makeText(RezeptUebersicht.this, food, Toast.LENGTH_SHORT).show();
                    }
                }
        );
    }

}
