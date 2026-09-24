package com.bajaj.rideconnect.re;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.Cursor;
import android.media.AudioManager;
import android.net.Uri;
import android.os.Build;
import android.provider.ContactsContract;
import android.telephony.TelephonyCallback;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.view.KeyEvent;

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

    private int currentCallState = 0; // 0=Idle, 1=Ringing, 2=Offhook
    private String activeCaller = "";

    public TelephonyCallHandler(Context context, PulsarBleManager bleManager) {
        this.context = context.getApplicationContext();
        this.bleManager = bleManager;
        this.telephonyManager = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);

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
        if (ev == null) return;

        try {
            if (ev.callAccept && currentCallState == TelephonyManager.CALL_STATE_RINGING) {
                Log.i(TAG, "Handlebar: Answering Incoming Phone Call");
                AudioManager am = (AudioManager) context.getSystemService(Context.AUDIO_SERVICE);
                if (am != null) {
                    am.dispatchMediaKeyEvent(new KeyEvent(KeyEvent.ACTION_DOWN, KeyEvent.KEYCODE_HEADSETHOOK));
                    am.dispatchMediaKeyEvent(new KeyEvent(KeyEvent.ACTION_UP, KeyEvent.KEYCODE_HEADSETHOOK));
                }
            } else if (ev.callReject && (currentCallState == TelephonyManager.CALL_STATE_RINGING || currentCallState == TelephonyManager.CALL_STATE_OFFHOOK)) {
                Log.i(TAG, "Handlebar: Ending / Rejecting Phone Call");
                AudioManager am = (AudioManager) context.getSystemService(Context.AUDIO_SERVICE);
                if (am != null) {
                    am.dispatchMediaKeyEvent(new KeyEvent(KeyEvent.ACTION_DOWN, KeyEvent.KEYCODE_ENDCALL));
                    am.dispatchMediaKeyEvent(new KeyEvent(KeyEvent.ACTION_UP, KeyEvent.KEYCODE_ENDCALL));
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
            try (Cursor cursor = context.getContentResolver().query(uri, new String[]{ContactsContract.PhoneLookup.DISPLAY_NAME}, null, null, null)) {
                if (cursor != null && cursor.moveToFirst()) {
                    int nameIdx = cursor.getColumnIndex(ContactsContract.PhoneLookup.DISPLAY_NAME);
                    if (nameIdx >= 0) {
                        return cursor.getString(nameIdx);
                    }
                }
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
