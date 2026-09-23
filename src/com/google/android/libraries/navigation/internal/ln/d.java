package com.google.android.libraries.navigation.internal.ln;

import android.content.Context;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class d {
    private static final d a = new d();
    private c b = null;

    public static c b(Context context) {
        return a.a(context);
    }

    public final synchronized c a(Context context) {
        if (this.b == null) {
            if (context.getApplicationContext() != null) {
                context = context.getApplicationContext();
            }
            this.b = new c(context);
        }
        return this.b;
    }
}
