package com.bajajconnect.recievers;

import android.content.Context;
import java.util.Date;

/* JADX INFO: loaded from: classes3.dex */
public interface IPhoneState {
    void onBatteryPercentageChange(int i);

    void onBluetoothDisconnected();

    void onHeadsetConnected();

    void onHeadsetDisconnected();

    void onIncoming(Context context, String str, Date date);

    void onIncomingCallEnded(Context context, String str, Date date, Date date2);

    void onIncomingCallStarted(Context context, String str, Date date);

    void onMissedCall(Context context, String str, Date date);

    void onNotificationRecieved(Context context, String str);

    default void onOutgoingCallConnected(Context context, String str, Date date) {
    }

    void onOutgoingCallEnded(Context context, String str, Date date, Date date2);

    void onOutgoingCallStarted(Context context, String str, Date date);

    void onSignalStrengthChange(int i);

    void onSmsReceived(Context context, String str);
}
