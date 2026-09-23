package com.google.android.libraries.geo.mapcore.internal.model;

import android.util.SparseIntArray;
import com.google.android.libraries.navigation.internal.adg.db;
import com.google.android.libraries.navigation.internal.adg.el;
import com.google.android.libraries.navigation.internal.adg.en;
import com.google.android.libraries.navigation.internal.adg.eo;
import com.google.android.libraries.navigation.internal.adg.fk;
import com.google.android.libraries.navigation.internal.adg.fz;
import com.google.android.libraries.navigation.internal.adg.ga;
import com.google.android.libraries.navigation.internal.adg.gk;
import com.google.android.libraries.navigation.internal.adg.he;
import com.google.android.libraries.navigation.internal.adg.id;
import com.google.android.libraries.navigation.internal.adg.ii;
import com.google.android.libraries.navigation.internal.adg.ip;
import com.google.android.libraries.navigation.internal.adg.jp;
import com.google.android.libraries.navigation.internal.afl.pw;
import com.google.android.libraries.navigation.internal.agg.ez;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes2.dex */
public abstract class bv {
    public static final bt c = new bt(0, new ai[]{ai.c}, new byte[]{0}, null, false);
    public static final byte[] d = new byte[0];

    /* JADX WARN: Code duplicated, block: B:101:0x01c0  */
    /* JADX WARN: Code duplicated, block: B:104:0x01cf  */
    /* JADX WARN: Code duplicated, block: B:106:0x01d3  */
    private static void f(db dbVar, bu buVar) {
        ab abVarA;
        com.google.android.libraries.navigation.internal.adg.p pVar;
        ah ahVar = buVar.a;
        if ((dbVar.b & 2) != 0) {
            com.google.android.libraries.navigation.internal.adg.ba baVar = dbVar.d;
            if (baVar == null) {
                baVar = com.google.android.libraries.navigation.internal.adg.ba.a;
            }
            ahVar.z = baVar.e;
            buVar.b = baVar.g;
            int size = baVar.c.size();
            ahVar.b = baVar.h;
            if (size > 0) {
                bs[] bsVarArr = new bs[size];
                for (int i = 0; i < size; i++) {
                    bsVarArr[i] = bs.a((id) baVar.c.get(i), null);
                }
                ahVar.j = bsVarArr;
            } else {
                ahVar.j = ai.b;
            }
            ahVar.a = baVar.i;
            if ((baVar.b & 2) != 0) {
                ahVar.g = baVar.f;
            } else {
                ahVar.g = 0;
            }
            String str = baVar.j;
            com.google.android.libraries.geo.mapcore.internal.vector.gl.o oVar = com.google.android.libraries.geo.mapcore.internal.vector.gl.o.NO_WRAP;
            com.google.android.libraries.geo.mapcore.internal.vector.gl.n nVar = com.google.android.libraries.geo.mapcore.internal.vector.gl.n.b;
            ahVar.A = new com.google.android.libraries.geo.mapcore.internal.vector.gl.a(str, oVar);
            ahVar.B = dbVar.c;
            ahVar.C = new com.google.android.libraries.geo.mapcore.internal.vector.gl.a(baVar.l, com.google.android.libraries.geo.mapcore.internal.vector.gl.o.WRAP_T);
            int iA = com.google.android.libraries.navigation.internal.adg.az.a(baVar.f180n);
            if (iA == 0) {
                iA = com.google.android.libraries.navigation.internal.adg.az.a;
            }
            ahVar.T = iA;
            int iA2 = com.google.android.libraries.navigation.internal.adg.av.a(baVar.o);
            if (iA2 == 0) {
                iA2 = com.google.android.libraries.navigation.internal.adg.av.a;
            }
            ahVar.U = iA2;
            int iA3 = com.google.android.libraries.navigation.internal.adg.ax.a(baVar.p);
            if (iA3 == 0) {
                iA3 = com.google.android.libraries.navigation.internal.adg.ax.a;
            }
            ahVar.V = iA3;
        }
        if ((dbVar.b & 32) != 0) {
            jp jpVar = dbVar.g;
            if (jpVar == null) {
                jpVar = jp.a;
            }
            buVar.b = jpVar.g;
            ahVar.d = jpVar.h;
            int i2 = jpVar.b;
            if ((i2 & 4) != 0) {
                ahVar.h = jpVar.e;
            } else {
                ahVar.h = 0;
            }
            if ((i2 & 1) != 0) {
                ahVar.l = new bs[]{new bs(jpVar.c, ay.a(jpVar.d), new int[0], 0.0f)};
            }
            int i3 = jpVar.b;
            if ((i3 & 8) != 0) {
                ahVar.N = jpVar.f;
            }
            if ((i3 & 128) != 0) {
                ahVar.O = Float.valueOf(jpVar.i);
            }
            if ((i3 & 256) != 0) {
                ahVar.P = Float.valueOf(jpVar.j);
            }
            if ((i3 & 1024) != 0) {
                ahVar.Q = Float.valueOf(jpVar.k);
            }
            if ((i3 & 2048) != 0) {
                ahVar.R = Float.valueOf(jpVar.l);
            }
        }
        if ((dbVar.b & 8) != 0) {
            fk fkVar = dbVar.f;
            if (fkVar == null) {
                fkVar = fk.a;
            }
            buVar.b = fkVar.g;
            int i4 = fkVar.b;
            if ((i4 & 256) != 0) {
                ahVar.w = fkVar.k;
            } else {
                ahVar.w = 0.375f;
            }
            if ((i4 & 512) != 0) {
                ahVar.x = fkVar.l;
            } else {
                ahVar.x = 0.375f;
            }
            ArrayList arrayList = new ArrayList(4);
            arrayList.addAll(fkVar.c);
            arrayList.addAll(fkVar.e);
            int size2 = arrayList.size();
            if (fkVar.h || size2 <= 0) {
                ahVar.k = ai.b;
            } else {
                ahVar.y = fkVar.m;
                bs[] bsVarArr2 = new bs[size2];
                for (int i5 = 0; i5 < size2; i5++) {
                    bsVarArr2[i5] = bs.a((id) arrayList.get(i5), null);
                }
                k(fkVar, bsVarArr2);
                ahVar.k = bsVarArr2;
            }
        }
        if ((dbVar.b & 4) != 0) {
            eo eoVar = dbVar.e;
            if (eoVar == null) {
                eoVar = eo.a;
            }
            boolean z = eoVar.l;
            ahVar.c = z;
            if (z) {
                buVar.b = 0;
                ahVar.f57n = null;
                ahVar.o = null;
                ahVar.p = null;
            } else {
                buVar.b = eoVar.i;
                ahVar.f57n = cb.j(eoVar);
                if ((eoVar.b & 32) != 0) {
                    ip ipVar = eoVar.h;
                    if (ipVar == null) {
                        ipVar = ip.b;
                    }
                    ahVar.o = bz.v(ipVar);
                    ip ipVar2 = eoVar.h;
                    if (ipVar2 == null) {
                        ipVar2 = ip.b;
                    }
                    if (ipVar2.r.size() > 0) {
                        ip ipVar3 = eoVar.h;
                        if (ipVar3 == null) {
                            ipVar3 = ip.b;
                        }
                        abVarA = ab.a(ipVar3.r);
                    }
                    if (eoVar.e.size() > 0) {
                        abVarA = ab.a(eoVar.e);
                    }
                    ahVar.p = abVarA;
                    if ((eoVar.b & 131072) != 0) {
                        pVar = eoVar.t;
                        if (pVar == null) {
                            pVar = com.google.android.libraries.navigation.internal.adg.p.a;
                        }
                        ahVar.a(pVar);
                    }
                    ahVar.M = eoVar.v;
                } else {
                    ahVar.o = null;
                }
                abVarA = null;
                if (eoVar.e.size() > 0) {
                    abVarA = ab.a(eoVar.e);
                }
                ahVar.p = abVarA;
                if ((eoVar.b & 131072) != 0) {
                    pVar = eoVar.t;
                    if (pVar == null) {
                        pVar = com.google.android.libraries.navigation.internal.adg.p.a;
                    }
                    ahVar.a(pVar);
                }
                ahVar.M = eoVar.v;
            }
            int i6 = eoVar.b;
            if ((i6 & 1024) != 0) {
                ahVar.q = ay.a(eoVar.m);
            }
            if ((i6 & 2048) != 0) {
                ahVar.r = ay.a(eoVar.f187n);
            }
            if ((i6 & 4096) != 0) {
                ahVar.s = ay.a(eoVar.o);
            }
            if ((i6 & 8192) != 0) {
                en enVarB = en.b(eoVar.p);
                if (enVarB == null) {
                    enVarB = en.SUBTITLE_ANNOTATE_UNKNOWN;
                }
                ahVar.F = enVarB;
            }
            if ((eoVar.b & 16384) != 0) {
                com.google.android.libraries.navigation.internal.adg.aj ajVar = (com.google.android.libraries.navigation.internal.adg.aj) com.google.android.libraries.navigation.internal.adg.ak.a.q();
                int i7 = 0;
                while (true) {
                    com.google.android.libraries.navigation.internal.adg.ak akVar = eoVar.q;
                    if (akVar == null) {
                        akVar = com.google.android.libraries.navigation.internal.adg.ak.a;
                    }
                    if (i7 >= akVar.b.size()) {
                        break;
                    }
                    com.google.android.libraries.navigation.internal.adg.ak akVar2 = eoVar.q;
                    if (akVar2 == null) {
                        akVar2 = com.google.android.libraries.navigation.internal.adg.ak.a;
                    }
                    ajVar.c(akVar2.b.d(i7));
                    i7++;
                }
                ahVar.G = (com.google.android.libraries.navigation.internal.adg.ak) ajVar.t();
            }
            ahVar.H = eoVar.r;
            if ((eoVar.b & 128) != 0) {
                com.google.android.libraries.navigation.internal.adg.b bVarB = com.google.android.libraries.navigation.internal.adg.b.b(eoVar.j);
                if (bVarB == null) {
                    bVarB = com.google.android.libraries.navigation.internal.adg.b.CENTER;
                }
                ahVar.I = bVarB;
            }
            if (eoVar.w.size() > 0) {
                ahVar.J = ak.a(eoVar);
            }
            if ((eoVar.b & 256) != 0) {
                el elVarB = el.b(eoVar.k);
                if (elVarB == null) {
                    elVarB = el.PROJECTION_SCREEN_ALIGNED;
                }
                if (elVarB != el.UNKNOWN_PROJECTION_BEHAVIOR) {
                    el elVarB2 = el.b(eoVar.k);
                    if (elVarB2 == null) {
                        elVarB2 = el.PROJECTION_SCREEN_ALIGNED;
                    }
                    ahVar.K = elVarB2;
                }
            }
        }
        if ((dbVar.b & 64) != 0) {
            he heVar = dbVar.h;
            if (heVar == null) {
                heVar = he.a;
            }
            ahVar.e = heVar.d;
            buVar.b = heVar.c;
            if (heVar.b.size() == 20) {
                float[] fArr = new float[20];
                for (int i8 = 0; i8 < 20; i8++) {
                    float fD = heVar.b.d(i8);
                    fArr[i8] = fD;
                    if (i8 % 5 == 4) {
                        fArr[i8] = fD * 255.0f;
                    }
                }
                ahVar.u = fArr;
                if (heVar.d) {
                    Arrays.toString(fArr);
                }
            } else {
                ahVar.u = null;
            }
        }
        if ((dbVar.b & 128) != 0) {
            gk gkVar = dbVar.i;
            if (gkVar == null) {
                gkVar = gk.a;
            }
            buVar.b = gkVar.g;
            int i9 = gkVar.b;
            if ((i9 & 1) != 0) {
                ahVar.i = gkVar.c;
            } else {
                ahVar.i = 0;
            }
            if ((i9 & 2) != 0) {
                ahVar.S = ay.a(gkVar.d);
            }
            if ((i9 & 4) == 0 || (i9 & 8) == 0) {
                return;
            }
            ahVar.m = new bs(gkVar.e, ay.a(gkVar.f), new int[0], 0.0f);
        }
    }

    public static SparseIntArray g(ii iiVar) {
        if (iiVar.b.size() <= 0 || iiVar.c.size() <= 0) {
            return null;
        }
        int iMin = Math.min(iiVar.b.size(), iiVar.c.size());
        SparseIntArray sparseIntArray = new SparseIntArray(iMin);
        while (true) {
            iMin--;
            if (iMin < 0) {
                return sparseIntArray;
            }
            sparseIntArray.put(iiVar.b.d(iMin), iiVar.c.d(iMin));
        }
    }

    public static s h(List list, boolean z) throws IOException {
        s sVar = new s(list);
        bu buVar = new bu(false);
        Iterator it2 = list.iterator();
        while (it2.hasNext()) {
            try {
                bt btVarJ = j((ga) it2.next(), buVar);
                synchronized (sVar.a) {
                    sVar.a.size();
                    sVar.a.add(btVarJ);
                }
            } catch (IndexOutOfBoundsException e) {
                throw new IOException("unpackProtoInTile: Error in parsing multiZoomStyle", e);
            }
        }
        return sVar;
    }

    public static an i(byte[] bArr, com.google.android.libraries.navigation.internal.adi.c cVar, pw pwVar) throws IOException {
        try {
            float f = pwVar.e;
            return new an(new an.a(bArr, cVar), pwVar.c);
        } catch (IndexOutOfBoundsException e) {
            throw new IOException("unpackProtoLazily: Error in parsing multiZoomStyleTable", e);
        }
    }

    public static bt j(ga gaVar, bu buVar) {
        ii iiVar = gaVar.e;
        if (iiVar == null) {
            iiVar = ii.a;
        }
        SparseIntArray sparseIntArrayG = g(iiVar);
        int size = gaVar.c.size();
        if (size <= 0) {
            return new bt(gaVar.b, null, null, sparseIntArrayG, buVar.c);
        }
        buVar.c(size);
        for (int i = 0; i < size; i++) {
            db dbVar = (db) gaVar.c.get(i);
            f(dbVar, buVar);
            buVar.b(dbVar.c);
        }
        bt btVarA = buVar.a(gaVar.b, sparseIntArrayG);
        if (gaVar.d.size() != 0) {
            HashMap map = new HashMap();
            for (int i2 = 0; i2 < gaVar.d.size(); i2++) {
                fz fzVar = (fz) gaVar.d.get(i2);
                if (fzVar.c.size() != 0) {
                    buVar.c(fzVar.c.size());
                    for (int i3 = 0; i3 < fzVar.c.size(); i3++) {
                        db dbVar2 = (db) fzVar.c.get(i3);
                        f(dbVar2, buVar);
                        buVar.b(dbVar2.c);
                    }
                    bt btVarA2 = buVar.a(gaVar.b, sparseIntArrayG);
                    for (int i4 = 0; i4 < fzVar.b.size(); i4++) {
                        com.google.android.libraries.navigation.internal.adi.bo boVarB = com.google.android.libraries.navigation.internal.adi.bo.b(fzVar.b.d(i4));
                        if (boVarB == null) {
                            boVarB = com.google.android.libraries.navigation.internal.adi.bo.UNKNOWN;
                        }
                        map.put(boVarB, btVarA2);
                    }
                }
            }
            btVarA.e = map;
        }
        return btVarA;
    }

    public static void k(fk fkVar, bs[] bsVarArr) {
        int i = fkVar.b;
        if ((i & 16) == 0 && (i & 64) == 0) {
            return;
        }
        int i2 = 0;
        while (true) {
            if (i2 >= bsVarArr.length) {
                for (bs bsVar : bsVarArr) {
                    if ((fkVar.b & 16) != 0) {
                        String str = fkVar.i;
                        com.google.android.libraries.geo.mapcore.internal.vector.gl.o oVar = com.google.android.libraries.geo.mapcore.internal.vector.gl.o.NO_WRAP;
                        com.google.android.libraries.geo.mapcore.internal.vector.gl.n nVar = com.google.android.libraries.geo.mapcore.internal.vector.gl.n.b;
                        bsVar.j = new com.google.android.libraries.geo.mapcore.internal.vector.gl.a(str, oVar);
                    }
                    if ((fkVar.b & 64) != 0) {
                        String str2 = fkVar.j;
                        com.google.android.libraries.geo.mapcore.internal.vector.gl.o oVar2 = com.google.android.libraries.geo.mapcore.internal.vector.gl.o.NO_WRAP;
                        com.google.android.libraries.geo.mapcore.internal.vector.gl.n nVar2 = com.google.android.libraries.geo.mapcore.internal.vector.gl.n.b;
                        bsVar.k = new com.google.android.libraries.geo.mapcore.internal.vector.gl.a(str2, oVar2);
                    }
                }
                return;
            }
            if (!bsVarArr[i2].j.c() || !bsVarArr[i2].k.c()) {
                return;
            } else {
                i2++;
            }
        }
    }

    public abstract int a();

    public abstract bt b(int i);

    public abstract bt c(long j);

    public abstract bt d(int i, ez ezVar, bx bxVar);

    public abstract byte[] e();
}
