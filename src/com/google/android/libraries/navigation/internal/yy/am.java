package com.google.android.libraries.navigation.internal.yy;

import com.google.android.libraries.navigation.internal.yx.bz;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
class am extends l implements Serializable {
    private static final long serialVersionUID = 1;
    final aq b;
    final aq c;
    final com.google.android.libraries.navigation.internal.yx.y d;
    final com.google.android.libraries.navigation.internal.yx.y e;
    final long f;
    final long g;
    final long h;
    final int i;
    final bz j;
    final j k;
    transient b l;
    final g m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    final f f656n;

    public am(bi biVar) {
        aq aqVar = biVar.j;
        aq aqVar2 = biVar.k;
        com.google.android.libraries.navigation.internal.yx.y yVar = biVar.h;
        com.google.android.libraries.navigation.internal.yx.y yVar2 = biVar.i;
        long j = biVar.f658n;
        long j2 = biVar.m;
        long j3 = biVar.l;
        g gVar = biVar.w;
        int i = biVar.g;
        f fVar = biVar.x;
        bz bzVar = biVar.q;
        j jVar = biVar.s;
        this.b = aqVar;
        this.c = aqVar2;
        this.d = yVar;
        this.e = yVar2;
        this.f = j;
        this.g = j2;
        this.h = j3;
        this.m = gVar;
        this.i = i;
        this.f656n = fVar;
        this.j = (bzVar == bz.a || bzVar == h.b) ? null : bzVar;
        this.k = jVar;
    }

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        objectInputStream.defaultReadObject();
        this.l = d().a();
    }

    private Object readResolve() {
        return this.l;
    }

    @Override // com.google.android.libraries.navigation.internal.yy.l, com.google.android.libraries.navigation.internal.yz.Cdo
    protected final /* synthetic */ Object aF() {
        return this.l;
    }

    final h d() {
        h hVar = new h();
        hVar.g(this.b);
        aq aqVar = hVar.i;
        com.google.android.libraries.navigation.internal.yx.ar.o(aqVar == null, "Value strength was already set to %s", aqVar);
        aq aqVar2 = this.c;
        com.google.android.libraries.navigation.internal.yx.ar.q(aqVar2);
        hVar.i = aqVar2;
        com.google.android.libraries.navigation.internal.yx.y yVar = hVar.m;
        com.google.android.libraries.navigation.internal.yx.ar.o(yVar == null, "key equivalence was already set to %s", yVar);
        com.google.android.libraries.navigation.internal.yx.y yVar2 = this.d;
        com.google.android.libraries.navigation.internal.yx.ar.q(yVar2);
        hVar.m = yVar2;
        com.google.android.libraries.navigation.internal.yx.y yVar3 = hVar.f659n;
        com.google.android.libraries.navigation.internal.yx.ar.o(yVar3 == null, "value equivalence was already set to %s", yVar3);
        com.google.android.libraries.navigation.internal.yx.y yVar4 = this.e;
        com.google.android.libraries.navigation.internal.yx.ar.q(yVar4);
        hVar.f659n = yVar4;
        int i = hVar.e;
        com.google.android.libraries.navigation.internal.yx.ar.m(i == -1, "concurrency level was already set to %s", i);
        int i2 = this.i;
        com.google.android.libraries.navigation.internal.yx.ar.a(i2 > 0);
        hVar.e = i2;
        com.google.android.libraries.navigation.internal.yx.ar.k(hVar.r == null);
        f fVar = this.f656n;
        com.google.android.libraries.navigation.internal.yx.ar.q(fVar);
        hVar.r = fVar;
        hVar.c = false;
        long j = this.f;
        if (j > 0) {
            TimeUnit timeUnit = TimeUnit.NANOSECONDS;
            long j2 = hVar.j;
            com.google.android.libraries.navigation.internal.yx.ar.n(j2 == -1, "expireAfterWrite was already set to %s ns", j2);
            hVar.j = timeUnit.toNanos(j);
        }
        long j3 = this.g;
        if (j3 > 0) {
            TimeUnit timeUnit2 = TimeUnit.NANOSECONDS;
            long j4 = hVar.k;
            com.google.android.libraries.navigation.internal.yx.ar.n(j4 == -1, "expireAfterAccess was already set to %s ns", j4);
            hVar.k = timeUnit2.toNanos(j3);
        }
        if (this.m != g.INSTANCE) {
            g gVar = this.m;
            com.google.android.libraries.navigation.internal.yx.ar.k(hVar.q == null);
            if (hVar.c) {
                long j5 = hVar.f;
                com.google.android.libraries.navigation.internal.yx.ar.n(j5 == -1, "weigher can not be combined with maximum size (%s provided)", j5);
            }
            com.google.android.libraries.navigation.internal.yx.ar.q(gVar);
            hVar.q = gVar;
            long j6 = this.h;
            if (j6 != -1) {
                long j7 = hVar.g;
                com.google.android.libraries.navigation.internal.yx.ar.n(j7 == -1, "maximum weight was already set to %s", j7);
                long j8 = hVar.f;
                com.google.android.libraries.navigation.internal.yx.ar.n(j8 == -1, "maximum size was already set to %s", j8);
                com.google.android.libraries.navigation.internal.yx.ar.b(true, "maximum weight must not be negative");
                hVar.g = j6;
            }
        } else {
            long j9 = this.h;
            if (j9 != -1) {
                hVar.f(j9);
            }
        }
        bz bzVar = this.j;
        if (bzVar != null) {
            com.google.android.libraries.navigation.internal.yx.ar.k(hVar.o == null);
            com.google.android.libraries.navigation.internal.yx.ar.q(bzVar);
            hVar.o = bzVar;
        }
        return hVar;
    }
}
