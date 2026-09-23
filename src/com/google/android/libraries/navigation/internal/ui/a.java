package com.google.android.libraries.navigation.internal.ui;

import com.google.android.libraries.navigation.internal.ady.al;
import com.google.android.libraries.navigation.internal.bp.ai;
import com.google.android.libraries.navigation.internal.bp.bg;
import com.google.android.libraries.navigation.internal.bp.bq;
import com.google.android.libraries.navigation.internal.ea.c;
import com.google.android.libraries.navigation.internal.ea.e;
import com.google.android.libraries.navigation.internal.tj.j;
import com.google.android.libraries.navigation.internal.uc.g;
import com.google.android.libraries.navigation.internal.uc.k;
import com.google.android.libraries.navigation.internal.yx.ak;
import com.google.android.libraries.navigation.internal.zb.h;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public class a extends e {
    public final j h;
    public final boolean i;
    public final bq j;
    public final boolean k;
    public final com.google.android.libraries.navigation.internal.x.a l;
    public final ai m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final boolean f614n;
    public final boolean o;
    public final com.google.android.libraries.navigation.internal.sz.a p;

    /* JADX INFO: renamed from: com.google.android.libraries.navigation.internal.ui.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: PG */
    public final class C0035a extends c<a, C0035a> {
        private static final com.google.android.libraries.navigation.internal.zb.j t = com.google.android.libraries.navigation.internal.zb.j.e("com.google.android.libraries.navigation.internal.ui.a$a");
        public j i;
        public boolean j;
        public bq k;
        public com.google.android.libraries.navigation.internal.x.a m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public boolean f615n;
        public ai o;
        public b p;
        public int q;
        public com.google.android.libraries.navigation.internal.sz.a s;
        public boolean l = true;
        public boolean r = false;

        public final a a() {
            j jVar = this.i;
            if (jVar == null || com.google.android.libraries.navigation.internal.up.b.b(jVar)) {
                this.k = null;
                if (this.c.a == g.INSPECT_STEP) {
                    com.google.android.libraries.navigation.internal.uc.j jVar2 = new com.google.android.libraries.navigation.internal.uc.j(this.c);
                    jVar2.a = g.FREE_MOVEMENT;
                    b(jVar2.a());
                }
            } else {
                bq bqVar = jVar.c().c;
                bg bgVar = jVar.c().b;
                if (bqVar == null) {
                    ((h) t.d(com.google.android.libraries.navigation.internal.nl.a.a).F((char) 1901)).p("No current step, despite no message to show.");
                } else if (this.l) {
                    this.k = bqVar;
                } else {
                    bq bqVar2 = this.k;
                    if (bqVar2 == null || !bgVar.S(bqVar2) || this.k.i < bqVar.i) {
                        this.k = bqVar;
                        if (this.c.a == g.INSPECT_STEP) {
                            com.google.android.libraries.navigation.internal.uc.j jVar3 = new com.google.android.libraries.navigation.internal.uc.j(this.c);
                            jVar3.a = g.FOLLOWING;
                            b(jVar3.a());
                        } else {
                            com.google.android.libraries.navigation.internal.uc.j jVar4 = new com.google.android.libraries.navigation.internal.uc.j(this.c);
                            jVar4.a = g.FREE_MOVEMENT;
                            b(jVar4.a());
                        }
                    }
                }
            }
            j jVar5 = this.i;
            if (this.k == null && jVar5 != null && !com.google.android.libraries.navigation.internal.up.b.b(jVar5)) {
                ((h) t.d(com.google.android.libraries.navigation.internal.nl.a.a).F((char) 1900)).p("headerStep can only return null when we aren't navigating, or when we aren't showing a message.");
            }
            bq bqVar3 = this.k;
            if (bqVar3 != null && jVar5 != null && !jVar5.c().b.S(bqVar3)) {
                ((h) t.d(com.google.android.libraries.navigation.internal.nl.a.a).F((char) 1899)).p("headerStep must return a step on the current route");
            }
            if (jVar5 != null && this.k == null && this.c.a == g.INSPECT_STEP) {
                ((h) t.d(com.google.android.libraries.navigation.internal.nl.a.a).F((char) 1898)).p("headerStep must be non-null when inspecting a step");
            }
            return new a(this);
        }

        public final void b(k kVar) {
            g gVar = kVar.a;
            if (gVar != g.FREE_MOVEMENT) {
                this.l = gVar != g.INSPECT_STEP;
            }
            this.c = kVar;
        }

        public final void c(j jVar) {
            this.i = jVar;
            b bVar = this.p;
            if (jVar == null || bVar == null) {
                return;
            }
            bg bgVar = jVar.c().b;
            this.o = bVar.k;
            int i = bVar.c;
            if (i >= 0 && i < bgVar.j()) {
                bq bqVarR = bgVar.r(i);
                if (bqVarR.hashCode() == bVar.d) {
                    this.k = bqVarR;
                }
            }
            this.p = null;
        }
    }

    public a(C0035a c0035a) {
        super(c0035a);
        this.h = c0035a.i;
        this.i = c0035a.j;
        this.j = c0035a.k;
        this.k = c0035a.l;
        this.l = c0035a.m;
        this.o = c0035a.f615n;
        this.m = c0035a.o;
        this.f614n = c0035a.r;
        this.p = c0035a.s;
    }

    public final al b() {
        j jVar = this.h;
        if (jVar == null) {
            return null;
        }
        return jVar.c().b.j;
    }

    public final boolean c() {
        return this.h != null;
    }

    public final String toString() {
        ak akVarA = a();
        akVarA.g("navState", this.h);
        ak akVarE = akVarA.e("useNightMode", this.i);
        akVarE.g("headerStep", this.j);
        akVarE.g("arrivedAtPlacemark", this.l);
        ak akVarE2 = akVarE.e("isPrearrived", this.o);
        akVarE2.g("directionsStorageItem", this.m);
        ak akVarE3 = akVarE2.e("showEnrouteFabTutorial", this.f614n);
        akVarE3.g("navigationDashboardStorageItem", this.p);
        return akVarE3.toString();
    }
}
