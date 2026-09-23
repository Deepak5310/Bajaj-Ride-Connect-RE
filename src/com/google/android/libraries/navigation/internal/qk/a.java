package com.google.android.libraries.navigation.internal.qk;

import com.google.android.libraries.navigation.internal.yz.ev;
import java.util.Objects;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class a extends g {
    private com.google.android.libraries.navigation.internal.ol.n a;
    private r b;
    private t c;
    private int d;
    private ev e;
    private byte f;

    public a() {
    }

    public a(h hVar) {
        b bVar = (b) hVar;
        this.a = bVar.a;
        this.b = bVar.b;
        this.c = bVar.c;
        this.d = bVar.d;
        this.e = bVar.e;
        this.f = (byte) 1;
    }

    @Override // com.google.android.libraries.navigation.internal.qk.g
    public final h a() {
        com.google.android.libraries.navigation.internal.ol.n nVar;
        r rVar;
        t tVar;
        ev evVar;
        if (this.f != 1 || (nVar = this.a) == null || (rVar = this.b) == null || (tVar = this.c) == null || (evVar = this.e) == null) {
            throw new IllegalStateException();
        }
        return new b(nVar, rVar, tVar, this.d, evVar);
    }

    @Override // com.google.android.libraries.navigation.internal.qk.g
    public final void b(com.google.android.libraries.navigation.internal.ol.n nVar) {
        Objects.requireNonNull(nVar);
        this.a = nVar;
    }

    @Override // com.google.android.libraries.navigation.internal.qk.g
    public final void c(r rVar) {
        Objects.requireNonNull(rVar);
        this.b = rVar;
    }

    @Override // com.google.android.libraries.navigation.internal.qk.g
    public final void d(int i) {
        this.d = i;
        this.f = (byte) 1;
    }

    @Override // com.google.android.libraries.navigation.internal.qk.g
    public final void e(ev evVar) {
        Objects.requireNonNull(evVar);
        this.e = evVar;
    }

    @Override // com.google.android.libraries.navigation.internal.qk.g
    public final void f(t tVar) {
        Objects.requireNonNull(tVar);
        this.c = tVar;
    }
}
