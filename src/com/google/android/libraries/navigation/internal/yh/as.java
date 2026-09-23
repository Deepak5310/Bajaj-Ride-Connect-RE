package com.google.android.libraries.navigation.internal.yh;

import android.net.Uri;
import com.google.android.libraries.navigation.internal.aac.av;
import com.google.android.libraries.navigation.internal.aac.az;
import com.google.android.libraries.navigation.internal.aac.be;
import com.google.android.libraries.navigation.internal.aac.bj;
import com.google.android.libraries.navigation.internal.yr.ax;
import com.google.android.libraries.navigation.internal.yx.bm;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public class as {
    public final String a;
    public final at b;
    public final com.google.android.libraries.navigation.internal.yq.h c;
    private final bj g;
    private final com.google.android.libraries.navigation.internal.yl.a j;
    private final com.google.android.libraries.navigation.internal.yq.h i = new com.google.android.libraries.navigation.internal.yq.h(new ap(this), com.google.android.libraries.navigation.internal.aac.ac.INSTANCE);
    public final Object d = new Object();
    public List f = new ArrayList();
    private final com.google.android.libraries.navigation.internal.aac.al h = new com.google.android.libraries.navigation.internal.aac.al();
    private final int k = com.google.android.libraries.navigation.internal.zt.aj.b;
    public final com.google.android.libraries.navigation.internal.yr.o e = new com.google.android.libraries.navigation.internal.yr.n();

    public as(at atVar, com.google.android.libraries.navigation.internal.yl.a aVar, bj bjVar) {
        this.b = atVar;
        this.j = aVar;
        this.g = bjVar;
        this.a = ((ae) atVar).a;
        final ae aeVar = (ae) atVar;
        this.c = new com.google.android.libraries.navigation.internal.yq.h(new com.google.android.libraries.navigation.internal.aac.s() { // from class: com.google.android.libraries.navigation.internal.yh.y
            @Override // com.google.android.libraries.navigation.internal.aac.s
            public final bj a() {
                final ae aeVar2 = aeVar;
                return az.i(com.google.android.libraries.navigation.internal.aac.j.i(aeVar2.b, com.google.android.libraries.navigation.internal.yr.am.d(new com.google.android.libraries.navigation.internal.aac.t() { // from class: com.google.android.libraries.navigation.internal.yh.v
                    @Override // com.google.android.libraries.navigation.internal.aac.t
                    public final bj a(Object obj) {
                        Uri uri = (Uri) obj;
                        Uri uriA = com.google.android.libraries.navigation.internal.yi.c.a(uri, ".bak");
                        ae aeVar3 = aeVar2;
                        try {
                            if (aeVar3.d.d(uriA)) {
                                aeVar3.d.c(uriA, uri);
                            }
                            return be.a;
                        } catch (IOException e) {
                            return az.g(e);
                        }
                    }
                }), aeVar2.c));
            }
        }, com.google.android.libraries.navigation.internal.aac.ac.INSTANCE);
        d(new com.google.android.libraries.navigation.internal.aac.t() { // from class: com.google.android.libraries.navigation.internal.yh.al
            @Override // com.google.android.libraries.navigation.internal.aac.t
            public final bj a(Object obj) {
                return this.a.c.c();
            }
        });
    }

    public final bj a() {
        bj bjVarA;
        this.e.b();
        bm.b(com.google.android.libraries.navigation.internal.yw.c.a);
        if (this.i.d.isDone()) {
            bjVarA = ((ae) this.b).a();
        } else {
            com.google.android.libraries.navigation.internal.yr.w wVarA = this.e.a("Get ".concat(String.valueOf(this.a)), ax.I_HAVE_PERMISSION_TO_USE_RESTRICTED_APIS);
            try {
                bj bjVarI = com.google.android.libraries.navigation.internal.aac.j.i(this.i.c(), com.google.android.libraries.navigation.internal.yr.am.d(new com.google.android.libraries.navigation.internal.aac.t() { // from class: com.google.android.libraries.navigation.internal.yh.an
                    @Override // com.google.android.libraries.navigation.internal.aac.t
                    public final bj a(Object obj) {
                        return ((ae) this.a.b).a();
                    }
                }), com.google.android.libraries.navigation.internal.aac.ac.INSTANCE);
                wVarA.a(bjVarI);
                wVarA.close();
                bjVarA = bjVarI;
            } catch (Throwable th) {
                try {
                    wVarA.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        }
        this.j.a();
        com.google.android.libraries.navigation.internal.yl.a aVar = this.j;
        az.i(this.g);
        aVar.b();
        return az.i(bjVarA);
    }

    public final bj b(final com.google.android.libraries.navigation.internal.yx.aa aaVar, Executor executor) {
        return c(com.google.android.libraries.navigation.internal.yr.am.d(new com.google.android.libraries.navigation.internal.aac.t() { // from class: com.google.android.libraries.navigation.internal.yh.ai
            @Override // com.google.android.libraries.navigation.internal.aac.t
            public final bj a(Object obj) {
                return az.h(aaVar.ak(obj));
            }
        }), executor);
    }

    public final bj c(final com.google.android.libraries.navigation.internal.aac.t tVar, final Executor executor) {
        bm.b(com.google.android.libraries.navigation.internal.yw.c.a);
        com.google.android.libraries.navigation.internal.yr.w wVarA = this.e.a("Update ".concat(String.valueOf(this.a)), ax.I_HAVE_PERMISSION_TO_USE_RESTRICTED_APIS);
        try {
            final bj bjVarC = this.i.c();
            this.h.a(new com.google.android.libraries.navigation.internal.aac.s() { // from class: com.google.android.libraries.navigation.internal.yh.aj
                @Override // com.google.android.libraries.navigation.internal.aac.s
                public final bj a() {
                    return bjVarC;
                }
            }, com.google.android.libraries.navigation.internal.aac.ac.INSTANCE);
            bj bjVarA = this.h.a(com.google.android.libraries.navigation.internal.yr.am.c(new com.google.android.libraries.navigation.internal.aac.s() { // from class: com.google.android.libraries.navigation.internal.yh.ak
                @Override // com.google.android.libraries.navigation.internal.aac.s
                public final bj a() {
                    final as asVar = this.a;
                    final com.google.android.libraries.navigation.internal.aac.t tVar2 = tVar;
                    final Executor executor2 = executor;
                    return com.google.android.libraries.navigation.internal.aac.j.i(bjVarC, com.google.android.libraries.navigation.internal.yr.am.d(new com.google.android.libraries.navigation.internal.aac.t() { // from class: com.google.android.libraries.navigation.internal.yh.am
                        @Override // com.google.android.libraries.navigation.internal.aac.t
                        public final bj a(Object obj) {
                            return asVar.b.d(tVar2, executor2);
                        }
                    }), com.google.android.libraries.navigation.internal.aac.ac.INSTANCE);
                }
            }), com.google.android.libraries.navigation.internal.aac.ac.INSTANCE);
            com.google.android.libraries.navigation.internal.yx.ar.q(bjVarA);
            if (!bjVarC.isDone()) {
                if (bjVarA.isDone()) {
                    az.p(bjVarA, bjVarC);
                } else {
                    av avVar = new av(bjVarA, bjVarC);
                    bjVarA.l(avVar, com.google.android.libraries.navigation.internal.aac.ac.INSTANCE);
                    bjVarC.l(avVar, com.google.android.libraries.navigation.internal.aac.ac.INSTANCE);
                }
            }
            this.j.a();
            com.google.android.libraries.navigation.internal.yl.a aVar = this.j;
            az.i(this.g);
            aVar.c();
            bj bjVarA2 = com.google.android.libraries.navigation.internal.yi.b.a(bjVarA);
            wVarA.a(bjVarA2);
            wVarA.close();
            return bjVarA2;
        } catch (Throwable th) {
            try {
                wVarA.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    public final void d(com.google.android.libraries.navigation.internal.aac.t tVar) {
        synchronized (this.d) {
            this.f.add(tVar);
        }
    }
}
