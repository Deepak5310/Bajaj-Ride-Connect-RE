package com.google.android.libraries.navigation.internal.pa;

import com.google.android.libraries.navigation.internal.adg.hg;
import com.google.android.libraries.navigation.internal.adg.hj;
import com.google.android.libraries.navigation.internal.adg.hk;
import com.google.android.libraries.navigation.internal.agg.ez;
import com.google.android.libraries.navigation.internal.rc.f;
import java.util.List;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class a {
    public static void a(List list, ez ezVar, f fVar) {
        for (int i = 0; i < list.size(); i++) {
            hg hgVar = (hg) list.get(i);
            int i2 = 0;
            while (true) {
                hk hkVar = hgVar.e;
                if (hkVar == null) {
                    hkVar = hk.a;
                }
                if (i2 >= hkVar.d.size()) {
                    break;
                }
                hk hkVar2 = hgVar.e;
                if (hkVar2 == null) {
                    hkVar2 = hk.a;
                }
                int iD = hkVar2.d.d(i2);
                if (ezVar.f(iD)) {
                    d(hgVar, iD, fVar);
                }
                i2++;
            }
            int i3 = 0;
            while (true) {
                hk hkVar3 = hgVar.e;
                if (hkVar3 == null) {
                    hkVar3 = hk.a;
                }
                if (i3 < hkVar3.b.size()) {
                    hk hkVar4 = hgVar.e;
                    if (hkVar4 == null) {
                        hkVar4 = hk.a;
                    }
                    int iD2 = hkVar4.b.d(i3);
                    if (ezVar.f(iD2)) {
                        d(hgVar, iD2, fVar);
                    }
                    i3++;
                }
            }
        }
    }

    public static boolean b(hg hgVar, ez ezVar) {
        hk hkVar = hgVar.e;
        if (hkVar == null) {
            hkVar = hk.a;
        }
        return e(hkVar, 2, ezVar);
    }

    public static boolean c(hg hgVar, ez ezVar) {
        hk hkVar = hgVar.e;
        if (hkVar == null) {
            hkVar = hk.a;
        }
        hk hkVar2 = hgVar.e;
        if (hkVar2 == null) {
            hkVar2 = hk.a;
        }
        if (e(hkVar2, 3, ezVar)) {
            return false;
        }
        if (hkVar.b.size() != 0) {
            hk hkVar3 = hgVar.e;
            if (hkVar3 == null) {
                hkVar3 = hk.a;
            }
            if (!e(hkVar3, 1, ezVar)) {
                hk hkVar4 = hgVar.e;
                if (hkVar4 == null) {
                    hkVar4 = hk.a;
                }
                return e(hkVar4, 2, ezVar);
            }
        }
        return true;
    }

    private static void d(hg hgVar, int i, f fVar) {
        hk hkVar = hgVar.e;
        if (hkVar == null) {
            hkVar = hk.a;
        }
        for (hj hjVar : hkVar.e) {
            if (hjVar.b == i) {
                fVar.a(hjVar.c);
            }
        }
    }

    private static boolean e(hk hkVar, int i, ez ezVar) {
        int i2 = i - 1;
        int size = i2 != 0 ? i2 != 1 ? hkVar.c.size() : hkVar.d.size() : hkVar.b.size();
        for (int i3 = 0; i3 < size; i3++) {
            if (ezVar.f(i2 != 0 ? i2 != 1 ? hkVar.c.d(i3) : hkVar.d.d(i3) : hkVar.b.d(i3))) {
                return true;
            }
        }
        return false;
    }
}
