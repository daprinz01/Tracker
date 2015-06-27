package inc.favy.tracker;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;
import android.widget.Toast;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

/**
 * Created by HP on 6/25/2015.
 */
public class RSSPullService extends IntentService {
    /**
     * Creates an IntentService.  Invoked by your subclass's constructor.
     *
     * @param name Used to name the worker thread, important only for debugging.
     */
    public RSSPullService(String name) {
        super(name);
    }

    public static String TAG;

    @Override
    protected void onHandleIntent(Intent intent) {

        // Whether there is a Wi-Fi connection.
        boolean wifiConnected = false;
        // Whether there is a mobile connection.
         boolean mobileConnected = false;
        /**
         * Check whether the device is connected, and if so, whether the connection
         * is wifi or mobile (it could be something else).
         */
        //    private void checkNetworkConnection() {

              ConnectivityManager connMgr =
         (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
         NetworkInfo activeInfo = connMgr.getActiveNetworkInfo();
         if (activeInfo != null && activeInfo.isConnected()) {
         wifiConnected = activeInfo.getType() == ConnectivityManager.TYPE_WIFI;
         mobileConnected = activeInfo.getType() == ConnectivityManager.TYPE_MOBILE;
         if (wifiConnected) {
         Toast.makeText(new TrackerActivity(), "WIFI Connected", Toast.LENGTH_SHORT).show();
         } else if (mobileConnected) {
         Toast.makeText(new TrackerActivity(), "Mobile Network Connected", Toast.LENGTH_SHORT).show();
         }
         } else {
         Toast.makeText(new TrackerActivity(), "No Connections Found", Toast.LENGTH_SHORT).show();
         }

        Geocoder geocoder = new Geocoder(this, Locale.getDefault());
        String errorMessage = "";

        //Get the location passed to this service through an extra
        Location location = intent.getParcelableExtra(Constants.LOCATION_DATA_EXTRA);

        List<Address> addresses = null;
        try {
            addresses = geocoder.getFromLocation(location.getLatitude(),location.getLongitude(),1);

        }
        catch (IOException ioException){
            //catch network or other I/O problems.
            errorMessage = getString(R.string.service_not_available);
            Log.e(TAG, errorMessage, ioException);
        }catch (IllegalArgumentException illegalArgumentException){

        }


    }

    }

