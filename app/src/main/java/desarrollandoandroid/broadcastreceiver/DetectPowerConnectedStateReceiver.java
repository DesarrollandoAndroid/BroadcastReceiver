package desarrollandoandroid.broadcastreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 * Created by pablo on 21/12/14.
 */
public class DetectPowerConnectedStateReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        if (intent.getAction().equals(Intent.ACTION_POWER_CONNECTED)) {
            Toast.makeText(context, context.getString(R.string.disconnected), Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(context, context.getString(R.string.connected), Toast.LENGTH_SHORT).show();
        }
    }
}
