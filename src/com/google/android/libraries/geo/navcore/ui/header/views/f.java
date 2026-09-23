package com.google.android.libraries.geo.navcore.ui.header.views;

import com.google.android.libraries.navigation.internal.adr.dr;
import com.google.android.libraries.navigation.internal.adr.dv;
import com.google.android.libraries.navigation.internal.bp.ar;
import com.google.android.libraries.navigation.internal.bp.at;
import com.google.android.libraries.navigation.internal.rz.aa;
import com.google.android.libraries.navigation.internal.rz.ab;
import com.google.android.libraries.navigation.internal.rz.z;
import com.google.android.libraries.navigation.internal.yz.ev;
import com.google.android.libraries.navigation.internal.yz.ez;
import com.google.android.libraries.navigation.internal.yz.fd;
import com.google.android.libraries.navigation.internal.yz.kc;
import com.google.android.libraries.navigation.internal.yz.lv;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes2.dex */
public final class f {
    public static final /* synthetic */ int a = 0;
    private static final fd b;
    private static final ar c;

    static {
        ez ezVar = new ez();
        ezVar.f(z.STRAIGHT, com.google.android.libraries.navigation.internal.um.b.STRAIGHT);
        ezVar.f(z.STRAIGHT_TALL, com.google.android.libraries.navigation.internal.um.b.STRAIGHT_TALL);
        ezVar.f(z.SLIGHT, com.google.android.libraries.navigation.internal.um.b.SLIGHT);
        ezVar.f(z.SLIGHT_TALL, com.google.android.libraries.navigation.internal.um.b.SLIGHT_TALL);
        ezVar.f(z.NORMAL, com.google.android.libraries.navigation.internal.um.b.NORMAL);
        ezVar.f(z.NORMAL_SHORT, com.google.android.libraries.navigation.internal.um.b.NORMAL_SHORT);
        ezVar.f(z.SHARP, com.google.android.libraries.navigation.internal.um.b.SHARP);
        ezVar.f(z.SHARP_SHORT, com.google.android.libraries.navigation.internal.um.b.SHARP_SHORT);
        ezVar.f(z.UTURN, com.google.android.libraries.navigation.internal.um.b.UTURN);
        ezVar.f(z.UTURN_SHORT, com.google.android.libraries.navigation.internal.um.b.UTURN_SHORT);
        ezVar.f(z.STUB, com.google.android.libraries.navigation.internal.um.b.STUB);
        b = kc.b(ezVar.d());
        int i = ev.d;
        c = new ar(0, lv.a);
    }

    public static List a(List list, int i, int i2) {
        if (i2 > 0) {
            list = list.subList(0, list.size() - i2);
            list.add(c);
        }
        if (i <= 0) {
            return list;
        }
        List listSubList = list.subList(i, list.size());
        listSubList.add(0, c);
        return listSubList;
    }

    public static e[][] b(ar arVar) {
        boolean z;
        int i;
        int i2;
        if (arVar == c) {
            e[][] eVarArr = (e[][]) Array.newInstance((Class<?>) e.class, 1, 1);
            eVarArr[0][0] = new e(com.google.android.libraries.navigation.internal.um.b.DOTS, false, false);
            return eVarArr;
        }
        boolean z2 = arVar.b == dr.a || arVar.b == dr.b;
        Iterator it2 = arVar.a.iterator();
        while (true) {
            if (!it2.hasNext()) {
                z = true;
                break;
            }
            if (((at) it2.next()).a != dv.U_TURN) {
                z = false;
                break;
            }
        }
        boolean z3 = true;
        int i3 = 0;
        int i4 = 0;
        for (at atVar : arVar.a) {
            if (atVar.a == dv.MERGE) {
                ((com.google.android.libraries.navigation.internal.zb.h) com.google.android.libraries.navigation.internal.sh.a.a.d(com.google.android.libraries.navigation.internal.nl.a.a).F((char) 1411)).p("Merge turns should never happen!");
            } else {
                dv dvVar = atVar.a;
                if (dvVar == dv.U_TURN && !z) {
                    if (z3 && z2) {
                        z = true;
                        z3 = true;
                    }
                }
                int iIntValue = ((Integer) com.google.android.libraries.navigation.internal.sh.a.c.get(dvVar)).intValue();
                if (!atVar.b) {
                    iIntValue = 6 - iIntValue;
                }
                i3 |= 1 << iIntValue;
                if (true == z3) {
                    i4 = iIntValue;
                }
                z3 = false;
            }
        }
        int[] iArr = com.google.android.libraries.navigation.internal.sh.a.b[i3];
        int length = iArr.length;
        ab[][] abVarArr = new ab[length][];
        if (i3 == 0) {
            ((com.google.android.libraries.navigation.internal.zb.h) com.google.android.libraries.navigation.internal.sh.a.a.d(com.google.android.libraries.navigation.internal.nl.a.a).F(1410)).s("Guidance resulted in empty turnMask: %s", arVar);
            abVarArr[0] = com.google.android.libraries.navigation.internal.sh.a.b();
        } else {
            int i5 = 0;
            for (int i6 : iArr) {
                if (!z2 || ((7 << (i4 * 3)) & i6) != 0) {
                    int i7 = 0;
                    int i8 = 0;
                    while (true) {
                        i = i5 + 1;
                        if (i8 >= 7) {
                            break;
                        }
                        if ((i6 & (7 << (i8 * 3))) != 0) {
                            i7++;
                        }
                        i8++;
                    }
                    if (i7 == 0) {
                        ((com.google.android.libraries.navigation.internal.zb.h) com.google.android.libraries.navigation.internal.sh.a.a.d(com.google.android.libraries.navigation.internal.nl.a.a).F(1409)).y("Invalid turn at index %d, attempt=0%o, turnMask=0x%x", Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i3));
                        abVarArr[i5] = com.google.android.libraries.navigation.internal.sh.a.b();
                    } else {
                        ab[] abVarArr2 = new ab[i7];
                        abVarArr[i5] = abVarArr2;
                        if (((7 << (i4 * 3)) & i6) != 0) {
                            abVarArr2[0] = com.google.android.libraries.navigation.internal.sh.a.a(i4, i6, arVar.b == dr.a, z);
                            i2 = 1;
                        } else {
                            i2 = 0;
                        }
                        for (int i9 = 0; i9 < 7; i9++) {
                            if (i9 != i4 && (i6 & (7 << (i9 * 3))) != 0) {
                                abVarArr[i5][i2] = com.google.android.libraries.navigation.internal.sh.a.a(i9, i6, false, false);
                                i2++;
                            }
                        }
                        if (i7 != i2) {
                            ((com.google.android.libraries.navigation.internal.zb.h) com.google.android.libraries.navigation.internal.sh.a.a.d(com.google.android.libraries.navigation.internal.nl.a.a).F(1408)).t("Turn size counter out-of-sync: %d vs %d", i7, i2);
                        }
                    }
                    i5 = i;
                }
            }
            if (i5 != length) {
                abVarArr = (ab[][]) Arrays.copyOf(abVarArr, i5);
            }
        }
        e[][] eVarArr2 = (e[][]) Array.newInstance((Class<?>) e.class, abVarArr.length, abVarArr[0].length);
        for (int i10 = 0; i10 < abVarArr.length; i10++) {
            for (int i11 = 0; i11 < abVarArr[0].length; i11++) {
                e[] eVarArr3 = eVarArr2[i10];
                ab abVar = abVarArr[i10][i11];
                com.google.android.libraries.navigation.internal.um.b bVar = (com.google.android.libraries.navigation.internal.um.b) b.get(abVar.a());
                com.google.android.libraries.navigation.internal.yx.ar.q(bVar);
                eVarArr3[i11] = new e(bVar, abVar.b().equals(aa.SIDE_LEFT), abVar.c());
            }
        }
        return eVarArr2;
    }
}
