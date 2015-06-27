package inc.favy.tracker;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class TrackerActivity extends ActionBarActivity {
    private Button mproceedButton;

    public static final String AUTHORITY = "inc.favy.traker";

    public static final String ACCOUNT_TYPE = "trecker.com";

    public static final String ACCOUNT = "dummyaccount";

    Account mAccount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tracker);

        mAccount = CreateSynAccount(this);

        mproceedButton = (Button) findViewById(R.id.proceedButton);
        mproceedButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(TrackerActivity.this, loginActivity.class);
                startActivity(i);
            }
        });
    }

    private Account CreateSynAccount(Context context) {
        Account newAccount = new Account(ACCOUNT, ACCOUNT_TYPE);
        AccountManager accountManager = (AccountManager) context.getSystemService(ACCOUNT_SERVICE);

/*        if (accountManager.addAccountExplicitly(newAccount,null,null)){
         // context.setIsSyncable(mAccount,AUTHORITY,1);
        }*/
return newAccount;
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_tracker, menu);
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

