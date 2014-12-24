package desarrollandoandroid.broadcastreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Vibrator;

/**
 * Creado por Pablo Bascuñana el 21/12/14.
 */
public class VibrateReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Vibrator mVibrator = (Vibrator) context.getSystemService(Context.VIBRATOR_SERVICE);
        mVibrator.vibrate(500);
    }
}

// Tiempo que vibra en milisegundos