package com.google.android.libraries.navigation.internal.ry;

import com.google.android.libraries.navigation.internal.rz.am;
import com.google.android.libraries.navigation.internal.rz.an;
import com.google.android.libraries.navigation.internal.sa.f;
import com.google.android.libraries.navigation.internal.sa.g;
import com.google.android.libraries.navigation.internal.sa.h;
import com.google.android.libraries.navigation.internal.yz.eq;
import com.google.android.libraries.navigation.internal.yz.ev;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class c {
    /* JADX WARN: Multi-variable type inference failed */
    public static final ev a(h hVar, h hVar2) {
        ev evVarB = b(hVar);
        ev evVarB2 = b(hVar2);
        h hVarA = h.f().a();
        int i = ev.d;
        eq eqVar = new eq();
        if (evVarB.isEmpty()) {
            int size = evVarB2.size();
            for (int i2 = 0; i2 < size; i2++) {
                eqVar.h(new e(hVarA, (h) evVarB2.get(i2)));
            }
            return eqVar.g().h();
        }
        if (!c(evVarB, 0)) {
            eqVar.h(new e((h) evVarB.get(0), hVarA));
        }
        if (evVarB.size() == 1) {
            int size2 = evVarB2.size();
            for (int i3 = 0; i3 < size2; i3++) {
                eqVar.h(new e((h) evVarB.get(0), (h) evVarB2.get(i3)));
            }
            return eqVar.g().h();
        }
        if (evVarB.size() >= 2 && !c(evVarB, 1)) {
            eqVar.h(new e((h) evVarB.get(1), hVarA));
            if (!evVarB2.isEmpty()) {
                eqVar.h(new e((h) evVarB.get(1), (h) evVarB2.get(0)));
            }
        }
        if (evVarB.size() == 2) {
            for (int i4 = 1; i4 < evVarB2.size(); i4++) {
                eqVar.h(new e((h) evVarB.get(1), (h) evVarB2.get(i4)));
            }
            return eqVar.g().h();
        }
        for (int i5 = 2; i5 < evVarB.size(); i5++) {
            if (!c(evVarB, i5)) {
                if (evVarB2.isEmpty() || eqVar.g().isEmpty()) {
                    eqVar.h(new e((h) evVarB.get(i5), hVarA));
                }
                int size3 = evVarB2.size();
                for (int i6 = 0; i6 < size3; i6++) {
                    eqVar.h(new e((h) evVarB.get(i5), (h) evVarB2.get(i6)));
                }
            }
        }
        return eqVar.g().h();
    }

    private static ev b(h hVar) {
        int i = ev.d;
        eq eqVar = new eq();
        com.google.android.libraries.navigation.internal.sa.d dVar = (com.google.android.libraries.navigation.internal.sa.d) hVar;
        ArrayList arrayList = new ArrayList(dVar.a);
        g gVarF = h.f();
        gVarF.f(dVar.b);
        gVarF.e(dVar.c);
        gVarF.d(dVar.d);
        gVarF.c(dVar.e);
        while (!arrayList.isEmpty()) {
            gVarF.g(ev.o(arrayList));
            eqVar.h(gVarF.a());
            arrayList.remove(arrayList.size() - 1);
        }
        return eqVar.g().h();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static boolean c(List list, int i) {
        if (i >= list.size() - 1) {
            return false;
        }
        ev evVarA = ((h) list.get(i)).a();
        int size = evVarA.size();
        for (int i2 = 0; i2 < size; i2++) {
            am amVarB = ((an) ((f) evVarA.get(i2)).a().get(0)).b();
            if (amVarB != am.ROAD_BADGE && amVarB != am.EXIT_NUMBER) {
                return false;
            }
        }
        return true;
    }
}
