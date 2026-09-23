package com.google.android.libraries.navigation.internal.ry;

import com.google.android.libraries.navigation.internal.rz.aa;
import com.google.android.libraries.navigation.internal.rz.ab;
import com.google.android.libraries.navigation.internal.rz.v;
import com.google.android.libraries.navigation.internal.rz.y;
import com.google.android.libraries.navigation.internal.rz.z;
import com.google.android.libraries.navigation.internal.yz.eq;
import com.google.android.libraries.navigation.internal.yz.ev;
import com.google.android.libraries.navigation.internal.yz.lv;
import java.util.Objects;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class b {
    public static v a(com.google.android.libraries.geo.navcore.ui.header.views.e[] eVarArr) {
        z zVar;
        com.google.android.libraries.navigation.internal.rz.c cVar = new com.google.android.libraries.navigation.internal.rz.c();
        int i = ev.d;
        ev evVar = lv.a;
        Objects.requireNonNull(evVar);
        if (cVar.a != null) {
            throw new IllegalStateException();
        }
        cVar.b = evVar;
        cVar.c = (byte) 1;
        for (com.google.android.libraries.geo.navcore.ui.header.views.e eVar : eVarArr) {
            y yVarD = ab.d();
            com.google.android.libraries.navigation.internal.um.b bVar = eVar.a;
            com.google.android.libraries.navigation.internal.um.b bVar2 = com.google.android.libraries.navigation.internal.um.b.STRAIGHT;
            switch (bVar) {
                case STRAIGHT:
                    zVar = z.STRAIGHT;
                    break;
                case STRAIGHT_TALL:
                    zVar = z.STRAIGHT_TALL;
                    break;
                case SLIGHT:
                    zVar = z.SLIGHT;
                    break;
                case SLIGHT_TALL:
                    zVar = z.SLIGHT_TALL;
                    break;
                case NORMAL:
                    zVar = z.NORMAL;
                    break;
                case NORMAL_SHORT:
                    zVar = z.NORMAL_SHORT;
                    break;
                case SHARP:
                    zVar = z.SHARP;
                    break;
                case SHARP_SHORT:
                    zVar = z.SHARP_SHORT;
                    break;
                case UTURN:
                    zVar = z.UTURN;
                    break;
                case UTURN_SHORT:
                    zVar = z.UTURN_SHORT;
                    break;
                case STUB:
                    zVar = z.STUB;
                    break;
                case DOTS:
                    zVar = z.UNKNOWN;
                    break;
                default:
                    zVar = z.UNKNOWN;
                    break;
            }
            yVarD.c(zVar);
            yVarD.d(eVar.b ? aa.SIDE_LEFT : aa.SIDE_RIGHT);
            yVarD.b(eVar.c);
            cVar.a().h(yVarD.a());
        }
        eq eqVar = cVar.a;
        if (eqVar != null) {
            cVar.b = eqVar.g();
        } else if (cVar.b == null) {
            cVar.b = lv.a;
        }
        if (cVar.c == 1) {
            return new com.google.android.libraries.navigation.internal.rz.d(cVar.b);
        }
        throw new IllegalStateException();
    }
}
