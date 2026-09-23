package com.google.android.libraries.navigation.internal.zd;

import java.util.Iterator;
import java.util.Set;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class x {
    private static final t a = new v();
    private static final s b = new w();

    public static u a(Set set) {
        q qVar = new q(a);
        qVar.f = b;
        Iterator it2 = set.iterator();
        while (it2.hasNext()) {
            com.google.android.libraries.navigation.internal.zb.ac acVar = (com.google.android.libraries.navigation.internal.zb.ac) it2.next();
            com.google.android.libraries.navigation.internal.zj.b.d(acVar, "key");
            if (acVar.b) {
                s sVar = q.b;
                com.google.android.libraries.navigation.internal.zj.b.d(acVar, "key");
                com.google.android.libraries.navigation.internal.zj.b.a(acVar.b, "key must be repeating");
                qVar.c.remove(acVar);
                qVar.d.put(acVar, sVar);
            } else {
                t tVar = q.a;
                com.google.android.libraries.navigation.internal.zj.b.d(acVar, "key");
                qVar.d.remove(acVar);
                qVar.c.put(acVar, tVar);
            }
        }
        return new r(qVar);
    }
}
