package com.google.android.libraries.navigation.internal.sl;

import com.google.android.libraries.navigation.internal.iv.ab;
import com.google.android.libraries.navigation.internal.yx.ar;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public enum s {
    LOUDER(20),
    NORMAL(10),
    SOFTER(0);

    public final int d;

    s(int i) {
        this.d = i;
    }

    public static s a(com.google.android.libraries.navigation.internal.iv.f fVar) {
        s sVar = (s) fVar.g(ab.aI, s.class, NORMAL);
        ar.q(sVar);
        return sVar;
    }
}
