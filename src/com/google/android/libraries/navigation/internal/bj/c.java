package com.google.android.libraries.navigation.internal.bj;

import com.google.android.libraries.navigation.internal.adr.bt;
import com.google.android.libraries.navigation.internal.adr.bu;
import com.google.android.libraries.navigation.internal.adr.bw;
import com.google.android.libraries.navigation.internal.adr.bx;
import com.google.android.libraries.navigation.internal.adr.by;
import com.google.android.libraries.navigation.internal.adr.kd;
import com.google.android.libraries.navigation.internal.yx.an;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class c {
    public static an a(kd kdVar) {
        switch (kdVar.ordinal()) {
            case 4:
            case 9:
                return an.j(1);
            case 5:
            case 10:
                return an.j(3);
            case 6:
            case 11:
                return an.j(5);
            case 7:
            case 12:
                return an.j(7);
            case 8:
            case 13:
                return an.j(9);
            case 14:
                return an.j(4);
            case 15:
                return an.j(6);
            case 16:
                return an.j(8);
            case 17:
                return an.j(0);
            case 18:
                return an.j(2);
            default:
                return com.google.android.libraries.navigation.internal.yx.a.a;
        }
    }

    public static an b(kd kdVar) {
        switch (kdVar.ordinal()) {
            case 4:
            case 9:
                return an.j(2);
            case 5:
            case 10:
                return an.j(4);
            case 6:
            case 11:
                return an.j(6);
            case 7:
            case 12:
                return an.j(8);
            case 8:
            case 13:
                return an.j(0);
            case 14:
                return an.j(5);
            case 15:
                return an.j(7);
            case 16:
                return an.j(9);
            case 17:
                return an.j(1);
            case 18:
                return an.j(3);
            default:
                return com.google.android.libraries.navigation.internal.yx.a.a;
        }
    }

    public static boolean c(bw bwVar) {
        return bwVar == bw.UNSET || bwVar == bw.UNKNOWN_LICENSE_PLATE_TYPE;
    }

    public static int d(bw bwVar) {
        if (bwVar == null) {
            return 0;
        }
        switch (bwVar.ordinal()) {
            case 2:
            case 3:
                return 1;
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
                return 2;
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
                return 3;
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
                return 4;
            default:
                return 0;
        }
    }

    public static void e(int i, bt btVar, bw bwVar) {
        int i2 = 0;
        if (c(bwVar) || d(bwVar) == i) {
            while (i2 < ((by) btVar.b).f.size()) {
                bw bwVarB = bw.b(((bx) ((by) btVar.b).f.get(i2)).c);
                if (bwVarB == null) {
                    bwVarB = bw.UNKNOWN_LICENSE_PLATE_TYPE;
                }
                if (d(bwVarB) == i) {
                    btVar.d(i2);
                    i2--;
                }
                i2++;
            }
            if (d(bwVar) == i) {
                bu buVar = (bu) bx.a.q();
                if (!buVar.b.H()) {
                    buVar.v();
                }
                bx bxVar = (bx) buVar.b;
                bxVar.c = bwVar.t;
                bxVar.b |= 1;
                btVar.c((bx) buVar.t());
            }
        }
    }
}
