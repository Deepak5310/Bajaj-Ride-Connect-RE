package com.google.android.libraries.navigation.internal.tt;

import com.google.android.libraries.navigation.internal.adr.Cdo;
import com.google.android.libraries.navigation.internal.yz.ev;
import com.google.common.base.Ascii;
import java.util.Objects;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class a extends c {
    private boolean A;
    private com.google.android.libraries.navigation.internal.hc.a B;
    private com.google.android.libraries.navigation.internal.hc.a C;
    private com.google.android.libraries.navigation.internal.hc.a D;
    private com.google.android.libraries.navigation.internal.hc.a E;
    private ev F;
    private byte G;
    public String a;
    public String b;
    public String c;
    public String d;
    public String e;
    public Cdo f;
    public Integer g;
    public String h;
    public String i;
    public Long j;
    public Long k;
    public String l;
    public int m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private long f602n;
    private String o;
    private String p;
    private boolean q;
    private boolean r;
    private String s;
    private String t;
    private com.google.android.libraries.navigation.internal.hc.a u;
    private com.google.android.libraries.navigation.internal.hc.a v;
    private com.google.android.libraries.navigation.internal.hc.a w;
    private com.google.android.libraries.navigation.internal.hc.a x;
    private com.google.android.libraries.navigation.internal.hc.a y;
    private float z;

    public a() {
    }

    public a(d dVar) {
        b bVar = (b) dVar;
        this.f602n = bVar.a;
        this.o = bVar.b;
        this.a = bVar.c;
        this.b = bVar.d;
        this.c = bVar.e;
        this.d = bVar.f;
        this.e = bVar.g;
        this.f = bVar.h;
        this.g = bVar.i;
        this.p = bVar.j;
        this.h = bVar.k;
        this.q = bVar.l;
        this.r = bVar.m;
        this.i = bVar.f603n;
        this.j = bVar.o;
        this.k = bVar.p;
        this.s = bVar.q;
        this.l = bVar.r;
        this.t = bVar.s;
        this.m = bVar.F;
        this.u = bVar.t;
        this.v = bVar.u;
        this.w = bVar.v;
        this.x = bVar.w;
        this.y = bVar.x;
        this.z = bVar.y;
        this.A = bVar.z;
        this.B = bVar.A;
        this.C = bVar.B;
        this.D = bVar.C;
        this.E = bVar.D;
        this.F = bVar.E;
        this.G = Ascii.US;
    }

    @Override // com.google.android.libraries.navigation.internal.tt.c
    public final c a(Long l) {
        this.j = l;
        return this;
    }

    @Override // com.google.android.libraries.navigation.internal.tt.c
    public final c b(String str) {
        this.p = str;
        return this;
    }

    @Override // com.google.android.libraries.navigation.internal.tt.c
    public final c c(String str) {
        this.t = str;
        return this;
    }

    @Override // com.google.android.libraries.navigation.internal.tt.c
    public final c d(String str) {
        this.s = str;
        return this;
    }

    @Override // com.google.android.libraries.navigation.internal.tt.c
    public final c e(com.google.android.libraries.navigation.internal.hc.a aVar) {
        this.v = aVar;
        return this;
    }

    @Override // com.google.android.libraries.navigation.internal.tt.c
    public final c f(com.google.android.libraries.navigation.internal.hc.a aVar) {
        this.C = aVar;
        return this;
    }

    @Override // com.google.android.libraries.navigation.internal.tt.c
    public final c g(com.google.android.libraries.navigation.internal.hc.a aVar) {
        this.u = aVar;
        return this;
    }

    @Override // com.google.android.libraries.navigation.internal.tt.c
    public final c h(com.google.android.libraries.navigation.internal.hc.a aVar) {
        this.y = aVar;
        return this;
    }

    @Override // com.google.android.libraries.navigation.internal.tt.c
    public final c i(com.google.android.libraries.navigation.internal.hc.a aVar) {
        this.x = aVar;
        return this;
    }

    @Override // com.google.android.libraries.navigation.internal.tt.c
    public final c j(com.google.android.libraries.navigation.internal.hc.a aVar) {
        this.w = aVar;
        return this;
    }

    @Override // com.google.android.libraries.navigation.internal.tt.c
    public final c k(com.google.android.libraries.navigation.internal.hc.a aVar) {
        this.E = aVar;
        return this;
    }

    @Override // com.google.android.libraries.navigation.internal.tt.c
    public final d l() {
        String str;
        if (this.G != 31 || (str = this.o) == null) {
            throw new IllegalStateException();
        }
        return new b(this.f602n, str, this.a, this.b, this.c, this.d, this.e, this.f, this.g, this.p, this.h, this.q, this.r, this.i, this.j, this.k, this.s, this.l, this.t, this.m, this.u, this.v, this.w, this.x, this.y, this.z, this.A, this.B, this.C, this.D, this.E, this.F);
    }

    @Override // com.google.android.libraries.navigation.internal.tt.c
    public final void m(String str) {
        Objects.requireNonNull(str);
        this.o = str;
    }

    @Override // com.google.android.libraries.navigation.internal.tt.c
    public final void n(long j) {
        this.f602n = j;
        this.G = (byte) (this.G | 1);
    }

    @Override // com.google.android.libraries.navigation.internal.tt.c
    public final void o(boolean z) {
        this.r = z;
        this.G = (byte) (this.G | 4);
    }

    @Override // com.google.android.libraries.navigation.internal.tt.c
    public final void p(boolean z) {
        this.q = z;
        this.G = (byte) (this.G | 2);
    }

    @Override // com.google.android.libraries.navigation.internal.tt.c
    public final void q(boolean z) {
        this.A = z;
        this.G = (byte) (this.G | Ascii.DLE);
    }

    @Override // com.google.android.libraries.navigation.internal.tt.c
    public final void r(float f) {
        this.z = f;
        this.G = (byte) (this.G | 8);
    }

    @Override // com.google.android.libraries.navigation.internal.tt.c
    public final void s(com.google.android.libraries.navigation.internal.hc.a aVar) {
        this.D = aVar;
    }

    @Override // com.google.android.libraries.navigation.internal.tt.c
    public final void t(com.google.android.libraries.navigation.internal.hc.a aVar) {
        this.B = aVar;
    }

    @Override // com.google.android.libraries.navigation.internal.tt.c
    public final void u(ev evVar) {
        this.F = evVar;
    }
}
