package mae.fhdo.appgebrueht.db;

import android.content.Context;

import mae.fhdo.appgebrueht.entities.Foto;
import mae.fhdo.appgebrueht.entities.Rezept;

/**
 * Created by Marvin Jakob.
 */

public class FotoManager {

    private static FotoManager sINSTANCE;
    private static Object sLOCK = "";

    private Context context;
    private DBManager dbManager;

    private FotoManager(Context context) {
        this.context = context;
        dbManager = DBManager.getInstance(context);
    }

    public static FotoManager getInstance(Context context){
        if (sINSTANCE == null){
            synchronized (sLOCK){
                if (sINSTANCE == null){
                    sINSTANCE = new FotoManager(context);
                }
            }
        }
        return sINSTANCE;
    }

    public Foto getFirstFoto(Rezept rezept){
        // TODO
        return null;
    }

    public Foto getFotoList(Rezept rezept){
        // TODO
        return null;
    }
}
