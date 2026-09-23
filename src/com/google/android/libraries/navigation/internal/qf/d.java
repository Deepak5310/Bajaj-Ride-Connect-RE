package com.google.android.libraries.navigation.internal.qf;

import androidx.tracing.Trace;
import com.google.android.libraries.geo.mapcore.internal.model.cd;
import com.google.android.libraries.navigation.internal.fq.f;
import com.google.android.libraries.navigation.internal.fq.j;
import com.google.android.libraries.navigation.internal.fq.p;
import com.google.android.libraries.navigation.internal.qi.e;
import com.google.android.libraries.navigation.internal.yx.br;
import com.google.android.libraries.navigation.internal.yz.fy;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class d implements p {
    private final com.google.android.libraries.navigation.internal.mj.a e;
    private final br g;
    private final int h;
    private final Map f = new HashMap();
    public int a = 0;
    public int b = 0;
    public int c = 0;
    public final Runnable d = new Runnable() { // from class: com.google.android.libraries.navigation.internal.qf.a
        @Override // java.lang.Runnable
        public final void run() {
            this.a.g();
        }
    };

    static {
        fy.u("SAMSUNG-SGH-I747", "SGH-T999", "SCH-I535", "SPH-L710", "SGH-I337", "SCH-I545", new String[0]);
    }

    public d(f fVar, com.google.android.libraries.navigation.internal.mj.a aVar, br brVar) {
        new HashMap();
        this.e = aVar;
        this.g = brVar;
        this.h = 64;
        fVar.d(this, "GLTileCacheManager");
    }

    /* JADX WARN: Code duplicated, block: B:16:0x003a A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:17:0x003c  */
    /* JADX WARN: Code duplicated, block: B:8:0x0022  */
    private final b j(com.google.android.libraries.navigation.internal.qi.f fVar, cd cdVar, boolean z, long j) {
        b bVar;
        e eVar;
        c cVar = (c) this.f.get(fVar);
        if (cVar != null) {
            bVar = (b) cVar.f(cdVar);
            if (bVar != null) {
                eVar = bVar.a;
                if (eVar != null || eVar.A()) {
                    bVar.d = j;
                    cVar.c = j;
                    return bVar;
                }
                bVar.a.s();
                cVar.g(cdVar);
                return null;
            }
            if (z) {
                cVar.m(cdVar, new b(j));
                cVar.c = j;
            }
        } else if (z) {
            cVar = new c(this, this.h);
            this.f.put(fVar, cVar);
            z = true;
            bVar = (b) cVar.f(cdVar);
            if (bVar != null) {
                eVar = bVar.a;
                if (eVar != null) {
                }
                bVar.d = j;
                cVar.c = j;
                return bVar;
            }
            if (z) {
                cVar.m(cdVar, new b(j));
                cVar.c = j;
            }
        }
        return null;
    }

    private final synchronized void k() {
        int i = this.a;
        String[] strArr = com.google.android.libraries.navigation.internal.nw.e.a;
        Trace.setCounter("GLTileCacheManager - glDataSize (B)", i);
        Trace.setCounter("GLTileCacheManager - javaAndNativeDataSize (B)", this.b);
    }

    private static boolean l(j jVar, long j) {
        if (jVar == null) {
            return false;
        }
        if (j != 0 && ((b) jVar.b).d > j) {
            return false;
        }
        e eVar = ((b) jVar.b).a;
        return true;
    }

    @Override // com.google.android.libraries.navigation.internal.fq.p
    public final synchronized String a() {
        int iC;
        StringBuilder sb;
        Iterator it2 = this.f.entrySet().iterator();
        iC = 0;
        while (it2.hasNext()) {
            iC += ((c) ((Map.Entry) it2.next()).getValue()).c();
        }
        int i = this.b * 10;
        sb = new StringBuilder();
        int i2 = (i + 524288) / 1048576;
        sb.append(i2 / 10);
        sb.append(".");
        sb.append(i2 % 10);
        return "javaAndNativeDataSize: " + sb.toString() + " tileCount: " + iC;
    }

    public final synchronized com.google.android.libraries.navigation.internal.qi.d b(com.google.android.libraries.navigation.internal.qi.f fVar, cd cdVar, boolean z) {
        e eVarC;
        eVarC = c(fVar, cdVar, z, this.e.a());
        if (eVarC != null) {
            eVarC.s();
        }
        return eVarC;
    }

    public final synchronized e c(com.google.android.libraries.navigation.internal.qi.f fVar, cd cdVar, boolean z, long j) {
        b bVarJ = j(fVar, cdVar, z, j);
        if (bVarJ == null) {
            return null;
        }
        return bVarJ.a;
    }

    public final synchronized List d(com.google.android.libraries.navigation.internal.qi.f fVar, com.google.android.libraries.navigation.internal.qi.f fVar2, List list) {
        ArrayList arrayList;
        e eVar;
        com.google.android.libraries.navigation.internal.nw.d dVarB = com.google.android.libraries.navigation.internal.nw.e.b("shallowCopyAvailableTiles");
        try {
            arrayList = new ArrayList(list.size());
            if (!fVar.equals(fVar2)) {
                long jA = this.e.a();
                Iterator it2 = list.iterator();
                while (it2.hasNext()) {
                    cd cdVar = (cd) it2.next();
                    b bVarJ = j(fVar, cdVar, false, jA);
                    if (bVarJ != null && bVarJ.a != null) {
                        b bVarJ2 = j(fVar2, cdVar, true, jA);
                        if (bVarJ2 != null && (eVar = bVarJ2.a) != null) {
                            eVar.s();
                        }
                        f(fVar2, cdVar, bVarJ.a);
                        arrayList.add(cdVar);
                        bVarJ.a.s();
                    }
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
        return arrayList;
    }

    public final synchronized void e(com.google.android.libraries.navigation.internal.qi.f fVar) {
        com.google.android.libraries.navigation.internal.nw.d dVarB = com.google.android.libraries.navigation.internal.nw.e.b("clearAllByCacheKey");
        try {
            c cVar = (c) this.f.get(fVar);
            if (cVar != null) {
                cVar.k();
                this.f.remove(fVar);
                k();
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
    }

    public final synchronized void f(com.google.android.libraries.navigation.internal.qi.f fVar, cd cdVar, e eVar) {
        com.google.android.libraries.navigation.internal.nw.d dVarB = com.google.android.libraries.navigation.internal.nw.e.b("insertByCacheKey");
        try {
            eVar.p();
            c cVar = (c) this.f.get(fVar);
            if (cVar == null) {
                cVar = new c(this, this.h);
                this.f.put(fVar, cVar);
            }
            b bVar = (b) cVar.e(cdVar);
            if (bVar == null) {
                eVar.s();
            } else {
                e eVar2 = bVar.a;
                if (eVar2 != null) {
                    this.a -= bVar.b;
                    this.b -= bVar.c;
                    eVar2.s();
                    bVar.a.s();
                } else {
                    this.c++;
                }
                bVar.a = eVar;
                bVar.b = eVar.i();
                int iJ = eVar.j();
                bVar.c = iJ;
                this.a += bVar.b;
                this.b += iJ;
                com.google.android.libraries.navigation.internal.nw.d dVarB2 = com.google.android.libraries.navigation.internal.nw.e.b("trim");
                try {
                    long jA = this.e.a() - 500;
                    boolean zBooleanValue = ((Boolean) this.g.a()).booleanValue();
                    ArrayList arrayList = new ArrayList();
                    for (Map.Entry entry : this.f.entrySet()) {
                        c cVar2 = (c) entry.getValue();
                        while (true) {
                            if (cVar2.c() <= cVar2.d && !zBooleanValue) {
                                break;
                            }
                            j jVarS = cVar2.s();
                            if (!l(jVarS, jA)) {
                                break;
                            } else {
                                cVar2.g((cd) jVarS.a);
                            }
                        }
                        if (cVar2.r()) {
                            arrayList.add((com.google.android.libraries.navigation.internal.qi.f) entry.getKey());
                        }
                    }
                    int size = arrayList.size();
                    for (int i = 0; i < size; i++) {
                        this.f.remove(arrayList.get(i));
                    }
                    if (dVarB2 != null) {
                        Trace.endSection();
                    }
                    k();
                } catch (Throwable th) {
                    if (dVarB2 != null) {
                        try {
                            Trace.endSection();
                        } catch (Throwable th2) {
                            th.addSuppressed(th2);
                        }
                    }
                    throw th;
                }
            }
            if (dVarB != null) {
                Trace.endSection();
            }
        } catch (Throwable th3) {
            if (dVarB != null) {
                try {
                    Trace.endSection();
                } catch (Throwable th4) {
                    th3.addSuppressed(th4);
                }
            }
            throw th3;
        }
    }

    public final synchronized void g() {
        j jVarS;
        try {
            com.google.android.libraries.navigation.internal.nw.d dVarB = com.google.android.libraries.navigation.internal.nw.e.b("cleanOldCaches");
            try {
                long jA = this.e.a() - 5000;
                ArrayList arrayList = new ArrayList();
                for (Map.Entry entry : this.f.entrySet()) {
                    c cVar = (c) entry.getValue();
                    long j = cVar.c;
                    if (j > 0 && j < jA && (jVarS = cVar.s()) != null) {
                        cVar.g((cd) jVarS.a);
                    }
                    if (cVar.r()) {
                        arrayList.add((com.google.android.libraries.navigation.internal.qi.f) entry.getKey());
                    }
                }
                int size = arrayList.size();
                for (int i = 0; i < size; i++) {
                    this.f.remove(arrayList.get(i));
                }
                k();
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
        } catch (Throwable th3) {
            throw th3;
        }
    }

    @Override // com.google.android.libraries.navigation.internal.fq.p
    public final synchronized void h(float f) {
        try {
            com.google.android.libraries.navigation.internal.nw.d dVarB = com.google.android.libraries.navigation.internal.nw.e.b("trimToFractionOfMeasuredSize");
            try {
                ArrayList arrayList = new ArrayList();
                for (Map.Entry entry : this.f.entrySet()) {
                    c cVar = (c) entry.getValue();
                    float fC = cVar.c() * f;
                    while (cVar.c() > ((int) fC)) {
                        j jVarS = cVar.s();
                        if (!l(jVarS, 0L)) {
                            break;
                        } else {
                            cVar.g((cd) jVarS.a);
                        }
                    }
                    if (cVar.r()) {
                        arrayList.add((com.google.android.libraries.navigation.internal.qi.f) entry.getKey());
                    }
                }
                int size = arrayList.size();
                for (int i = 0; i < size; i++) {
                    this.f.remove(arrayList.get(i));
                }
                if (dVarB != null) {
                    Trace.endSection();
                }
                k();
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
        } catch (Throwable th3) {
            throw th3;
        }
    }

    public final synchronized void i(com.google.android.libraries.navigation.internal.qi.f fVar, int i) {
        c cVar = (c) this.f.get(fVar);
        if (cVar != null) {
            int i2 = this.h;
            if (i > 0) {
                float f = i;
                int iCeil = (int) Math.ceil(f + f);
                int i3 = cVar.d;
                if (iCeil > i3) {
                    cVar.d = iCeil;
                } else {
                    cVar.d = i3 - ((int) Math.ceil((i3 - iCeil) * 0.05f));
                }
            }
            int i4 = cVar.d;
            if (i4 < 16) {
                cVar.d = 16;
                i4 = 16;
            }
            if (i4 > i2) {
                cVar.d = i2;
            }
        }
    }
}
