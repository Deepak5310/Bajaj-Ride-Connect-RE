package com.pulsar.ns400z.tbtbridge;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.provider.ContactsContract;
import android.telecom.TelecomManager;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyCallback;
import android.telephony.TelephonyManager;
import android.util.Log;

/**
 * Enterprise Telephony & Caller ID Handler for Pulsar NS400Z.
 * Detects incoming calls, queries contact names, pushes Caller ID to cluster LCD,
 * and handles handlebar switch Accept / Reject call commands.
 */
public class TelephonyCallHandler {

    private static final String TAG = "TelephonyCallHandler";

    private final Context context;
    private final PulsarBleManager bleManager;
    private final TelephonyManager telephonyManager;
    private final TelecomManager telecomManager;

    private int currentCallState = 0; // 0=Idle, 1=Ringing, 2=Offhook
    private String activeCaller = "";

    public TelephonyCallHandler(Context context, PulsarBleManager bleManager) {
        this.context = context.getApplicationContext();
        this.bleManager = bleManager;
        this.telephonyManager = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
        this.telecomManager = (TelecomManager) context.getSystemService(Context.TELECOM_SERVICE);

        registerCallListener();
    }

    private static class CallStateCallback extends TelephonyCallback implements TelephonyCallback.CallStateListener {
        private final TelephonyCallHandler handler;

        CallStateCallback(TelephonyCallHandler handler) {
            this.handler = handler;
        }

        @Override
        public void onCallStateChanged(int state) {
            handler.handleStateChanged(state, null);
        }
    }

    @SuppressLint("MissingPermission")
    private void registerCallListener() {
        if (telephonyManager == null) return;

        try {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
                telephonyManager.registerTelephonyCallback(
                        context.getMainExecutor(),
                        new CallStateCallback(this)
                );
            } else {
                telephonyManager.listen(new PhoneStateListener() {
                    @Override
                    public void onCallStateChanged(int state, String phoneNumber) {
                        handleStateChanged(state, phoneNumber);
                    }
                }, PhoneStateListener.LISTEN_CALL_STATE);
            }
        } catch (SecurityException e) {
            Log.w(TAG, "READ_PHONE_STATE permission needed for Call handler: " + e.getMessage());
        }
    }

    public void handleStateChanged(int state, String incomingNumber) {
        this.currentCallState = state;
        if (state == TelephonyManager.CALL_STATE_RINGING) {
            String name = resolveContactName(incomingNumber);
            this.activeCaller = name != null ? name : (incomingNumber != null ? incomingNumber : "INCOMING CALL");
            Log.i(TAG, "Incoming Call: " + activeCaller + " -> Pushing to Cluster LCD");
            pushCallTelemetry(1, activeCaller);
        } else if (state == TelephonyManager.CALL_STATE_OFFHOOK) {
            Log.i(TAG, "Call in progress (Offhook)");
            pushCallTelemetry(2, activeCaller);
        } else {
            Log.i(TAG, "Call Idle / Ended");
            this.activeCaller = "";
            pushCallTelemetry(0, "");
        }
    }

    private void pushCallTelemetry(int callState, String caller) {
        bleManager.sendTelemetry(100, 4, callState, caller, 0, 0);
    }

    @SuppressLint("MissingPermission")
    public void handleHandlebarCallAction(PulsarProtocol.HandlebarEvent ev) {
        if (ev == null || telecomManager == null) return;

        try {
            if (ev.callAccept && currentCallState == TelephonyManager.CALL_STATE_RINGING) {
                Log.i(TAG, "Handlebar: Answering Incoming Phone Call");
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    telecomManager.acceptRingingCall();
                }
            } else if (ev.callReject && (currentCallState == TelephonyManager.CALL_STATE_RINGING || currentCallState == TelephonyManager.CALL_STATE_OFFHOOK)) {
                Log.i(TAG, "Handlebar: Ending / Rejecting Phone Call");
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
                    telecomManager.endCall();
                }
            }
        } catch (SecurityException e) {
            Log.e(TAG, "Call answer/end permission error: " + e.getMessage());
        }
    }

    private String resolveContactName(String phoneNumber) {
        if (phoneNumber == null || phoneNumber.isEmpty()) return null;
        try {
            Uri uri = Uri.withAppendedPath(ContactsContract.PhoneLookup.CONTENT_FILTER_URI, Uri.encode(phoneNumber));
            Cursor cursor = context.getContentResolver().query(uri, new String[]{ContactsContract.PhoneLookup.DISPLAY_NAME}, null, null, null);
            if (cursor != null) {
                if (cursor.moveToFirst()) {
                    int nameIdx = cursor.getColumnIndex(ContactsContract.PhoneLookup.DISPLAY_NAME);
                    if (nameIdx >= 0) {
                        String name = cursor.getString(nameIdx);
                        cursor.close();
                        return name;
                    }
                }
                cursor.close();
            }
        } catch (Exception e) {
            Log.w(TAG, "Contact lookup error: " + e.getMessage());
        }
        return phoneNumber;
    }

    public int getCurrentCallState() {
        return currentCallState;
    }

    public String getActiveCaller() {
        return activeCaller;
    }
}
