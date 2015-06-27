package inc.favy.tracker;

import android.accounts.AbstractAccountAuthenticator;
import android.accounts.Account;
import android.accounts.AccountAuthenticatorResponse;
import android.accounts.NetworkErrorException;
import android.content.Context;
import android.os.Bundle;

/**
 * Created by HP on 6/23/2015.
 */
/*
 * Implement AbstractAccountAuthenticator and stub out all
 * of its methods
 */
public class Authenticator extends AbstractAccountAuthenticator {
    private AccountAuthenticatorResponse response;
    private Account account;
    private Bundle options;

    // Simple constructor
    public Authenticator(Context context) {
        super(context);
    }

    // Editing properties is not supported
    @Override
    public Bundle editProperties(
            AccountAuthenticatorResponse r, String s) {
        throw new UnsupportedOperationException();
    }

    // Don't add additional accounts
    @Override
    public Bundle addAccount(
            AccountAuthenticatorResponse r,
            String s,
            String s2,
            String[] strings,
            Bundle bundle) throws NetworkErrorException {
        return null;
    }

    // Ignore attempts to confirm credentials
    @Override
    public Bundle confirmCredentials(
            AccountAuthenticatorResponse r,
            Account account,
            Bundle options) throws NetworkErrorException {
        return null;
    }


    //Getting an authentication token is not supported
    @Override
    public Bundle getAuthToken(
            AccountAuthenticatorResponse r,
            Account account,
            String s,
            Bundle bundle) throws NetworkErrorException {
        throw new UnsupportedOperationException();
    }

    // Getting a label for the auth token is not supported
    @Override
    public String getAuthTokenLabel(String s) {
        throw new UnsupportedOperationException();
    }

    // Updating user credentials is not supported
    @Override
    public Bundle updateCredentials(
            AccountAuthenticatorResponse r,
            Account account,
            String s, Bundle bundle) throws NetworkErrorException {
        throw new UnsupportedOperationException();
    }

    // Checking features for the account is not supported
    @Override
    public Bundle hasFeatures(
            AccountAuthenticatorResponse r,
            Account account, String[] strings) throws NetworkErrorException {
        throw new UnsupportedOperationException();
    }
}

/*
 * Define an implementation of ContentProvider that stubs out
 * all methods
 */
//public class StubProvider extends ContentProvider {
//    /*
//     * Always return true, indicating that the
//     * provider loaded correctly.
//     */
//    @Override
//    public boolean onCreate() {
//        return true;
//    }
//    /*
//     * Return an empty String for MIME type
//     */
//    @Override
//    public String getType() {
//        return new String();
//    }
//    /*
//     * query() always returns no results
//     *
//     */
//    @Override
//    public Cursor query(
//            Uri uri,
//            String[] projection,
//            String selection,
//            String[] selectionArgs,
//            String sortOrder) {
//        return null;
//    }
//    /*
//     * insert() always returns null (no URI)
//     */
//    @Override
//    public Uri insert(Uri uri, ContentValues values) {
//        return null;
//    }
//    /*
//     * delete() always returns "no rows affected" (0)
//     */
//    @Override
//    public int delete(Uri uri, String selection, String[] selectionArgs) {
//        return 0;
//    }
//    /*
//     * update() always returns "no rows affected" (0)
//     */
//    public int update(
//            Uri uri,
//            ContentValues values,
//            String selection,
//            String[] selectionArgs) {
//        return 0;
//    }
//}

/**
 * A bound Service that instantiates the authenticator
 * when started
 */

