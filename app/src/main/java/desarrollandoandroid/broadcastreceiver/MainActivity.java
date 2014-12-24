package desarrollandoandroid.broadcastreceiver;

import android.Manifest;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

/**
 * Creado por Pablo Bascuñana el 21/12/14.
 */
public class MainActivity extends ActionBarActivity {

    private static final String CUSTOM_INTENT = "desarrollandoandroid.broadcastreceiver.vibracion";
/** BroadcastReceiver Dinámico */
    private final IntentFilter intentFilter = new IntentFilter(CUSTOM_INTENT);
    private final VibrateReceiver receiver = new VibrateReceiver();
    private LocalBroadcastManager mBroadcastMgr;
// Fin
    private Button mBtVibracionStatic, mBtVibracionDynamic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
/** BroadcastReceiver Dinámico */
        mBroadcastMgr = LocalBroadcastManager.getInstance(getApplicationContext());
        mBroadcastMgr.registerReceiver(receiver, intentFilter);
// Fin
        mBtVibracionStatic = (Button) findViewById(R.id.buttonStatic);
        mBtVibracionDynamic = (Button) findViewById(R.id.buttonDynamic);

        mBtVibracionStatic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendBroadcast(new Intent(CUSTOM_INTENT), Manifest.permission.VIBRATE);
            }
        });
/** BroadcastReceiver Dinámico */
        mBtVibracionDynamic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendBroadcast(new Intent(CUSTOM_INTENT));
            }
        });
// Fin
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
    protected void onDestroy() {
        mBroadcastMgr.unregisterReceiver(receiver);
        super.onDestroy();
    }
}
