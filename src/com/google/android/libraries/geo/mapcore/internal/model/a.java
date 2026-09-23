package com.google.android.libraries.geo.mapcore.internal.model;

import com.google.android.libraries.navigation.internal.afm.dh;
import com.google.android.libraries.navigation.internal.yz.ev;
import com.google.android.libraries.navigation.internal.yz.fy;
import com.google.android.libraries.navigation.internal.yz.lv;
import java.util.Objects;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes2.dex */
public final class a extends cf {
    public com.google.android.libraries.navigation.internal.aai.f a;
    public com.google.android.libraries.navigation.internal.acy.b b;
    public ev c;
    public ev d;
    public com.google.android.libraries.navigation.internal.aas.b e;
    public Boolean f;
    public ev g;
    public com.google.android.libraries.navigation.internal.aaj.b h;
    public dh i;
    public com.google.android.libraries.navigation.internal.adi.aj j;
    public String k;
    public String l;
    public String m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public String f56n;
    public com.google.android.libraries.navigation.internal.aec.b o;
    public com.google.android.libraries.navigation.internal.aep.c p;
    private ev q;
    private fy r;

    public a() {
    }

    public a(cg cgVar) {
        this.a = cgVar.g();
        this.b = cgVar.j();
        this.c = cgVar.c();
        this.d = cgVar.b();
        this.e = cgVar.i();
        this.f = cgVar.o();
        this.g = cgVar.e();
        this.h = cgVar.h();
        this.i = cgVar.n();
        this.q = cgVar.d();
        this.j = cgVar.k();
        this.k = null;
        this.l = cgVar.p();
        this.m = cgVar.r();
        this.f56n = cgVar.q();
        this.o = cgVar.l();
        this.r = cgVar.f();
        this.p = cgVar.m();
    }

    @Override // com.google.android.libraries.geo.mapcore.internal.model.cf
    public final cg a() {
        if (this.q == null) {
            int i = ev.d;
            this.q = lv.a;
        }
        if (this.r != null) {
            return new p(this.a, this.b, this.c, this.d, this.e, this.f, this.g, this.h, this.i, this.q, this.j, null, this.l, this.m, this.f56n, this.o, this.r, this.p);
        }
        throw new IllegalStateException();
    }

    @Override // com.google.android.libraries.geo.mapcore.internal.model.cf
    public final void b(fy fyVar) {
        Objects.requireNonNull(fyVar);
        this.r = fyVar;
    }
}
