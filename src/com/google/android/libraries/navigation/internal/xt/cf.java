package com.google.android.libraries.navigation.internal.xt;

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.StrictMode;
import android.util.Log;
import com.google.android.libraries.navigation.internal.yz.ev;
import java.io.IOException;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class cf {
    public static final Object a = new Object();
    public static final Object b = new Object();
    public final Context c;
    public final com.google.android.libraries.navigation.internal.yx.br d;
    public final com.google.android.libraries.navigation.internal.yx.br e;
    public final com.google.android.libraries.navigation.internal.yx.br f;
    public final com.google.android.libraries.navigation.internal.yx.br g;
    public final com.google.android.libraries.navigation.internal.yx.br h;
    public final Uri i;
    public volatile com.google.android.libraries.navigation.internal.xs.n j;
    public final Uri k;
    public volatile com.google.android.libraries.navigation.internal.xs.p l;

    public cf(Context context, final com.google.android.libraries.navigation.internal.yx.br brVar, com.google.android.libraries.navigation.internal.yx.br brVar2, com.google.android.libraries.navigation.internal.yx.br brVar3) {
        this.c = context;
        this.e = brVar;
        this.d = brVar3;
        this.f = brVar2;
        Pattern pattern = com.google.android.libraries.navigation.internal.xz.g.a;
        com.google.android.libraries.navigation.internal.xz.f fVar = new com.google.android.libraries.navigation.internal.xz.f(context);
        fVar.b("phenotype_storage_info");
        fVar.c("storage-info.pb");
        this.i = fVar.a();
        com.google.android.libraries.navigation.internal.xz.f fVar2 = new com.google.android.libraries.navigation.internal.xz.f(context);
        fVar2.b("phenotype_storage_info");
        fVar2.c("device-encrypted-storage-info.pb");
        if (com.google.android.libraries.navigation.internal.nd.a.c()) {
            com.google.android.libraries.navigation.internal.yc.f.a(com.google.android.libraries.navigation.internal.xz.g.d.contains("directboot-files"), "The only supported locations are %s: %s", com.google.android.libraries.navigation.internal.xz.g.d, "directboot-files");
            fVar2.a = "directboot-files";
        }
        this.k = fVar2.a();
        this.g = com.google.android.libraries.navigation.internal.yx.bw.a(new com.google.android.libraries.navigation.internal.yx.br() { // from class: com.google.android.libraries.navigation.internal.xt.cc
            @Override // com.google.android.libraries.navigation.internal.yx.br
            public final Object a() {
                final cf cfVar = this.a;
                com.google.android.libraries.navigation.internal.aac.bn bnVar = (com.google.android.libraries.navigation.internal.aac.bn) cfVar.e.a();
                com.google.android.libraries.navigation.internal.yx.ar.q(bnVar);
                com.google.android.libraries.navigation.internal.xp.l lVar = (com.google.android.libraries.navigation.internal.xp.l) cfVar.d.a();
                com.google.android.libraries.navigation.internal.yx.ar.q(lVar);
                final com.google.android.libraries.navigation.internal.aac.bj bjVarH = com.google.android.libraries.navigation.internal.aac.j.h(com.google.android.libraries.navigation.internal.aac.c.h(com.google.android.libraries.navigation.internal.aac.an.q(lVar.d()), com.google.android.libraries.navigation.internal.xp.m.class, new com.google.android.libraries.navigation.internal.yx.aa() { // from class: com.google.android.libraries.navigation.internal.xt.by
                    @Override // com.google.android.libraries.navigation.internal.yx.aa
                    public final Object ak(Object obj) {
                        com.google.android.libraries.navigation.internal.xp.m mVar = (com.google.android.libraries.navigation.internal.xp.m) obj;
                        if (mVar.a != 29514) {
                            throw mVar;
                        }
                        com.google.android.libraries.navigation.internal.xs.s sVar = (com.google.android.libraries.navigation.internal.xs.s) com.google.android.libraries.navigation.internal.xs.t.a.q();
                        com.google.android.libraries.navigation.internal.xs.m mVar2 = (com.google.android.libraries.navigation.internal.xs.m) com.google.android.libraries.navigation.internal.xs.n.b.q();
                        long jCurrentTimeMillis = System.currentTimeMillis();
                        if (!mVar2.b.H()) {
                            mVar2.v();
                        }
                        com.google.android.libraries.navigation.internal.xs.n nVar = (com.google.android.libraries.navigation.internal.xs.n) mVar2.b;
                        nVar.c |= 8;
                        nVar.g = jCurrentTimeMillis;
                        if (!sVar.b.H()) {
                            sVar.v();
                        }
                        com.google.android.libraries.navigation.internal.xs.t tVar = (com.google.android.libraries.navigation.internal.xs.t) sVar.b;
                        com.google.android.libraries.navigation.internal.xs.n nVar2 = (com.google.android.libraries.navigation.internal.xs.n) mVar2.t();
                        nVar2.getClass();
                        tVar.c = nVar2;
                        tVar.b |= 1;
                        return (com.google.android.libraries.navigation.internal.xs.t) sVar.t();
                    }
                }, bnVar), new com.google.android.libraries.navigation.internal.yx.aa() { // from class: com.google.android.libraries.navigation.internal.xt.bz
                    @Override // com.google.android.libraries.navigation.internal.yx.aa
                    public final Object ak(Object obj) {
                        com.google.android.libraries.navigation.internal.xs.t tVar = (com.google.android.libraries.navigation.internal.xs.t) obj;
                        com.google.android.libraries.navigation.internal.ya.a aVar = new com.google.android.libraries.navigation.internal.ya.a();
                        StrictMode.ThreadPolicy threadPolicy = StrictMode.getThreadPolicy();
                        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder(threadPolicy).permitDiskWrites().build());
                        cf cfVar2 = cfVar;
                        try {
                            try {
                                synchronized (cf.a) {
                                    com.google.android.libraries.navigation.internal.xy.f fVar3 = (com.google.android.libraries.navigation.internal.xy.f) cfVar2.f.a();
                                    Uri uri = cfVar2.i;
                                    com.google.android.libraries.navigation.internal.xs.n nVar = tVar.c;
                                    if (nVar == null) {
                                        nVar = com.google.android.libraries.navigation.internal.xs.n.b;
                                    }
                                    com.google.android.libraries.navigation.internal.ye.e eVar = new com.google.android.libraries.navigation.internal.ye.e(nVar);
                                    eVar.a = new com.google.android.libraries.navigation.internal.ya.a[]{aVar};
                                    fVar3.b(uri, eVar);
                                    com.google.android.libraries.navigation.internal.xs.n nVar2 = tVar.c;
                                    if (nVar2 == null) {
                                        nVar2 = com.google.android.libraries.navigation.internal.xs.n.b;
                                    }
                                    cfVar2.j = nVar2;
                                }
                                synchronized (cf.b) {
                                    com.google.android.libraries.navigation.internal.xy.f fVar4 = (com.google.android.libraries.navigation.internal.xy.f) cfVar2.f.a();
                                    Uri uri2 = cfVar2.k;
                                    com.google.android.libraries.navigation.internal.xs.p pVar = tVar.d;
                                    if (pVar == null) {
                                        pVar = com.google.android.libraries.navigation.internal.xs.p.a;
                                    }
                                    com.google.android.libraries.navigation.internal.ye.e eVar2 = new com.google.android.libraries.navigation.internal.ye.e(pVar);
                                    eVar2.a = new com.google.android.libraries.navigation.internal.ya.a[]{aVar};
                                    fVar4.b(uri2, eVar2);
                                    com.google.android.libraries.navigation.internal.xs.p pVar2 = tVar.d;
                                    if (pVar2 == null) {
                                        pVar2 = com.google.android.libraries.navigation.internal.xs.p.a;
                                    }
                                    cfVar2.l = pVar2;
                                }
                                StrictMode.setThreadPolicy(threadPolicy);
                                return null;
                            } catch (IOException e) {
                                throw new RuntimeException(e);
                            }
                        } catch (Throwable th) {
                            StrictMode.setThreadPolicy(threadPolicy);
                            throw th;
                        }
                    }
                }, bnVar);
                bjVarH.l(new Runnable() { // from class: com.google.android.libraries.navigation.internal.xt.ca
                    @Override // java.lang.Runnable
                    public final void run() {
                        try {
                            com.google.android.libraries.navigation.internal.aac.az.n(bjVarH);
                        } catch (Exception unused) {
                            Log.isLoggable("StorageInfoHandler", 3);
                        }
                    }
                }, bnVar);
                return bjVarH;
            }
        });
        this.h = com.google.android.libraries.navigation.internal.yx.bw.a(new com.google.android.libraries.navigation.internal.yx.br() { // from class: com.google.android.libraries.navigation.internal.xt.cd
            @Override // com.google.android.libraries.navigation.internal.yx.br
            public final Object a() {
                com.google.android.libraries.navigation.internal.aac.bn bnVar = (com.google.android.libraries.navigation.internal.aac.bn) brVar.a();
                com.google.android.libraries.navigation.internal.yx.ar.q(bnVar);
                return bnVar.schedule(new Callable() { // from class: com.google.android.libraries.navigation.internal.xt.ce
                    @Override // java.util.concurrent.Callable
                    public final Object call() {
                        return null;
                    }
                }, 10000L, TimeUnit.MILLISECONDS);
            }
        });
    }

    public final com.google.android.libraries.navigation.internal.xs.n a() {
        com.google.android.libraries.navigation.internal.xs.n nVar = this.j;
        if (nVar == null) {
            synchronized (a) {
                nVar = this.j;
                if (nVar == null) {
                    nVar = com.google.android.libraries.navigation.internal.xs.n.b;
                    com.google.android.libraries.navigation.internal.ye.b bVarB = com.google.android.libraries.navigation.internal.ye.b.b(nVar);
                    StrictMode.ThreadPolicy threadPolicy = StrictMode.getThreadPolicy();
                    StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder(threadPolicy).permitDiskReads().build());
                    try {
                        try {
                            com.google.android.libraries.navigation.internal.xs.n nVar2 = (com.google.android.libraries.navigation.internal.xs.n) ((com.google.android.libraries.navigation.internal.xy.f) this.f.a()).b(this.i, bVarB);
                            StrictMode.setThreadPolicy(threadPolicy);
                            nVar = nVar2;
                        } catch (IOException unused) {
                            StrictMode.setThreadPolicy(threadPolicy);
                        }
                        this.j = nVar;
                    } catch (Throwable th) {
                        StrictMode.setThreadPolicy(threadPolicy);
                        throw th;
                    }
                }
            }
        }
        return nVar;
    }

    /* JADX WARN: Code duplicated, block: B:13:0x0041  */
    public final bl b() {
        String str;
        com.google.android.libraries.navigation.internal.xs.n nVarA = a();
        boolean z = nVarA.e;
        ev evVarO = ev.o(new com.google.android.libraries.navigation.internal.ael.bs(nVarA.j, com.google.android.libraries.navigation.internal.xs.n.a));
        com.google.android.libraries.navigation.internal.ael.x xVar = nVarA.d;
        String str2 = nVarA.f;
        ev evVarO2 = ev.o(nVarA.h);
        ev evVarO3 = ev.o(nVarA.i);
        if ((nVarA.c & 16) == 0) {
            str = "";
        } else {
            com.google.android.libraries.navigation.internal.xs.r rVar = nVarA.k;
            if (rVar == null) {
                rVar = com.google.android.libraries.navigation.internal.xs.r.a;
            }
            if (rVar.c == Build.VERSION.SDK_INT) {
                com.google.android.libraries.navigation.internal.xs.r rVar2 = nVarA.k;
                if (rVar2 == null) {
                    rVar2 = com.google.android.libraries.navigation.internal.xs.r.a;
                }
                str = rVar2.b;
            } else {
                str = "";
            }
        }
        return new bl(z, evVarO, xVar, str2, str, evVarO2, evVarO3, 1 == (nVarA.c & 1), nVarA.m, nVarA.l);
    }
}
