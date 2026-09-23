package com.google.android.libraries.navigation.internal.hm;

import androidx.tracing.Trace;
import com.google.android.libraries.navigation.internal.ace.bj;
import com.google.android.libraries.navigation.internal.ace.bk;
import com.google.android.libraries.navigation.internal.ael.cz;
import com.google.android.libraries.navigation.internal.afl.cd;
import com.google.android.libraries.navigation.internal.afl.fs;
import com.google.android.libraries.navigation.internal.afl.gy;
import com.google.android.libraries.navigation.internal.afl.ha;
import com.google.android.libraries.navigation.internal.afl.hb;
import com.google.android.libraries.navigation.internal.yz.fy;
import com.google.android.libraries.navigation.internal.yz.nn;
import java.util.ArrayList;
import java.util.EnumMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class e extends b implements com.google.android.libraries.navigation.internal.hp.f {
    private final com.google.android.libraries.navigation.internal.afo.a b;
    private final fy f;
    private com.google.android.libraries.navigation.internal.hn.p g;
    private com.google.android.libraries.navigation.internal.hn.j h;
    private String j;
    private int k;
    private com.google.android.libraries.navigation.internal.ael.x c = com.google.android.libraries.navigation.internal.ael.x.b;
    private long d = 0;
    private final Map e = new EnumMap(ha.class);
    private volatile a i = new a(this);
    public final com.google.android.libraries.navigation.internal.hp.g a = new com.google.android.libraries.navigation.internal.hp.g(this);

    public e(String str, com.google.android.libraries.navigation.internal.ael.x xVar, long j, int i, List list, com.google.android.libraries.navigation.internal.afo.a aVar, Set set) {
        this.b = aVar;
        this.f = fy.o(set);
        this.k = i;
        ai(str, xVar, j, i, list);
    }

    private final synchronized com.google.android.libraries.navigation.internal.hn.p aj() {
        if (this.g == null) {
            this.g = new com.google.android.libraries.navigation.internal.hn.p(com.google.android.libraries.navigation.internal.fz.b.d(this));
        }
        return this.g;
    }

    private static boolean ak(boolean z, boolean z2) {
        return z2 && z;
    }

    @Override // com.google.android.libraries.navigation.internal.fz.d
    public final synchronized hb L(ha haVar) {
        return (hb) this.e.get(haVar);
    }

    @Override // com.google.android.libraries.navigation.internal.fz.d
    public final synchronized Map X() {
        return new EnumMap(this.e);
    }

    @Override // com.google.android.libraries.navigation.internal.hn.e
    public final synchronized long Y() {
        return this.d;
    }

    @Override // com.google.android.libraries.navigation.internal.hp.f
    public final synchronized com.google.android.libraries.navigation.internal.hp.d Z() {
        com.google.android.libraries.navigation.internal.hp.d dVarA;
        com.google.android.libraries.navigation.internal.nw.d dVarB = com.google.android.libraries.navigation.internal.nw.e.b("ClientParametersImpl.getAttribution");
        try {
            dVarA = this.i.a();
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
        return dVarA;
    }

    @Override // com.google.android.libraries.navigation.internal.fz.d
    public final synchronized com.google.android.libraries.navigation.internal.fz.c a(com.google.android.libraries.navigation.internal.yx.aa aaVar) {
        String strAc;
        cz czVar;
        strAc = ac();
        czVar = (cz) aaVar.ak(this);
        if (strAc == null) {
            strAc = "unknown@";
        }
        return new com.google.android.libraries.navigation.internal.fz.a(strAc, czVar);
    }

    @Override // com.google.android.libraries.navigation.internal.hp.f
    public final com.google.android.libraries.navigation.internal.hp.e aa() {
        return (com.google.android.libraries.navigation.internal.hp.e) this.b.a();
    }

    @Override // com.google.android.libraries.navigation.internal.hn.e
    public final synchronized com.google.android.libraries.navigation.internal.ael.x ab() {
        return this.c;
    }

    @Override // com.google.android.libraries.navigation.internal.hn.e
    public final synchronized String ac() {
        return this.j;
    }

    @Override // com.google.android.libraries.navigation.internal.hn.e
    public final synchronized List ad() {
        ArrayList arrayList;
        com.google.android.libraries.navigation.internal.nw.d dVarB = com.google.android.libraries.navigation.internal.nw.e.b("ClientParametersImpl.getParameterGroupsForRequest");
        try {
            arrayList = new ArrayList(this.e.size());
            for (hb hbVar : this.e.values()) {
                gy gyVar = (gy) hb.a.q();
                if ((hbVar.b & 1) != 0) {
                    ha haVarB = ha.b(hbVar.e);
                    if (haVarB == null) {
                        haVarB = ha.UNKNOWN_TYPE;
                    }
                    if (!gyVar.b.H()) {
                        gyVar.v();
                    }
                    hb hbVar2 = (hb) gyVar.b;
                    hbVar2.e = haVarB.eg;
                    hbVar2.b |= 1;
                }
                if ((hbVar.b & 2) != 0) {
                    long j = hbVar.f;
                    if (!gyVar.b.H()) {
                        gyVar.v();
                    }
                    hb hbVar3 = (hb) gyVar.b;
                    hbVar3.b |= 2;
                    hbVar3.f = j;
                }
                arrayList.add((hb) gyVar.t());
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
        return arrayList;
    }

    public final synchronized com.google.android.libraries.navigation.internal.afl.am ae() {
        com.google.android.libraries.navigation.internal.afl.al alVar;
        alVar = (com.google.android.libraries.navigation.internal.afl.al) com.google.android.libraries.navigation.internal.afl.am.a.q();
        alVar.c(this.e.values());
        long j = this.d;
        if (!alVar.b.H()) {
            alVar.v();
        }
        com.google.android.libraries.navigation.internal.afl.am amVar = (com.google.android.libraries.navigation.internal.afl.am) alVar.b;
        amVar.b |= 4;
        amVar.e = j;
        return (com.google.android.libraries.navigation.internal.afl.am) alVar.t();
    }

    @Override // com.google.android.libraries.navigation.internal.hn.e
    public final synchronized int af() {
        return this.k;
    }

    final synchronized boolean ag(String str) {
        if (com.google.android.libraries.navigation.internal.yx.am.a(this.j, str)) {
            return false;
        }
        this.j = str;
        return true;
    }

    @Override // com.google.android.libraries.navigation.internal.hn.e
    public final com.google.android.libraries.navigation.internal.hp.g ah() {
        return this.a;
    }

    /* JADX WARN: Code duplicated, block: B:194:0x02e8 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:198:0x02da A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:216:? A[Catch: all -> 0x02e4, SYNTHETIC, TRY_LEAVE, TryCatch #2 {all -> 0x02e4, blocks: (B:5:0x000b, B:12:0x0032, B:132:0x0261, B:134:0x026c, B:146:0x02ba, B:156:0x02cb, B:155:0x02c8, B:157:0x02cc, B:130:0x025d, B:170:0x02e3, B:169:0x02e0, B:151:0x02c2, B:7:0x0019, B:9:0x0028, B:14:0x0038, B:16:0x0040, B:18:0x0045, B:19:0x0049, B:21:0x004f, B:37:0x0087, B:117:0x0244, B:128:0x025a, B:127:0x0257, B:165:0x02da, B:135:0x0272, B:136:0x0278, B:138:0x027e, B:140:0x028c, B:142:0x029c, B:143:0x029f), top: B:186:0x000b, outer: #1, inners: #4, #5, #9, #10 }] */
    /* JADX WARN: Code duplicated, block: B:218:? A[Catch: all -> 0x02f2, SYNTHETIC, TryCatch #1 {, blocks: (B:4:0x0005, B:159:0x02d1, B:179:0x02f1, B:178:0x02ee, B:5:0x000b, B:12:0x0032, B:132:0x0261, B:134:0x026c, B:146:0x02ba, B:156:0x02cb, B:155:0x02c8, B:157:0x02cc, B:130:0x025d, B:170:0x02e3, B:169:0x02e0, B:174:0x02e8), top: B:185:0x0005, inners: #2, #7 }] */
    final synchronized boolean ai(String str, com.google.android.libraries.navigation.internal.ael.x xVar, long j, int i, List list) {
        boolean z;
        boolean z2;
        ha haVarB;
        boolean z3;
        hb hbVar;
        boolean zAg;
        com.google.android.libraries.navigation.internal.nw.d dVarB = com.google.android.libraries.navigation.internal.nw.e.b("ClientParametersImpl.update");
        try {
            boolean zIsEmpty = this.e.isEmpty();
            com.google.android.libraries.navigation.internal.nw.d dVarB2 = com.google.android.libraries.navigation.internal.nw.e.b("ClientParametersImpl.updateParametersInternal");
            try {
                this.d = j;
                if (com.google.android.libraries.navigation.internal.afl.am.a.c.equals(list) && com.google.android.libraries.navigation.internal.yx.am.a(this.c, xVar)) {
                    if (dVarB2 != null) {
                        Trace.endSection();
                    }
                    z2 = false;
                } else {
                    if (com.google.android.libraries.navigation.internal.yx.am.a(this.c, xVar)) {
                        z = false;
                    } else {
                        this.c = xVar;
                        z = true;
                    }
                    Iterator it2 = list.iterator();
                    while (it2.hasNext()) {
                        hb hbVar2 = (hb) it2.next();
                        com.google.android.libraries.navigation.internal.nw.d dVarB3 = com.google.android.libraries.navigation.internal.nw.e.b("ClientParametersImpl.updateParameterGroup");
                        try {
                            if ((hbVar2.b & 1) != 0) {
                                haVarB = ha.b(hbVar2.e);
                                if (haVarB == null) {
                                    haVarB = ha.UNKNOWN_TYPE;
                                }
                            } else {
                                haVarB = null;
                            }
                            if (this.f.contains(haVarB) && !((hbVar2.b & 2) == 0 && this.e.containsKey(haVarB))) {
                                ha haVarB2 = ha.b(hbVar2.e);
                                if (haVarB2 == null) {
                                    haVarB2 = ha.UNKNOWN_TYPE;
                                }
                                if (haVarB2 == ha.ENABLE_FEATURES && (hbVar = (hb) this.e.get(ha.ENABLE_FEATURES)) != null) {
                                    com.google.android.libraries.navigation.internal.ael.bb bbVar = (com.google.android.libraries.navigation.internal.ael.bb) hbVar2.aH(5, null);
                                    bbVar.x(hbVar2);
                                    gy gyVar = (gy) bbVar;
                                    bk bkVar = hbVar.c == 4 ? (bk) hbVar.d : bk.a;
                                    bk bkVar2 = hbVar2.c == 4 ? (bk) hbVar2.d : bk.a;
                                    com.google.android.libraries.navigation.internal.nw.d dVarB4 = com.google.android.libraries.navigation.internal.nw.e.b("ClientParametersImpl.mergeEnableFeatureParameters");
                                    try {
                                        com.google.android.libraries.navigation.internal.ael.bb bbVar2 = (com.google.android.libraries.navigation.internal.ael.bb) bkVar2.aH(5, null);
                                        bbVar2.x(bkVar2);
                                        bj bjVar = (bj) bbVar2;
                                        boolean zAk = ak(bkVar.d, bkVar2.d);
                                        if (!bjVar.b.H()) {
                                            bjVar.v();
                                        }
                                        bk bkVar3 = (bk) bjVar.b;
                                        bkVar3.b |= 1;
                                        bkVar3.d = zAk;
                                        boolean zAk2 = ak(bkVar.e, bkVar2.e);
                                        if (!bjVar.b.H()) {
                                            bjVar.v();
                                        }
                                        bk bkVar4 = (bk) bjVar.b;
                                        bkVar4.b |= 128;
                                        bkVar4.e = zAk2;
                                        boolean zAk3 = ak(bkVar.f, bkVar2.f);
                                        if (!bjVar.b.H()) {
                                            bjVar.v();
                                        }
                                        bk bkVar5 = (bk) bjVar.b;
                                        bkVar5.b |= 256;
                                        bkVar5.f = zAk3;
                                        boolean zAk4 = ak(bkVar.g, bkVar2.g);
                                        if (!bjVar.b.H()) {
                                            bjVar.v();
                                        }
                                        bk bkVar6 = (bk) bjVar.b;
                                        bkVar6.b |= 131072;
                                        bkVar6.g = zAk4;
                                        boolean zAk5 = ak(bkVar.i, bkVar2.i);
                                        if (!bjVar.b.H()) {
                                            bjVar.v();
                                        }
                                        bk bkVar7 = (bk) bjVar.b;
                                        bkVar7.b |= 4194304;
                                        bkVar7.i = zAk5;
                                        boolean zAk6 = ak(bkVar.h, bkVar2.h);
                                        if (!bjVar.b.H()) {
                                            bjVar.v();
                                        }
                                        bk bkVar8 = (bk) bjVar.b;
                                        bkVar8.b |= 262144;
                                        bkVar8.h = zAk6;
                                        boolean zAk7 = ak(bkVar.j, bkVar2.j);
                                        if (!bjVar.b.H()) {
                                            bjVar.v();
                                        }
                                        bk bkVar9 = (bk) bjVar.b;
                                        bkVar9.b |= 8388608;
                                        bkVar9.j = zAk7;
                                        bk bkVar10 = (bk) bjVar.t();
                                        if (dVarB4 != null) {
                                            Trace.endSection();
                                        }
                                        if (!gyVar.b.H()) {
                                            gyVar.v();
                                        }
                                        hb hbVar3 = (hb) gyVar.b;
                                        bkVar10.getClass();
                                        hbVar3.d = bkVar10;
                                        hbVar3.c = 4;
                                        hbVar2 = (hb) gyVar.t();
                                    } catch (Throwable th) {
                                        if (dVarB4 == null) {
                                            throw th;
                                        }
                                        try {
                                            Trace.endSection();
                                            throw th;
                                        } catch (Throwable th2) {
                                            th.addSuppressed(th2);
                                            throw th;
                                        }
                                        if (dVarB2 != null) {
                                            throw th;
                                        }
                                        try {
                                            Trace.endSection();
                                            throw th;
                                        } catch (Throwable th3) {
                                            th.addSuppressed(th3);
                                            throw th;
                                        }
                                    }
                                }
                                this.e.put(haVarB2, hbVar2);
                                int iOrdinal = haVarB2.ordinal();
                                if (iOrdinal != 1) {
                                    if (iOrdinal != 23) {
                                        if (iOrdinal == 149) {
                                            this.i.b(hbVar2.f);
                                        }
                                    } else if (this.h != null) {
                                        this.h = new com.google.android.libraries.navigation.internal.hn.j(hbVar2.c == 23 ? (cd) hbVar2.d : cd.a);
                                    }
                                } else if (this.g != null) {
                                    this.g = new com.google.android.libraries.navigation.internal.hn.p(hbVar2.c == 3 ? (fs) hbVar2.d : fs.a);
                                }
                                if (dVarB3 != null) {
                                    Trace.endSection();
                                }
                                z3 = true;
                            } else {
                                if (dVarB3 != null) {
                                    Trace.endSection();
                                }
                                it2 = it2;
                                z3 = false;
                            }
                            z |= z3;
                            it2 = it2;
                        } catch (Throwable th4) {
                            if (dVarB3 == null) {
                                throw th4;
                            }
                            try {
                                Trace.endSection();
                                throw th4;
                            } catch (Throwable th5) {
                                th4.addSuppressed(th5);
                                throw th4;
                            }
                            if (dVarB != null) {
                                throw th;
                            }
                            try {
                                Trace.endSection();
                                throw th;
                            } catch (Throwable th6) {
                                th.addSuppressed(th6);
                                throw th;
                            }
                        }
                    }
                    if (dVarB2 != null) {
                        Trace.endSection();
                    }
                    z2 = z;
                }
                zAg = ag(str) | z2;
                this.k = i;
                if (zIsEmpty) {
                    com.google.android.libraries.navigation.internal.nw.d dVarB5 = com.google.android.libraries.navigation.internal.nw.e.b("ClientParametersImpl.initializeMissingDefaults");
                    try {
                        nn nnVarListIterator = this.f.listIterator();
                        while (nnVarListIterator.hasNext()) {
                            ha haVar = (ha) nnVarListIterator.next();
                            if (!this.e.containsKey(haVar)) {
                                gy gyVar2 = (gy) hb.a.q();
                                if (!gyVar2.b.H()) {
                                    gyVar2.v();
                                }
                                hb hbVar4 = (hb) gyVar2.b;
                                hbVar4.e = haVar.eg;
                                hbVar4.b |= 1;
                                this.e.put(haVar, (hb) gyVar2.t());
                            }
                        }
                        if (dVarB5 != null) {
                            Trace.endSection();
                        }
                    } catch (Throwable th7) {
                        if (dVarB5 == null) {
                            throw th7;
                        }
                        try {
                            Trace.endSection();
                            throw th7;
                        } catch (Throwable th8) {
                            th7.addSuppressed(th8);
                            throw th7;
                        }
                    }
                }
                notifyAll();
                if (dVarB != null) {
                    Trace.endSection();
                }
            } catch (Throwable th9) {
                if (dVarB2 != null) {
                    throw th9;
                }
                Trace.endSection();
                throw th9;
            }
        } catch (Throwable th10) {
            if (dVarB != null) {
                throw th10;
            }
            Trace.endSection();
            throw th10;
        }
        return zAg;
    }

    @Override // com.google.android.libraries.navigation.internal.fz.d
    public final com.google.android.libraries.navigation.internal.hn.p b() {
        com.google.android.libraries.navigation.internal.nw.d dVarB = com.google.android.libraries.navigation.internal.nw.e.b("ClientParametersImpl.getNavigationParameters");
        try {
            com.google.android.libraries.navigation.internal.hn.p pVarAj = aj();
            if (dVarB != null) {
                Trace.endSection();
            }
            return pVarAj;
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
