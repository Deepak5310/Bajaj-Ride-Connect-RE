package com.google.android.libraries.navigation.internal.rw;

import com.google.android.libraries.navigation.internal.add.ag;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class i extends b {
    public final ag a;
    public final u b;
    public final p c;
    public final com.google.android.libraries.navigation.internal.tj.j d;
    public final com.google.android.libraries.navigation.internal.tj.h e;

    public i(ag agVar, u uVar, p pVar, com.google.android.libraries.navigation.internal.tj.j jVar, com.google.android.libraries.navigation.internal.tj.h hVar) {
        this.a = agVar;
        this.b = uVar;
        this.c = pVar;
        this.d = jVar;
        this.e = hVar;
    }

    @Override // com.google.android.libraries.navigation.internal.rw.b
    public final p b() {
        return this.c;
    }

    @Override // com.google.android.libraries.navigation.internal.rw.b
    public final u c() {
        return this.b;
    }

    @Override // com.google.android.libraries.navigation.internal.rw.b
    public final com.google.android.libraries.navigation.internal.tj.h d() {
        return this.e;
    }

    @Override // com.google.android.libraries.navigation.internal.rw.b
    @Deprecated
    public final com.google.android.libraries.navigation.internal.tj.j e() {
        return this.d;
    }

    public final boolean equals(Object obj) {
        com.google.android.libraries.navigation.internal.tj.j jVar;
        com.google.android.libraries.navigation.internal.tj.h hVar;
        if (obj == this) {
            return true;
        }
        if (obj instanceof b) {
            b bVar = (b) obj;
            if (this.a.equals(bVar.f()) && this.b.equals(bVar.c()) && this.c.equals(bVar.b()) && ((jVar = this.d) != null ? jVar.equals(bVar.e()) : bVar.e() == null) && ((hVar = this.e) != null ? hVar.equals(bVar.d()) : bVar.d() == null)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.android.libraries.navigation.internal.rw.b
    public final ag f() {
        return this.a;
    }

    public final String toString() {
        com.google.android.libraries.navigation.internal.tj.h hVar = this.e;
        com.google.android.libraries.navigation.internal.tj.j jVar = this.d;
        p pVar = this.c;
        u uVar = this.b;
        return "{" + String.valueOf(this.a) + ", " + String.valueOf(uVar) + ", " + String.valueOf(pVar) + ", " + String.valueOf(jVar) + ", " + String.valueOf(hVar) + "}";
    }

    public final int hashCode() {
        int iN;
        ag agVar = this.a;
        if (agVar.H()) {
            iN = agVar.n();
        } else {
            int iN2 = agVar.ak;
            if (iN2 == 0) {
                iN2 = agVar.n();
                agVar.ak = iN2;
            }
            iN = iN2;
        }
        int iHashCode = ((((iN ^ 1000003) * 1000003) ^ this.b.hashCode()) * 1000003) ^ this.c.hashCode();
        com.google.android.libraries.navigation.internal.tj.j jVar = this.d;
        int iHashCode2 = ((iHashCode * 1000003) ^ (jVar == null ? 0 : jVar.hashCode())) * 1000003;
        com.google.android.libraries.navigation.internal.tj.h hVar = this.e;
        return iHashCode2 ^ (hVar != null ? hVar.hashCode() : 0);
    }
}
