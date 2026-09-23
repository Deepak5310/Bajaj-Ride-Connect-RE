package com.google.android.libraries.navigation.internal.br;

import com.google.android.libraries.navigation.internal.adr.ag;
import com.google.android.libraries.navigation.internal.adr.ah;
import com.google.android.libraries.navigation.internal.yz.fy;
import com.google.android.libraries.navigation.internal.yz.mq;
import java.util.Collection;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class g {
    public static final fy a = new mq(com.google.android.libraries.navigation.internal.ady.s.SVG);
    public static final fy b = new mq(com.google.android.libraries.navigation.internal.ady.s.PNG);
    public static final fy c = fy.q(com.google.android.libraries.navigation.internal.ady.s.SVG, com.google.android.libraries.navigation.internal.ady.s.PNG);

    public static String a(String str) {
        return (str.startsWith("http:") || str.startsWith("https:")) ? str : "https:".concat(String.valueOf(str));
    }

    public static void b(Collection collection, ah ahVar) {
        for (ag agVar : ahVar.e) {
            if ((agVar.b & 1) != 0) {
                collection.add(a(agVar.c));
            }
        }
    }

    public static String c(ah ahVar, fy fyVar, int i) {
        if (ahVar.e.size() == 0) {
            return null;
        }
        for (ag agVar : ahVar.e) {
            com.google.android.libraries.navigation.internal.ady.s sVarB = com.google.android.libraries.navigation.internal.ady.s.b(agVar.d);
            if (sVarB == null) {
                sVarB = com.google.android.libraries.navigation.internal.ady.s.PNG;
            }
            if (fyVar.contains(sVarB)) {
                int iA = com.google.android.libraries.navigation.internal.ady.u.a(agVar.e);
                if (iA == 0) {
                    iA = com.google.android.libraries.navigation.internal.ady.u.a;
                }
                if (iA == i && (agVar.b & 1) != 0) {
                    String str = agVar.c;
                    if (!str.isEmpty()) {
                        return a(str);
                    }
                }
            }
        }
        return null;
    }
}
