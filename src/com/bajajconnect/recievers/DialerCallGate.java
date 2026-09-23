package com.bajajconnect.recievers;

import android.content.Context;
import android.media.AudioManager;
import android.telephony.TelephonyManager;
import android.util.Log;
import androidx.autofill.HintConstants;
import com.bajajconnect.ble.BleService;
import com.bajajconnect.enums.CallState;
import com.bajajconnect.variables.GlobalVar;

/* JADX INFO: loaded from: classes3.dex */
public final class DialerCallGate {
    private static final String TAG = "DIALER_CALL_GATE";
    private static volatile boolean whatsAppVoipNotificationActive = false;

    private DialerCallGate() {
    }

    public static void setWhatsAppVoipNotificationActive(boolean z) {
        boolean z2 = whatsAppVoipNotificationActive;
        whatsAppVoipNotificationActive = z;
        if (z) {
            clearClusterCallState("whatsapp voip notification active");
        } else if (z2) {
            clearClusterCallState("whatsapp voip notification cleared");
        }
    }

    public static boolean isWhatsAppVoipNotificationActive() {
        return whatsAppVoipNotificationActive;
    }

    public static boolean shouldSuppressTelephonyCallEvents(Context context) {
        int callState;
        if (whatsAppVoipNotificationActive) {
            return true;
        }
        if (GlobalVar.callState == CallState.OUTGOING_CALL || GlobalVar.callState == CallState.ACTIVE_CALL || GlobalVar.callState == CallState.INCOMING_CALL || GlobalVar.callState == CallState.END_CALL || context == null) {
            return false;
        }
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService(HintConstants.AUTOFILL_HINT_PHONE);
            if (telephonyManager != null && ((callState = telephonyManager.getCallState()) == 2 || callState == 1)) {
                return false;
            }
        } catch (Exception unused) {
        }
        try {
            AudioManager audioManager = (AudioManager) context.getSystemService("audio");
            if (audioManager != null && audioManager.getMode() == 3) {
                Log.d(TAG, "suppress telephony: audio MODE_IN_COMMUNICATION (VoIP)");
                return true;
            }
        } catch (Exception unused2) {
        }
        return false;
    }

    public static void clearClusterCallState(String str) {
        if (GlobalVar.callState != CallState.NO_CALL || ((GlobalVar.callerName != null && !GlobalVar.callerName.isEmpty()) || (GlobalVar.callerNumber != null && !GlobalVar.callerNumber.isEmpty()))) {
            Log.i(TAG, "clearing cluster call state — " + str + " (was callState=" + GlobalVar.callState + ")");
        }
        try {
            BleService.forceClearClusterCall("gate:" + str);
        } catch (Exception unused) {
            GlobalVar.callState = CallState.NO_CALL;
            GlobalVar.callerName = "";
            GlobalVar.callerNumber = "";
            GlobalVar.callProgressCount = 0;
        }
    }
}
