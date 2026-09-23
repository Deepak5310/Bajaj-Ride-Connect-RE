package com.google.android.libraries.geo.mapcore.internal.store.diskcache;

import androidx.tracing.Trace;
import com.google.android.libraries.geo.mapcore.internal.model.cc;
import com.google.android.libraries.geo.mapcore.internal.model.cd;
import com.google.android.libraries.geo.mapcore.internal.model.cg;
import com.google.android.libraries.geo.mapcore.internal.model.ch;
import com.google.android.libraries.geo.mapcore.internal.model.ck;
import com.google.android.libraries.geo.mapcore.internal.model.cl;
import com.google.android.libraries.geo.mapcore.internal.model.t;
import com.google.android.libraries.navigation.internal.adi.an;
import com.google.android.libraries.navigation.internal.ael.bb;
import com.google.android.libraries.navigation.internal.dm.q;
import com.google.android.libraries.navigation.internal.dm.r;
import com.google.android.libraries.navigation.internal.dm.s;
import com.google.android.libraries.navigation.internal.oe.ap;
import com.google.android.libraries.navigation.internal.oe.as;
import com.google.android.libraries.navigation.internal.oe.at;
import com.google.android.libraries.navigation.internal.qu.br;
import java.io.IOException;
import java.util.Locale;
import java.util.logging.Level;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes2.dex */
public class o implements com.google.android.libraries.navigation.internal.qv.d {
    private static final com.google.android.libraries.navigation.internal.zb.j a = com.google.android.libraries.navigation.internal.zb.j.e("com.google.android.libraries.geo.mapcore.internal.store.diskcache.o");
    private final an b;
    private final ap c;
    private final cg d;
    private final g e;
    private final com.google.android.libraries.navigation.internal.qv.e f;
    private final com.google.android.libraries.navigation.internal.no.a g;
    private final at h;
    private final com.google.android.libraries.navigation.internal.mj.a i;
    private final com.google.android.libraries.navigation.internal.kl.b j;
    private final br k;

    public o(at atVar, g gVar, ap apVar, cg cgVar, com.google.android.libraries.navigation.internal.qv.e eVar, com.google.android.libraries.navigation.internal.no.a aVar, br brVar, com.google.android.libraries.navigation.internal.mj.a aVar2, com.google.android.libraries.navigation.internal.kl.b bVar) {
        this.h = atVar;
        this.e = gVar;
        this.b = apVar.c;
        this.c = apVar;
        this.d = cgVar;
        this.f = eVar;
        this.g = aVar;
        this.k = brVar;
        this.i = aVar2;
        this.j = bVar;
    }

    static s c(s sVar, com.google.android.libraries.navigation.internal.mj.a aVar) {
        s sVarR = r(sVar);
        bb bbVar = (bb) sVarR.aH(5, null);
        bbVar.x(sVarR);
        r rVar = (r) bbVar;
        if ((sVarR.b & 32) != 0) {
            long jP = p(aVar, sVarR.h);
            if (!rVar.b.H()) {
                rVar.v();
            }
            s sVar2 = (s) rVar.b;
            sVar2.b |= 32;
            sVar2.h = jP;
        }
        if ((sVarR.b & 64) != 0) {
            long jP2 = p(aVar, sVarR.i);
            if (!rVar.b.H()) {
                rVar.v();
            }
            s sVar3 = (s) rVar.b;
            sVar3.b |= 64;
            sVar3.i = jP2;
        }
        return (s) rVar.t();
    }

    static s i(s sVar, com.google.android.libraries.navigation.internal.mj.a aVar) {
        s sVarR = r(sVar);
        bb bbVar = (bb) sVarR.aH(5, null);
        bbVar.x(sVarR);
        r rVar = (r) bbVar;
        if ((sVarR.b & 32) != 0) {
            long jA = com.google.android.libraries.navigation.internal.mj.d.a(aVar, sVarR.h);
            if (!rVar.b.H()) {
                rVar.v();
            }
            s sVar2 = (s) rVar.b;
            sVar2.b |= 32;
            sVar2.h = jA;
        }
        if ((sVarR.b & 64) != 0) {
            long jA2 = com.google.android.libraries.navigation.internal.mj.d.a(aVar, sVarR.i);
            if (!rVar.b.H()) {
                rVar.v();
            }
            s sVar3 = (s) rVar.b;
            sVar3.b |= 64;
            sVar3.i = jA2;
        }
        return (s) rVar.t();
    }

    private static long p(com.google.android.libraries.navigation.internal.mj.a aVar, long j) {
        if (j >= 0) {
            return Math.max(0L, (j + aVar.a()) - aVar.f().toEpochMilli());
        }
        return -1L;
    }

    private final r q(cd cdVar, int i, String str, String str2, int i2) {
        r rVar = (r) s.a.q();
        com.google.android.libraries.navigation.internal.dm.o oVarA = ch.a(this.c, this.d, cdVar, str, str2);
        if (!rVar.b.H()) {
            rVar.v();
        }
        s sVar = (s) rVar.b;
        oVarA.getClass();
        sVar.c = oVarA;
        sVar.b |= 1;
        if (i != 0) {
            if (!rVar.b.H()) {
                rVar.v();
            }
            s sVar2 = (s) rVar.b;
            sVar2.b |= 256;
            sVar2.k = i;
        }
        if (i2 != 0) {
            if (!rVar.b.H()) {
                rVar.v();
            }
            s sVar3 = (s) rVar.b;
            sVar3.b |= 4;
            sVar3.e = i2;
        }
        long jC = this.h.c(this.b, this.i);
        if (jC != -1) {
            if (!rVar.b.H()) {
                rVar.v();
            }
            s sVar4 = (s) rVar.b;
            sVar4.b |= 32;
            sVar4.h = jC;
        }
        long jG = this.h.g(this.b, this.i);
        if (jG != -1) {
            if (!rVar.b.H()) {
                rVar.v();
            }
            s sVar5 = (s) rVar.b;
            sVar5.b |= 64;
            sVar5.i = jG;
        }
        return rVar;
    }

    private static s r(s sVar) {
        if ((sVar.b & 4) != 0 && sVar.e == 0) {
            bb bbVar = (bb) sVar.aH(5, null);
            bbVar.x(sVar);
            r rVar = (r) bbVar;
            if (!rVar.b.H()) {
                rVar.v();
            }
            s sVar2 = (s) rVar.b;
            sVar2.b &= -5;
            sVar2.e = 0;
            sVar = (s) rVar.t();
        }
        if ((sVar.b & 32) != 0 && sVar.h == -1) {
            bb bbVar2 = (bb) sVar.aH(5, null);
            bbVar2.x(sVar);
            r rVar2 = (r) bbVar2;
            if (!rVar2.b.H()) {
                rVar2.v();
            }
            s sVar3 = (s) rVar2.b;
            sVar3.b &= -33;
            sVar3.h = 0L;
            sVar = (s) rVar2.t();
        }
        if ((sVar.b & 64) != 0 && sVar.i == -1) {
            bb bbVar3 = (bb) sVar.aH(5, null);
            bbVar3.x(sVar);
            r rVar3 = (r) bbVar3;
            if (!rVar3.b.H()) {
                rVar3.v();
            }
            s sVar4 = (s) rVar3.b;
            sVar4.b &= -65;
            sVar4.i = 0L;
            sVar = (s) rVar3.t();
        }
        if ((sVar.b & 8) != 0 && sVar.f == -1) {
            bb bbVar4 = (bb) sVar.aH(5, null);
            bbVar4.x(sVar);
            r rVar4 = (r) bbVar4;
            if (!rVar4.b.H()) {
                rVar4.v();
            }
            s sVar5 = (s) rVar4.b;
            sVar5.b &= -9;
            sVar5.f = 0;
            sVar = (s) rVar4.t();
        }
        if ((sVar.b & 16) != 0 && sVar.g == -1) {
            bb bbVar5 = (bb) sVar.aH(5, null);
            bbVar5.x(sVar);
            r rVar5 = (r) bbVar5;
            if (!rVar5.b.H()) {
                rVar5.v();
            }
            s sVar6 = (s) rVar5.b;
            sVar6.b &= -17;
            sVar6.g = 0;
            sVar = (s) rVar5.t();
        }
        if ((sVar.b & 256) != 0 && sVar.k == 0) {
            bb bbVar6 = (bb) sVar.aH(5, null);
            bbVar6.x(sVar);
            r rVar6 = (r) bbVar6;
            if (!rVar6.b.H()) {
                rVar6.v();
            }
            s sVar7 = (s) rVar6.b;
            sVar7.b &= -257;
            sVar7.k = 0;
            sVar = (s) rVar6.t();
        }
        if ((sVar.b & 512) != 0 && sVar.l.equals("")) {
            bb bbVar7 = (bb) sVar.aH(5, null);
            bbVar7.x(sVar);
            r rVar7 = (r) bbVar7;
            if (!rVar7.b.H()) {
                rVar7.v();
            }
            s sVar8 = (s) rVar7.b;
            sVar8.b &= -513;
            sVar8.l = s.a.l;
            sVar = (s) rVar7.t();
        }
        if ((sVar.b & 2) == 0 || sVar.d != -1) {
            return sVar;
        }
        bb bbVar8 = (bb) sVar.aH(5, null);
        bbVar8.x(sVar);
        r rVar8 = (r) bbVar8;
        if (!rVar8.b.H()) {
            rVar8.v();
        }
        s sVar9 = (s) rVar8.b;
        sVar9.b &= -3;
        sVar9.d = 0;
        return (s) rVar8.t();
    }

    private final boolean s(cd cdVar, s sVar) {
        long epochMilli = this.i.f().toEpochMilli();
        long j = sVar.m;
        if (j < epochMilli || (sVar.b & 32) == 0 || j - epochMilli <= sVar.h - j) {
            return false;
        }
        this.b.name();
        try {
            this.e.f(ch.a(this.c, this.d, cdVar, this.k.a(), Locale.getDefault().toLanguageTag()));
            ((com.google.android.libraries.navigation.internal.kk.k) this.j.a(com.google.android.libraries.navigation.internal.km.k.b)).a(this.b.ah);
            return true;
        } catch (IOException unused) {
            ((com.google.android.libraries.navigation.internal.zb.h) com.google.android.libraries.navigation.internal.zb.j.b.F(1272)).x("Failed to delete tile with invalid timestamp: coords= %s , paintRequestTemplateTileType= %s :", cdVar, this.b.name());
            return true;
        }
    }

    @Override // com.google.android.libraries.navigation.internal.qv.d
    public final s a(cd cdVar) {
        try {
            s sVarD = this.e.d(ch.a(this.c, this.d, cdVar, this.k.a(), this.g.b().toLanguageTag()));
            if (sVarD == null || s(cdVar, sVarD)) {
                return null;
            }
            return c(sVarD, this.i);
        } catch (IOException unused) {
            ((com.google.android.libraries.navigation.internal.zb.h) com.google.android.libraries.navigation.internal.zb.j.b.F(1261)).x("Get tile metadata failed: coords= %s , paintRequestTemplateTileType= %s :", cdVar, this.b.name());
            return null;
        }
    }

    @Override // com.google.android.libraries.navigation.internal.qv.g
    public final cc b(cd cdVar) {
        q qVarC;
        com.google.android.libraries.navigation.internal.dm.o oVarA = ch.a(this.c, this.d, cdVar, this.k.a(), Locale.getDefault().toLanguageTag());
        try {
            qVarC = this.e.c(oVarA);
        } catch (IOException unused) {
            ((com.google.android.libraries.navigation.internal.zb.h) com.google.android.libraries.navigation.internal.zb.j.b.F(1265)).x("getTile failed: coords= %s , paintRequestTemplateTileType= %s :", cdVar, this.b.name());
            qVarC = null;
        }
        if (qVarC != null) {
            s sVar = qVarC.b;
            if (sVar == null) {
                sVar = s.a;
            }
            if (s(cdVar, sVar)) {
                qVarC = null;
            }
        }
        if (qVarC == null) {
            return null;
        }
        s sVar2 = qVarC.b;
        if (sVar2 == null) {
            sVar2 = s.a;
        }
        if (qVarC.c.d() == 0) {
            return new t(c(sVar2, this.i), this.b, cdVar, as.DISK_CACHE);
        }
        cl clVarA = this.f.a(c(sVar2, this.i), this.b, cdVar, qVarC.c.B(), true, as.DISK_CACHE);
        com.google.android.libraries.geo.mapcore.internal.model.q qVar = (com.google.android.libraries.geo.mapcore.internal.model.q) clVarA;
        if (qVar.a == ck.IO_ERROR || qVar.a == ck.PARSE_ERROR) {
            this.b.name();
            try {
                this.e.f(oVarA);
            } catch (IOException unused2) {
                ((com.google.android.libraries.navigation.internal.zb.h) com.google.android.libraries.navigation.internal.zb.j.b.F(1264)).x("Failed to delete corrupt tile: coords= %s , paintRequestTemplateTileType= %s :", cdVar, this.b.name());
            }
        }
        com.google.android.libraries.navigation.internal.ox.d.a(this.j, this.b.ah, clVarA);
        ((com.google.android.libraries.navigation.internal.zb.h) a.d(qVar.a == ck.SUCCESS ? Level.FINE : Level.WARNING).F(1263)).y("Sqlite disk unpack result for tile type %s and coords %s - %s", this.b.name(), cdVar, qVar.a);
        return (cc) qVar.b.f();
    }

    @Override // com.google.android.libraries.navigation.internal.qv.d
    public final void d() {
        g gVar = this.e;
        synchronized (gVar) {
            if (gVar.f) {
                return;
            }
            com.google.android.libraries.navigation.internal.kk.m mVarA = ((com.google.android.libraries.navigation.internal.kk.n) gVar.d.a(com.google.android.libraries.navigation.internal.km.k.f)).a();
            try {
                try {
                    com.google.android.libraries.navigation.internal.nw.d dVarB = com.google.android.libraries.navigation.internal.nw.e.b("SqliteDiskCache.flushWrites");
                    try {
                        gVar.c.b();
                        if (dVarB != null) {
                            Trace.endSection();
                        }
                        mVarA.a();
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
                } catch (d e) {
                    gVar.j(e);
                    mVarA.a();
                }
            } catch (Throwable th3) {
                mVarA.a();
                throw th3;
            }
        }
    }

    @Override // com.google.android.libraries.navigation.internal.qv.g
    public final void e(cd cdVar, cc ccVar) {
        throw new IllegalStateException("Don't store unencrypted tiles into tile cache.");
    }

    @Override // com.google.android.libraries.navigation.internal.qv.g
    public final void f(cd cdVar) {
        try {
            this.e.h((s) q(cdVar, 0, this.k.a(), Locale.getDefault().toLanguageTag(), 0).t());
        } catch (IOException unused) {
            ((com.google.android.libraries.navigation.internal.zb.h) com.google.android.libraries.navigation.internal.zb.j.b.F(1268)).x("Not found tile insert failed: coords= %s , paintRequestTemplateTileType= %s :", cdVar, this.b.name());
        }
    }

    @Override // com.google.android.libraries.navigation.internal.qv.d
    public final void g(s sVar) {
        try {
            g gVar = this.e;
            com.google.android.libraries.navigation.internal.dm.o oVar = sVar.c;
            if (oVar == null) {
                oVar = com.google.android.libraries.navigation.internal.dm.o.a;
            }
            if (gVar.d(oVar) == null) {
                return;
            }
            sVar = i(sVar, this.i);
            bb bbVar = (bb) sVar.aH(5, null);
            bbVar.x(sVar);
            r rVar = (r) bbVar;
            long epochMilli = this.i.f().toEpochMilli();
            if (!rVar.b.H()) {
                rVar.v();
            }
            s sVar2 = (s) rVar.b;
            sVar2.b |= 1024;
            sVar2.m = epochMilli;
            s sVar3 = (s) rVar.t();
            try {
                g gVar2 = this.e;
                try {
                    try {
                        NativeSqliteDiskCacheImpl.nativeSqliteDiskCacheUpdateTileMetadata(((NativeSqliteDiskCacheImpl) gVar2.c).b, sVar3.m());
                        return;
                    } catch (com.google.android.apps.gmm.jni.util.c e) {
                        throw new d(e);
                    }
                } catch (d e2) {
                    gVar2.j(e2);
                    throw e2;
                }
            } catch (IOException unused) {
                sVar = sVar3;
            }
        } catch (IOException unused2) {
        }
        com.google.android.libraries.navigation.internal.dm.o oVar2 = sVar.c;
        if (oVar2 == null) {
            oVar2 = com.google.android.libraries.navigation.internal.dm.o.a;
        }
        com.google.android.libraries.navigation.internal.aeg.d dVar = oVar2.f;
        if (dVar == null) {
            dVar = com.google.android.libraries.navigation.internal.aeg.d.a;
        }
        ((com.google.android.libraries.navigation.internal.zb.h) com.google.android.libraries.navigation.internal.zb.j.b.F(1270)).z("updateTileMetadata failed: coords= %d,%d,%d , paintRequestTemplateTileType= %s :", Integer.valueOf(dVar.c), Integer.valueOf(dVar.d), Integer.valueOf(dVar.e), this.b.name());
    }

    @Override // com.google.android.libraries.navigation.internal.qv.g
    public final boolean h(cd cdVar) {
        try {
            g gVar = this.e;
            try {
                try {
                    return NativeSqliteDiskCacheImpl.nativeSqliteDiskCacheHasTile(((NativeSqliteDiskCacheImpl) gVar.c).b, ch.a(this.c, this.d, cdVar, this.k.a(), Locale.getDefault().toLanguageTag()).m());
                } catch (com.google.android.apps.gmm.jni.util.c e) {
                    throw new d(e);
                }
            } catch (d e2) {
                gVar.j(e2);
                throw e2;
            }
        } catch (IOException unused) {
            ((com.google.android.libraries.navigation.internal.zb.h) com.google.android.libraries.navigation.internal.zb.j.b.F(1273)).x("Failed to query tile: coords= %s , paintRequestTemplateTileType= %s :", cdVar, this.b.name());
            return false;
        }
    }

    @Override // com.google.android.libraries.navigation.internal.qv.g
    public final boolean j(cc ccVar) {
        return ccVar instanceof t;
    }

    @Override // com.google.android.libraries.navigation.internal.qv.d
    public final boolean k() {
        return true;
    }

    @Override // com.google.android.libraries.navigation.internal.qv.d
    public final boolean l() {
        return true;
    }

    @Override // com.google.android.libraries.navigation.internal.qv.d
    public final byte[] m(cd cdVar) {
        q qVarC;
        try {
            qVarC = this.e.c(ch.a(this.c, this.d, cdVar, this.k.a(), this.g.b().toLanguageTag()));
        } catch (IOException unused) {
            ((com.google.android.libraries.navigation.internal.zb.h) com.google.android.libraries.navigation.internal.zb.j.b.F(1274)).x("getTileData failed: coords= %s , paintRequestTemplateTileType= %s :", cdVar, this.b.name());
            qVarC = null;
        }
        if (qVarC != null) {
            s sVar = qVarC.b;
            if (sVar == null) {
                sVar = s.a;
            }
            if (!s(cdVar, sVar)) {
                return qVarC.c.B();
            }
        }
        return null;
    }

    @Override // com.google.android.libraries.navigation.internal.qv.d
    public final void n(cd cdVar, String str, String str2, int i, int i2) {
        try {
            g gVar = this.e;
            r rVarQ = q(cdVar, i, str, str2, i2);
            if (!rVarQ.b.H()) {
                rVarQ.v();
            }
            s sVar = (s) rVarQ.b;
            s sVar2 = s.a;
            sVar.b |= 16;
            sVar.g = -1;
            if (!rVarQ.b.H()) {
                rVarQ.v();
            }
            s sVar3 = (s) rVarQ.b;
            sVar3.b |= 8;
            sVar3.f = -1;
            gVar.h((s) rVarQ.t());
        } catch (IOException unused) {
            ((com.google.android.libraries.navigation.internal.zb.h) com.google.android.libraries.navigation.internal.zb.j.b.F(1269)).y("Empty Tile insert failed: coords= %s paintMajorEpoch= %d paintRequestTemplateTileType= %s :", cdVar, Integer.valueOf(i), this.b.name());
        }
    }

    @Override // com.google.android.libraries.navigation.internal.qv.d
    public final void o(s sVar, byte[] bArr, com.google.android.libraries.navigation.internal.mj.a aVar) {
        if (sVar.o) {
            ((com.google.android.libraries.navigation.internal.zb.h) a.d(com.google.android.libraries.navigation.internal.nl.a.a).F((char) 1267)).p("Attempting to insert an offroad tile into the SqliteDiskTileCache should not happen.");
            return;
        }
        bb bbVar = (bb) sVar.aH(5, null);
        bbVar.x(sVar);
        r rVar = (r) bbVar;
        long epochMilli = aVar.f().toEpochMilli();
        if (!rVar.b.H()) {
            rVar.v();
        }
        s sVar2 = (s) rVar.b;
        sVar2.b |= 1024;
        sVar2.m = epochMilli;
        s sVarI = (s) rVar.t();
        try {
            sVarI = i(sVarI, aVar);
            g gVar = this.e;
            try {
                try {
                    NativeSqliteDiskCacheImpl.nativeSqliteDiskCacheInsertOrUpdateTile(((NativeSqliteDiskCacheImpl) gVar.c).b, sVarI.m(), bArr);
                    gVar.k();
                } catch (com.google.android.apps.gmm.jni.util.c e) {
                    throw new d(e);
                }
            } catch (d e2) {
                gVar.j(e2);
                throw e2;
            }
        } catch (IOException unused) {
            com.google.android.libraries.navigation.internal.zb.h hVar = (com.google.android.libraries.navigation.internal.zb.h) com.google.android.libraries.navigation.internal.zb.j.b.F(1266);
            com.google.android.libraries.navigation.internal.dm.o oVar = sVarI.c;
            if (oVar == null) {
                oVar = com.google.android.libraries.navigation.internal.dm.o.a;
            }
            com.google.android.libraries.navigation.internal.aeg.d dVar = oVar.f;
            if (dVar == null) {
                dVar = com.google.android.libraries.navigation.internal.aeg.d.a;
            }
            hVar.x("Tile insert failed: coords= %s , tileType= %s :", dVar, this.b.name());
        }
    }

    @Override // com.google.android.libraries.navigation.internal.qv.g
    public final void t() {
    }
}
