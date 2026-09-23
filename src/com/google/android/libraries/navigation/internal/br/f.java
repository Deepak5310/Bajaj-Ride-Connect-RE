package com.google.android.libraries.navigation.internal.br;

import com.google.android.libraries.geo.mapcore.renderer.cn;
import com.google.android.libraries.navigation.internal.adg.da;
import com.google.android.libraries.navigation.internal.adg.db;
import com.google.android.libraries.navigation.internal.adg.fj;
import com.google.android.libraries.navigation.internal.adg.fk;
import com.google.android.libraries.navigation.internal.adg.fx;
import com.google.android.libraries.navigation.internal.adg.ga;
import com.google.android.libraries.navigation.internal.adg.ic;
import com.google.android.libraries.navigation.internal.adg.id;
import com.google.android.libraries.navigation.internal.ael.bi;
import com.google.android.libraries.navigation.internal.ael.bq;
import com.google.android.libraries.navigation.internal.yx.ar;
import com.google.android.libraries.navigation.internal.yz.ev;
import com.google.android.libraries.navigation.internal.yz.lv;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class f {
    public static final int[] a = {0, 4, 8, 16};
    public static final int[] b = {12, 14, 17, 19};
    private static final int[] c = {2, 3, 5, 8};
    private static final int[] d = {3, 5, 7, 10};
    private static final int[] e = {0, 0, 0, 0};
    private static final ev f;

    static {
        int i = ev.d;
        f = lv.a;
    }

    public static ga a(int i, int i2, cn cnVar) {
        return c(0, i, i2, f, cnVar, null, c, d, e, a);
    }

    public static List b(int[] iArr, float f2, int[] iArr2) {
        ar.k(iArr.length == iArr2.length);
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < iArr.length; i++) {
            arrayList.add(new b(Math.round(iArr[i] * f2), iArr2[i]));
        }
        return arrayList;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static ga c(int i, int i2, int i3, List list, cn cnVar, String str, int[] iArr, int[] iArr2, int[] iArr3, int[] iArr4) {
        int length = iArr.length;
        int length2 = iArr4.length;
        int i4 = 1;
        ar.a(length == length2);
        ar.a(iArr2.length == length2);
        ar.a(iArr3.length == length2);
        List listB = b(iArr, 1.0f, iArr4);
        List listB2 = b(iArr2, 1.0f, iArr4);
        List listB3 = b(iArr3, 1.0f, iArr4);
        ar.k(listB.size() == listB2.size());
        ar.k(listB.size() == listB3.size());
        fx fxVar = (fx) ga.a.q();
        int i5 = 0;
        while (i5 < listB.size()) {
            e eVar = (e) listB.get(i5);
            e eVar2 = (e) listB2.get(i5);
            e eVar3 = (e) listB3.get(i5);
            ar.k(eVar.b() == eVar2.b() ? i4 : 0);
            ar.k(eVar.b() == eVar3.b() ? i4 : 0);
            fj fjVar = (fj) fk.a.q();
            ic icVar = (ic) id.a.q();
            int iA = eVar3.a() * 8;
            if (!icVar.b.H()) {
                icVar.v();
            }
            id idVar = (id) icVar.b;
            idVar.b |= 8;
            idVar.e = iA;
            if (!icVar.b.H()) {
                icVar.v();
            }
            id idVar2 = (id) icVar.b;
            idVar2.b |= i4;
            idVar2.c = i;
            fjVar.c(icVar);
            ic icVar2 = (ic) id.a.q();
            int iA2 = eVar2.a() * 8;
            if (!icVar2.b.H()) {
                icVar2.v();
            }
            id idVar3 = (id) icVar2.b;
            idVar3.b |= 8;
            idVar3.e = iA2;
            if (!icVar2.b.H()) {
                icVar2.v();
            }
            id idVar4 = (id) icVar2.b;
            idVar4.b |= i4;
            idVar4.c = i2;
            fjVar.c(icVar2);
            ic icVar3 = (ic) id.a.q();
            int iA3 = eVar.a() * 8;
            if (!icVar3.b.H()) {
                icVar3.v();
            }
            id idVar5 = (id) icVar3.b;
            idVar5.b |= 8;
            idVar5.e = iA3;
            if (!icVar3.b.H()) {
                icVar3.v();
            }
            id idVar6 = (id) icVar3.b;
            idVar6.b |= i4;
            idVar6.c = i3;
            if (!icVar3.b.H()) {
                icVar3.v();
            }
            id idVar7 = (id) icVar3.b;
            bq bqVar = idVar7.f;
            if (!bqVar.c()) {
                idVar7.f = bi.w(bqVar);
            }
            com.google.android.libraries.navigation.internal.ael.b.m(list, idVar7.f);
            fjVar.c(icVar3);
            int i6 = cnVar.k;
            if (!fjVar.b.H()) {
                fjVar.v();
            }
            fk fkVar = (fk) fjVar.b;
            fkVar.b |= 4;
            fkVar.g = i6;
            if (str != null) {
                ic icVar4 = (ic) id.a.q();
                int iA4 = eVar.a() * 8;
                if (!icVar4.b.H()) {
                    icVar4.v();
                }
                id idVar8 = (id) icVar4.b;
                idVar8.b |= 8;
                idVar8.e = iA4;
                if (!icVar4.b.H()) {
                    icVar4.v();
                }
                id idVar9 = (id) icVar4.b;
                idVar9.b |= 64;
                idVar9.h = str;
                fjVar.c(icVar4);
            } else {
                ic icVar5 = (ic) id.a.q();
                if (!icVar5.b.H()) {
                    icVar5.v();
                }
                id idVar10 = (id) icVar5.b;
                idVar10.b |= 8;
                idVar10.e = 0;
                if (!icVar5.b.H()) {
                    icVar5.v();
                }
                id idVar11 = (id) icVar5.b;
                idVar11.b |= 1;
                idVar11.c = 0;
                fjVar.c(icVar5);
            }
            da daVar = (da) db.a.q();
            int iB = eVar.b();
            if (!daVar.b.H()) {
                daVar.v();
            }
            db dbVar = (db) daVar.b;
            dbVar.b |= 1;
            dbVar.c = iB;
            if (!daVar.b.H()) {
                daVar.v();
            }
            db dbVar2 = (db) daVar.b;
            fk fkVar2 = (fk) fjVar.t();
            fkVar2.getClass();
            dbVar2.f = fkVar2;
            dbVar2.b |= 8;
            fxVar.c(daVar);
            i5++;
            listB = listB;
            i4 = 1;
        }
        return (ga) fxVar.t();
    }
}
