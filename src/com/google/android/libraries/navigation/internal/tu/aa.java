package com.google.android.libraries.navigation.internal.tu;

import android.app.Application;
import com.google.android.libraries.navigation.internal.afl.ni;
import com.google.android.libraries.navigation.internal.gq.al;
import com.google.android.libraries.navigation.internal.hx.ap;
import com.google.android.libraries.navigation.internal.sk.ej;
import com.google.android.libraries.navigation.internal.sk.eo;
import com.google.android.libraries.navigation.internal.yr.ai;
import com.google.android.libraries.navigation.internal.yz.fz;
import java.io.File;
import java.util.concurrent.Executor;
import java.util.concurrent.PriorityBlockingQueue;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class aa implements com.google.android.libraries.navigation.internal.tv.f {
    private final Application a;
    private final com.google.android.libraries.navigation.internal.mj.a b;
    private final com.google.android.libraries.navigation.internal.ia.e c;
    private final com.google.android.libraries.navigation.internal.cw.a d;
    private final com.google.android.libraries.navigation.internal.gb.a e;
    private final com.google.android.libraries.navigation.internal.sl.o f;
    private final com.google.android.libraries.navigation.internal.th.c g;
    private final com.google.android.libraries.navigation.internal.afo.a h;
    private final Executor i;
    private final Executor j;
    private final Executor k;
    private final Executor l;
    private final Boolean m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final com.google.android.libraries.navigation.internal.sk.d f604n;
    private final com.google.android.libraries.navigation.internal.hn.r o;
    private final al p;
    private final eo q;
    private final com.google.android.libraries.navigation.internal.tx.b r;

    public aa(Application application, com.google.android.libraries.navigation.internal.mj.a aVar, com.google.android.libraries.navigation.internal.ia.e eVar, com.google.android.libraries.navigation.internal.cw.a aVar2, com.google.android.libraries.navigation.internal.gb.a aVar3, com.google.android.libraries.navigation.internal.sl.o oVar, com.google.android.libraries.navigation.internal.th.c cVar, com.google.android.libraries.navigation.internal.afo.a aVar4, Executor executor, Executor executor2, com.google.android.libraries.navigation.internal.sk.d dVar, Executor executor3, al alVar, eo eoVar, com.google.android.libraries.navigation.internal.tx.b bVar, Boolean bool, com.google.android.libraries.navigation.internal.hn.r rVar) {
        this.a = application;
        this.b = aVar;
        this.c = eVar;
        this.d = aVar2;
        this.e = aVar3;
        this.f = oVar;
        this.g = cVar;
        this.p = alVar;
        this.h = aVar4;
        this.i = executor;
        this.j = executor2;
        this.k = (Executor) dVar.a().a();
        this.l = executor3;
        this.q = eoVar;
        this.r = bVar;
        this.m = bool;
        this.f604n = dVar;
        this.o = rVar;
    }

    private final f b(ej ejVar, ad adVar) {
        this.m.booleanValue();
        z zVar = new z(this.a);
        com.google.android.libraries.navigation.internal.th.c cVar = this.g;
        f fVar = new f(zVar, ejVar, this.f, adVar, cVar, this.d, this.q, this.i, this.l, this.o);
        fVar.b.c(new b(fVar), cVar);
        return fVar;
    }

    private final s c(ej ejVar, ad adVar, com.google.android.libraries.navigation.internal.fz.d dVar) {
        y yVar = new y(this.a, this.f604n, this.b, dVar);
        PriorityBlockingQueue priorityBlockingQueue = new PriorityBlockingQueue();
        Executor executor = (Executor) this.h.a();
        eo eoVar = this.q;
        p pVar = new p(dVar, eoVar, this.r);
        fz fzVar = new fz();
        fzVar.b(com.google.android.libraries.navigation.internal.db.s.class, new q(com.google.android.libraries.navigation.internal.db.s.class, pVar, ap.DANGEROUS_PUBLISHER_THREAD));
        this.c.c(pVar, fzVar.a());
        o oVar = new o(this.p, this.i, dVar, eoVar);
        com.google.android.libraries.navigation.internal.gb.a aVar = this.e;
        Executor executor2 = this.k;
        com.google.android.libraries.navigation.internal.th.c cVar = this.g;
        Application application = this.a;
        s.a aVar2 = new s.a(application, priorityBlockingQueue, ejVar, adVar, dVar, yVar, executor, executor2, cVar, pVar, oVar, aVar, eoVar);
        s sVar = new s(application, yVar, dVar, cVar, priorityBlockingQueue, aVar2, eoVar);
        ai aiVarA = com.google.android.libraries.navigation.internal.yu.f.a();
        try {
            aVar2.b.execute(aVar2);
            aiVarA.close();
            return sVar;
        } catch (Throwable th) {
            try {
                aiVarA.close();
                throw th;
            } catch (Throwable th2) {
                th.addSuppressed(th2);
                throw th;
            }
        }
    }

    @Override // com.google.android.libraries.navigation.internal.tv.f
    public final com.google.android.libraries.navigation.internal.tv.e a(ej ejVar, com.google.android.libraries.navigation.internal.fz.d dVar) {
        s sVarC;
        final ad adVar = new ad(this.a.getDir("tts-temp", 0), this.b, this.i);
        adVar.c.getAbsolutePath();
        adVar.a.execute(new Runnable() { // from class: com.google.android.libraries.navigation.internal.tu.ac
            @Override // java.lang.Runnable
            public final void run() {
                ad adVar2 = adVar;
                File[] fileArrListFiles = adVar2.b.listFiles();
                if (fileArrListFiles != null) {
                    for (File file : fileArrListFiles) {
                        if (file.isDirectory() && !file.equals(adVar2.c)) {
                            File[] fileArrListFiles2 = file.listFiles();
                            if (fileArrListFiles2 != null) {
                                for (File file2 : fileArrListFiles2) {
                                    file2.delete();
                                }
                            }
                            if (file.delete()) {
                                file.getAbsolutePath();
                            } else {
                                file.getAbsolutePath();
                            }
                        }
                    }
                }
            }
        });
        int iA = ni.a(dVar.R().d);
        if (iA == 0) {
            iA = ni.a;
        }
        f fVarB = null;
        if (iA == 0) {
            throw null;
        }
        int i = iA - 1;
        if (i == 0) {
            fVarB = b(ejVar, adVar);
            sVarC = null;
        } else if (i == 1) {
            sVarC = c(ejVar, adVar, dVar);
        } else if (i != 2) {
            sVarC = null;
        } else {
            fVarB = b(null, adVar);
            sVarC = c(ejVar, adVar, dVar);
        }
        return new com.google.android.libraries.navigation.internal.tv.a(fVarB, sVarC);
    }
}
