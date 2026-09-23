package com.google.android.libraries.navigation.internal.xt;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class ad {
    public final ConcurrentMap a = new ConcurrentHashMap();

    public final void a(String str) {
        ae[] aeVarArrB = b(str);
        if (aeVarArrB != null) {
            for (ae aeVar : aeVarArrB) {
                ad adVar = ae.a;
                aeVar.b();
            }
        }
    }

    public final ae[] b(String str) {
        AtomicReference atomicReference = (AtomicReference) this.a.get(str);
        if (atomicReference == null) {
            return null;
        }
        return (ae[]) atomicReference.get();
    }
}
