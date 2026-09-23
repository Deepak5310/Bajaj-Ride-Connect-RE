package com.google.android.libraries.navigation.internal.ca;

import com.google.android.libraries.navigation.internal.gw.x;
import com.google.android.libraries.navigation.internal.nc.ah;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class d {
    public ah a;
    public ah b;
    private final com.google.android.libraries.navigation.internal.bn.b c;
    private final com.google.android.libraries.navigation.internal.bn.b d;
    private final com.google.android.libraries.navigation.internal.bn.b e;

    private d(String str, String str2, com.google.android.libraries.navigation.internal.bn.d dVar, com.google.android.libraries.navigation.internal.bn.b bVar) {
        b bVar2 = new b(this);
        this.d = bVar2;
        c cVar = new c(this);
        this.e = cVar;
        this.c = bVar;
        this.a = dVar.d(str, x.c, bVar2);
        this.b = dVar.d(str2, x.c, cVar);
    }

    public static ah a(String str, String str2, com.google.android.libraries.navigation.internal.bn.d dVar, com.google.android.libraries.navigation.internal.bn.b bVar) {
        if (str == null) {
            return null;
        }
        return str2 == null ? dVar.d(str, x.c, bVar) : new d(str, str2, dVar, bVar).c();
    }

    private final ah c() {
        ah ahVar = this.a;
        if (ahVar == null) {
            return null;
        }
        ah ahVar2 = this.b;
        return ahVar2 == null ? ahVar : com.google.android.libraries.navigation.internal.af.e.d(ahVar, ahVar2);
    }

    public final void b() {
        ah ahVarC = c();
        if (ahVarC != null) {
            this.c.a(ahVarC);
        }
    }
}
