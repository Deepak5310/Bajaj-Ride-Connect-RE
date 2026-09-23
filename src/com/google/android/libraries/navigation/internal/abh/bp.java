package com.google.android.libraries.navigation.internal.abh;

import android.content.Context;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class bp {
    public static synchronized void a(Context context) {
        Context applicationContext = context.getApplicationContext();
        com.google.android.libraries.navigation.internal.xo.y.e(applicationContext);
        new com.google.android.libraries.navigation.internal.ma.al(context).b("com.google.android.gms.maps#".concat(String.valueOf(applicationContext.getPackageName())), 1, new String[]{"MAPS_API", "GMM_REALTIME_COUNTERS"});
    }
}
