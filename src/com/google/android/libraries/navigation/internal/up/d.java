package com.google.android.libraries.navigation.internal.up;

import com.google.android.libraries.navigation.internal.bp.bs;
import com.google.android.libraries.navigation.internal.yz.eq;
import com.google.android.libraries.navigation.internal.yz.ev;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class d {
    public static Collection a(Collection collection, Set set) {
        if (collection.isEmpty()) {
            return collection;
        }
        HashSet hashSet = new HashSet();
        Iterator it2 = collection.iterator();
        while (it2.hasNext()) {
            bs bsVar = (bs) it2.next();
            String strF = bsVar.f();
            if (strF != null && bsVar.e() != null) {
                hashSet.add(strF);
            }
        }
        int i = ev.d;
        eq eqVar = new eq();
        Iterator it3 = collection.iterator();
        while (it3.hasNext()) {
            bs bsVar2 = (bs) it3.next();
            String strF2 = bsVar2.f();
            if (strF2 != null) {
                String strE = bsVar2.e();
                if (strE != null || !hashSet.contains(strF2)) {
                    if (strE != null) {
                        strF2 = strF2.concat(strE);
                    }
                    if (set.add(strF2)) {
                    }
                }
            }
            String strG = bsVar2.g();
            if (strG != null && set.add(strG)) {
                eqVar.h(bsVar2);
            }
        }
        return eqVar.g();
    }
}
