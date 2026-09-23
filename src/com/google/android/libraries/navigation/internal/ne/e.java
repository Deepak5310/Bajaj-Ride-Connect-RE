package com.google.android.libraries.navigation.internal.ne;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import java.util.TimeZone;
import org.joda.time.DateTimeZone;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class e extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        try {
            DateTimeZone dateTimeZoneForTimeZone = DateTimeZone.forTimeZone(TimeZone.getDefault());
            DateTimeZone.setDefault(dateTimeZoneForTimeZone);
            dateTimeZoneForTimeZone.getID();
        } catch (IllegalArgumentException unused) {
        }
    }
}
