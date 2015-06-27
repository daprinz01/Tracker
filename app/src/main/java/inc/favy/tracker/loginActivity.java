package inc.favy.tracker;

import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class loginActivity extends ActionBarActivity{

    public EditText mUsername;
    public EditText mEmail;
    private EditText mPassword;
    private Button mLoginButton;

    private long rowID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

/*//        loginDb.loginDataBase.loginDbHelper mDbHelper;
        loginDb mDbHelper = new loginDb();
//        mDbHelper = new loginDb.loginDataBase.loginDbHelper(getContext());
       /*//* Gets the data repository in write mode *//*
//        SQLiteDatabase db = mDbHelper.getWritableDatabase();



// Insert the new row, returning the primary key value of the new row
        long newRowId;
        newRowId = db.insert(
                loginDb.loginDataBase.TABLE_NAME,
                null,
                values);*/

        mLoginButton = (Button) findViewById(R.id.loginButton);
        mUsername = (EditText) findViewById(R.id.username);
        mEmail = (EditText) findViewById(R.id.email);
        mPassword = (EditText) findViewById(R.id.password);
        mLoginButton.setOnClickListener(loginButtonListener);

    }

    View.OnClickListener loginButtonListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            if (mUsername.getText().toString().trim().length() != 0 && mPassword.getText().toString().trim().length() != 0
                    && mEmail.getText().toString().trim().length() != 0) {
                // Create a new map of values, where column names are the keys
                ContentValues values = new ContentValues();
                values.put(LoginProvider.COLUMN_USERNAME, mUsername.getText().toString());
                values.put(LoginProvider.COLUMN_EMAIL, String.valueOf(mEmail));
                values.put(LoginProvider.COLUMN_PASSWORD, String.valueOf(mPassword));

                Uri uri = getApplicationContext().getContentResolver().insert(LoginProvider.LOGIN_URI, values);
                rowID = ContentUris.parseId(uri);

            }
            Intent j = new Intent(loginActivity.this, detailActivity.class);
            startActivity(j);
        }
    };


            @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_login, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}



