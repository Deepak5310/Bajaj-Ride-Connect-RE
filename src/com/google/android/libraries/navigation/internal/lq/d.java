package com.google.android.libraries.navigation.internal.lq;

import android.content.Context;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class d {
    private static d b;
    public final Context a;
    private final boolean c = true;

    public d(Context context) {
        this.a = context;
    }

    public static synchronized d a(Context context) {
        Context contextA = a.a(context);
        d dVar = b;
        if (dVar == null || dVar.a != contextA) {
            b = new d(contextA);
        }
        return b;
    }
}
