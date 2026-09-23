package com.pulsar.ns400z.tbtbridge;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.BatteryManager;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.telephony.CellInfo;
import android.telephony.CellInfoLte;
import android.telephony.CellSignalStrengthLte;
import android.telephony.SignalStrength;
import android.telephony.TelephonyCallback;
import android.telephony.TelephonyManager;
import android.util.Log;

import java.util.List;

/**
 * Monitors Phone Battery Level & Cellular Signal Strength,
 * streaming periodic heartbeat telemetry to the NS400Z digital speedometer cluster.
 */
public class PhoneStateMonitor {

    private static final String TAG = "PhoneStateMonitor";
    public static final String ACTION_TELEMETRY_UPDATE = "com.pulsar.ns400z.tbtbridge.TELEMETRY_UPDATE";

    private final Context context;
    private final PulsarBleManager bleManager;
    private final TelephonyCallHandler callHandler;
    private final Handler handler = new Handler(Looper.getMainLooper());

    private int batteryPercent = -1;
    private int signalBars = -1; // 0-4
    private boolean isRunning = false;
    private boolean batteryReceiverRegistered = false;

    private final BroadcastReceiver batteryReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            int level = intent.getIntExtra(BatteryManager.EXTRA_LEVEL, -1);
            int scale = intent.getIntExtra(BatteryManager.EXTRA_SCALE, -1);
            if (level >= 0 && scale > 0) {
                batteryPercent = (int) ((level / (float) scale) * 100);
                broadcastTelemetry();
            }
        }
    };

    private void broadcastTelemetry() {
        Intent intent = new Intent(ACTION_TELEMETRY_UPDATE);
        intent.setPackage(context.getPackageName());
        intent.putExtra("battery", batteryPercent);
        intent.putExtra("signal", signalBars);
        context.sendBroadcast(intent);
    }

    private final Runnable heartbeatRunnable = new Runnable() {
        @Override
        public void run() {
            if (isRunning) {
                broadcastTelemetry();
                if (bleManager.isConnected()) {
                    int callState = callHandler != null ? callHandler.getCurrentCallState() : 0;
                    String caller = callHandler != null ? callHandler.getActiveCaller() : "";
                    bleManager.sendTelemetry(batteryPercent >= 0 ? batteryPercent : 85,
                            signalBars >= 0 ? signalBars : 4, callState, caller, 0, 0);
                }
                handler.postDelayed(this, 4000); // 4-second interval heartbeat
            }
        }
    };

    public PhoneStateMonitor(Context context, PulsarBleManager bleManager, TelephonyCallHandler callHandler) {
        this.context = context.getApplicationContext();
        this.bleManager = bleManager;
        this.callHandler = callHandler;
        initBatteryListener();
        initSignalListener();
    }

    private synchronized void initBatteryListener() {
        if (!batteryReceiverRegistered) {
            IntentFilter filter = new IntentFilter(Intent.ACTION_BATTERY_CHANGED);
            Intent sticky = context.registerReceiver(batteryReceiver, filter);
            batteryReceiverRegistered = true;
            if (sticky != null) {
                int level = sticky.getIntExtra(BatteryManager.EXTRA_LEVEL, -1);
                int scale = sticky.getIntExtra(BatteryManager.EXTRA_SCALE, -1);
                if (level >= 0 && scale > 0) {
                    batteryPercent = (int) ((level / (float) scale) * 100);
                    broadcastTelemetry();
                }
            }
        }
    }

    private static class SignalStrengthCallback extends TelephonyCallback implements TelephonyCallback.SignalStrengthsListener {
        private final PhoneStateMonitor monitor;

        SignalStrengthCallback(PhoneStateMonitor monitor) {
            this.monitor = monitor;
        }

        @Override
        public void onSignalStrengthsChanged(SignalStrength signalStrength) {
            if (signalStrength != null) {
                monitor.signalBars = signalStrength.getLevel(); // 0 to 4
                monitor.broadcastTelemetry();
            }
        }
    }

    @SuppressLint("MissingPermission")
    private void initSignalListener() {
        TelephonyManager tm = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
        if (tm == null) return;

        try {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
                tm.registerTelephonyCallback(context.getMainExecutor(), new SignalStrengthCallback(this));
            }
        } catch (SecurityException ignored) {}
    }

    public synchronized void start() {
        if (!isRunning) {
            isRunning = true;
            initBatteryListener();
            handler.post(heartbeatRunnable);
            Log.i(TAG, "Phone State Telemetry Monitor Started.");
        }
    }

    public synchronized void stop() {
        isRunning = false;
        handler.removeCallbacks(heartbeatRunnable);
        if (batteryReceiverRegistered) {
            try {
                context.unregisterReceiver(batteryReceiver);
            } catch (Exception ignored) {}
            batteryReceiverRegistered = false;
        }
        Log.i(TAG, "Phone State Telemetry Monitor Stopped.");
    }

    public int getBatteryPercent() {
        return batteryPercent;
    }

    public int getSignalBars() {
        return signalBars;
    }
}
