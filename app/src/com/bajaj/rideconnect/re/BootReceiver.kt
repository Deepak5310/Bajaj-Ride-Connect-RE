package com.bajaj.rideconnect.re

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log

class BootReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context?, intent: Intent?) {
        val action = intent?.action ?: return
        Log.i(TAG, "Received broadcast action: $action")

        if (action == Intent.ACTION_BOOT_COMPLETED || action == Intent.ACTION_MY_PACKAGE_REPLACED) {
            context?.let {
                Log.i(TAG, "Starting PulsarForegroundService after boot/package update.")
                PulsarForegroundService.start(it)
            }
        }
    }

    companion object {
        private const val TAG = "PulsarBootReceiver"
    }
}
