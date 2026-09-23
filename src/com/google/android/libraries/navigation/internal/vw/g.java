package com.google.android.libraries.navigation.internal.vw;

import com.google.android.libraries.navigation.internal.bp.ck;
import com.google.android.libraries.navigation.internal.db.r;
import com.google.android.libraries.navigation.internal.oe.x;
import com.google.android.libraries.navigation.internal.xe.fb;
import com.google.android.libraries.navigation.internal.xe.fd;
import com.google.android.libraries.navigation.internal.xe.fe;
import com.google.android.libraries.navigation.internal.yx.am;
import java.util.Iterator;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class g implements com.google.android.libraries.navigation.internal.rw.d {
    final /* synthetic */ j a;

    public g(j jVar) {
        this.a = jVar;
    }

    /* JADX WARN: Code duplicated, block: B:63:0x00e7 A[Catch: all -> 0x013b, TryCatch #0 {, blocks: (B:4:0x0003, B:6:0x0009, B:9:0x0013, B:12:0x0020, B:14:0x002c, B:16:0x0034, B:18:0x0036, B:20:0x0047, B:22:0x004d, B:24:0x0057, B:25:0x005c, B:27:0x0065, B:32:0x0073, B:34:0x007d, B:38:0x008d, B:40:0x0091, B:45:0x00a1, B:46:0x00a7, B:48:0x00ad, B:50:0x00b5, B:52:0x00c7, B:55:0x00cd, B:57:0x00d1, B:44:0x009c, B:58:0x00db, B:61:0x00e1, B:69:0x0103, B:71:0x0109, B:72:0x0110, B:74:0x0114, B:76:0x011a, B:78:0x011e, B:81:0x0133, B:63:0x00e7, B:65:0x00ed, B:66:0x00f3, B:68:0x00f9, B:82:0x0137, B:84:0x0139), top: B:89:0x0003 }] */
    /* JADX WARN: Code duplicated, block: B:65:0x00ed A[Catch: all -> 0x013b, TryCatch #0 {, blocks: (B:4:0x0003, B:6:0x0009, B:9:0x0013, B:12:0x0020, B:14:0x002c, B:16:0x0034, B:18:0x0036, B:20:0x0047, B:22:0x004d, B:24:0x0057, B:25:0x005c, B:27:0x0065, B:32:0x0073, B:34:0x007d, B:38:0x008d, B:40:0x0091, B:45:0x00a1, B:46:0x00a7, B:48:0x00ad, B:50:0x00b5, B:52:0x00c7, B:55:0x00cd, B:57:0x00d1, B:44:0x009c, B:58:0x00db, B:61:0x00e1, B:69:0x0103, B:71:0x0109, B:72:0x0110, B:74:0x0114, B:76:0x011a, B:78:0x011e, B:81:0x0133, B:63:0x00e7, B:65:0x00ed, B:66:0x00f3, B:68:0x00f9, B:82:0x0137, B:84:0x0139), top: B:89:0x0003 }] */
    /* JADX WARN: Code duplicated, block: B:68:0x00f9 A[Catch: all -> 0x013b, LOOP:1: B:66:0x00f3->B:68:0x00f9, LOOP_END, TryCatch #0 {, blocks: (B:4:0x0003, B:6:0x0009, B:9:0x0013, B:12:0x0020, B:14:0x002c, B:16:0x0034, B:18:0x0036, B:20:0x0047, B:22:0x004d, B:24:0x0057, B:25:0x005c, B:27:0x0065, B:32:0x0073, B:34:0x007d, B:38:0x008d, B:40:0x0091, B:45:0x00a1, B:46:0x00a7, B:48:0x00ad, B:50:0x00b5, B:52:0x00c7, B:55:0x00cd, B:57:0x00d1, B:44:0x009c, B:58:0x00db, B:61:0x00e1, B:69:0x0103, B:71:0x0109, B:72:0x0110, B:74:0x0114, B:76:0x011a, B:78:0x011e, B:81:0x0133, B:63:0x00e7, B:65:0x00ed, B:66:0x00f3, B:68:0x00f9, B:82:0x0137, B:84:0x0139), top: B:89:0x0003 }] */
    @Override // com.google.android.libraries.navigation.internal.rw.d
    public final void a(com.google.android.libraries.navigation.internal.rw.b bVar) {
        Iterator it2;
        j jVar;
        fb fbVar;
        boolean z;
        synchronized (this.a) {
            j jVar2 = this.a;
            if (jVar2.g && jVar2.k.d()) {
                com.google.android.libraries.navigation.internal.tj.j jVar3 = ((com.google.android.libraries.navigation.internal.rw.i) bVar).d;
                if (((com.google.android.libraries.navigation.internal.rw.i) bVar).e == null && jVar3 == null) {
                    this.a.j();
                    this.a.k();
                }
                if (jVar3 != null) {
                    if (this.a.u(jVar3)) {
                        return;
                    }
                    j jVar4 = this.a;
                    jVar4.i = true;
                    r rVarB = jVar4.q.b();
                    o oVar = this.a.j;
                    x xVarN = rVarB != null ? rVarB.n() : null;
                    ck ckVarA = this.a.k.a();
                    if (xVarN != null) {
                        oVar.d.add(xVarN);
                    }
                    com.google.android.libraries.navigation.internal.se.b bVarC = jVar3.c();
                    com.google.android.libraries.navigation.internal.se.b bVar2 = oVar.e;
                    boolean z2 = bVar2 == null || !am.a(bVar2.b, bVarC.b);
                    oVar.e = bVarC;
                    if (!oVar.f.isEmpty()) {
                        int iC = oVar.e.c();
                        int i = oVar.e.k;
                        if (iC != -1 && i != -1) {
                            if (oVar.a && ckVarA.equals(oVar.b)) {
                                z = false;
                            } else {
                                oVar.a = true;
                                oVar.b = ckVarA;
                                z = true;
                            }
                            for (n nVar : oVar.f) {
                                if (!z) {
                                    int iAbs = Math.abs(iC - nVar.c);
                                    int iAbs2 = Math.abs(i - nVar.d);
                                    if ((iAbs <= 0 || iAbs < nVar.a) && (iAbs2 <= 0 || iAbs2 < nVar.b)) {
                                    }
                                }
                                nVar.c = iC;
                                nVar.d = i;
                                nVar.e.a();
                            }
                        }
                    }
                    fe feVar = oVar.g;
                    if (feVar != null) {
                        if (z2) {
                            feVar.a();
                        } else if (jVar3.f()) {
                            it2 = oVar.c.iterator();
                            while (it2.hasNext()) {
                                ((fd) it2.next()).a();
                            }
                        }
                    } else if (!z2) {
                        if (jVar3.f()) {
                            it2 = oVar.c.iterator();
                            while (it2.hasNext()) {
                                ((fd) it2.next()).a();
                            }
                        }
                    }
                    com.google.android.libraries.navigation.internal.vp.b bVar3 = this.a.l;
                    if (bVar3 != null) {
                        bVar3.a(jVar3.c());
                    }
                    if (jVar3.h && (fbVar = (jVar = this.a).s) != null && !jVar.h) {
                        jVar.h = true;
                        fbVar.a(jVar.k.a(), true ^ (this.a.k.c.size() > 1));
                    }
                }
            }
        }
    }
}
