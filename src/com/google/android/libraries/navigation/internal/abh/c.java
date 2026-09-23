package com.google.android.libraries.navigation.internal.abh;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.StrictMode;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class c {
    public final SharedPreferences a;

    public c(Context context) {
        StrictMode.ThreadPolicy threadPolicyB = com.google.android.libraries.navigation.internal.abf.w.a.b();
        try {
            this.a = context.getSharedPreferences("com.google.maps.api.android.lib6.impl.PREFERENCES_FILE", 0);
        } finally {
            com.google.android.libraries.navigation.internal.abf.w.a.d(threadPolicyB);
        }
    }
}
