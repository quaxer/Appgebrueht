package mae.fhdo.appgebrueht.db;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

import mae.fhdo.appgebrueht.entities.Rezept;

/**
 * Created by Marvin Jakob.
 */

public class RezeptManager {

    private static RezeptManager sINSTANCE;
    private static Object sLOCK = "";

    private Context context;
    private DBManager dbManager;

    private RezeptManager(Context context) {
        this.context = context;
        dbManager = DBManager.getInstance(context);
    }

    public static RezeptManager getInstance(Context context){
        if (sINSTANCE == null){
            synchronized (sLOCK){
                if (sINSTANCE == null){
                    sINSTANCE = new RezeptManager(context);
                }
            }
        }
        return sINSTANCE;
    }

    public Rezept addRezept(Rezept rezept){
        // TODO
        return null;
    }

    public void deleteRezept(Rezept rezept) {
        // TODO
    }

    public Rezept updateRezept(Rezept rezept){
        // TODO
        return null;
    }

    public Rezept getRezeptById(int id){
        // TODO

        // ! Testdaten !
        return new Rezept("Pizza", "Hier steht die Beschreibung für das Pizza-Rezept!!!");

        //return null;
    }

    public Rezept getRezeptByTitel(String titel) {
        // TODO

        // ! Testdaten !
        return new Rezept("Lasagne");

        //return null;
    }

    public List<Rezept> getAllRezept(){
        // TODO: Rezepte aus DB

        List<Rezept> list_Rezepte = new ArrayList<Rezept>();

        list_Rezepte.add(new Rezept("Lasagne"));
        list_Rezepte.add(new Rezept("Nudelsalat"));
        list_Rezepte.add(new Rezept("Nudelauflauf"));
        list_Rezepte.add(new Rezept("Spaghetti Bolognese"));
        list_Rezepte.add(new Rezept("Vegetarische Bouletten"));

        return list_Rezepte;
    }
}
