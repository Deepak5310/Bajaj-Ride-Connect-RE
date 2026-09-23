package com.google.android.libraries.navigation.internal.bp;

import com.google.android.libraries.navigation.internal.adr.hs;
import java.util.Objects;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public abstract class bs {
    public static bs c(com.google.android.libraries.navigation.internal.adr.bh bhVar, hs hsVar) {
        hs hsVar2;
        if (bhVar == null || (bhVar.b & 1) == 0) {
            return null;
        }
        o oVar = new o();
        Objects.requireNonNull(hsVar);
        oVar.b = hsVar;
        Objects.requireNonNull(bhVar);
        oVar.a = bhVar;
        com.google.android.libraries.navigation.internal.adr.bh bhVar2 = oVar.a;
        if (bhVar2 == null || (hsVar2 = oVar.b) == null) {
            throw new IllegalStateException();
        }
        return new p(bhVar2, hsVar2);
    }

    public abstract com.google.android.libraries.navigation.internal.adr.bh a();

    public abstract hs b();

    public final com.google.android.libraries.navigation.internal.adr.bg d() {
        com.google.android.libraries.navigation.internal.adr.bg bgVarB = com.google.android.libraries.navigation.internal.adr.bg.b(a().c);
        return bgVarB == null ? com.google.android.libraries.navigation.internal.adr.bg.TYPE_TO_ROAD_NAME : bgVarB;
    }

    public final String e() {
        if ((a().b & 256) != 0) {
            return a().h;
        }
        return null;
    }

    public final String f() {
        if ((a().b & 64) != 0) {
            com.google.android.libraries.navigation.internal.adr.ah ahVar = a().f;
            if (ahVar == null) {
                ahVar = com.google.android.libraries.navigation.internal.adr.ah.a;
            }
            String strC = com.google.android.libraries.navigation.internal.br.g.c(ahVar, com.google.android.libraries.navigation.internal.br.g.c, com.google.android.libraries.navigation.internal.ady.u.a);
            if (strC != null) {
                return strC;
            }
        }
        if ((a().b & 128) != 0) {
            return a().g;
        }
        return null;
    }

    public final String g() {
        return a().d;
    }

    public final boolean h() {
        return d() == com.google.android.libraries.navigation.internal.adr.bg.TYPE_EXIT_NAME || d() == com.google.android.libraries.navigation.internal.adr.bg.TYPE_EXIT_NUMBER;
    }

    public final String toString() {
        com.google.android.libraries.navigation.internal.yx.ak akVarB = com.google.android.libraries.navigation.internal.yx.al.b(this);
        akVarB.h();
        akVarB.g("type", d().name());
        int iB = com.google.android.libraries.navigation.internal.adr.be.b(a().i);
        if (iB == 0) {
            iB = com.google.android.libraries.navigation.internal.adr.be.a;
        }
        String strA = com.google.android.libraries.navigation.internal.adr.be.a(iB);
        if (iB == 0) {
            throw null;
        }
        akVarB.g("priority", strA);
        akVarB.g("name", g());
        return akVarB.toString();
    }
}
