package com.google.android.libraries.navigation.internal.wa;

import android.app.PendingIntent;
import android.app.Service;
import android.content.ComponentName;
import android.content.Intent;
import android.os.Build;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class a {
    private static final int a;
    private final com.google.android.libraries.navigation.internal.tk.e b;
    private final Service c;

    static {
        a = Build.VERSION.SDK_INT >= 26 ? 201326592 : 134217728;
    }

    public a(Service service, com.google.android.libraries.navigation.internal.tk.e eVar) {
        this.c = service;
        this.b = eVar;
    }

    public final int a() {
        return this.b.b;
    }

    public final PendingIntent b(ComponentName componentName) {
        if (componentName == null) {
            return null;
        }
        return PendingIntent.getActivity(this.c, 0, new Intent().setComponent(componentName), a);
    }
}
