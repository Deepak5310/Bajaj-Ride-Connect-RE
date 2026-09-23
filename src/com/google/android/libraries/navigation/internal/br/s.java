package com.google.android.libraries.navigation.internal.br;

import com.google.android.libraries.navigation.internal.adr.ae;
import com.google.android.libraries.navigation.internal.adr.ai;
import com.google.android.libraries.navigation.internal.adr.aj;
import com.google.android.libraries.navigation.internal.adr.gk;
import com.google.android.libraries.navigation.internal.adr.gm;
import com.google.android.libraries.navigation.internal.adr.gn;
import com.google.android.libraries.navigation.internal.yx.aa;
import com.google.android.libraries.navigation.internal.yx.af;
import com.google.android.libraries.navigation.internal.yx.ah;
import com.google.android.libraries.navigation.internal.yx.aq;
import com.google.android.libraries.navigation.internal.yx.ar;
import com.google.android.libraries.navigation.internal.yz.de;
import java.util.Iterator;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class s {
    public static gn a(String str) {
        r rVar = new r();
        ai aiVar = rVar.b;
        if (!aiVar.b.H()) {
            aiVar.v();
        }
        aj ajVar = (aj) aiVar.b;
        aj ajVar2 = aj.a;
        ajVar.b |= 1;
        ajVar.c = str;
        gk gkVar = rVar.a;
        ai aiVar2 = rVar.b;
        if (!gkVar.b.H()) {
            gkVar.v();
        }
        gn gnVar = (gn) gkVar.b;
        aj ajVar3 = (aj) aiVar2.t();
        gn gnVar2 = gn.a;
        ajVar3.getClass();
        gnVar.d = ajVar3;
        gnVar.b |= 2;
        return (gn) gkVar.t();
    }

    public static String b(Iterable iterable) {
        ah ahVarE = ah.e(' ');
        return new af(ahVarE, ahVarE).g(de.d(iterable).e(new aa() { // from class: com.google.android.libraries.navigation.internal.br.q
            @Override // com.google.android.libraries.navigation.internal.yx.aa
            public final Object ak(Object obj) {
                gn gnVar = (gn) obj;
                ar.q(gnVar);
                aj ajVar = gnVar.d;
                if (ajVar == null) {
                    ajVar = aj.a;
                }
                return aq.a(ajVar.c.trim());
            }
        }).iterator());
    }

    /* JADX WARN: Code duplicated, block: B:26:0x0048  */
    public static String c(Iterable iterable) {
        com.google.android.libraries.navigation.internal.adr.ah ahVar;
        Iterator it2 = iterable.iterator();
        String str = null;
        while (it2.hasNext()) {
            gn gnVar = (gn) it2.next();
            if ((gnVar.b & 1) == 0) {
                ahVar = null;
            } else {
                int iA = gm.a(gnVar.c);
                if (iA == 0) {
                    iA = gm.a;
                }
                if ((iA == gm.b || iA == gm.f || iA == gm.g) && (gnVar.b & 4) != 0) {
                    ahVar = gnVar.e;
                    if (ahVar == null) {
                        ahVar = com.google.android.libraries.navigation.internal.adr.ah.a;
                    }
                    int iA2 = ae.a(ahVar.c);
                    if (iA2 == 0) {
                        iA2 = ae.a;
                    }
                    if (iA2 != ae.c) {
                        ahVar = null;
                    }
                } else {
                    ahVar = null;
                }
            }
            String str2 = (ahVar == null || (ahVar.b & 2) == 0) ? null : ahVar.d;
            if (str2 != null) {
                str = str2;
            }
        }
        return str;
    }

    /* JADX WARN: Code duplicated, block: B:27:0x0049  */
    public static String d(Iterable iterable) {
        String str;
        Iterator it2 = iterable.iterator();
        String str2 = null;
        while (it2.hasNext()) {
            gn gnVar = (gn) it2.next();
            int iA = gm.a(gnVar.c);
            if (iA == 0) {
                iA = gm.a;
            }
            if (iA != gm.g) {
                str = null;
            } else {
                com.google.android.libraries.navigation.internal.adr.ah ahVar = gnVar.e;
                if (ahVar == null) {
                    ahVar = com.google.android.libraries.navigation.internal.adr.ah.a;
                }
                int iA2 = ae.a(ahVar.c);
                if (iA2 == 0) {
                    iA2 = ae.a;
                }
                if (iA2 != ae.c) {
                    str = null;
                } else {
                    com.google.android.libraries.navigation.internal.adr.ah ahVar2 = gnVar.e;
                    if (ahVar2 == null) {
                        ahVar2 = com.google.android.libraries.navigation.internal.adr.ah.a;
                    }
                    if ((ahVar2.b & 4) != 0) {
                        com.google.android.libraries.navigation.internal.adr.ah ahVar3 = gnVar.e;
                        if (ahVar3 == null) {
                            ahVar3 = com.google.android.libraries.navigation.internal.adr.ah.a;
                        }
                        str = ahVar3.f;
                    } else {
                        str = null;
                    }
                }
            }
            if (str != null) {
                str2 = str;
            }
        }
        return str2;
    }
}
