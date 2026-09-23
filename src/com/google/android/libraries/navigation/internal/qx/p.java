package com.google.android.libraries.navigation.internal.qx;

import com.google.android.libraries.navigation.internal.afm.ai;
import com.google.android.libraries.navigation.internal.afm.aj;
import com.google.android.libraries.navigation.internal.yx.am;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class p implements com.google.android.libraries.navigation.internal.gg.e {
    final com.google.android.libraries.navigation.internal.qz.k a;
    volatile ai b;
    final /* synthetic */ q c;

    public p(q qVar, com.google.android.libraries.navigation.internal.qz.k kVar) {
        this.c = qVar;
        this.a = kVar;
    }

    @Override // com.google.android.libraries.navigation.internal.gg.e
    public final void a(com.google.android.libraries.navigation.internal.gg.i iVar, com.google.android.libraries.navigation.internal.gg.o oVar) {
        if (am.a(oVar, com.google.android.libraries.navigation.internal.gg.o.b)) {
            this.a.o(2);
        } else {
            this.a.o(1);
        }
        this.a.j(false);
        this.a.i();
    }

    @Override // com.google.android.libraries.navigation.internal.gg.e
    public final /* bridge */ /* synthetic */ void b(com.google.android.libraries.navigation.internal.gg.i iVar, Object obj) {
        aj ajVar = (aj) obj;
        if (ajVar.b.size() == 0) {
            this.a.o(1);
            this.a.j(false);
            this.a.i();
            return;
        }
        this.b = (ai) ajVar.b.get(0);
        synchronized (this.a) {
            if (this.b != null) {
                boolean zR = this.a.r(this.b);
                if (this.c.l != null && zR && this.a.b) {
                    this.c.f.execute(new Runnable() { // from class: com.google.android.libraries.navigation.internal.qx.o
                        @Override // java.lang.Runnable
                        public final void run() {
                            p pVar = this.a;
                            if (pVar.c.l != null) {
                                pVar.c.l.a(pVar.b);
                            }
                        }
                    });
                }
            }
            this.a.j(false);
            this.a.i();
        }
    }
}
