package com.google.android.libraries.navigation.internal.qe;

import com.google.android.libraries.navigation.internal.pb.t;
import com.google.android.libraries.navigation.internal.pb.x;
import com.google.android.libraries.navigation.internal.yx.ar;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class c extends x {
    public boolean a;
    public float m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public float f550n;
    public float o;
    public com.google.android.libraries.navigation.internal.pd.d p;
    public long q;
    private com.google.android.libraries.navigation.internal.pd.d r;
    private final t s;

    public c(com.google.android.libraries.navigation.internal.ni.a aVar, t tVar) {
        super(aVar);
        this.q = 0L;
        this.s = tVar;
    }

    @Override // com.google.android.libraries.navigation.internal.pb.x, com.google.android.libraries.navigation.internal.pc.c
    public final int a(long j) {
        if (this.p == null) {
            com.google.android.libraries.navigation.internal.pd.d dVar = this.r;
            ar.q(dVar);
            if (this.a) {
                this.p = com.google.android.libraries.navigation.internal.pb.j.k(this.s, dVar, this.m, this.f550n, this.o);
            } else {
                com.google.android.libraries.navigation.internal.pd.a aVar = new com.google.android.libraries.navigation.internal.pd.a(dVar);
                aVar.c = this.m;
                this.p = aVar.a();
            }
            super.m(dVar, this.p);
            super.p(this.q);
        }
        return super.a(j);
    }

    @Override // com.google.android.libraries.navigation.internal.pb.x, com.google.android.libraries.navigation.internal.pc.c
    public final int b() {
        return this.a ? com.google.android.libraries.navigation.internal.pd.d.c | com.google.android.libraries.navigation.internal.pd.d.d : com.google.android.libraries.navigation.internal.pd.d.d;
    }

    @Override // com.google.android.libraries.navigation.internal.pb.x, com.google.android.libraries.navigation.internal.pc.c
    public final boolean k(com.google.android.libraries.navigation.internal.pc.c cVar) {
        return ((cVar instanceof d) && ((d) cVar).D()) ? false : true;
    }

    @Override // com.google.android.libraries.navigation.internal.pb.x, com.google.android.libraries.navigation.internal.pc.c
    public final void l(int i) {
        this.d = this.c.a();
    }

    @Override // com.google.android.libraries.navigation.internal.pb.x
    public final boolean m(com.google.android.libraries.navigation.internal.pd.d dVar, com.google.android.libraries.navigation.internal.pd.d dVar2) {
        this.r = dVar;
        return true;
    }
}
