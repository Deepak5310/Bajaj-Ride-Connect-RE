package com.google.android.libraries.navigation.internal.cl;

import com.google.android.libraries.navigation.internal.adr.cg;
import com.google.android.libraries.navigation.internal.yz.lo;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class bp {
    public final bh a;
    private final com.google.android.libraries.navigation.internal.hn.r b;

    public bp(bh bhVar, com.google.android.libraries.navigation.internal.hn.r rVar) {
        this.b = rVar;
        this.a = bhVar;
    }

    public final boolean b(int i) {
        com.google.android.libraries.navigation.internal.afl.bh bhVar = (com.google.android.libraries.navigation.internal.afl.bh) this.b.b();
        if (i == 0) {
            throw null;
        }
        int i2 = i - 1;
        if (i2 == 1) {
            return bhVar.e;
        }
        if (i2 == 2) {
            return (bhVar.b & 4) != 0;
        }
        if (i2 == 3 || i2 == 4) {
            return bhVar.h;
        }
        return i2 != 5;
    }

    public static String a(cg cgVar, boolean z, boolean z2) {
        com.google.android.libraries.navigation.internal.br.k kVarB;
        String str;
        if ((cgVar.b & 4) != 0) {
            if (z2) {
                com.google.android.libraries.navigation.internal.adr.ah ahVar = cgVar.e;
                if (ahVar == null) {
                    ahVar = com.google.android.libraries.navigation.internal.adr.ah.a;
                }
                lo loVar = com.google.android.libraries.navigation.internal.br.l.a;
                com.google.android.libraries.navigation.internal.br.c cVar = new com.google.android.libraries.navigation.internal.br.c();
                cVar.a = com.google.android.libraries.navigation.internal.br.g.c(ahVar, com.google.android.libraries.navigation.internal.br.g.b, com.google.android.libraries.navigation.internal.ady.u.g);
                cVar.b = com.google.android.libraries.navigation.internal.br.g.c(ahVar, com.google.android.libraries.navigation.internal.br.g.b, com.google.android.libraries.navigation.internal.ady.u.h);
                kVarB = cVar.a();
            } else {
                com.google.android.libraries.navigation.internal.adr.ah ahVar2 = cgVar.e;
                if (ahVar2 == null) {
                    ahVar2 = com.google.android.libraries.navigation.internal.adr.ah.a;
                }
                kVarB = com.google.android.libraries.navigation.internal.br.l.b(ahVar2);
            }
            if (z && (str = ((com.google.android.libraries.navigation.internal.br.d) kVarB).b) != null) {
                return str;
            }
            String str2 = ((com.google.android.libraries.navigation.internal.br.d) kVarB).a;
            if (str2 != null) {
                return str2;
            }
        }
        return cgVar.c;
    }
}
