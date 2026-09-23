package com.google.android.apps.gmm.location.navigation;

import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes3.dex */
public final class at extends com.google.android.libraries.navigation.internal.kp.c {
    private final String a;

    public at(List list) {
        StringBuilder sb = new StringBuilder();
        Iterator it2 = list.iterator();
        String str = "";
        while (it2.hasNext()) {
            com.google.android.libraries.navigation.internal.acu.am amVar = (com.google.android.libraries.navigation.internal.acu.am) it2.next();
            sb.append(str);
            sb.append('H');
            int iA = com.google.android.libraries.navigation.internal.acu.ao.a(amVar.b);
            iA = iA == 0 ? com.google.android.libraries.navigation.internal.acu.ao.a : iA;
            if (iA == 0) {
                throw null;
            }
            sb.append(iA - 1);
            sb.append('b');
            sb.append(amVar.c);
            sb.append('c');
            sb.append(amVar.d);
            str = ", ";
        }
        this.a = sb.toString();
    }

    @Override // com.google.android.libraries.navigation.internal.kp.e, com.google.android.libraries.navigation.internal.ic.a
    public final boolean a() {
        return true;
    }

    @Override // com.google.android.libraries.navigation.internal.kp.c
    public final com.google.android.libraries.navigation.internal.kp.f c() {
        com.google.android.libraries.navigation.internal.kp.f fVar = new com.google.android.libraries.navigation.internal.kp.f("snapper-metrics");
        fVar.m("metrics", this.a);
        return fVar;
    }

    public final String toString() {
        return "snapper-metrics[" + this.a + "]";
    }
}
