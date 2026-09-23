package com.google.android.libraries.navigation.internal.oj;

import com.google.android.libraries.navigation.internal.oe.r;
import com.google.android.libraries.navigation.internal.oe.x;
import com.google.android.libraries.navigation.internal.ol.m;
import com.google.android.libraries.navigation.internal.ol.n;
import com.google.android.libraries.navigation.internal.po.aa;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class d implements com.google.android.libraries.navigation.internal.op.f {
    private final n a;

    public d(n nVar) {
        this.a = nVar;
    }

    @Override // com.google.android.libraries.navigation.internal.op.f
    public final com.google.android.libraries.navigation.internal.op.g a() {
        return ((aa) this.a).d;
    }

    @Override // com.google.android.libraries.navigation.internal.op.f
    public final void b() {
        this.a.i();
    }

    @Override // com.google.android.libraries.navigation.internal.op.f
    public final void c() {
        this.a.h();
    }

    public final void d(com.google.android.libraries.navigation.internal.ol.l lVar) {
        this.a.d(lVar);
    }

    @Override // com.google.android.libraries.navigation.internal.op.f
    public final void e(r rVar, com.google.android.libraries.navigation.internal.adg.b bVar) {
        ((aa) this.a).e(new m(x.z(rVar), bVar), true);
        this.a.m();
    }

    @Override // com.google.android.libraries.navigation.internal.op.f
    public final void f(r rVar, com.google.android.libraries.navigation.internal.adg.b bVar) {
        e(rVar, bVar);
    }
}
