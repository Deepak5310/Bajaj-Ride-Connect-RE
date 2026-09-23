package com.google.android.libraries.navigation.internal.cr;

import com.google.android.libraries.navigation.internal.ot.q;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class f {
    private final Map a = new ConcurrentHashMap();

    public final void a(com.google.android.libraries.navigation.internal.op.f fVar) {
        this.a.remove(e.d(fVar));
    }

    public final void b(q qVar) {
        this.a.remove(e.e(qVar));
    }

    public final void c(com.google.android.libraries.navigation.internal.op.f fVar, com.google.android.libraries.navigation.internal.cs.a aVar) {
        this.a.put(e.d(fVar), aVar);
    }

    public final void d(q qVar, com.google.android.libraries.navigation.internal.cs.a aVar) {
        this.a.put(e.e(qVar), aVar);
    }
}
