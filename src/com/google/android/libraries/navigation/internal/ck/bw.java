package com.google.android.libraries.navigation.internal.ck;

import com.google.android.libraries.navigation.internal.adg.ex;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class bw implements bs {
    private static final com.google.android.libraries.navigation.internal.zb.j b = com.google.android.libraries.navigation.internal.zb.j.e("com.google.android.libraries.navigation.internal.ck.bw");
    public final com.google.android.libraries.navigation.internal.cp.r a;

    public bw(com.google.android.libraries.navigation.internal.cp.r rVar) {
        this.a = rVar;
    }

    @Override // com.google.android.libraries.navigation.internal.ck.as
    public final void a(com.google.android.libraries.navigation.internal.ol.ax axVar) {
        throw null;
    }

    @Override // com.google.android.libraries.navigation.internal.ck.as
    public final cm b(aq aqVar) {
        return new br(this, aqVar.a, aqVar.b);
    }

    @Override // com.google.android.libraries.navigation.internal.ck.bs
    public final com.google.android.libraries.navigation.internal.ol.aq c(com.google.android.libraries.navigation.internal.cq.ac acVar) {
        int iOrdinal = acVar.c().ordinal();
        com.google.android.libraries.navigation.internal.cp.r rVar = this.a;
        switch (iOrdinal) {
            case 17:
                return rVar.l;
            case 18:
                return rVar.m;
            case 19:
                acVar.e();
                return rVar.a(null, rVar.a, true);
            default:
                return rVar.a;
        }
    }

    @Override // com.google.android.libraries.navigation.internal.ck.bs
    public final com.google.android.libraries.navigation.internal.ol.aq d(com.google.android.libraries.navigation.internal.cq.ac acVar) {
        int iOrdinal = acVar.c().ordinal();
        com.google.android.libraries.navigation.internal.cp.r rVar = this.a;
        if (iOrdinal == 1) {
            return rVar.e;
        }
        if (iOrdinal == 2) {
            return rVar.f;
        }
        if (iOrdinal == 4) {
            return rVar.g;
        }
        if (iOrdinal == 5) {
            return rVar.h;
        }
        switch (iOrdinal) {
            case 17:
                return rVar.f377n;
            case 18:
                return rVar.o;
            case 19:
                acVar.e();
                return rVar.a(null, rVar.d, false);
            default:
                return rVar.d;
        }
    }

    @Override // com.google.android.libraries.navigation.internal.ck.bs
    public final com.google.android.libraries.navigation.internal.ol.aq e(com.google.android.libraries.navigation.internal.cq.ac acVar) {
        com.google.android.libraries.navigation.internal.cq.f fVar = (com.google.android.libraries.navigation.internal.cq.f) acVar;
        int iOrdinal = fVar.a.ordinal();
        com.google.android.libraries.navigation.internal.cp.r rVar = this.a;
        switch (iOrdinal) {
            case 17:
                return rVar.p;
            case 18:
                return rVar.q;
            case 19:
                ex exVar = fVar.b;
                return rVar.a(null, rVar.c, false);
            default:
                return rVar.c;
        }
    }

    @Override // com.google.android.libraries.navigation.internal.ck.bs
    public final com.google.android.libraries.navigation.internal.ol.aq f(com.google.android.libraries.navigation.internal.cq.ac acVar) {
        int iOrdinal = acVar.c().ordinal();
        com.google.android.libraries.navigation.internal.cp.r rVar = this.a;
        if (iOrdinal == 1 || iOrdinal == 2) {
            return rVar.i;
        }
        if (iOrdinal == 4) {
            return rVar.j;
        }
        if (iOrdinal == 5) {
            return rVar.k;
        }
        switch (iOrdinal) {
            case 17:
                return rVar.r;
            case 18:
                return rVar.s;
            case 19:
                acVar.e();
                return rVar.a(null, rVar.b, false);
            default:
                return rVar.b;
        }
    }
}
