package mae.fhdo.appgebrueht.db;

import mae.fhdo.appgebrueht.db.interfaces.RezeptColumns;

/**
 * Created by Marvin Jakob.
 */

public class RezeptTbl implements RezeptColumns {
    public static final String TABLE_NAME = "rezept";

    public static final String SQL_CREATE =
            "CREATE TABLE " + TABLE_NAME + "(" +
            "_id INTEGER PRIMARY KEY AUTOINCREMENT," +
            "titel TEXT NOT NULL," +
            "likes INTEGER," +
            "beschreibung TEXT" +
            ");";

    public static final String SQL_DROP =
            "DROP TABLE IF EXISTS " + TABLE_NAME;

    public static final String REZEPT_INSERT =
            "INSERT INTO " + TABLE_NAME +
            "(titel,likes,beschreibung)" +
            "VALUES (?,?,?)";

    public static final String REZEPT_DELETE =
            "DELETE " + TABLE_NAME;

    public static final String REZEPT_DELETE_BY_ID =
            "DELETE " + TABLE_NAME +
            "WHERE _id = ?";

    public static final String[] ALL_COLUMNS = new String[]{
            ID,
            TITEL,
            LIKES,
            BESCHREIBUNG
    };

    public static final String WHERE_ID_EQUALS =
            ID + "=?";

    private RezeptTbl(){
    }
}
