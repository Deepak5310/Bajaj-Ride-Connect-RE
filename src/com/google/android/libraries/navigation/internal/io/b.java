package com.google.android.libraries.navigation.internal.io;

import com.google.android.libraries.navigation.internal.yx.ar;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public abstract class b {
    public static final b b = new a(false, "", false);
    public static final b c = new a(true, "", true);

    public abstract String a();

    public abstract boolean b();

    public abstract boolean c();

    public final String d() {
        boolean z = false;
        if (c() && !e()) {
            z = true;
        }
        ar.l(z, "Zwieback cookie is only valid if the Zwieback cookie override is enabled and not clearing the Zwieback cookie.");
        return a();
    }

    public final boolean e() {
        ar.l(c(), "Zwieback cookie clearing is only valid if the Zwieback cookie override is enabled.");
        return b();
    }
}
