package com.google.android.libraries.navigation.internal.er;

import com.google.android.libraries.navigation.internal.ael.x;
import com.google.android.libraries.navigation.internal.jy.af;
import com.google.android.libraries.navigation.internal.yx.aq;
import java.util.Locale;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class s {
    public final com.google.android.libraries.navigation.internal.fu.a a;
    public final af b;
    public final com.google.android.libraries.navigation.internal.afo.a c;

    public s(com.google.android.libraries.navigation.internal.afo.a aVar, com.google.android.libraries.navigation.internal.fu.a aVar2, af afVar) {
        this.c = aVar;
        this.a = aVar2;
        this.b = afVar;
    }

    public static com.google.android.libraries.navigation.internal.aco.b a(com.google.android.libraries.navigation.internal.fu.a aVar, com.google.android.libraries.navigation.internal.db.n nVar, String str) {
        com.google.android.libraries.navigation.internal.aes.h hVarO = nVar != null ? nVar.o() : null;
        com.google.android.libraries.navigation.internal.aco.a aVar2 = (com.google.android.libraries.navigation.internal.aco.a) com.google.android.libraries.navigation.internal.aco.b.a.q();
        String string = Locale.getDefault().toString();
        if (!aVar2.b.H()) {
            aVar2.v();
        }
        com.google.android.libraries.navigation.internal.aco.b bVar = (com.google.android.libraries.navigation.internal.aco.b) aVar2.b;
        string.getClass();
        bVar.b |= 1;
        bVar.c = string;
        String strB = aVar.b();
        if (!aq.c(strB)) {
            if (!aVar2.b.H()) {
                aVar2.v();
            }
            com.google.android.libraries.navigation.internal.aco.b bVar2 = (com.google.android.libraries.navigation.internal.aco.b) aVar2.b;
            strB.getClass();
            bVar2.b |= 2;
            bVar2.d = strB;
        }
        if (aVar.e() && hVarO != null) {
            if (!aVar2.b.H()) {
                aVar2.v();
            }
            com.google.android.libraries.navigation.internal.aco.b bVar3 = (com.google.android.libraries.navigation.internal.aco.b) aVar2.b;
            bVar3.e = hVarO;
            bVar3.b |= 4;
        }
        if (str != null) {
            if (!aVar2.b.H()) {
                aVar2.v();
            }
            com.google.android.libraries.navigation.internal.aco.b bVar4 = (com.google.android.libraries.navigation.internal.aco.b) aVar2.b;
            bVar4.b |= 64;
            bVar4.h = str;
        }
        x xVar = x.b;
        if (!aVar2.b.H()) {
            aVar2.v();
        }
        com.google.android.libraries.navigation.internal.aco.b bVar5 = (com.google.android.libraries.navigation.internal.aco.b) aVar2.b;
        xVar.getClass();
        bVar5.b |= 16;
        bVar5.g = xVar;
        if (!aVar2.b.H()) {
            aVar2.v();
        }
        com.google.android.libraries.navigation.internal.aco.b bVar6 = (com.google.android.libraries.navigation.internal.aco.b) aVar2.b;
        bVar6.b |= 128;
        bVar6.i = true;
        return (com.google.android.libraries.navigation.internal.aco.b) aVar2.t();
    }
}
