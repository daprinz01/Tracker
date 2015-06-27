package inc.favy.tracker;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

public class SyncService extends Service {
    public SyncService() {
    }
    public static SyncAdapter sSyncAdapter = null;

    private static final Object sSyncAdapterLock = new Object();

    public void onCreate(){

        synchronized (sSyncAdapterLock){
            if (sSyncAdapter == null){
                sSyncAdapter = new SyncAdapter(getApplicationContext(),true);
            }
        }
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        return sSyncAdapter.getSyncAdapterBinder();
        //throw new UnsupportedOperationException("Not yet implemented");
    }
}
