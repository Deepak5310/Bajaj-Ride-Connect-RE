package com.bajaj.rideconnect.re;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/**
 * Automatically starts the Pulsar Connected Device background service upon phone reboot.
 */
public class BootReceiver extends BroadcastReceiver {

    private static final String TAG = "PulsarBootReceiver";

    @Override
    public void onReceive(Context context, Intent intent) {
        if (intent == null || intent.getAction() == null) return;
        String action = intent.getAction();
        Log.i(TAG, "Received broadcast action: " + action);

        if (Intent.ACTION_BOOT_COMPLETED.equals(action) || Intent.ACTION_MY_PACKAGE_REPLACED.equals(action)) {
            Log.i(TAG, "Starting PulsarForegroundService after boot/package update.");
            PulsarForegroundService.start(context);
        }
    }
}
