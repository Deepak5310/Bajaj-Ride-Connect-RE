package com.google.android.libraries.navigation.internal.ps;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class k {
    public com.google.android.libraries.navigation.internal.pt.a a;
    public final List c = new CopyOnWriteArrayList();
    public final com.google.android.libraries.navigation.internal.fq.k b = new com.google.android.libraries.navigation.internal.fq.k(50, com.google.android.libraries.navigation.internal.fq.h.INDOOR_ACTIVE_LEVELS, null);

    public final com.google.android.libraries.navigation.internal.pt.c a(com.google.android.libraries.navigation.internal.pt.a aVar) {
        if (aVar == null) {
            return null;
        }
        j jVar = (j) this.b.f(aVar.a);
        if (jVar == null) {
            return aVar.a();
        }
        int i = jVar.b;
        if (i != -1) {
            return aVar.b(i);
        }
        return null;
    }

    public final String toString() {
        return String.format("[focused: %s]", this.a);
    }
}
