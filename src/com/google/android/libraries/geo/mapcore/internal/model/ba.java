package com.google.android.libraries.geo.mapcore.internal.model;

import com.google.android.libraries.navigation.internal.agg.ez;
import com.google.android.libraries.navigation.internal.po.dj;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes2.dex */
public final class ba {
    public static final ba a = new ba(-1, -1, 0);
    public static final ba b = new ba(-1, 0, 0);
    public final long c;
    public final int d;
    public final int e;

    public ba(long j, int i, int i2) {
        this.c = j;
        this.d = i;
        this.e = i2;
    }

    public static long a(long j, bd bdVar, ez ezVar) {
        return (bdVar == null || ezVar == null || ezVar.isEmpty()) ? j : bdVar.a.a(j, ezVar);
    }

    public final ai b(be beVar, int i) {
        bt btVar;
        bt btVar2;
        if (this.e != 0) {
            synchronized (((dj) beVar).b) {
                btVar2 = ((dj) beVar).b;
            }
            return btVar2.f(i);
        }
        if (this.c == -1) {
            int i2 = this.d;
            return i2 != -1 ? beVar.k(i2).g(i) : ai.c;
        }
        synchronized (((dj) beVar).b) {
            btVar = ((dj) beVar).b;
        }
        return btVar.g(i);
    }

    public final bt c(bv bvVar) {
        return d(bvVar, null, null);
    }

    public final bt d(bv bvVar, bd bdVar, ez ezVar) {
        if (bvVar == null) {
            return bt.a;
        }
        int i = this.e;
        if (i != 0) {
            return bvVar.b(i);
        }
        long j = this.c;
        if (j != -1) {
            return bvVar.c(a(j, bdVar, ezVar));
        }
        int i2 = this.d;
        return i2 != -1 ? bvVar.c(i2) : bt.a;
    }

    public final boolean e() {
        return (this.c == -1 && this.e == 0) ? false : true;
    }

    public final boolean equals(Object obj) {
        ba baVar;
        return (obj instanceof ba) && (baVar = (ba) obj) != null && this.c == baVar.c && this.d == baVar.d;
    }

    public final boolean f() {
        return this.c == -1 && this.d == -1 && this.e == 0;
    }

    public final int hashCode() {
        return ((((int) this.c) + 31) * 31) + this.d;
    }
}
