package com.google.android.libraries.navigation.internal.afx;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class o {
    public static final o a = new o(new k(), l.a);
    private final ConcurrentMap b = new ConcurrentHashMap();

    public o(n... nVarArr) {
        for (int i = 0; i < 2; i++) {
            n nVar = nVarArr[i];
            this.b.put(nVar.a(), nVar);
        }
    }
}
