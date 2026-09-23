package com.google.android.libraries.navigation.internal.u;

import com.google.android.libraries.navigation.internal.oe.r;
import com.google.android.libraries.navigation.internal.ol.z;
import com.google.android.libraries.navigation.internal.pi.ac;
import com.google.android.libraries.navigation.internal.pi.ad;
import com.google.android.libraries.navigation.internal.pi.ae;
import com.google.android.libraries.navigation.internal.pi.s;
import com.google.android.libraries.navigation.internal.pi.u;
import com.google.android.libraries.navigation.internal.pn.k;
import com.google.android.libraries.navigation.internal.pn.o;
import com.google.android.libraries.navigation.internal.yx.ax;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class f extends com.google.android.libraries.navigation.internal.pn.a {
    private final s a;

    public f(s sVar) {
        this.a = sVar;
    }

    @Override // com.google.android.libraries.navigation.internal.pn.a, com.google.android.libraries.navigation.internal.pn.l
    public final void a(z zVar, r rVar, k kVar) {
        d(kVar);
    }

    @Override // com.google.android.libraries.navigation.internal.pn.a, com.google.android.libraries.navigation.internal.pn.l
    public final void b(z zVar, r rVar, k kVar) {
        kVar.a();
        super.b(zVar, rVar, kVar);
    }

    @Override // com.google.android.libraries.navigation.internal.pn.a, com.google.android.libraries.navigation.internal.pn.l
    public final void c(z zVar, r rVar, k kVar) {
        kVar.a();
        super.c(zVar, rVar, kVar);
    }

    @Override // com.google.android.libraries.navigation.internal.pn.a, com.google.android.libraries.navigation.internal.pn.l
    public final void d(k kVar) {
        kVar.a();
    }

    @Override // com.google.android.libraries.navigation.internal.pn.a, com.google.android.libraries.navigation.internal.pn.l
    public final void e(k kVar) {
        kVar.a();
        this.a.e(u.a);
    }

    @Override // com.google.android.libraries.navigation.internal.pn.a, com.google.android.libraries.navigation.internal.pn.l
    public final void f() {
        this.a.b.d(new ax() { // from class: com.google.android.libraries.navigation.internal.pi.g
            @Override // com.google.android.libraries.navigation.internal.yx.ax
            public final void a(Object obj) {
                ((m) obj).a();
            }
        });
    }

    @Override // com.google.android.libraries.navigation.internal.pn.a, com.google.android.libraries.navigation.internal.pn.l
    public final void g(o oVar, k kVar) {
        kVar.a();
        this.a.h(new ac(oVar));
    }

    @Override // com.google.android.libraries.navigation.internal.pn.a, com.google.android.libraries.navigation.internal.pn.l
    public final void h(float f, boolean z, k kVar) {
        kVar.a();
        this.a.j(ae.a);
        if (z) {
            this.a.i(new ad(f));
        }
    }
}
