package com.google.android.libraries.navigation.internal.lk;

import android.content.Context;
import android.content.ServiceConnection;
import java.util.NoSuchElementException;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class a {
    public static final Object a = new Object();
    public static volatile a b;
    public final ConcurrentHashMap c = new ConcurrentHashMap();

    private static void b(Context context, ServiceConnection serviceConnection) {
        try {
            context.unbindService(serviceConnection);
        } catch (IllegalArgumentException | IllegalStateException | NoSuchElementException unused) {
        }
    }

    public final void a(Context context, ServiceConnection serviceConnection) {
        b(context, serviceConnection);
    }
}
