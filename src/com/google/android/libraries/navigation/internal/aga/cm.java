package com.google.android.libraries.navigation.internal.aga;

import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class cm extends com.google.android.libraries.navigation.internal.afx.e {
    public final AtomicReference a = new AtomicReference(cr.e);
    public final String b;
    final /* synthetic */ cr c;

    public cm(cr crVar, String str) {
        this.c = crVar;
        com.google.android.libraries.navigation.internal.yx.ar.r(str, "authority");
        this.b = str;
    }

    @Override // com.google.android.libraries.navigation.internal.afx.e
    public final String a() {
        return this.b;
    }

    final void b(com.google.android.libraries.navigation.internal.afx.ah ahVar) {
        this.a.set(ahVar);
        dc dcVar = cr.d;
    }
}
