package com.google.android.libraries.navigation.internal.abh;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class ct extends com.google.android.libraries.navigation.internal.lz.i {
    private final ht a;
    private final com.google.android.libraries.navigation.internal.abm.aj b;
    private final com.google.android.libraries.navigation.internal.abm.ag c;

    public ct(com.google.android.libraries.navigation.internal.abm.aj ajVar, com.google.android.libraries.navigation.internal.abm.ag agVar, ht htVar) {
        com.google.android.libraries.navigation.internal.abf.s.k(ajVar, "indoorState");
        this.b = ajVar;
        com.google.android.libraries.navigation.internal.abf.s.k(agVar, "indoorBuilding");
        this.c = agVar;
        agVar.c();
        com.google.android.libraries.navigation.internal.abf.s.k(htVar, "log");
        this.a = htVar;
    }

    private final String g() {
        return ((com.google.android.libraries.navigation.internal.oe.j) this.c.c()).f();
    }

    @Override // com.google.android.libraries.navigation.internal.lz.j
    public final int a() {
        this.a.c(com.google.android.libraries.navigation.internal.abx.b.INDOOR_GET_ACTIVE_LEVEL);
        return this.b.b(this.c);
    }

    @Override // com.google.android.libraries.navigation.internal.lz.j
    public final int b() {
        this.a.c(com.google.android.libraries.navigation.internal.abx.b.INDOOR_GET_DEFAULT_LEVEL);
        return this.c.a();
    }

    @Override // com.google.android.libraries.navigation.internal.lz.j
    public final int c() {
        return hashCode();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.libraries.navigation.internal.lz.j
    public final List d() {
        com.google.android.libraries.navigation.internal.yz.ev evVarB = this.c.b();
        ArrayList arrayList = new ArrayList(evVarB.size());
        int size = evVarB.size();
        for (int i = 0; i < size; i++) {
            arrayList.add(new cu(this.b, (com.google.android.libraries.navigation.internal.abm.ah) evVarB.get(i), this.a));
        }
        return arrayList;
    }

    @Override // com.google.android.libraries.navigation.internal.lz.j
    public final boolean e(com.google.android.libraries.navigation.internal.lz.j jVar) {
        return equals(jVar);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ct) {
            return this.c.c().equals(((ct) obj).c.c());
        }
        return false;
    }

    @Override // com.google.android.libraries.navigation.internal.lz.j
    public final boolean f() {
        this.a.c(com.google.android.libraries.navigation.internal.abx.b.INDOOR_IS_UNDERGROUND);
        return this.c.d();
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{g()});
    }

    public final String toString() {
        com.google.android.libraries.navigation.internal.abf.aj ajVarF = com.google.android.libraries.navigation.internal.abf.aj.f(this);
        ajVarF.g("id", g());
        return ajVarF.c("number of level: ", this.c.b().size()).toString();
    }
}
