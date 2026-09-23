package com.google.android.libraries.navigation.internal.rw;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class j extends u {
    public final com.google.android.libraries.navigation.internal.tj.j a;
    public final ac b;
    private final com.google.android.libraries.navigation.internal.tj.h c;
    private final com.google.android.libraries.navigation.internal.tj.u d;

    public j(com.google.android.libraries.navigation.internal.tj.j jVar, com.google.android.libraries.navigation.internal.tj.h hVar, ac acVar, com.google.android.libraries.navigation.internal.tj.u uVar) {
        this.a = jVar;
        this.c = hVar;
        this.b = acVar;
        this.d = uVar;
    }

    @Override // com.google.android.libraries.navigation.internal.rw.u
    public final ac a() {
        return this.b;
    }

    @Override // com.google.android.libraries.navigation.internal.rw.u
    public final com.google.android.libraries.navigation.internal.tj.h b() {
        return this.c;
    }

    @Override // com.google.android.libraries.navigation.internal.rw.u
    public final com.google.android.libraries.navigation.internal.tj.j c() {
        return this.a;
    }

    @Override // com.google.android.libraries.navigation.internal.rw.u
    public final com.google.android.libraries.navigation.internal.tj.u d() {
        return this.d;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof u) {
            u uVar = (u) obj;
            com.google.android.libraries.navigation.internal.tj.j jVar = this.a;
            if (jVar != null ? jVar.equals(uVar.c()) : uVar.c() == null) {
                com.google.android.libraries.navigation.internal.tj.h hVar = this.c;
                if (hVar != null ? hVar.equals(uVar.b()) : uVar.b() == null) {
                    ac acVar = this.b;
                    if (acVar != null ? acVar.equals(uVar.a()) : uVar.a() == null) {
                        com.google.android.libraries.navigation.internal.tj.u uVar2 = this.d;
                        if (uVar2 != null ? uVar2.equals(uVar.d()) : uVar.d() == null) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    public final String toString() {
        com.google.android.libraries.navigation.internal.tj.u uVar = this.d;
        ac acVar = this.b;
        com.google.android.libraries.navigation.internal.tj.h hVar = this.c;
        return "{" + String.valueOf(this.a) + ", " + String.valueOf(hVar) + ", " + String.valueOf(acVar) + ", " + String.valueOf(uVar) + "}";
    }

    public final int hashCode() {
        com.google.android.libraries.navigation.internal.tj.j jVar = this.a;
        int iHashCode = jVar == null ? 0 : jVar.hashCode();
        com.google.android.libraries.navigation.internal.tj.h hVar = this.c;
        int iHashCode2 = hVar == null ? 0 : hVar.hashCode();
        int i = iHashCode ^ 1000003;
        ac acVar = this.b;
        int iHashCode3 = ((((i * 1000003) ^ iHashCode2) * 1000003) ^ (acVar == null ? 0 : acVar.hashCode())) * 1000003;
        com.google.android.libraries.navigation.internal.tj.u uVar = this.d;
        return iHashCode3 ^ (uVar != null ? uVar.hashCode() : 0);
    }
}
