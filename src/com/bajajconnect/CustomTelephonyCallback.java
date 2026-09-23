package com.bajajconnect;

import android.telephony.TelephonyCallback;

/* JADX INFO: loaded from: classes3.dex */
public class CustomTelephonyCallback extends TelephonyCallback implements TelephonyCallback.CallStateListener {
    private CallStateUpdate mCallBack;

    interface CallStateUpdate {
        void phoneCallStateUpdated(int i, String str);
    }

    public CustomTelephonyCallback(CallStateUpdate callStateUpdate) {
        this.mCallBack = callStateUpdate;
    }

    public void onCallStateChanged(int i) {
        this.mCallBack.phoneCallStateUpdated(i, "1234");
    }
}
