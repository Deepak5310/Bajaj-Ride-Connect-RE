package com.google.android.libraries.geo.mapcore.internal.store.diskcache;

import android.support.v4.media.session.PlaybackStateCompat;
import androidx.tracing.Trace;
import com.google.android.libraries.navigation.internal.aac.bn;
import com.google.android.libraries.navigation.internal.adi.an;
import com.google.android.libraries.navigation.internal.ael.ar;
import com.google.android.libraries.navigation.internal.ael.bi;
import com.google.android.libraries.navigation.internal.ael.cc;
import com.google.android.libraries.navigation.internal.dm.q;
import com.google.android.libraries.navigation.internal.dm.s;
import com.google.android.libraries.navigation.internal.oe.at;
import com.google.android.libraries.navigation.internal.qu.bs;
import java.io.File;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes2.dex */
public class g {
    public final b c;
    public final com.google.android.libraries.navigation.internal.kl.b d;
    private final File h;
    private final bn i;
    private final com.google.android.libraries.navigation.internal.mj.a j;
    private final at k;
    private final bs o;
    private static final com.google.android.libraries.navigation.internal.zb.j g = com.google.android.libraries.navigation.internal.zb.j.e("com.google.android.libraries.geo.mapcore.internal.store.diskcache.g");
    static final long a = TimeUnit.SECONDS.toMillis(30);
    static final long b = TimeUnit.SECONDS.toMillis(1);
    public final Set e = ConcurrentHashMap.newKeySet();
    public boolean f = false;
    private boolean l = false;
    private long m = 0;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private long f69n = 0;

    public g(b bVar, File file, com.google.android.libraries.navigation.internal.kl.b bVar2, bn bnVar, com.google.android.libraries.navigation.internal.mj.a aVar, bs bsVar, at atVar) {
        this.c = bVar;
        this.h = file;
        this.d = bVar2;
        this.i = bnVar;
        this.j = aVar;
        this.o = bsVar;
        this.k = atVar;
        NativeSqliteDiskCacheImpl.nativeSqliteDiskCacheSetStyleTablePriorityBoostMillis(((NativeSqliteDiskCacheImpl) bVar).b, bsVar.g());
    }

    public static g o(File file, File file2, com.google.android.libraries.navigation.internal.kl.b bVar, bn bnVar, com.google.android.libraries.navigation.internal.mj.a aVar, bs bsVar, at atVar) throws d {
        if ((!file.exists() && !file.mkdirs()) || (!file2.exists() && !file2.mkdirs())) {
            ((com.google.android.libraries.navigation.internal.kk.j) bVar.a(com.google.android.libraries.navigation.internal.km.k.j)).a();
            if (file.getParentFile() == null || file.getParentFile().getFreeSpace() > PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM) {
                ((com.google.android.libraries.navigation.internal.kk.k) bVar.a(com.google.android.libraries.navigation.internal.km.k.k)).a(7946);
            } else {
                ((com.google.android.libraries.navigation.internal.kk.k) bVar.a(com.google.android.libraries.navigation.internal.km.k.k)).a(7949);
            }
            throw new d();
        }
        file.getPath();
        file2.getPath();
        try {
            int i = com.google.android.libraries.navigation.internal.dm.a.c;
            com.google.android.libraries.navigation.internal.zb.j jVar = NativeSqliteDiskCacheImpl.a;
            try {
                String string = file.toString();
                String string2 = file2.toString();
                int i2 = i - 1;
                if (i == 0) {
                    throw null;
                }
                g gVar = new g(new NativeSqliteDiskCacheImpl(NativeSqliteDiskCacheImpl.nativeOpenOrCreateSqliteDiskCache(string, string2, i2)), file, bVar, bnVar, aVar, bsVar, atVar);
                ((com.google.android.libraries.navigation.internal.kk.k) bVar.a(com.google.android.libraries.navigation.internal.km.k.k)).a(0);
                return gVar;
            } catch (com.google.android.apps.gmm.jni.util.c e) {
                throw new d(e);
            }
        } catch (d e2) {
            ((com.google.android.libraries.navigation.internal.kk.j) bVar.a(com.google.android.libraries.navigation.internal.km.k.j)).a();
            ((com.google.android.libraries.navigation.internal.kk.k) bVar.a(com.google.android.libraries.navigation.internal.km.k.k)).a(e2.a);
            throw e2;
        }
    }

    private static void p(com.google.android.libraries.navigation.internal.kk.j jVar, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            jVar.a();
        }
    }

    private static void q(com.google.android.libraries.navigation.internal.kk.k kVar, an anVar, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            kVar.a(anVar.ah);
        }
    }

    private final void r() {
        com.google.android.libraries.navigation.internal.dm.c cVar;
        try {
            try {
                byte[] bArrNativeSqliteDiskCacheGetAndClearStats = NativeSqliteDiskCacheImpl.nativeSqliteDiskCacheGetAndClearStats(((NativeSqliteDiskCacheImpl) this.c).b);
                try {
                    bi biVarV = bi.v(com.google.android.libraries.navigation.internal.dm.c.a, bArrNativeSqliteDiskCacheGetAndClearStats, 0, bArrNativeSqliteDiskCacheGetAndClearStats.length, ar.b());
                    bi.I(biVarV);
                    cVar = (com.google.android.libraries.navigation.internal.dm.c) biVarV;
                } catch (cc e) {
                    throw new d(e);
                }
            } catch (com.google.android.apps.gmm.jni.util.c unused) {
                ((com.google.android.libraries.navigation.internal.zb.h) NativeSqliteDiskCacheImpl.a.d(com.google.android.libraries.navigation.internal.nl.a.a).F((char) 1201)).p("getAndClearStats result bytes were null");
                cVar = com.google.android.libraries.navigation.internal.dm.c.a;
            }
            com.google.android.libraries.navigation.internal.nw.d dVarB = com.google.android.libraries.navigation.internal.nw.e.b("SqliteDiskCache.reportDatabaseMetrics");
            try {
                p((com.google.android.libraries.navigation.internal.kk.j) this.d.a(com.google.android.libraries.navigation.internal.km.k.g), cVar.e);
                p((com.google.android.libraries.navigation.internal.kk.j) this.d.a(com.google.android.libraries.navigation.internal.km.k.h), cVar.f);
                p((com.google.android.libraries.navigation.internal.kk.j) this.d.a(com.google.android.libraries.navigation.internal.km.k.i), cVar.d);
                if ((cVar.b & 64) != 0) {
                    ((com.google.android.libraries.navigation.internal.kk.l) this.d.a(com.google.android.libraries.navigation.internal.km.k.t)).a(cVar.g);
                }
                if ((cVar.b & 128) != 0) {
                    ((com.google.android.libraries.navigation.internal.kk.l) this.d.a(com.google.android.libraries.navigation.internal.km.k.u)).a(cVar.h);
                }
                if ((cVar.b & 256) != 0) {
                    ((com.google.android.libraries.navigation.internal.kk.l) this.d.a(com.google.android.libraries.navigation.internal.km.k.v)).a(cVar.i);
                }
                for (com.google.android.libraries.navigation.internal.dm.e eVar : cVar.c) {
                    an anVarB = an.b(this.k.j(eVar.b).c);
                    if (anVarB == null) {
                        anVarB = an.UNKNOWN;
                    }
                    if (anVarB != an.UNKNOWN) {
                        q((com.google.android.libraries.navigation.internal.kk.k) this.d.a(com.google.android.libraries.navigation.internal.km.k.d), anVarB, eVar.e);
                        q((com.google.android.libraries.navigation.internal.kk.k) this.d.a(com.google.android.libraries.navigation.internal.km.k.e), anVarB, eVar.f);
                        q((com.google.android.libraries.navigation.internal.kk.k) this.d.a(com.google.android.libraries.navigation.internal.km.k.a), anVarB, eVar.c);
                        q((com.google.android.libraries.navigation.internal.kk.k) this.d.a(com.google.android.libraries.navigation.internal.km.k.c), anVarB, eVar.d);
                    } else {
                        ((com.google.android.libraries.navigation.internal.zb.h) g.d(com.google.android.libraries.navigation.internal.nl.a.a).F(1209)).s("Disk cache reported stats for an unknown pipe name '%s'", eVar.b);
                    }
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
        } catch (d unused2) {
            ((com.google.android.libraries.navigation.internal.zb.h) com.google.android.libraries.navigation.internal.zb.j.b.F((char) 1208)).p("Error getting disk cache statistics:");
        }
    }

    public final long a() {
        try {
            return this.c.a();
        } catch (d e) {
            j(e);
            ((com.google.android.libraries.navigation.internal.zb.h) ((com.google.android.libraries.navigation.internal.zb.h) g.d(com.google.android.libraries.navigation.internal.nl.a.a).g(e)).F((char) 1202)).p("Failed to get database size %s");
            return 0L;
        }
    }

    public final com.google.android.libraries.navigation.internal.dm.g b(com.google.android.libraries.navigation.internal.dm.i iVar) throws cc, d {
        try {
            try {
                byte[] bArrNativeSqliteDiskCacheGetResource = NativeSqliteDiskCacheImpl.nativeSqliteDiskCacheGetResource(((NativeSqliteDiskCacheImpl) this.c).b, iVar.m());
                if (bArrNativeSqliteDiskCacheGetResource == null) {
                    return null;
                }
                bi biVarV = bi.v(com.google.android.libraries.navigation.internal.dm.g.a, bArrNativeSqliteDiskCacheGetResource, 0, bArrNativeSqliteDiskCacheGetResource.length, ar.b());
                bi.I(biVarV);
                return (com.google.android.libraries.navigation.internal.dm.g) biVarV;
            } catch (com.google.android.apps.gmm.jni.util.c e) {
                throw new d(e);
            }
        } catch (d e2) {
            j(e2);
            throw e2;
        }
    }

    public final q c(com.google.android.libraries.navigation.internal.dm.o oVar) throws cc, d {
        try {
            try {
                byte[] bArrNativeSqliteDiskCacheGetTile = NativeSqliteDiskCacheImpl.nativeSqliteDiskCacheGetTile(((NativeSqliteDiskCacheImpl) this.c).b, oVar.m());
                if (bArrNativeSqliteDiskCacheGetTile == null) {
                    return null;
                }
                bi biVarV = bi.v(q.a, bArrNativeSqliteDiskCacheGetTile, 0, bArrNativeSqliteDiskCacheGetTile.length, ar.b());
                bi.I(biVarV);
                return (q) biVarV;
            } catch (com.google.android.apps.gmm.jni.util.c e) {
                throw new d(e);
            }
        } catch (d e2) {
            j(e2);
            throw e2;
        }
    }

    public final s d(com.google.android.libraries.navigation.internal.dm.o oVar) throws cc, d {
        try {
            try {
                byte[] bArrNativeSqliteDiskCacheGetTileMetadata = NativeSqliteDiskCacheImpl.nativeSqliteDiskCacheGetTileMetadata(((NativeSqliteDiskCacheImpl) this.c).b, oVar.m());
                if (bArrNativeSqliteDiskCacheGetTileMetadata == null) {
                    return null;
                }
                bi biVarV = bi.v(s.a, bArrNativeSqliteDiskCacheGetTileMetadata, 0, bArrNativeSqliteDiskCacheGetTileMetadata.length, ar.b());
                bi.I(biVarV);
                return (s) biVarV;
            } catch (com.google.android.apps.gmm.jni.util.c e) {
                throw new d(e);
            }
        } catch (d e2) {
            j(e2);
            throw e2;
        }
    }

    public final void e(com.google.android.libraries.navigation.internal.dm.i iVar) throws d {
        try {
            this.e.remove(iVar);
            try {
                NativeSqliteDiskCacheImpl.nativeSqliteDiskCacheDeleteResource(((NativeSqliteDiskCacheImpl) this.c).b, iVar.m());
            } catch (com.google.android.apps.gmm.jni.util.c e) {
                throw new d(e);
            }
        } catch (d e2) {
            j(e2);
            throw e2;
        }
    }

    public final void f(com.google.android.libraries.navigation.internal.dm.o oVar) throws d {
        try {
            try {
                NativeSqliteDiskCacheImpl.nativeSqliteDiskCacheDeleteTile(((NativeSqliteDiskCacheImpl) this.c).b, oVar.m());
            } catch (com.google.android.apps.gmm.jni.util.c e) {
                throw new d(e);
            }
        } catch (d e2) {
            j(e2);
            throw e2;
        }
    }

    final void g(long j, final long j2) throws d {
        boolean z;
        final long jA;
        boolean z2;
        long jA2 = this.j.a();
        double d = j2;
        double dB = this.o.b() * d;
        double dC = d * this.o.c();
        long j3 = (long) dB;
        if (j <= j3) {
            z = false;
        } else {
            long jMax = (long) dC;
            long j4 = j - j3;
            z = j4 > PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED;
            long jB = com.google.android.libraries.navigation.internal.zy.k.b(j4, 0L, PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED);
            if (z) {
                jMax = Math.max(jMax, j - 1048576);
            }
            com.google.android.libraries.navigation.internal.kk.m mVarA = ((com.google.android.libraries.navigation.internal.kk.n) this.d.a(com.google.android.libraries.navigation.internal.km.k.l)).a();
            try {
                try {
                    com.google.android.libraries.navigation.internal.nw.d dVarB = com.google.android.libraries.navigation.internal.nw.e.b("SqliteDiskCache.trimAndVacuumDatabase");
                    try {
                        b bVar = this.c;
                        try {
                            NativeSqliteDiskCacheImpl.nativeSqliteDiskCacheTrimToSize(((NativeSqliteDiskCacheImpl) bVar).b, jMax);
                            NativeSqliteDiskCacheImpl.nativeSqliteDiskCacheFlushWrites(((NativeSqliteDiskCacheImpl) bVar).b);
                            if (jB > 0) {
                                com.google.android.libraries.navigation.internal.kk.m mVarA2 = ((com.google.android.libraries.navigation.internal.kk.n) this.d.a(com.google.android.libraries.navigation.internal.km.k.w)).a();
                                try {
                                    NativeSqliteDiskCacheImpl.nativeSqliteDiskCacheIncrementalVacuum(((NativeSqliteDiskCacheImpl) this.c).b, jB);
                                    mVarA2.a();
                                } catch (com.google.android.apps.gmm.jni.util.c e) {
                                    throw new d(e);
                                }
                            }
                            r();
                            if (dVarB != null) {
                                Trace.endSection();
                            }
                            mVarA.a();
                        } catch (com.google.android.apps.gmm.jni.util.c e2) {
                            throw new d(e2);
                        }
                    } catch (Throwable th) {
                        if (dVarB == null) {
                            throw th;
                        }
                        try {
                            Trace.endSection();
                            throw th;
                        } catch (Throwable th2) {
                            th.addSuppressed(th2);
                            throw th;
                        }
                    }
                } catch (Throwable th3) {
                    mVarA.a();
                    throw th3;
                }
            } catch (d e3) {
                j(e3);
                ((com.google.android.libraries.navigation.internal.zb.h) com.google.android.libraries.navigation.internal.zb.j.b.F(1211)).p("Failed to compact database:");
                mVarA.a();
                z = false;
            }
        }
        boolean z3 = !z;
        if (z) {
            try {
                z2 = z3;
                jA = this.c.a();
            } catch (d e4) {
                j(e4);
                ((com.google.android.libraries.navigation.internal.zb.h) ((com.google.android.libraries.navigation.internal.zb.h) g.d(com.google.android.libraries.navigation.internal.nl.a.a).g(e4)).F((char) 1206)).p("Failed to get database size %s");
                jA = 0;
                z2 = true;
            }
        } else {
            z2 = z3;
            jA = 0;
        }
        long jA3 = this.j.a();
        synchronized (this) {
            this.f69n += jA3 - jA2;
            if (z2) {
                this.f = false;
                ((com.google.android.libraries.navigation.internal.kk.l) this.d.a(com.google.android.libraries.navigation.internal.km.k.m)).a(this.f69n);
                this.f69n = 0L;
            }
        }
        if (!z2) {
            com.google.android.libraries.navigation.internal.hx.n.a(this.i.schedule(new Runnable() { // from class: com.google.android.libraries.geo.mapcore.internal.store.diskcache.e
                @Override // java.lang.Runnable
                public final void run() throws d {
                    this.a.g(jA, j2);
                }
            }, b, TimeUnit.MILLISECONDS), this.i);
        }
        this.e.clear();
    }

    public final void h(s sVar) throws d {
        try {
            try {
                NativeSqliteDiskCacheImpl.nativeSqliteDiskCacheInsertOrUpdateEmptyTile(((NativeSqliteDiskCacheImpl) this.c).b, sVar.m());
            } catch (com.google.android.apps.gmm.jni.util.c e) {
                throw new d(e);
            }
        } catch (d e2) {
            j(e2);
            throw e2;
        }
    }

    public final void i(com.google.android.libraries.navigation.internal.dm.k kVar, byte[] bArr) throws d {
        com.google.android.libraries.navigation.internal.kk.m mVarA = ((com.google.android.libraries.navigation.internal.kk.n) this.d.a(com.google.android.libraries.navigation.internal.km.k.s)).a();
        try {
            try {
                NativeSqliteDiskCacheImpl.nativeSqliteDiskCacheInsertOrUpdateResource(((NativeSqliteDiskCacheImpl) this.c).b, kVar.m(), bArr);
                k();
                mVarA.a();
            } catch (com.google.android.apps.gmm.jni.util.c e) {
                throw new d(e);
            }
        } catch (d e2) {
            j(e2);
            throw e2;
        }
    }

    public final void j(d dVar) {
        r();
        Throwable cause = dVar.getCause();
        if (cause instanceof com.google.android.apps.gmm.jni.util.c) {
            com.google.android.apps.gmm.jni.util.c cVar = (com.google.android.apps.gmm.jni.util.c) cause;
            if (!com.google.android.libraries.navigation.internal.aei.a.INVALID_ARGUMENT.equals(cVar.a)) {
                if (!com.google.android.libraries.navigation.internal.aei.a.INTERNAL.equals(cVar.a)) {
                    return;
                }
            }
            ((com.google.android.libraries.navigation.internal.zb.h) ((com.google.android.libraries.navigation.internal.zb.h) g.d(com.google.android.libraries.navigation.internal.nl.a.a).g(cVar)).F((char) 1207)).o();
        }
    }

    final synchronized void k() {
        if (this.l && !this.f && this.j.a() - this.m >= a) {
            this.m = this.j.a();
            final long jA = a();
            double freeSpace = (this.h.getFreeSpace() + jA) * this.o.a();
            long jE = this.o.e();
            long jMin = (long) freeSpace;
            if (jE > 0) {
                jMin = Math.min(jE, jMin);
            }
            if (jA >= jMin) {
                this.f = true;
                this.m = this.j.a();
                this.f69n = 0L;
                final long j = jMin;
                this.i.execute(new Runnable() { // from class: com.google.android.libraries.geo.mapcore.internal.store.diskcache.f
                    @Override // java.lang.Runnable
                    public final void run() throws d {
                        this.a.g(jA, j);
                    }
                });
            }
        }
    }

    public final synchronized void l() {
        this.l = true;
    }

    public final void m(int i) throws d {
        try {
            try {
                NativeSqliteDiskCacheImpl.nativeSqliteDiskCacheSetServerDataVersion(((NativeSqliteDiskCacheImpl) this.c).b, i);
            } catch (com.google.android.apps.gmm.jni.util.c e) {
                throw new d(e);
            }
        } catch (d e2) {
            j(e2);
            throw e2;
        }
    }

    public final boolean n(com.google.android.libraries.navigation.internal.dm.i iVar) throws d {
        try {
            if (!this.o.h()) {
                return this.c.c(iVar);
            }
            int iA = com.google.android.libraries.navigation.internal.dm.m.a(iVar.c);
            if (iA == 0) {
                iA = com.google.android.libraries.navigation.internal.dm.m.a;
            }
            if (iA != com.google.android.libraries.navigation.internal.dm.m.b) {
                return this.c.c(iVar);
            }
            if (this.e.contains(iVar)) {
                return true;
            }
            if (!this.c.c(iVar)) {
                return false;
            }
            this.e.add(iVar);
            return true;
        } catch (d e) {
            j(e);
            throw e;
        }
    }
}
