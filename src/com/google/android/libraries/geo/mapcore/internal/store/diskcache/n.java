package com.google.android.libraries.geo.mapcore.internal.store.diskcache;

import androidx.exifinterface.media.ExifInterface;
import androidx.tracing.Trace;
import com.google.android.libraries.geo.mapcore.internal.model.an;
import com.google.android.libraries.geo.mapcore.internal.model.bd;
import com.google.android.libraries.geo.mapcore.internal.model.bv;
import com.google.android.libraries.navigation.internal.afl.pw;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes2.dex */
public class n implements com.google.android.libraries.navigation.internal.qv.c {
    public static final com.google.android.libraries.navigation.internal.zb.j a = com.google.android.libraries.navigation.internal.zb.j.e("com.google.android.libraries.geo.mapcore.internal.store.diskcache.n");
    public static final long b = TimeUnit.DAYS.toMillis(45);
    public final g c;
    public final com.google.android.libraries.navigation.internal.mj.a d;
    private final m e = new m();
    private final pw f;

    public n(g gVar, com.google.android.libraries.navigation.internal.mj.a aVar, pw pwVar) {
        this.c = gVar;
        this.d = aVar;
        this.f = pwVar;
    }

    @Override // com.google.android.libraries.navigation.internal.qv.c
    public final bd a(String str, boolean z) throws IOException {
        com.google.android.libraries.navigation.internal.nw.d dVarB = com.google.android.libraries.navigation.internal.nw.e.b("SqliteDiskStyleTableCache.getCommonStyleData");
        try {
            com.google.android.libraries.navigation.internal.dm.h hVar = (com.google.android.libraries.navigation.internal.dm.h) com.google.android.libraries.navigation.internal.dm.i.a.q();
            if (!hVar.b.H()) {
                hVar.v();
            }
            com.google.android.libraries.navigation.internal.dm.i iVar = (com.google.android.libraries.navigation.internal.dm.i) hVar.b;
            iVar.b |= 2;
            iVar.d = str;
            int i = com.google.android.libraries.navigation.internal.dm.m.d;
            if (!hVar.b.H()) {
                hVar.v();
            }
            com.google.android.libraries.navigation.internal.dm.i iVar2 = (com.google.android.libraries.navigation.internal.dm.i) hVar.b;
            bd bdVarA = null;
            if (i == 0) {
                throw null;
            }
            iVar2.c = i;
            iVar2.b |= 1;
            com.google.android.libraries.navigation.internal.dm.i iVar3 = (com.google.android.libraries.navigation.internal.dm.i) hVar.t();
            try {
                com.google.android.libraries.navigation.internal.dm.g gVarB = this.c.b(iVar3);
                if (gVarB != null) {
                    try {
                        byte[] bArrB = gVarB.c.B();
                        com.google.android.libraries.navigation.internal.dm.k kVar = gVarB.b;
                        if (kVar == null) {
                            kVar = com.google.android.libraries.navigation.internal.dm.k.a;
                        }
                        long j = kVar.f;
                        if (j != 0) {
                            bdVarA = bd.a(com.google.android.libraries.navigation.internal.rq.k.b(bArrB, bArrB.length, (int) j));
                        } else {
                            try {
                                this.c.e(iVar3);
                            } catch (d unused) {
                                ((com.google.android.libraries.navigation.internal.zb.h) com.google.android.libraries.navigation.internal.zb.j.b.F(1235)).s("Failed to delete resource %s :", str);
                            }
                        }
                    } catch (IOException unused2) {
                        ((com.google.android.libraries.navigation.internal.zb.h) com.google.android.libraries.navigation.internal.zb.j.b.F(1236)).s("Failed to unpack common style data %s", str);
                    }
                }
            } catch (IOException unused3) {
                ((com.google.android.libraries.navigation.internal.zb.h) com.google.android.libraries.navigation.internal.zb.j.b.F(1237)).s("Failed to get common style data %s", str);
            }
            if (dVarB != null) {
                Trace.endSection();
            }
            return bdVarA;
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
    }

    @Override // com.google.android.libraries.navigation.internal.qv.c
    public final bv b(String str) throws IOException {
        com.google.android.libraries.navigation.internal.adi.c cVar;
        com.google.android.libraries.navigation.internal.nw.d dVarB = com.google.android.libraries.navigation.internal.nw.e.b("SqliteDiskStyleTableCache.getStyleTable");
        try {
            com.google.android.libraries.navigation.internal.dm.h hVar = (com.google.android.libraries.navigation.internal.dm.h) com.google.android.libraries.navigation.internal.dm.i.a.q();
            if (!hVar.b.H()) {
                hVar.v();
            }
            com.google.android.libraries.navigation.internal.dm.i iVar = (com.google.android.libraries.navigation.internal.dm.i) hVar.b;
            iVar.b |= 2;
            iVar.d = str;
            int i = com.google.android.libraries.navigation.internal.dm.m.b;
            if (!hVar.b.H()) {
                hVar.v();
            }
            com.google.android.libraries.navigation.internal.dm.i iVar2 = (com.google.android.libraries.navigation.internal.dm.i) hVar.b;
            an anVarI = null;
            if (i == 0) {
                throw null;
            }
            iVar2.c = i;
            iVar2.b |= 1;
            com.google.android.libraries.navigation.internal.dm.i iVar3 = (com.google.android.libraries.navigation.internal.dm.i) hVar.t();
            try {
                com.google.android.libraries.navigation.internal.dm.g gVarB = this.c.b(iVar3);
                if (gVarB != null) {
                    com.google.android.libraries.navigation.internal.dm.k kVar = gVarB.b;
                    if (kVar == null) {
                        kVar = com.google.android.libraries.navigation.internal.dm.k.a;
                    }
                    if (kVar.d.equals("1")) {
                        cVar = com.google.android.libraries.navigation.internal.adi.c.MULTIZOOM_STYLE_TABLE;
                    } else {
                        com.google.android.libraries.navigation.internal.dm.k kVar2 = gVarB.b;
                        if (kVar2 == null) {
                            kVar2 = com.google.android.libraries.navigation.internal.dm.k.a;
                        }
                        if (kVar2.d.equals(ExifInterface.GPS_MEASUREMENT_2D)) {
                            cVar = com.google.android.libraries.navigation.internal.adi.c.COMPACT_MULTIZOOM_STYLE_TABLE;
                        } else {
                            com.google.android.libraries.navigation.internal.dm.k kVar3 = gVarB.b;
                            if (kVar3 == null) {
                                kVar3 = com.google.android.libraries.navigation.internal.dm.k.a;
                            }
                            if (kVar3.d.equals(ExifInterface.GPS_MEASUREMENT_3D)) {
                                cVar = com.google.android.libraries.navigation.internal.adi.c.COMPACT_MULTIZOOM_STYLE_TABLE_WITH_INLINING;
                            } else {
                                com.google.android.libraries.navigation.internal.dm.k kVar4 = gVarB.b;
                                if (kVar4 == null) {
                                    kVar4 = com.google.android.libraries.navigation.internal.dm.k.a;
                                }
                                String str2 = kVar4.d;
                                try {
                                    this.c.e(iVar3);
                                } catch (d unused) {
                                    ((com.google.android.libraries.navigation.internal.zb.h) com.google.android.libraries.navigation.internal.zb.j.b.F(1239)).s("Failed to delete resource %s :", str);
                                }
                            }
                        }
                    }
                    try {
                        byte[] bArrB = gVarB.c.B();
                        com.google.android.libraries.navigation.internal.dm.k kVar5 = gVarB.b;
                        if (kVar5 == null) {
                            kVar5 = com.google.android.libraries.navigation.internal.dm.k.a;
                        }
                        long j = kVar5.f;
                        if (j != 0) {
                            anVarI = bv.i(com.google.android.libraries.navigation.internal.rq.k.b(bArrB, bArrB.length, (int) j), cVar, this.f);
                        } else {
                            try {
                                this.c.e(iVar3);
                            } catch (d unused2) {
                                ((com.google.android.libraries.navigation.internal.zb.h) com.google.android.libraries.navigation.internal.zb.j.b.F(1241)).s("Failed to delete resource %s :", str);
                            }
                        }
                    } catch (IOException unused3) {
                        ((com.google.android.libraries.navigation.internal.zb.h) com.google.android.libraries.navigation.internal.zb.j.b.F(1242)).s("Failed to unpack style table table %s", str);
                    }
                }
            } catch (IOException unused4) {
                ((com.google.android.libraries.navigation.internal.zb.h) com.google.android.libraries.navigation.internal.zb.j.b.F(1243)).s("Failed to get style table %s", str);
            }
            if (dVarB != null) {
                Trace.endSection();
            }
            return anVarI;
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
    }
}
