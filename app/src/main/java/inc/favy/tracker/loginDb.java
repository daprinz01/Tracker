package inc.favy.tracker;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;

/**
 * Created by HP on 6/23/2015.*/
 public final class loginDb {
 // To prevent someone from accidentally instantiating the contract class,
 // give it an empty constructor.
 public loginDb() {}

 /* Inner class that defines the table contents */
public static abstract class loginDataBase implements BaseColumns {
     public static final String TABLE_NAME = "login";
     public static final String COLUMN_USERNAME = "username";
     public static final String COLUMN_LONGITUDE = "longitude";
     public static final String COLUMN_LATITUDE = "latitude";
     public static final String COLUMN_PASSWORD = "password";
     public static final String COLUMN_EMAIL = "email";

     private static final String TEXT_TYPE = " TEXT";
     private static final String COMMA_SEP = ",";
     private static final String SQL_CREATE_ENTRIES =
             "CREATE TABLE " + loginDataBase.TABLE_NAME + " (" +
                     loginDataBase._ID + " INTEGER PRIMARY KEY," +
                     loginDataBase.COLUMN_USERNAME + TEXT_TYPE + COMMA_SEP +
                     loginDataBase.COLUMN_EMAIL + TEXT_TYPE + COMMA_SEP +
                     loginDataBase.COLUMN_PASSWORD + TEXT_TYPE + COMMA_SEP +
                     loginDataBase.COLUMN_LATITUDE + TEXT_TYPE + COMMA_SEP +
                     loginDataBase.COLUMN_LONGITUDE + TEXT_TYPE +
                     " );";

     private static final String SQL_DELETE_ENTRIES =
             "DROP TABLE IF EXISTS " + loginDataBase.TABLE_NAME;

public class loginDbHelper extends SQLiteOpenHelper {
    // If you change the database schema, you must increment the database version.
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "loginDatabase.db";

    public loginDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_ENTRIES);
    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // This database is only a cache for online data, so its upgrade policy is
        // to simply to discard the data and start over
        db.execSQL(SQL_DELETE_ENTRIES);
        onCreate(db);
    }

    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onUpgrade(db, oldVersion, newVersion);
    }
}

 }

}