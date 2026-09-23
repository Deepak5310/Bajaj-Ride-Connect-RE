package com.bajajconnect.recievers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.telephony.TelephonyManager;
import android.util.Log;
import com.bajajconnect.ble.BleFeatures;
import java.util.Date;

/* JADX INFO: loaded from: classes3.dex */
public class PhoneClassStateListener extends BroadcastReceiver {
    private static final String TAG = "CALL_STATE";
    private static Date callStartTime;
    private static boolean isIncoming;
    private static String lastState = TelephonyManager.EXTRA_STATE_IDLE;
    private static String savedNumber;

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        boolean zIsWhatsAppVoipNotificationActive;
        String action = intent.getAction();
        Log.d(TAG, "onReceive: action=" + action);
        if ("android.intent.action.NEW_OUTGOING_CALL".equals(action)) {
            if (DialerCallGate.isWhatsAppVoipNotificationActive()) {
                Log.d(TAG, "Ignoring NEW_OUTGOING_CALL — WhatsApp VoIP active");
                return;
            }
            String stringExtra = intent.getStringExtra("android.intent.extra.PHONE_NUMBER");
            Log.d(TAG, "Outgoing call to: " + stringExtra);
            savedNumber = stringExtra != null ? stringExtra : "";
            isIncoming = false;
            if (BleFeatures.iphoneState != null) {
                BleFeatures.iphoneState.onOutgoingCallStarted(context, savedNumber, new Date());
                return;
            }
            return;
        }
        String stringExtra2 = intent.getStringExtra("state");
        if (stringExtra2 == null) {
            Log.d(TAG, "phoneState is null, ignoring");
            return;
        }
        String stringExtra3 = intent.getStringExtra("incoming_number");
        boolean z = (stringExtra3 == null || stringExtra3.isEmpty()) ? false : true;
        if (TelephonyManager.EXTRA_STATE_RINGING.equals(stringExtra2) && !TelephonyManager.EXTRA_STATE_RINGING.equals(lastState)) {
            if (!z) {
                stringExtra3 = "";
            }
            savedNumber = stringExtra3;
        } else if (z) {
            savedNumber = stringExtra3;
        }
        String str = savedNumber;
        if (str == null) {
            str = "";
        }
        Log.d(TAG, "phoneState=" + stringExtra2 + " lastState=" + lastState + " numberLen=" + str.length() + " freshNumber=" + z);
        if (TelephonyManager.EXTRA_STATE_RINGING.equals(stringExtra2) || TelephonyManager.EXTRA_STATE_OFFHOOK.equals(stringExtra2)) {
            zIsWhatsAppVoipNotificationActive = DialerCallGate.isWhatsAppVoipNotificationActive();
        } else {
            zIsWhatsAppVoipNotificationActive = DialerCallGate.shouldSuppressTelephonyCallEvents(context);
        }
        if (zIsWhatsAppVoipNotificationActive) {
            Log.d(TAG, "Suppressing PHONE_STATE for cluster — non-dialer/VoIP call");
            if (!lastState.equals(stringExtra2)) {
                lastState = stringExtra2;
            }
            DialerCallGate.clearClusterCallState("suppressed PHONE_STATE=" + stringExtra2);
            if (TelephonyManager.EXTRA_STATE_IDLE.equals(stringExtra2)) {
                savedNumber = "";
                isIncoming = false;
                return;
            }
            return;
        }
        if (lastState.equals(stringExtra2)) {
            if (TelephonyManager.EXTRA_STATE_RINGING.equals(stringExtra2) && z && BleFeatures.iphoneState != null) {
                Log.d(TAG, "Same RINGING state but got number now, updating");
                BleFeatures.iphoneState.onIncoming(context, str, callStartTime);
                return;
            } else {
                if (TelephonyManager.EXTRA_STATE_IDLE.equals(stringExtra2)) {
                    savedNumber = "";
                    isIncoming = false;
                }
                Log.d(TAG, "Same state, ignoring");
                return;
            }
        }
        if (BleFeatures.iphoneState == null) {
            Log.d(TAG, "iphoneState is null, cannot dispatch call events");
            return;
        }
        if (TelephonyManager.EXTRA_STATE_RINGING.equals(stringExtra2)) {
            isIncoming = true;
            callStartTime = new Date();
            lastState = TelephonyManager.EXTRA_STATE_RINGING;
            Log.d(TAG, "INCOMING CALL from: " + str);
            BleFeatures.iphoneState.onIncoming(context, str, callStartTime);
            return;
        }
        if (TelephonyManager.EXTRA_STATE_IDLE.equals(stringExtra2)) {
            if (lastState.equals(TelephonyManager.EXTRA_STATE_RINGING)) {
                lastState = TelephonyManager.EXTRA_STATE_IDLE;
                Log.d(TAG, "MISSED CALL from: " + str);
                BleFeatures.iphoneState.onMissedCall(context, str, callStartTime);
            } else if (isIncoming) {
                lastState = TelephonyManager.EXTRA_STATE_IDLE;
                Log.d(TAG, "INCOMING CALL ENDED: " + str);
                BleFeatures.iphoneState.onIncomingCallEnded(context, str, callStartTime, new Date());
            } else {
                lastState = TelephonyManager.EXTRA_STATE_IDLE;
                Log.d(TAG, "OUTGOING CALL ENDED: " + str);
                BleFeatures.iphoneState.onOutgoingCallEnded(context, str, callStartTime, new Date());
            }
            savedNumber = "";
            return;
        }
        if (TelephonyManager.EXTRA_STATE_OFFHOOK.equals(stringExtra2)) {
            if (lastState.equals(TelephonyManager.EXTRA_STATE_RINGING)) {
                isIncoming = true;
                callStartTime = new Date();
                lastState = TelephonyManager.EXTRA_STATE_OFFHOOK;
                Log.d(TAG, "INCOMING CALL ANSWERED: " + str);
                BleFeatures.iphoneState.onIncomingCallStarted(context, str, callStartTime);
                return;
            }
            isIncoming = false;
            callStartTime = new Date();
            lastState = TelephonyManager.EXTRA_STATE_OFFHOOK;
            Log.d(TAG, "OUTGOING CALL OFFHOOK (local dialing started): " + str);
            BleFeatures.iphoneState.onOutgoingCallConnected(context, str, callStartTime);
        }
    }
}
