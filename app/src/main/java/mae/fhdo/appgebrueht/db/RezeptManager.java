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

    List<Rezept> list_Rezept;

    private RezeptManager(Context context) {
        this.context = context;
        this.list_Rezept = new ArrayList<Rezept>();
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

    public void addRezept(Rezept rezept){
        list_Rezept.add(rezept);
    }

    public void deleteRezept(Rezept rezept) {
        list_Rezept.remove(rezept);
    }

    public Rezept updateRezept(Rezept rezept){
        list_Rezept.remove(getRezeptById(rezept.getId()));
        list_Rezept.add(rezept);
        return null;
    }

    public Rezept getRezeptById(int id){
        for(Rezept r: list_Rezept)
        {
            if (r.getId() == id)
                return r;
        }
        return null;
    }

    public Rezept getRezeptByTitel(String titel) {
        for(Rezept r: list_Rezept)
        {
            if (r.getTitel().equals(titel))
                return r;
        }
        return null;
    }

    public List<Rezept> getAllRezept(){
        return list_Rezept;
    }
}
