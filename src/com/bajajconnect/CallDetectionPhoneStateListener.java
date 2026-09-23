package com.bajajconnect;

import android.telephony.PhoneStateListener;

/* JADX INFO: loaded from: classes3.dex */
public class CallDetectionPhoneStateListener extends PhoneStateListener {
    private PhoneCallStateUpdate callStatCallBack;

    interface PhoneCallStateUpdate {
        void phoneCallStateUpdated(int i, String str);
    }

    public CallDetectionPhoneStateListener(PhoneCallStateUpdate phoneCallStateUpdate) {
        this.callStatCallBack = phoneCallStateUpdate;
    }

    @Override // android.telephony.PhoneStateListener
    public void onCallStateChanged(int i, String str) {
        this.callStatCallBack.phoneCallStateUpdated(i, str);
    }
}
