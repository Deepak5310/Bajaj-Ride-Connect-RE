package com.google.android.libraries.navigation.internal.qk;

import com.google.android.libraries.navigation.internal.yx.an;
import com.google.android.libraries.navigation.internal.yz.ev;
import java.util.Objects;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class c extends u {
    public com.google.android.libraries.navigation.internal.oe.x a;
    public byte b;
    private com.google.android.libraries.navigation.internal.op.f c;
    private r d;
    private t e;
    private int f;
    private ev g;
    private com.google.android.libraries.navigation.internal.adg.b h;

    public c() {
    }

    public c(v vVar) {
        d dVar = (d) vVar;
        this.c = dVar.a;
        this.d = dVar.b;
        this.e = dVar.c;
        this.f = dVar.d;
        this.g = dVar.e;
        this.h = dVar.f;
        this.a = dVar.g;
        this.b = (byte) 3;
    }

    @Override // com.google.android.libraries.navigation.internal.qk.u
    public final v a() {
        com.google.android.libraries.navigation.internal.op.f fVar;
        r rVar;
        t tVar;
        ev evVar;
        com.google.android.libraries.navigation.internal.adg.b bVar;
        if (this.b != 3 || (fVar = this.c) == null || (rVar = this.d) == null || (tVar = this.e) == null || (evVar = this.g) == null || (bVar = this.h) == null) {
            throw new IllegalStateException();
        }
        return new d(fVar, rVar, tVar, this.f, evVar, bVar, this.a);
    }

    @Override // com.google.android.libraries.navigation.internal.qk.u
    public final an b() {
        com.google.android.libraries.navigation.internal.adg.b bVar = this.h;
        return bVar == null ? com.google.android.libraries.navigation.internal.yx.a.a : an.j(bVar);
    }

    @Override // com.google.android.libraries.navigation.internal.qk.u
    public final ev c() {
        ev evVar = this.g;
        if (evVar != null) {
            return evVar;
        }
        throw new IllegalStateException();
    }

    @Override // com.google.android.libraries.navigation.internal.qk.u
    public final void d(com.google.android.libraries.navigation.internal.op.f fVar) {
        Objects.requireNonNull(fVar);
        this.c = fVar;
    }

    @Override // com.google.android.libraries.navigation.internal.qk.u
    public final void e(com.google.android.libraries.navigation.internal.adg.b bVar) {
        Objects.requireNonNull(bVar);
        this.h = bVar;
    }

    @Override // com.google.android.libraries.navigation.internal.qk.u
    public final void f(r rVar) {
        Objects.requireNonNull(rVar);
        this.d = rVar;
    }

    @Override // com.google.android.libraries.navigation.internal.qk.u
    public final void g(int i) {
        this.f = i;
        this.b = (byte) (this.b | 1);
    }

    @Override // com.google.android.libraries.navigation.internal.qk.u
    public final void h(ev evVar) {
        Objects.requireNonNull(evVar);
        this.g = evVar;
    }

    @Override // com.google.android.libraries.navigation.internal.qk.u
    public final void i(t tVar) {
        Objects.requireNonNull(tVar);
        this.e = tVar;
    }
}
