package com.bajajconnect.recievers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import com.bajajconnect.RNBleCustomModule;
import com.bajajconnect.ble.BleFeatures;
import com.bajajconnect.variables.GlobalVar;

/* JADX INFO: loaded from: classes3.dex */
public class BleReceiver extends BroadcastReceiver {
    private static final String TAG = "BLE_ADAPTER";

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if ("android.bluetooth.adapter.action.STATE_CHANGED".equals(intent.getAction())) {
            int intExtra = intent.getIntExtra("android.bluetooth.adapter.extra.STATE", -1);
            Log.i(TAG, "ACTION_STATE_CHANGED state=" + stateName(intExtra));
            if (intExtra == 10) {
                handleAdapterOff(context);
                emitBluetoothAdapterStateToJs(context, false);
            } else if (intExtra == 12) {
                emitBluetoothAdapterStateToJs(context, true);
            } else {
                if (intExtra != 13) {
                    return;
                }
                handleAdapterOff(context);
                emitBluetoothAdapterStateToJs(context, false);
            }
        }
    }

    private void handleAdapterOff(Context context) {
        GlobalVar.isBlueToothConnected = false;
        try {
            if (BleFeatures.getInstance().connectionCallback != null) {
                BleFeatures.getInstance().connectionCallback.onStateChange(false);
            }
        } catch (Exception e) {
            Log.w(TAG, "connectionCallback.onStateChange(false) failed", e);
        }
        try {
            if (BleFeatures.iphoneState != null) {
                BleFeatures.iphoneState.onBluetoothDisconnected();
            }
        } catch (Exception e2) {
            Log.w(TAG, "iphoneState.onBluetoothDisconnected() failed", e2);
        }
    }

    private void emitBluetoothAdapterStateToJs(Context context, boolean z) {
        try {
            RNBleCustomModule.emitAdapterState(context, z);
        } catch (Throwable th) {
            Log.w(TAG, "emitAdapterState failed: " + th.getMessage());
        }
    }

    private static String stateName(int i) {
        switch (i) {
            case 10:
                return "OFF";
            case 11:
                return "TURNING_ON";
            case 12:
                return "ON";
            case 13:
                return "TURNING_OFF";
            default:
                return "UNKNOWN(" + i + ")";
        }
    }
}
