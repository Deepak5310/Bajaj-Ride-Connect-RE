package com.google.android.libraries.navigation.internal.px;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public abstract class cg {
    public static cg c(com.google.android.libraries.navigation.internal.oe.ad adVar) {
        return new m(null, adVar);
    }

    public static cg d(com.google.android.libraries.navigation.internal.oe.x xVar) {
        return e(com.google.android.libraries.geo.mapcore.internal.model.c.a(xVar));
    }

    public static cg e(com.google.android.libraries.geo.mapcore.internal.model.c cVar) {
        return new m(cVar, null);
    }

    public static cg f() {
        return new m(null, null);
    }

    public abstract com.google.android.libraries.navigation.internal.oe.ad a();

    public abstract com.google.android.libraries.geo.mapcore.internal.model.c b();

    public final boolean g() {
        return a() != null;
    }

    public final boolean h() {
        return b() != null;
    }
}
