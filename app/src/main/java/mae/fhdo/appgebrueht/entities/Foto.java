package mae.fhdo.appgebrueht.entities;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;

import mae.fhdo.appgebrueht.R;
import mae.fhdo.appgebrueht.entities.interfaces.IFoto;

/**
 * Created by Marvin Jakob.
 */

public class Foto implements IFoto{
    private int _id;

    public Foto() {

    }

    public Drawable getDrawable(Context context) {
        return ContextCompat.getDrawable(context, R.drawable.first);
    }
}
