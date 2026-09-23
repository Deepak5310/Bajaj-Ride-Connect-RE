package com.google.android.libraries.geo.mapcore.internal.legacy.vector.gl.drawable;

import com.google.android.libraries.geo.mapcore.internal.model.br;
import com.google.android.libraries.geo.mapcore.internal.model.ce;
import com.google.android.libraries.geo.mapcore.internal.model.cp;
import com.google.android.libraries.geo.mapcore.internal.vector.gl.GeometryUtil;
import com.google.android.libraries.geo.mapcore.renderer.bq;
import com.google.android.libraries.geo.mapcore.renderer.bt;
import com.google.android.libraries.geo.mapcore.renderer.ef;
import com.google.android.libraries.navigation.internal.agg.fd;
import com.google.android.libraries.navigation.internal.agi.cj;
import com.google.android.libraries.navigation.internal.agi.fo;
import com.google.android.libraries.navigation.internal.yz.gs;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes2.dex */
public final class h {
    public final ArrayList a;
    private final ce b;
    private final ba c;
    private final GeometryUtil d;
    private final bq e;
    private final boolean f;

    public h(ce ceVar, ba baVar, GeometryUtil geometryUtil, bq bqVar, boolean z) {
        ArrayList arrayList = new ArrayList();
        this.a = arrayList;
        this.b = ceVar;
        this.c = baVar;
        this.d = geometryUtil;
        this.e = bqVar;
        this.f = z;
        arrayList.add(new ArrayList());
    }

    /* JADX WARN: Code duplicated, block: B:26:0x0070  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v1 */
    /* JADX WARN: Type inference failed for: r4v11 */
    /* JADX WARN: Type inference failed for: r4v2, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r4v28 */
    /* JADX WARN: Type inference failed for: r4v29 */
    /* JADX WARN: Type inference failed for: r7v14, types: [com.google.android.libraries.geo.mapcore.internal.model.ai] */
    public final void a(com.google.android.libraries.geo.mapcore.renderer.af afVar, com.google.android.libraries.navigation.internal.ps.q qVar, ef efVar, List list, List list2, List list3) {
        l lVarG;
        i iVarE;
        HashSet hashSet;
        ArrayList arrayList;
        HashSet hashSet2;
        i iVarE2;
        int i;
        if (c()) {
            int i2 = bt.a().b;
            int iHighestOneBit = i2 > 1 ? Integer.highestOneBit(i2) : 256;
            if (this.f) {
                cj cjVar = new cj();
                ArrayList arrayList2 = this.a;
                int size = arrayList2.size();
                float fMax = 1.0f;
                int i3 = 0;
                while (i3 < size) {
                    ArrayList arrayList3 = (ArrayList) arrayList2.get(i3);
                    int size2 = arrayList3.size();
                    int i4 = 0;
                    while (true) {
                        i = i3 + 1;
                        if (i4 < size2) {
                            j jVar = (j) arrayList3.get(i4);
                            if (!jVar.b.d()) {
                                fMax = Math.max(fMax, jVar.d);
                                if (!cjVar.containsKey(jVar.b)) {
                                    cjVar.a(jVar.b, cjVar.h);
                                }
                            }
                            i4++;
                        }
                    }
                    i3 = i;
                }
                int i5 = cjVar.h;
                if (i5 + i5 <= iHighestOneBit) {
                    lVarG = l.g(cjVar, fMax);
                } else {
                    lVarG = null;
                }
            } else {
                lVarG = null;
            }
            fo foVar = new fo();
            ArrayList arrayList4 = new ArrayList();
            ArrayList arrayList5 = new ArrayList();
            HashSet hashSet3 = new HashSet();
            ArrayList arrayList6 = this.a;
            int size3 = arrayList6.size();
            int i6 = 0;
            while (i6 < size3) {
                ArrayList arrayList7 = (ArrayList) arrayList6.get(i6);
                int size4 = arrayList7.size();
                ArrayList arrayList8 = arrayList5;
                ?? r4 = 0;
                int i7 = 0;
                while (i7 < size4) {
                    j jVar2 = (j) arrayList7.get(i7);
                    int i8 = i7;
                    m mVar = ((a) jVar2.b).b;
                    int i9 = size4;
                    com.google.android.libraries.geo.mapcore.internal.model.ai aiVarB = jVar2.b();
                    ArrayList arrayList9 = arrayList7;
                    if (mVar == m.LINE_STROKE || (d.e(aiVarB, mVar) && d.f(aiVarB, mVar))) {
                        if (jVar2.b.d()) {
                            ?? B = jVar2.b();
                            if (r4 != 0 && !B.equals(r4)) {
                                j jVar3 = (j) arrayList8.get(0);
                                if (!this.f) {
                                    iVarE2 = i.e(jVar3, this.b);
                                } else if (foVar.containsKey(jVar3.b)) {
                                    iVarE2 = (i) foVar.get(jVar3.b);
                                } else {
                                    iVarE2 = i.e(jVar3, this.b);
                                    foVar.put(jVar3.b, iVarE2);
                                }
                                list2.add(o.c(this.d, this.b, this.c, this.e, arrayList8, iVarE2, afVar, qVar, efVar, jVar3.c, list, list3));
                                arrayList8 = new ArrayList();
                            }
                            arrayList8.add(jVar2);
                            i8 = i8;
                            i9 = i9;
                            arrayList9 = arrayList9;
                            r4 = B;
                            i6 = i6;
                            iHighestOneBit = iHighestOneBit;
                            size3 = size3;
                            arrayList6 = arrayList6;
                            arrayList = arrayList4;
                            hashSet2 = hashSet3;
                        } else {
                            int size5 = hashSet3.size();
                            if (size5 + size5 >= iHighestOneBit) {
                                hashSet = hashSet3;
                                ArrayList arrayList10 = arrayList4;
                                list2.add(o.c(this.d, this.b, this.c, this.e, arrayList4, lVarG != null ? lVarG : l.e(arrayList4), afVar, qVar, efVar, ((j) arrayList4.get(0)).c, list, list3));
                                arrayList10.clear();
                                hashSet.clear();
                                arrayList = arrayList10;
                            } else {
                                iHighestOneBit = iHighestOneBit;
                                hashSet = hashSet3;
                                arrayList = arrayList4;
                            }
                            arrayList.add(jVar2);
                            hashSet2 = hashSet;
                            hashSet2.add(jVar2.b);
                        }
                        i7 = i8 + 1;
                        hashSet3 = hashSet2;
                        size4 = i9;
                        arrayList7 = arrayList9;
                        i6 = i6;
                        size3 = size3;
                        arrayList6 = arrayList6;
                        arrayList4 = arrayList;
                        iHighestOneBit = iHighestOneBit;
                        r4 = r4;
                    } else {
                        iHighestOneBit = iHighestOneBit;
                        arrayList6 = arrayList6;
                        arrayList = arrayList4;
                        i8 = i8;
                        i9 = i9;
                        arrayList9 = arrayList9;
                        arrayList8 = arrayList8;
                        size3 = size3;
                        hashSet2 = hashSet3;
                    }
                    arrayList8 = arrayList8;
                    i7 = i8 + 1;
                    hashSet3 = hashSet2;
                    size4 = i9;
                    arrayList7 = arrayList9;
                    i6 = i6;
                    size3 = size3;
                    arrayList6 = arrayList6;
                    arrayList4 = arrayList;
                    iHighestOneBit = iHighestOneBit;
                    r4 = r4;
                }
                int i10 = iHighestOneBit;
                ArrayList arrayList11 = arrayList8;
                int i11 = i6;
                int i12 = size3;
                ArrayList arrayList12 = arrayList6;
                ArrayList arrayList13 = arrayList4;
                HashSet hashSet4 = hashSet3;
                hashSet4.clear();
                if (!arrayList13.isEmpty()) {
                    list2.add(o.c(this.d, this.b, this.c, this.e, arrayList13, lVarG != null ? lVarG : l.e(arrayList13), afVar, qVar, efVar, ((j) arrayList13.get(0)).c, list, list3));
                    arrayList13.clear();
                }
                arrayList5 = arrayList11;
                if (!arrayList11.isEmpty()) {
                    j jVar4 = (j) arrayList5.get(0);
                    if (!this.f) {
                        iVarE = i.e(jVar4, this.b);
                    } else if (foVar.containsKey(jVar4.b)) {
                        iVarE = (i) foVar.get(jVar4.b);
                    } else {
                        iVarE = i.e(jVar4, this.b);
                        foVar.put(jVar4.b, iVarE);
                    }
                    list2.add(o.c(this.d, this.b, this.c, this.e, arrayList5, iVarE, afVar, qVar, efVar, jVar4.c, list, list3));
                    arrayList5.clear();
                }
                i6 = i11 + 1;
                arrayList4 = arrayList13;
                hashSet3 = hashSet4;
                size3 = i12;
                iHighestOneBit = i10;
                arrayList6 = arrayList12;
            }
            ArrayList arrayList14 = this.a;
            int size6 = arrayList14.size();
            for (int i13 = 0; i13 < size6; i13++) {
                ((ArrayList) arrayList14.get(i13)).clear();
            }
            this.a.clear();
            this.a.add(new ArrayList());
            this.a.trimToSize();
        }
    }

    public final void b() {
        if (((ArrayList) gs.d(this.a)).isEmpty()) {
            return;
        }
        this.a.add(new ArrayList());
    }

    public final boolean c() {
        ArrayList arrayList = this.a;
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            boolean zIsEmpty = ((ArrayList) arrayList.get(i)).isEmpty();
            i++;
            if (!zIsEmpty) {
                return true;
            }
        }
        return false;
    }

    public final void d(cp cpVar, com.google.android.libraries.navigation.internal.qh.c cVar) {
        while (cpVar.hasNext()) {
            br brVarB = cpVar.b();
            com.google.android.libraries.geo.mapcore.internal.model.ai aiVarF = cVar.f(brVarB, fd.a);
            if (brVarB.a() != 8 || com.google.android.libraries.geo.mapcore.internal.model.ar.f(brVarB, aiVarF)) {
                return;
            }
            if (com.google.android.libraries.geo.mapcore.internal.model.ar.e(brVarB, aiVarF)) {
                com.google.android.libraries.geo.mapcore.internal.model.ar arVar = (com.google.android.libraries.geo.mapcore.internal.model.ar) brVarB;
                ((ArrayList) gs.d(this.a)).add(new j(arVar, aiVarF, com.google.android.libraries.navigation.internal.qq.an.k(arVar, cVar.f(arVar, fd.a)), m.LINE_STROKE));
                cpVar.next();
            } else {
                cpVar.next();
            }
        }
    }
}
