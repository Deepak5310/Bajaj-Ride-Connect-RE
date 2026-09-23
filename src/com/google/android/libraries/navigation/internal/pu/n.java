package com.google.android.libraries.navigation.internal.pu;

import com.google.android.libraries.navigation.internal.aac.bz;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class n implements com.google.android.libraries.navigation.internal.oo.e, bq {
    private static final Object b = new Object();
    public final com.google.android.libraries.navigation.internal.ox.f a;
    private final a c;
    private final com.google.android.libraries.navigation.internal.yx.an d;
    private final com.google.android.libraries.navigation.internal.pm.d e;
    private final Executor f;
    private final Set g = new HashSet();

    public n(a aVar, com.google.android.libraries.navigation.internal.ox.f fVar, com.google.android.libraries.navigation.internal.yx.an anVar, Executor executor, com.google.android.libraries.navigation.internal.pm.d dVar) {
        this.c = aVar;
        this.a = fVar;
        this.d = anVar;
        this.e = dVar;
        this.f = new bz(executor);
    }

    @Override // com.google.android.libraries.navigation.internal.oo.e
    public final void a(com.google.android.libraries.navigation.internal.adi.af afVar) {
        this.a.b(afVar);
    }

    @Override // com.google.android.libraries.navigation.internal.oo.e
    public final boolean b() {
        return false;
    }

    @Override // com.google.android.libraries.navigation.internal.oo.e
    public final m c() {
        return new m(this.c, this.e, this.a, this);
    }
}
