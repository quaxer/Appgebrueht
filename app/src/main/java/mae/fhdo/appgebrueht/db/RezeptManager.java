package mae.fhdo.appgebrueht.db;

import android.content.Context;

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

    public Rezept getRezeptById(int id){
        // TODO
        return null;
    }

    public Rezept getRezeptByTitel(String titel) {
        // TODO
        return null;
    }

}
