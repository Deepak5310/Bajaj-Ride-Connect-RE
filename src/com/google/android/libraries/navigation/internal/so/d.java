package com.google.android.libraries.navigation.internal.so;

import com.google.android.libraries.navigation.internal.afl.bz;
import com.google.android.libraries.navigation.internal.bp.bh;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class d {
    public bh b;
    public boolean c;
    public com.google.android.libraries.navigation.internal.su.d e;
    public boolean f;
    private bz g;
    public final String d = "";
    public com.google.android.libraries.navigation.internal.si.e a = com.google.android.libraries.navigation.internal.si.e.GUIDED_NAV;

    private d() {
    }

    public static d a(com.google.android.libraries.navigation.internal.su.d dVar) {
        d dVar2 = new d();
        dVar2.a = com.google.android.libraries.navigation.internal.si.e.FREE_NAV;
        dVar2.e = dVar;
        return dVar2;
    }

    public static d b(bh bhVar, bz bzVar) {
        d dVar = new d();
        dVar.a = com.google.android.libraries.navigation.internal.si.e.GUIDED_NAV;
        dVar.b = bhVar;
        dVar.g = bzVar;
        return dVar;
    }
}
