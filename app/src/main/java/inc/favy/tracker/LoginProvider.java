package inc.favy.tracker;

import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.net.Uri;

public class LoginProvider extends ContentProvider {

    static final String PROVIDER_AUTHORITY_NAME = "inc.favy.tracker";
    static final String URL = "content://" + PROVIDER_AUTHORITY_NAME + "/login";
    static final Uri LOGIN_URI = Uri.parse(URL);




    private SQLiteDatabase database;
    public static final String TABLE_NAME = "login";
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_USERNAME = "username";
    public static final String COLUMN_LONGITUDE = "longitude";
    public static final String COLUMN_LATITUDE = "latitude";
    public static final String COLUMN_PASSWORD = "password";
    public static final String COLUMN_EMAIL = "email";

    private static final String TEXT_TYPE = " TEXT";
    private static final String COMMA_SEP = ",";
    private static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + LoginProvider.TABLE_NAME + " (" +
                    LoginProvider.COLUMN_ID + " INTEGER PRIMARY KEY," +
                    LoginProvider.COLUMN_USERNAME + TEXT_TYPE + COMMA_SEP +
                    LoginProvider.COLUMN_EMAIL + TEXT_TYPE + COMMA_SEP +
                    LoginProvider.COLUMN_PASSWORD + TEXT_TYPE + COMMA_SEP +
                    LoginProvider.COLUMN_LATITUDE + TEXT_TYPE + COMMA_SEP +
                    LoginProvider.COLUMN_LONGITUDE + TEXT_TYPE  +
                    " )";

    private static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + LoginProvider.TABLE_NAME;

    public LoginProvider() {
    }

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

    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        // Implement this to handle requests to delete one or more rows.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public String getType(Uri uri) {
        // TODO: Implement this to handle requests for the MIME type of the data
        // at the given URI.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public Uri insert(Uri uri, ContentValues values) {
        // TODO: Implement this to handle requests to insert a new row.

        long id;
        switch (URI_MATCHER.match(uri)){
            case LOGIN:
                values.remove(LoginProvider.COLUMN_ID);
                id = database.insertOrThrow(LoginProvider.TABLE_NAME, null, values);
                break;

            default:
                throw new UnsupportedOperationException("Not yet implemented");
        }
        getContext().getContentResolver().notifyChange(uri, null);
        return ContentUris.withAppendedId(uri, id);
    }

    @Override
    public boolean onCreate() {
        // TODO: Implement this to initialize your content provider on startup.
        database = new loginDbHelper(getContext()).getWritableDatabase();
        return true;
    }

    @Override
    public Cursor query(Uri uri, String[] projection, String selection,
                        String[] selectionArgs, String sortOrder) {
        // TODO: Implement this to handle query requests from clients.
        Cursor cursor;
        switch (URI_MATCHER.match(uri)){
            case LOGIN:
                cursor = database.query(LoginProvider.TABLE_NAME, null, null, null, null, null, null);
                break;

            default:
                throw new UnsupportedOperationException("Not yet implemented");
        }
        if (cursor != null) {
            cursor.setNotificationUri(getContext().getContentResolver(), uri);
        }
        return cursor;
    }

    @Override
    public int update(Uri uri, ContentValues values, String selection,
                      String[] selectionArgs) {
        // TODO: Implement this to handle requests to update one or more rows.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    //Uri matchers
    private static final int LOGIN = 100;
    private static final UriMatcher URI_MATCHER = buildUriMatcher();

    private static UriMatcher buildUriMatcher(){
        UriMatcher uriMatcher = new UriMatcher(UriMatcher.NO_MATCH);

        uriMatcher.addURI(PROVIDER_AUTHORITY_NAME, "login", LOGIN);

        return uriMatcher;
    }


}
