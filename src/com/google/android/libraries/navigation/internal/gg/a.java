package com.google.android.libraries.navigation.internal.gg;

import j$.time.Duration;
import java.util.Objects;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class a extends l {
    public final m a;
    private final Duration c;
    private final Duration d;
    private final Duration e;
    private final Duration f;
    private final Duration g;
    private final Duration h;
    private final Duration i;
    private final Duration j;
    private final Duration k;
    private final Duration l;
    private final Duration m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final Duration f435n;
    private final Duration o;
    private final Duration p;
    private final Duration q;
    private final Duration r;
    private final Duration s;
    private final Duration t;
    private final Duration u;
    private final Duration v;
    private final Duration w;
    private final Duration x;
    private final Duration y;

    public a(Duration duration, Duration duration2, Duration duration3, Duration duration4, Duration duration5, Duration duration6, Duration duration7, Duration duration8, Duration duration9, Duration duration10, Duration duration11, Duration duration12, Duration duration13, Duration duration14, Duration duration15, Duration duration16, Duration duration17, Duration duration18, Duration duration19, Duration duration20, Duration duration21, Duration duration22, Duration duration23, m mVar) {
        Objects.requireNonNull(duration);
        this.c = duration;
        Objects.requireNonNull(duration2);
        this.d = duration2;
        Objects.requireNonNull(duration3);
        this.e = duration3;
        Objects.requireNonNull(duration4);
        this.f = duration4;
        Objects.requireNonNull(duration5);
        this.g = duration5;
        Objects.requireNonNull(duration6);
        this.h = duration6;
        Objects.requireNonNull(duration7);
        this.i = duration7;
        Objects.requireNonNull(duration8);
        this.j = duration8;
        Objects.requireNonNull(duration9);
        this.k = duration9;
        Objects.requireNonNull(duration10);
        this.l = duration10;
        Objects.requireNonNull(duration11);
        this.m = duration11;
        Objects.requireNonNull(duration12);
        this.f435n = duration12;
        Objects.requireNonNull(duration13);
        this.o = duration13;
        Objects.requireNonNull(duration14);
        this.p = duration14;
        Objects.requireNonNull(duration15);
        this.q = duration15;
        Objects.requireNonNull(duration16);
        this.r = duration16;
        Objects.requireNonNull(duration17);
        this.s = duration17;
        Objects.requireNonNull(duration18);
        this.t = duration18;
        Objects.requireNonNull(duration19);
        this.u = duration19;
        Objects.requireNonNull(duration20);
        this.v = duration20;
        Objects.requireNonNull(duration21);
        this.w = duration21;
        Objects.requireNonNull(duration22);
        this.x = duration22;
        Objects.requireNonNull(duration23);
        this.y = duration23;
        Objects.requireNonNull(mVar);
        this.a = mVar;
    }

    @Override // com.google.android.libraries.navigation.internal.gg.l
    public final m a() {
        return this.a;
    }

    @Override // com.google.android.libraries.navigation.internal.gg.l
    public final Duration b() {
        return this.p;
    }

    @Override // com.google.android.libraries.navigation.internal.gg.l
    public final Duration c() {
        return this.o;
    }

    @Override // com.google.android.libraries.navigation.internal.gg.l
    public final Duration d() {
        return this.f435n;
    }

    @Override // com.google.android.libraries.navigation.internal.gg.l
    public final Duration e() {
        return this.m;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof l) {
            l lVar = (l) obj;
            if (this.c.equals(lVar.s()) && this.d.equals(lVar.r()) && this.e.equals(lVar.o()) && this.f.equals(lVar.n()) && this.g.equals(lVar.g()) && this.h.equals(lVar.f()) && this.i.equals(lVar.x()) && this.j.equals(lVar.w()) && this.k.equals(lVar.v()) && this.l.equals(lVar.u()) && this.m.equals(lVar.e()) && this.f435n.equals(lVar.d()) && this.o.equals(lVar.c()) && this.p.equals(lVar.b()) && this.q.equals(lVar.q()) && this.r.equals(lVar.p()) && this.s.equals(lVar.m()) && this.t.equals(lVar.l()) && this.u.equals(lVar.i()) && this.v.equals(lVar.k()) && this.w.equals(lVar.h()) && this.x.equals(lVar.j()) && this.y.equals(lVar.t()) && this.a.equals(lVar.a())) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.android.libraries.navigation.internal.gg.l
    public final Duration f() {
        return this.h;
    }

    @Override // com.google.android.libraries.navigation.internal.gg.l
    public final Duration g() {
        return this.g;
    }

    @Override // com.google.android.libraries.navigation.internal.gg.l
    public final Duration h() {
        return this.w;
    }

    public final int hashCode() {
        return ((((((((((((((((((((((((((((((((((((((((((((((this.c.hashCode() ^ 1000003) * 1000003) ^ this.d.hashCode()) * 1000003) ^ this.e.hashCode()) * 1000003) ^ this.f.hashCode()) * 1000003) ^ this.g.hashCode()) * 1000003) ^ this.h.hashCode()) * 1000003) ^ this.i.hashCode()) * 1000003) ^ this.j.hashCode()) * 1000003) ^ this.k.hashCode()) * 1000003) ^ this.l.hashCode()) * 1000003) ^ this.m.hashCode()) * 1000003) ^ this.f435n.hashCode()) * 1000003) ^ this.o.hashCode()) * 1000003) ^ this.p.hashCode()) * 1000003) ^ this.q.hashCode()) * 1000003) ^ this.r.hashCode()) * 1000003) ^ this.s.hashCode()) * 1000003) ^ this.t.hashCode()) * 1000003) ^ this.u.hashCode()) * 1000003) ^ this.v.hashCode()) * 1000003) ^ this.w.hashCode()) * 1000003) ^ this.x.hashCode()) * 1000003) ^ this.y.hashCode()) * 1000003) ^ this.a.hashCode();
    }

    @Override // com.google.android.libraries.navigation.internal.gg.l
    public final Duration i() {
        return this.u;
    }

    @Override // com.google.android.libraries.navigation.internal.gg.l
    public final Duration j() {
        return this.x;
    }

    @Override // com.google.android.libraries.navigation.internal.gg.l
    public final Duration k() {
        return this.v;
    }

    @Override // com.google.android.libraries.navigation.internal.gg.l
    public final Duration l() {
        return this.t;
    }

    @Override // com.google.android.libraries.navigation.internal.gg.l
    public final Duration m() {
        return this.s;
    }

    @Override // com.google.android.libraries.navigation.internal.gg.l
    public final Duration n() {
        return this.f;
    }

    @Override // com.google.android.libraries.navigation.internal.gg.l
    public final Duration o() {
        return this.e;
    }

    @Override // com.google.android.libraries.navigation.internal.gg.l
    public final Duration p() {
        return this.r;
    }

    @Override // com.google.android.libraries.navigation.internal.gg.l
    public final Duration q() {
        return this.q;
    }

    @Override // com.google.android.libraries.navigation.internal.gg.l
    public final Duration r() {
        return this.d;
    }

    @Override // com.google.android.libraries.navigation.internal.gg.l
    public final Duration s() {
        return this.c;
    }

    @Override // com.google.android.libraries.navigation.internal.gg.l
    public final Duration t() {
        return this.y;
    }

    @Override // com.google.android.libraries.navigation.internal.gg.l
    public final Duration u() {
        return this.l;
    }

    @Override // com.google.android.libraries.navigation.internal.gg.l
    public final Duration v() {
        return this.k;
    }

    @Override // com.google.android.libraries.navigation.internal.gg.l
    public final Duration w() {
        return this.j;
    }

    @Override // com.google.android.libraries.navigation.internal.gg.l
    public final Duration x() {
        return this.i;
    }
}
