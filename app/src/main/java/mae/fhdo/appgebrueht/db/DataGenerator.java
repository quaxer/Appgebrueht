package mae.fhdo.appgebrueht.db;

import android.content.Context;

import mae.fhdo.appgebrueht.R;
import mae.fhdo.appgebrueht.entities.Rezept;
import java.util.List;
import java.util.ArrayList;

/**
 * Created by Marvin Jakob.
 */

public class DataGenerator {
    public DataGenerator() {

    }

    public void generateData(Context context){
        RezeptManager rezeptManager = RezeptManager.getInstance(context);

        List<Integer> lasagneFotos = new ArrayList<Integer>();
        List<Integer> nudelsalatFotos = new ArrayList<Integer>();
        List<Integer> nudelauflaufFotos = new ArrayList<Integer>();
        List<Integer> spaghettiFotos = new ArrayList<Integer>();
        List<Integer> pizzaFotos = new ArrayList<Integer>();

        lasagneFotos.add(R.drawable.lasagne1);
        lasagneFotos.add(R.drawable.lasagne2);
        nudelsalatFotos.add(R.drawable.salat1);
        nudelsalatFotos.add(R.drawable.salat2);
        nudelsalatFotos.add(R.drawable.salat3);
        nudelauflaufFotos.add(R.drawable.lasagne3);
        spaghettiFotos.add(R.drawable.spaghetti1);
        spaghettiFotos.add(R.drawable.spaghetti2);
        spaghettiFotos.add(R.drawable.spaghetti3);
        pizzaFotos.add(R.drawable.pizza1);
        pizzaFotos.add(R.drawable.pizza2);
        pizzaFotos.add(R.drawable.pizza3);

        rezeptManager.addRezept(new Rezept("Lasagne", "", lasagneFotos));
        rezeptManager.addRezept(new Rezept("Nudelsalat", "" , nudelsalatFotos));
        rezeptManager.addRezept(new Rezept("Nudelauflauf", "" , nudelauflaufFotos));
        rezeptManager.addRezept(new Rezept("Spaghetti Bolognese", "" , spaghettiFotos));
        rezeptManager.addRezept(new Rezept("Vegetarische Pizza", "" , pizzaFotos));
    }
}
