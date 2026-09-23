package com.google.android.libraries.navigation.internal.ht;

import android.content.Context;
import android.os.StatFs;
import androidx.tracing.Trace;
import com.google.android.libraries.navigation.internal.ael.bb;
import com.google.android.libraries.navigation.internal.ael.dg;
import com.google.android.libraries.navigation.internal.ael.dj;
import com.google.android.libraries.navigation.internal.afl.al;
import com.google.android.libraries.navigation.internal.afl.am;
import com.google.android.libraries.navigation.internal.afl.gy;
import com.google.android.libraries.navigation.internal.afl.hb;
import com.google.android.libraries.navigation.internal.yx.an;
import com.google.android.libraries.navigation.internal.yx.aq;
import com.google.android.libraries.navigation.internal.yx.ar;
import com.google.android.libraries.navigation.internal.yx.aw;
import j$.time.Duration;
import j$.time.Instant;
import j$.util.concurrent.DesugarTimeUnit;
import java.io.File;
import java.util.Locale;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class d {
    public final Context a;
    public final com.google.android.libraries.navigation.internal.mj.a b;
    public final com.google.android.libraries.navigation.internal.afo.a c;
    public final an d;
    private final com.google.android.libraries.navigation.internal.hh.q e;
    private final Executor f;

    public d(Context context, com.google.android.libraries.navigation.internal.mj.a aVar, an anVar, Executor executor, an anVar2) {
        com.google.android.libraries.navigation.internal.hh.q qVar = new com.google.android.libraries.navigation.internal.hh.q((dg) com.google.android.libraries.navigation.internal.gd.m.a.aH(7, null), context, com.google.android.libraries.navigation.internal.hh.n.PERSISTENT_FILE, "SavedClientParameters.data");
        this.a = context;
        this.b = aVar;
        this.c = (com.google.android.libraries.navigation.internal.afo.a) anVar.f();
        this.f = executor;
        this.d = anVar2;
        this.e = qVar;
    }

    public final synchronized com.google.android.libraries.navigation.internal.gd.m a() {
        final com.google.android.libraries.navigation.internal.gd.m mVar;
        com.google.android.libraries.navigation.internal.nw.d dVarB = com.google.android.libraries.navigation.internal.nw.e.b("ClientParametersCache.loadFrom");
        try {
            final com.google.android.libraries.navigation.internal.hh.p pVarA = this.e.a();
            mVar = (com.google.android.libraries.navigation.internal.gd.m) pVarA.a;
            if (mVar == null) {
                mVar = null;
            } else if (!pVarA.b) {
                bb bbVar = (bb) mVar.aH(5, null);
                bbVar.x(mVar);
                com.google.android.libraries.navigation.internal.gd.l lVar = (com.google.android.libraries.navigation.internal.gd.l) bbVar;
                am amVar = ((com.google.android.libraries.navigation.internal.gd.m) lVar.b).f;
                if (amVar == null) {
                    amVar = am.a;
                }
                bb bbVar2 = (bb) amVar.aH(5, null);
                bbVar2.x(amVar);
                al alVar = (al) bbVar2;
                if (!alVar.b.H()) {
                    alVar.v();
                }
                ((am) alVar.b).c = dj.b;
                am amVar2 = mVar.f;
                if (amVar2 == null) {
                    amVar2 = am.a;
                }
                int size = amVar2.c.size();
                for (int i = 0; i < size; i++) {
                    am amVar3 = mVar.f;
                    if (amVar3 == null) {
                        amVar3 = am.a;
                    }
                    hb hbVar = (hb) amVar3.c.get(i);
                    bb bbVar3 = (bb) hbVar.aH(5, null);
                    bbVar3.x(hbVar);
                    gy gyVar = (gy) bbVar3;
                    if (!gyVar.b.H()) {
                        gyVar.v();
                    }
                    hb hbVar2 = (hb) gyVar.b;
                    hb hbVar3 = hb.a;
                    hbVar2.b &= -3;
                    hbVar2.f = 0L;
                    alVar.d((hb) gyVar.t());
                }
                am amVar4 = (am) alVar.t();
                if (!lVar.b.H()) {
                    lVar.v();
                }
                com.google.android.libraries.navigation.internal.gd.m mVar2 = (com.google.android.libraries.navigation.internal.gd.m) lVar.b;
                amVar4.getClass();
                mVar2.f = amVar4;
                mVar2.b |= 8;
                if (!lVar.b.H()) {
                    lVar.v();
                }
                com.google.android.libraries.navigation.internal.gd.m mVar3 = (com.google.android.libraries.navigation.internal.gd.m) lVar.b;
                mVar3.b &= -5;
                mVar3.e = 0L;
                mVar = (com.google.android.libraries.navigation.internal.gd.m) lVar.t();
            }
            if (this.c != null) {
                this.f.execute(new Runnable() { // from class: com.google.android.libraries.navigation.internal.ht.c
                    @Override // java.lang.Runnable
                    public final void run() {
                        long availableBytes;
                        d dVar = this.a;
                        com.google.android.libraries.navigation.internal.afo.a aVar = dVar.c;
                        ar.q(aVar);
                        com.google.android.libraries.navigation.internal.kk.k kVar = (com.google.android.libraries.navigation.internal.kk.k) ((com.google.android.libraries.navigation.internal.kl.a) aVar.a()).a(com.google.android.libraries.navigation.internal.hw.a.i);
                        com.google.android.libraries.navigation.internal.hh.p pVar = pVarA;
                        pVar.a(kVar);
                        try {
                            if (((com.google.android.libraries.navigation.internal.iu.b) ((aw) dVar.d).a).a()) {
                                pVar.a((com.google.android.libraries.navigation.internal.kk.k) ((com.google.android.libraries.navigation.internal.kl.a) dVar.c.a()).a(com.google.android.libraries.navigation.internal.hw.a.j));
                                int i2 = pVar.c;
                                if (dVar.c != null) {
                                    File filesDir = dVar.a.getFilesDir();
                                    long totalBytes = 0;
                                    if (filesDir == null) {
                                        availableBytes = 0;
                                    } else {
                                        try {
                                            availableBytes = new StatFs(filesDir.getPath()).getAvailableBytes();
                                        } catch (IllegalArgumentException unused) {
                                            availableBytes = 0;
                                        }
                                    }
                                    long jI = com.google.android.libraries.navigation.internal.nq.a.i(availableBytes);
                                    File filesDir2 = dVar.a.getFilesDir();
                                    if (filesDir2 != null) {
                                        try {
                                            totalBytes = new StatFs(filesDir2.getPath()).getTotalBytes();
                                        } catch (IllegalArgumentException unused2) {
                                        }
                                    }
                                    long jI2 = com.google.android.libraries.navigation.internal.nq.a.i(totalBytes);
                                    ((com.google.android.libraries.navigation.internal.kk.l) ((com.google.android.libraries.navigation.internal.kl.a) dVar.c.a()).a(com.google.android.libraries.navigation.internal.hw.a.l)).a(jI);
                                    ((com.google.android.libraries.navigation.internal.kk.l) ((com.google.android.libraries.navigation.internal.kl.a) dVar.c.a()).a(com.google.android.libraries.navigation.internal.hw.a.m)).a(jI2);
                                    if (i2 == 7) {
                                        ((com.google.android.libraries.navigation.internal.kk.l) ((com.google.android.libraries.navigation.internal.kl.a) dVar.c.a()).a(com.google.android.libraries.navigation.internal.hw.a.f448n)).a(jI);
                                        ((com.google.android.libraries.navigation.internal.kk.l) ((com.google.android.libraries.navigation.internal.kl.a) dVar.c.a()).a(com.google.android.libraries.navigation.internal.hw.a.o)).a(jI2);
                                    }
                                }
                            }
                        } catch (com.google.android.libraries.navigation.internal.iu.a unused3) {
                            ((com.google.android.libraries.navigation.internal.zb.h) com.google.android.libraries.navigation.internal.zb.j.b.F((char) 694)).p("Unable to determine if app is in foreground");
                        }
                        com.google.android.libraries.navigation.internal.gd.m mVar4 = mVar;
                        if (mVar4 != null) {
                            ((com.google.android.libraries.navigation.internal.kl.a) dVar.c.a()).f(com.google.android.libraries.navigation.internal.hw.a.k, DesugarTimeUnit.convert(TimeUnit.MINUTES, Duration.ofMillis(Duration.between(Instant.ofEpochMilli(mVar4.e), dVar.b.f()).toMillis())));
                        }
                    }
                });
            }
            if (dVarB != null) {
                Trace.endSection();
            }
        } catch (Throwable th) {
            if (dVarB != null) {
                try {
                    Trace.endSection();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
        return mVar;
    }

    public final synchronized boolean b(String str, Locale locale, long j, am amVar, com.google.android.libraries.navigation.internal.hh.q qVar) {
        boolean zC;
        com.google.android.libraries.navigation.internal.gd.l lVar = (com.google.android.libraries.navigation.internal.gd.l) com.google.android.libraries.navigation.internal.gd.m.a.q();
        if (!lVar.b.H()) {
            lVar.v();
        }
        com.google.android.libraries.navigation.internal.gd.m mVar = (com.google.android.libraries.navigation.internal.gd.m) lVar.b;
        amVar.getClass();
        mVar.f = amVar;
        mVar.b |= 8;
        String strB = aq.b(str);
        if (!lVar.b.H()) {
            lVar.v();
        }
        com.google.android.libraries.navigation.internal.gd.m mVar2 = (com.google.android.libraries.navigation.internal.gd.m) lVar.b;
        mVar2.b |= 1;
        mVar2.c = strB;
        String string = locale.toString();
        if (!lVar.b.H()) {
            lVar.v();
        }
        com.google.android.libraries.navigation.internal.gd.m mVar3 = (com.google.android.libraries.navigation.internal.gd.m) lVar.b;
        string.getClass();
        mVar3.b |= 2;
        mVar3.d = string;
        if (!lVar.b.H()) {
            lVar.v();
        }
        com.google.android.libraries.navigation.internal.gd.m mVar4 = (com.google.android.libraries.navigation.internal.gd.m) lVar.b;
        mVar4.b |= 4;
        mVar4.e = j;
        zC = qVar.c((com.google.android.libraries.navigation.internal.gd.m) lVar.t(), qVar.b.incrementAndGet());
        if (zC) {
            com.google.android.libraries.navigation.internal.fd.d.a(this.a);
        }
        return zC;
    }

    public final synchronized void c(String str, Locale locale, long j, am amVar) {
        b(str, locale, j, amVar, this.e);
    }
}
