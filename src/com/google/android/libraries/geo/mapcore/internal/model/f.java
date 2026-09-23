package com.google.android.libraries.geo.mapcore.internal.model;

import com.google.android.libraries.navigation.internal.yz.gz;
import com.google.android.libraries.navigation.internal.yz.hb;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes2.dex */
public final class f {
    public static final Comparator a = new Comparator() { // from class: com.google.android.libraries.geo.mapcore.internal.model.e
        @Override // java.util.Comparator
        public final int compare(Object obj, Object obj2) {
            com.google.android.libraries.navigation.internal.adg.w wVar = (com.google.android.libraries.navigation.internal.adg.w) obj;
            com.google.android.libraries.navigation.internal.adg.w wVar2 = (com.google.android.libraries.navigation.internal.adg.w) obj2;
            return com.google.android.libraries.navigation.internal.yz.ck.b.c(wVar.b, wVar2.b).c(wVar.c, wVar2.c).a();
        }
    };
    public final com.google.android.libraries.navigation.internal.agg.bz b;

    public f(com.google.android.libraries.navigation.internal.adg.aa aaVar) {
        if (aaVar.b.size() != aaVar.c.size()) {
            aaVar.b.size();
            aaVar.c.size();
        }
        int iMin = Math.min(aaVar.b.size(), aaVar.c.size());
        this.b = new com.google.android.libraries.navigation.internal.agg.bz(iMin);
        for (int i = 0; i < iMin; i++) {
            int iD = aaVar.b.d(i);
            int iD2 = aaVar.c.d(i);
            if (iD2 < 0 || iD2 >= aaVar.d.size()) {
                aaVar.d.size();
            } else {
                this.b.a(iD, ((com.google.android.libraries.navigation.internal.adg.z) aaVar.d.get(iD2)).b);
            }
        }
    }

    public static boolean a(List list, com.google.android.libraries.navigation.internal.adg.ag agVar) {
        if (list.isEmpty()) {
            return false;
        }
        int iA = com.google.android.libraries.navigation.internal.adg.ai.a(agVar.c);
        if (iA == 0) {
            iA = com.google.android.libraries.navigation.internal.adg.ai.c;
        }
        if (iA == 0) {
            throw null;
        }
        int i = iA - 1;
        if (i == 1) {
            Iterator it2 = agVar.b.iterator();
            while (it2.hasNext()) {
                if (b(list, (com.google.android.libraries.navigation.internal.adg.ac) it2.next())) {
                    return true;
                }
            }
            return false;
        }
        if (i != 2 || agVar.b.isEmpty()) {
            return false;
        }
        Iterator it3 = agVar.b.iterator();
        while (it3.hasNext()) {
            if (!b(list, (com.google.android.libraries.navigation.internal.adg.ac) it3.next())) {
                return false;
            }
        }
        return true;
    }

    private static boolean b(List list, com.google.android.libraries.navigation.internal.adg.ac acVar) {
        int iA = com.google.android.libraries.navigation.internal.adg.ai.a(acVar.c);
        if (iA == 0) {
            iA = com.google.android.libraries.navigation.internal.adg.ai.b;
        }
        if (iA == 0) {
            throw null;
        }
        int i = iA - 1;
        if (i == 1) {
            com.google.android.libraries.navigation.internal.ael.bz bzVar = acVar.b;
            if (!list.isEmpty() && !bzVar.isEmpty()) {
                gz gzVarI = hb.i(list.iterator());
                gz gzVarI2 = hb.i(bzVar.iterator());
                while (gzVarI.hasNext() && gzVarI2.hasNext()) {
                    int iCompare = a.compare((com.google.android.libraries.navigation.internal.adg.w) gzVarI.a(), (com.google.android.libraries.navigation.internal.adg.w) gzVarI2.a());
                    if (iCompare == 0) {
                        return true;
                    }
                    if (iCompare < 0) {
                        gzVarI.next();
                    } else {
                        gzVarI2.next();
                    }
                }
            }
            return false;
        }
        if (i != 2) {
            return false;
        }
        com.google.android.libraries.navigation.internal.ael.bz bzVar2 = acVar.b;
        if (!list.isEmpty() && !bzVar2.isEmpty()) {
            gz gzVarI3 = hb.i(list.iterator());
            gz gzVarI4 = hb.i(bzVar2.iterator());
            while (gzVarI3.hasNext() && gzVarI4.hasNext()) {
                int iCompare2 = a.compare((com.google.android.libraries.navigation.internal.adg.w) gzVarI3.a(), (com.google.android.libraries.navigation.internal.adg.w) gzVarI4.a());
                if (iCompare2 == 0) {
                    gzVarI3.next();
                    gzVarI4.next();
                } else if (iCompare2 < 0) {
                    gzVarI3.next();
                }
            }
            if (!gzVarI4.hasNext()) {
                return true;
            }
        }
        return false;
    }
}
