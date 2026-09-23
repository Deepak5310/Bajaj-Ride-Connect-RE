package com.google.android.libraries.navigation.internal.uu;

import com.google.android.libraries.navigation.internal.aac.ac;
import com.google.android.libraries.navigation.internal.adr.bm;
import com.google.android.libraries.navigation.internal.ady.al;
import com.google.android.libraries.navigation.internal.bp.bq;
import com.google.android.libraries.navigation.internal.hx.ap;
import com.google.android.libraries.navigation.internal.yx.ar;
import com.google.android.libraries.navigation.internal.yx.ax;
import com.google.android.libraries.navigation.internal.yz.fz;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public class l {
    private static final com.google.android.libraries.navigation.internal.zb.j h = com.google.android.libraries.navigation.internal.zb.j.e("com.google.android.libraries.navigation.internal.uu.l");
    public bq a;
    public int b;
    public int c;
    public al d;
    public boolean e = false;
    public boolean f = false;
    public final com.google.android.libraries.navigation.internal.nn.b g = new com.google.android.libraries.navigation.internal.nn.b();
    private final com.google.android.libraries.navigation.internal.rw.f i;
    private final j j;
    private final Executor k;
    private final com.google.android.libraries.navigation.internal.ia.e l;

    public l(com.google.android.libraries.navigation.internal.ia.e eVar, com.google.android.libraries.navigation.internal.rw.f fVar, Executor executor) {
        ar.q(eVar);
        this.l = eVar;
        this.i = fVar;
        this.k = executor;
        this.j = new j(this);
    }

    public static int a(int i, bm.a aVar) {
        return (i > 0 && aVar != bm.a.KILOMETERS) ? Math.round(i * 0.62137f) : i;
    }

    public final synchronized void b(k kVar) {
        com.google.android.libraries.navigation.internal.nn.b bVar = this.g;
        int iA = bVar.a();
        bVar.b(kVar, ac.INSTANCE);
        if (iA <= 0) {
            com.google.android.libraries.navigation.internal.ia.e eVar = this.l;
            fz fzVar = new fz();
            fzVar.b(com.google.android.libraries.navigation.internal.db.s.class, new m(com.google.android.libraries.navigation.internal.db.s.class, this, ap.UI_THREAD));
            eVar.c(this, fzVar.a());
            this.i.c(this.j, this.k);
        }
    }

    public final synchronized void c(k kVar) {
        com.google.android.libraries.navigation.internal.nn.b bVar = this.g;
        int iA = bVar.a();
        bVar.e(kVar);
        int iA2 = this.g.a();
        if (iA <= 0 || iA2 != 0) {
            return;
        }
        this.l.e(this);
        this.i.d(this.j);
        this.c = -1;
        this.a = null;
        this.b = -1;
    }

    public final void d(final bm.a aVar) {
        this.c = -1;
        this.g.d(new ax() { // from class: com.google.android.libraries.navigation.internal.uu.g
            @Override // com.google.android.libraries.navigation.internal.yx.ax
            public final void a(Object obj) {
                ((k) obj).f(-1, aVar);
            }
        });
    }

    public final void e() {
        this.g.d(new c());
    }

    public final void f(final boolean z) {
        this.g.d(new ax() { // from class: com.google.android.libraries.navigation.internal.uu.h
            @Override // com.google.android.libraries.navigation.internal.yx.ax
            public final void a(Object obj) {
                ((k) obj).e(z ? 3 : 2);
            }
        });
    }
}
