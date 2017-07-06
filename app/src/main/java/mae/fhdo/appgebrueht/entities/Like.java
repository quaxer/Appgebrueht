package mae.fhdo.appgebrueht.entities;

import mae.fhdo.appgebrueht.entities.interfaces.ILike;

/**
 * Created by Marvin Jakob.
 */

public class Like implements ILike {
    private int _id;
    private Rezept rezept;
    private Benutzer benutzer;

    public Like() {

    }
}
