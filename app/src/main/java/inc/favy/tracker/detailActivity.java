package inc.favy.tracker;

import android.app.LoaderManager;
import android.content.CursorLoader;
import android.content.Intent;
import android.content.Loader;
import android.database.Cursor;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.GoogleMap;


public class detailActivity extends ActionBarActivity implements LoaderManager.LoaderCallbacks<Cursor>{
    private EditText mNewusername;
    private Button mLocateButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        mNewusername = (EditText)findViewById(R.id.ip);
        mLocateButton = (Button)findViewById(R.id.searchButton);
        mLocateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mNewusername == null) {
                    Toast.makeText(detailActivity.this, R.string.noIP, Toast.LENGTH_SHORT).show();
                } else {
                    Intent d = new Intent(detailActivity.this, Locate.class);
                    startActivity(d);
                }
            }
        });

        getLoaderManager().initLoader(0, null, this);
  /*  GoogleApiClient mGoogleApiClient=new GoogleApiClient.Builder(this)
            .addApi(GoogleMap.API);

        protected synchronized void buildGoogleapiClient() {
        mGoogleApiClient = new GoogleApiClient.Builder(this)
                .addConnectionCallbacks(this).
                addOnConnectionFailedListener(this)
                .addApi(LocationServices.API).build();
    }*/

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_detail, menu);
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

    @Override
    public Loader<Cursor> onCreateLoader(int id, Bundle args) {
        return new CursorLoader(getApplicationContext(), LoginProvider.LOGIN_URI, null, null, null, null);
    }

    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor data) {
    }

    @Override
    public void onLoaderReset(Loader<Cursor> loader) {

    }
}
