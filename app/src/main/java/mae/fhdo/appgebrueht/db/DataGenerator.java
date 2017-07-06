package mae.fhdo.appgebrueht.db;

import android.content.Context;

import mae.fhdo.appgebrueht.R;
import mae.fhdo.appgebrueht.entities.Rezept;

/**
 * Created by Marvin Jakob.
 */

public class DataGenerator {
    public DataGenerator() {

    }

    public void generateData(Context context){
        RezeptManager rezeptManager = RezeptManager.getInstance(context);

        rezeptManager.addRezept(new Rezept("Lasagne", "" , R.drawable.first));
        rezeptManager.addRezept(new Rezept("Nudelsalat", "" , R.drawable.first));
        rezeptManager.addRezept(new Rezept("Nudelauflauf", "" , R.drawable.first));
        rezeptManager.addRezept(new Rezept("Spaghetti Bolognese", "" , R.drawable.first));
        rezeptManager.addRezept(new Rezept("Vegetarische Bouletten", "" , R.drawable.first));
    }
}
