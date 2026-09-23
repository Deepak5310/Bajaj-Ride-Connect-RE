package com.bajajconnect.recievers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsMessage;
import android.util.Log;
import com.bajajconnect.ble.BleFeatures;

/* JADX INFO: loaded from: classes3.dex */
public class SmsReceiver extends BroadcastReceiver {
    private static final String TAG = "SMS_STATE";

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        Object[] objArr;
        Log.d(TAG, "onReceive: SMS broadcast received");
        Bundle extras = intent.getExtras();
        String originatingAddress = "";
        if (extras != null && (objArr = (Object[]) extras.get("pdus")) != null) {
            int length = objArr.length;
            SmsMessage[] smsMessageArr = new SmsMessage[length];
            for (int i = 0; i < length; i++) {
                SmsMessage smsMessageCreateFromPdu = SmsMessage.createFromPdu((byte[]) objArr[i]);
                smsMessageArr[i] = smsMessageCreateFromPdu;
                originatingAddress = smsMessageCreateFromPdu.getOriginatingAddress();
            }
        }
        StringBuilder sb = new StringBuilder("SMS from numberLen=");
        sb.append(originatingAddress != null ? originatingAddress.length() : 0);
        Log.d(TAG, sb.toString());
        if (BleFeatures.iphoneState != null) {
            BleFeatures.iphoneState.onSmsReceived(context, originatingAddress);
        } else {
            Log.d(TAG, "iphoneState is null, cannot dispatch SMS event");
        }
    }
}
