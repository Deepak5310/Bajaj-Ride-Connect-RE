package com.google.android.libraries.navigation.internal.xe;

import com.google.android.gms.maps.model.LatLng;
import com.google.android.libraries.navigation.DisplayOptions;
import com.google.android.libraries.navigation.Waypoint;
import com.google.android.libraries.navigation.internal.adr.lj;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class z {
    public static com.google.android.libraries.navigation.internal.ed.a a(int i) {
        if (i != 1) {
            return i != 2 ? com.google.android.libraries.navigation.internal.ed.a.AUTO : com.google.android.libraries.navigation.internal.ed.a.FORCE_NIGHT;
        }
        return com.google.android.libraries.navigation.internal.ed.a.FORCE_DAY;
    }

    public static com.google.android.libraries.navigation.internal.si.d b(DisplayOptions displayOptions) {
        com.google.android.libraries.navigation.internal.si.c cVarB = com.google.android.libraries.navigation.internal.si.d.b();
        cVarB.b(displayOptions.getHideDestinationMarkers());
        return cVarB.a();
    }

    public static Waypoint c(com.google.android.libraries.navigation.internal.bp.ck ckVar) {
        if (!ckVar.Y()) {
            if (ckVar.w() != null) {
                try {
                    return Waypoint.c(ckVar.w(), ckVar.y());
                } catch (Waypoint.UnsupportedPlaceIdException unused) {
                }
            }
            return null;
        }
        if (com.google.android.libraries.navigation.internal.yx.aq.c(ckVar.w())) {
            com.google.android.libraries.navigation.internal.oe.r rVarN = ckVar.n();
            return Waypoint.b(rVarN.a, rVarN.b, ckVar.y());
        }
        com.google.android.libraries.navigation.internal.bp.cj cjVarM = com.google.android.libraries.navigation.internal.bp.ck.M();
        com.google.android.libraries.navigation.internal.bp.t tVar = (com.google.android.libraries.navigation.internal.bp.t) cjVarM;
        tVar.c = ckVar.n();
        tVar.d = ckVar.w();
        tVar.f = ckVar.y();
        cjVarM.u();
        if (!com.google.android.libraries.navigation.internal.yx.aq.c(ckVar.y())) {
            cjVarM.m(lj.ENTITY_TYPE_NICKNAME);
        }
        return new Waypoint(cjVarM.B());
    }

    public static List d(List list) {
        ArrayList arrayList = new ArrayList();
        Iterator it2 = list.iterator();
        while (it2.hasNext()) {
            com.google.android.libraries.navigation.internal.oe.r rVar = (com.google.android.libraries.navigation.internal.oe.r) it2.next();
            arrayList.add(new LatLng(rVar.a, rVar.b));
        }
        return arrayList;
    }
}
