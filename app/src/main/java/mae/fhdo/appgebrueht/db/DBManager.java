package mae.fhdo.appgebrueht.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Marvin Jakob.
 */

public class DBManager extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "appgebrueht.db";
    private static final int DATABASE_VERSION = 1;

    private static DBManager sINSTANCE;
    private static Object sLOCK = "";

    public static DBManager getInstance(Context context){
        if (sINSTANCE == null){
            synchronized (sLOCK){
                if (sINSTANCE == null){
                    sINSTANCE = new DBManager(context);
                }
            }
        }
        return sINSTANCE;
    }

    private DBManager(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(RezeptTbl.SQL_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(RezeptTbl.SQL_DROP);
        onCreate(db);
    }


}
