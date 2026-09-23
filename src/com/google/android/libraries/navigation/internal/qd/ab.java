package com.google.android.libraries.navigation.internal.qd;

import com.google.android.libraries.geo.mapcore.internal.model.ar;
import com.google.android.libraries.geo.mapcore.internal.model.bk;
import com.google.android.libraries.navigation.internal.oe.ad;
import com.google.android.libraries.navigation.internal.oe.ai;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class ab implements aa {
    public final o a;
    public final a[] b;
    private final ar[] c;
    private final List d;

    public ab(o oVar, ar[] arVarArr) {
        int length;
        this.a = oVar;
        this.c = arVarArr;
        int i = 0;
        int length2 = 0;
        while (true) {
            length = arVarArr.length;
            if (i >= length) {
                break;
            }
            length2 += arVarArr[i].d.length;
            i++;
        }
        this.b = new a[length2];
        this.d = new ArrayList(length);
        int i2 = 0;
        for (ar arVar : arVarArr) {
            this.d.add(new ArrayList());
            for (ad adVar : arVar.d) {
                this.b[i2] = new a(adVar);
                i2++;
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:102:0x025c  */
    /* JADX WARN: Code duplicated, block: B:123:0x026c A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:133:0x0225 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:47:0x016a  */
    /* JADX WARN: Code duplicated, block: B:51:0x017e  */
    /* JADX WARN: Code duplicated, block: B:53:0x0197  */
    /* JADX WARN: Code duplicated, block: B:54:0x019c  */
    /* JADX WARN: Code duplicated, block: B:56:0x01c9  */
    /* JADX WARN: Code duplicated, block: B:58:0x01cc  */
    /* JADX WARN: Code duplicated, block: B:66:0x01e2  */
    /* JADX WARN: Code duplicated, block: B:70:0x01f8  */
    /* JADX WARN: Code duplicated, block: B:72:0x01fb  */
    /* JADX WARN: Code duplicated, block: B:74:0x01ff  */
    /* JADX WARN: Code duplicated, block: B:76:0x0208  */
    /* JADX WARN: Code duplicated, block: B:77:0x020d  */
    /* JADX WARN: Code duplicated, block: B:78:0x0213  */
    /* JADX WARN: Code duplicated, block: B:82:0x021f  */
    /* JADX WARN: Code duplicated, block: B:84:0x0223  */
    /* JADX WARN: Code duplicated, block: B:89:0x022f A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:90:0x0231  */
    /* JADX WARN: Code duplicated, block: B:91:0x0234  */
    /* JADX WARN: Code duplicated, block: B:94:0x0243  */
    /* JADX WARN: Code duplicated, block: B:96:0x0247  */
    @Override // com.google.android.libraries.navigation.internal.qd.aa
    public final void a(com.google.android.libraries.navigation.internal.pb.t tVar, j jVar) {
        List listA;
        boolean z;
        int iE;
        ai aiVar;
        int i;
        int i2;
        int i3;
        int i4;
        a aVar;
        ad adVar;
        bk[] bkVarArr;
        int iE2;
        boolean[] zArr;
        com.google.android.libraries.navigation.internal.oe.x xVarL;
        com.google.android.libraries.navigation.internal.oe.x xVar;
        int i5;
        int i6;
        bk[] bkVarArr2;
        com.google.android.libraries.navigation.internal.oe.ab abVar;
        int i7;
        int i8;
        int i9;
        int i10;
        bk[] bkVarArr3;
        ai aiVar2;
        Iterator it2 = this.d.iterator();
        while (it2.hasNext()) {
            ((List) it2.next()).clear();
        }
        float fO = tVar.o();
        ai aiVar3 = tVar.v().e;
        float fH = tVar.h();
        int i11 = 0;
        int length = 0;
        while (true) {
            ar[] arVarArr = this.c;
            if (i11 >= arVarArr.length) {
                return;
            }
            ar arVar = arVarArr[i11];
            o oVar = this.a;
            oVar.c = arVar;
            oVar.d.put(oVar.c, new ArrayList());
            this.a.c();
            List list = (List) this.d.get(i11);
            int length2 = arVar.d.length + length;
            int i12 = length;
            while (i12 < length2) {
                a aVar2 = this.b[i12];
                if (jVar.a == null) {
                    jVar.a = new ai(new com.google.android.libraries.navigation.internal.oe.x(), new com.google.android.libraries.navigation.internal.oe.x());
                }
                com.google.android.libraries.navigation.internal.oe.x xVar2 = aiVar3.a;
                com.google.android.libraries.navigation.internal.oe.x xVar3 = aiVar3.b;
                int i13 = length2;
                if (xVar3.a >= 536870912) {
                    listA = aVar2.b(true);
                } else {
                    if (xVar2.a < -536870912) {
                        listA = aVar2.b(false);
                    } else {
                        listA = aVar2.a(aVar2.a.r(-536870912));
                        z = false;
                    }
                    iE = aiVar3.e();
                    int iD = aiVar3.d();
                    int i14 = i11;
                    if (iE <= 119304647 || iD > 119304647) {
                        aiVar = aiVar3;
                        list.addAll(listA);
                        jVar.a.n(xVar2, xVar3);
                    } else {
                        com.google.android.libraries.navigation.internal.oe.x xVar4 = new com.google.android.libraries.navigation.internal.oe.x(iE * 4, iD * 4);
                        com.google.android.libraries.navigation.internal.oe.x xVarC = aiVar3.a.C(xVar4);
                        com.google.android.libraries.navigation.internal.oe.x xVarU = aiVar3.b.u(xVar4);
                        if (!z) {
                            xVarC.G(xVarC);
                            xVarU.G(xVarU);
                        }
                        jVar.a.n(xVarC, xVarU);
                        com.google.android.libraries.navigation.internal.oe.d dVar = new com.google.android.libraries.navigation.internal.oe.d(jVar.a);
                        dVar.a = jVar.c;
                        ArrayList arrayList = new ArrayList();
                        ArrayList arrayList2 = new ArrayList();
                        for (Iterator it3 = listA.iterator(); it3.hasNext(); it3 = it3) {
                            a aVar3 = (a) it3.next();
                            bk[] bkVarArr4 = aVar3.b;
                            if (bkVarArr4 == null) {
                                dVar.a(aVar3.a, arrayList);
                                int size = arrayList.size();
                                int i15 = 0;
                                while (i15 < size) {
                                    list.add(new a((ad) arrayList.get(i15)));
                                    i15++;
                                    aiVar3 = aiVar3;
                                }
                                aiVar2 = aiVar3;
                            } else {
                                aiVar2 = aiVar3;
                                ad adVar2 = aVar3.a;
                                int length3 = bkVarArr4.length;
                                long[] jArr = new long[length3];
                                int i16 = 0;
                                while (i16 < length3) {
                                    jArr[i16] = aVar3.b[i16].a();
                                    i16++;
                                    length3 = length3;
                                }
                                dVar.b(adVar2, jArr, arrayList, arrayList2);
                                for (int i17 = 0; i17 < arrayList.size(); i17++) {
                                    list.add(new a((ad) arrayList.get(i17), (long[]) arrayList2.get(i17)));
                                }
                            }
                            arrayList.clear();
                            arrayList2.clear();
                            aiVar3 = aiVar2;
                        }
                        aiVar = aiVar3;
                    }
                    i = 1;
                    i2 = ((int) fO) + 1;
                    i3 = 0;
                    while (i3 < list.size()) {
                        i4 = i << (30 - i2);
                        aVar = (a) list.get(i3);
                        adVar = aVar.a;
                        bkVarArr = aVar.b;
                        iE2 = adVar.e();
                        zArr = new boolean[iE2];
                        float f = fO;
                        if (iE2 <= 2) {
                            Arrays.fill(zArr, true);
                        } else {
                            zArr[0] = true;
                            int i18 = iE2 - 1;
                            zArr[i18] = true;
                            float f2 = i4 / 256;
                            adVar.j(f2 * f2, 0, i18, new com.google.android.libraries.navigation.internal.oe.x(), new com.google.android.libraries.navigation.internal.oe.x(), new com.google.android.libraries.navigation.internal.oe.x(), new com.google.android.libraries.navigation.internal.oe.x(), zArr);
                        }
                        if (bkVarArr != null) {
                            i10 = 0;
                            while (i10 < iE2) {
                                bkVarArr3 = aVar.b;
                                int i19 = i2;
                                if (bkVarArr3 == null && i10 < bkVarArr3.length && (bkVarArr3[i10].a & 256) != 0) {
                                    zArr[i10] = true;
                                }
                                i10++;
                                i2 = i19;
                            }
                        }
                        int i20 = i2;
                        xVarL = adVar.l(0);
                        xVar = new com.google.android.libraries.navigation.internal.oe.x();
                        if (iE2 > 2) {
                            for (i9 = 1; i9 < iE2; i9++) {
                                if (zArr[i9]) {
                                    adVar.u(i9, xVar);
                                    if (xVar.equals(xVarL)) {
                                        zArr[i9] = false;
                                    } else {
                                        xVarL.W(xVar);
                                    }
                                }
                            }
                        }
                        i6 = 0;
                        for (i5 = 0; i5 < iE2; i5++) {
                            if (zArr[i5]) {
                                i6++;
                            }
                        }
                        if (i6 != adVar.e()) {
                            if (bkVarArr != null) {
                                bkVarArr2 = new bk[i6];
                            } else {
                                bkVarArr2 = null;
                            }
                            abVar = new com.google.android.libraries.navigation.internal.oe.ab(i6);
                            abVar.b = adVar.f;
                            i7 = 0;
                            i8 = 0;
                            while (i7 < iE2) {
                                if (zArr[i7]) {
                                    abVar.c(adVar.l(i7));
                                    if (bkVarArr2 != null && i7 < bkVarArr.length) {
                                        bkVarArr2[i8] = bkVarArr[i7];
                                    }
                                    i8++;
                                }
                                i7++;
                                zArr = zArr;
                            }
                            aVar = new a(abVar.a(), bkVarArr2);
                        }
                        list.set(i3, aVar);
                        i3++;
                        i2 = i20;
                        fO = f;
                        i = 1;
                    }
                    jVar.b = fH;
                    i12++;
                    length2 = i13;
                    i11 = i14;
                    aiVar3 = aiVar;
                }
                z = true;
                iE = aiVar3.e();
                int iD2 = aiVar3.d();
                int i110 = i11;
                if (iE <= 119304647) {
                    aiVar = aiVar3;
                    list.addAll(listA);
                    jVar.a.n(xVar2, xVar3);
                } else {
                    aiVar = aiVar3;
                    list.addAll(listA);
                    jVar.a.n(xVar2, xVar3);
                }
                i = 1;
                i2 = ((int) fO) + 1;
                i3 = 0;
                while (i3 < list.size()) {
                    i4 = i << (30 - i2);
                    aVar = (a) list.get(i3);
                    adVar = aVar.a;
                    bkVarArr = aVar.b;
                    iE2 = adVar.e();
                    zArr = new boolean[iE2];
                    float f3 = fO;
                    if (iE2 <= 2) {
                        Arrays.fill(zArr, true);
                    } else {
                        zArr[0] = true;
                        int i111 = iE2 - 1;
                        zArr[i111] = true;
                        float f4 = i4 / 256;
                        adVar.j(f4 * f4, 0, i111, new com.google.android.libraries.navigation.internal.oe.x(), new com.google.android.libraries.navigation.internal.oe.x(), new com.google.android.libraries.navigation.internal.oe.x(), new com.google.android.libraries.navigation.internal.oe.x(), zArr);
                    }
                    if (bkVarArr != null) {
                        i10 = 0;
                        while (i10 < iE2) {
                            bkVarArr3 = aVar.b;
                            int i112 = i2;
                            if (bkVarArr3 == null) {
                            }
                            i10++;
                            i2 = i112;
                        }
                    }
                    int i21 = i2;
                    xVarL = adVar.l(0);
                    xVar = new com.google.android.libraries.navigation.internal.oe.x();
                    if (iE2 > 2) {
                        while (i9 < iE2) {
                            if (zArr[i9]) {
                                adVar.u(i9, xVar);
                                if (xVar.equals(xVarL)) {
                                    zArr[i9] = false;
                                } else {
                                    xVarL.W(xVar);
                                }
                            }
                        }
                    }
                    i6 = 0;
                    while (i5 < iE2) {
                        if (zArr[i5]) {
                            i6++;
                        }
                    }
                    if (i6 != adVar.e()) {
                        if (bkVarArr != null) {
                            bkVarArr2 = new bk[i6];
                        } else {
                            bkVarArr2 = null;
                        }
                        abVar = new com.google.android.libraries.navigation.internal.oe.ab(i6);
                        abVar.b = adVar.f;
                        i7 = 0;
                        i8 = 0;
                        while (i7 < iE2) {
                            if (zArr[i7]) {
                                abVar.c(adVar.l(i7));
                                if (bkVarArr2 != null) {
                                    bkVarArr2[i8] = bkVarArr[i7];
                                }
                                i8++;
                            }
                            i7++;
                            zArr = zArr;
                        }
                        aVar = new a(abVar.a(), bkVarArr2);
                    }
                    list.set(i3, aVar);
                    i3++;
                    i2 = i21;
                    fO = f3;
                    i = 1;
                }
                jVar.b = fH;
                i12++;
                length2 = i13;
                i11 = i110;
                aiVar3 = aiVar;
            }
            float f5 = fO;
            ai aiVar4 = aiVar3;
            int i22 = i11;
            Iterator it4 = list.iterator();
            while (it4.hasNext()) {
                this.a.b((a) it4.next());
            }
            length += arVar.d.length;
            i11 = i22 + 1;
            aiVar3 = aiVar4;
            fO = f5;
        }
    }
}
