package mae.fhdo.appgebrueht.db;

import android.content.Context;

import java.util.List;

import mae.fhdo.appgebrueht.entities.Benutzer;

/**
 * Created by Marvin Jakob.
 */

public class BenutzerManager {
    private static BenutzerManager sINSTANCE;
    private static Object sLOCK = "";

    private Context context;
    private DBManager dbManager;

    private BenutzerManager(Context context) {
        this.context = context;
        dbManager = DBManager.getInstance(context);
    }

    public static BenutzerManager getInstance(Context context){
        if (sINSTANCE == null){
            synchronized (sLOCK){
                if (sINSTANCE == null){
                    sINSTANCE = new BenutzerManager(context);
                }
            }
        }
        return sINSTANCE;
    }

    public Benutzer addBenutzer(Benutzer benutzer){
        // TODO
        return null;
    }

    public void deleteBenutzer(){
        // TODO
    }

    public List<Benutzer> getAllBenutzer(){
        // TODO
        return null;
    }
}
