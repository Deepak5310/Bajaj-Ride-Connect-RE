package com.google.android.libraries.navigation.internal.lh;

import android.content.ServiceConnection;
import android.os.HandlerThread;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public abstract class ad {
    public static final int a = 4225;
    public static final Object b = new Object();
    public static final int c = 9;
    public static ag d;
    public static HandlerThread e;

    public final void a(String str, String str2, int i, ServiceConnection serviceConnection, String str3, boolean z) {
        c(new ac(str, "com.google.android.gms", a, z), serviceConnection);
    }

    protected abstract com.google.android.libraries.navigation.internal.lc.a b(ac acVar, ServiceConnection serviceConnection, String str);

    protected abstract void c(ac acVar, ServiceConnection serviceConnection);
}
