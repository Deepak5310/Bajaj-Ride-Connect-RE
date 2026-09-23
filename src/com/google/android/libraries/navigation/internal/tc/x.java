package com.google.android.libraries.navigation.internal.tc;

import android.content.Context;
import android.os.Build;
import androidx.core.content.ContextCompat;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class x {
    private final Context a;

    public x(Context context) {
        this.a = context;
    }

    private final boolean b(String str) {
        return ContextCompat.checkSelfPermission(this.a, str) == 0;
    }

    public final boolean a() {
        if (Build.VERSION.SDK_INT < 31) {
            return b("android.permission.BLUETOOTH");
        }
        return b("android.permission.BLUETOOTH_SCAN") && b("android.permission.BLUETOOTH_CONNECT") && b("android.permission.BLUETOOTH");
    }
}
