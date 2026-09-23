package com.google.android.libraries.navigation.internal.ft;

import com.google.android.libraries.navigation.internal.aac.az;
import com.google.android.libraries.navigation.internal.aac.be;
import com.google.android.libraries.navigation.internal.aac.bj;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class z implements n {
    public static final com.google.android.libraries.navigation.internal.iv.x a;
    public static final com.google.android.libraries.navigation.internal.iv.x b;
    public static final com.google.android.libraries.navigation.internal.iv.u c;
    public static final com.google.android.libraries.navigation.internal.iv.u d;
    public final com.google.android.libraries.navigation.internal.iv.f e;
    private final bj f;
    private final af g;
    private final af h;

    static {
        com.google.android.libraries.navigation.internal.iv.ad adVar = com.google.android.libraries.navigation.internal.iv.ab.c;
        a = new com.google.android.libraries.navigation.internal.iv.x("cy", adVar);
        b = new com.google.android.libraries.navigation.internal.iv.x("qy", adVar);
        c = new com.google.android.libraries.navigation.internal.iv.u("terms_accepted", com.google.android.libraries.navigation.internal.iv.ab.d);
        d = new com.google.android.libraries.navigation.internal.iv.u("terms_accepted_kr", com.google.android.libraries.navigation.internal.iv.ab.c);
    }

    public z(com.google.android.libraries.navigation.internal.iv.f fVar, ab abVar) {
        this.e = fVar;
        af afVarA = abVar.a(com.google.android.libraries.navigation.internal.ij.a.a);
        this.g = afVarA;
        this.h = abVar.a(com.google.android.libraries.navigation.internal.ij.a.b);
        this.f = az.h(new y(fVar, afVarA));
    }

    @Override // com.google.android.libraries.navigation.internal.ft.n
    public final bj a() {
        this.h.b(new Runnable() { // from class: com.google.android.libraries.navigation.internal.ft.q
            @Override // java.lang.Runnable
            public final void run() {
                z zVar = this.a;
                zVar.e.q(z.c, 0);
                zVar.e.q(z.d, 0);
            }
        });
        return be.a;
    }

    @Override // com.google.android.libraries.navigation.internal.ft.n
    public final bj b() {
        return this.f;
    }

    @Override // com.google.android.libraries.navigation.internal.ft.n
    public final bj c(final int i) {
        this.h.b(new Runnable() { // from class: com.google.android.libraries.navigation.internal.ft.t
            @Override // java.lang.Runnable
            public final void run() {
                this.a.e.q(z.c, i);
            }
        });
        return be.a;
    }

    @Override // com.google.android.libraries.navigation.internal.ft.n
    public final void d() {
        this.h.b(new Runnable() { // from class: com.google.android.libraries.navigation.internal.ft.p
            @Override // java.lang.Runnable
            public final void run() {
                this.a.e.m(z.b);
            }
        });
    }

    @Override // com.google.android.libraries.navigation.internal.ft.n
    public final void e(final String str) {
        this.h.b(new Runnable() { // from class: com.google.android.libraries.navigation.internal.ft.s
            @Override // java.lang.Runnable
            public final void run() {
                this.a.e.t(z.a, str);
            }
        });
    }

    @Override // com.google.android.libraries.navigation.internal.ft.n
    public final void f(final String str) {
        this.h.b(new Runnable() { // from class: com.google.android.libraries.navigation.internal.ft.r
            @Override // java.lang.Runnable
            public final void run() {
                this.a.e.t(z.b, str);
            }
        });
    }

    @Override // com.google.android.libraries.navigation.internal.ft.n
    public final bj g() {
        this.h.b(new Runnable() { // from class: com.google.android.libraries.navigation.internal.ft.o
            public final /* synthetic */ int b = 1;

            @Override // java.lang.Runnable
            public final void run() {
                this.a.e.q(z.d, 1);
            }
        });
        return be.a;
    }
}
