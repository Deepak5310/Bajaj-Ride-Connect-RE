package com.google.android.libraries.navigation.internal.abh;

import java.util.Arrays;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class cu extends com.google.android.libraries.navigation.internal.lz.k {
    private final ht a;
    private final com.google.android.libraries.navigation.internal.abm.aj b;
    private final com.google.android.libraries.navigation.internal.abm.ah c;

    public cu(com.google.android.libraries.navigation.internal.abm.aj ajVar, com.google.android.libraries.navigation.internal.abm.ah ahVar, ht htVar) {
        com.google.android.libraries.navigation.internal.abf.s.k(ajVar, "indoorState");
        this.b = ajVar;
        com.google.android.libraries.navigation.internal.abf.s.k(ahVar, "indoorLevel");
        this.c = ahVar;
        com.google.android.libraries.navigation.internal.abf.s.k(ahVar.a(), "indoorLevel.getId()");
        com.google.android.libraries.navigation.internal.abf.s.k(htVar, "log");
        this.a = htVar;
    }

    private final String f() {
        return String.valueOf(this.c.a());
    }

    @Override // com.google.android.libraries.navigation.internal.lz.l
    public final int a() {
        return hashCode();
    }

    @Override // com.google.android.libraries.navigation.internal.lz.l
    public final String b() {
        return this.c.b();
    }

    @Override // com.google.android.libraries.navigation.internal.lz.l
    public final String c() {
        return this.c.c();
    }

    @Override // com.google.android.libraries.navigation.internal.lz.l
    public final void d() {
        this.a.c(com.google.android.libraries.navigation.internal.abx.b.INDOOR_ACTIVATE_LEVEL);
        this.b.a(this.c.a());
    }

    @Override // com.google.android.libraries.navigation.internal.lz.l
    public final boolean e(com.google.android.libraries.navigation.internal.lz.l lVar) {
        return equals(lVar);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof cu) {
            return this.c.a().equals(((cu) obj).c.a());
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{f()});
    }

    public final String toString() {
        com.google.android.libraries.navigation.internal.abf.aj ajVarF = com.google.android.libraries.navigation.internal.abf.aj.f(this);
        ajVarF.g("id", f());
        ajVarF.g("name", b());
        ajVarF.g("shortName", c());
        return ajVarF.toString();
    }
}
