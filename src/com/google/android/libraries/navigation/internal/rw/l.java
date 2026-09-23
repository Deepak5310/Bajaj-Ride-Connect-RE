package com.google.android.libraries.navigation.internal.rw;

import com.google.android.libraries.navigation.internal.bp.bw;
import com.google.android.libraries.navigation.internal.yz.ev;
import com.google.android.libraries.navigation.internal.yz.hx;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class l extends ac {
    public final com.google.android.libraries.navigation.internal.bp.ac a;
    public final bw b;
    public final com.google.android.libraries.navigation.internal.vn.a c;
    public final ev d;
    public final com.google.android.libraries.navigation.internal.ael.x e;
    private final com.google.android.libraries.navigation.internal.tu.t f;
    private final com.google.android.libraries.navigation.internal.vn.c g;

    public l(com.google.android.libraries.navigation.internal.tu.t tVar, com.google.android.libraries.navigation.internal.bp.ac acVar, com.google.android.libraries.navigation.internal.vn.c cVar, bw bwVar, com.google.android.libraries.navigation.internal.vn.a aVar, ev evVar, com.google.android.libraries.navigation.internal.ael.x xVar) {
        this.f = tVar;
        this.a = acVar;
        this.g = cVar;
        this.b = bwVar;
        this.c = aVar;
        this.d = evVar;
        this.e = xVar;
    }

    @Override // com.google.android.libraries.navigation.internal.rw.ac
    public final com.google.android.libraries.navigation.internal.bp.ac a() {
        return this.a;
    }

    @Override // com.google.android.libraries.navigation.internal.rw.ac
    public final bw b() {
        return this.b;
    }

    @Override // com.google.android.libraries.navigation.internal.rw.ac
    public final com.google.android.libraries.navigation.internal.tu.t c() {
        return this.f;
    }

    @Override // com.google.android.libraries.navigation.internal.rw.ac
    public final com.google.android.libraries.navigation.internal.vn.a d() {
        return this.c;
    }

    @Override // com.google.android.libraries.navigation.internal.rw.ac
    public final com.google.android.libraries.navigation.internal.vn.c e() {
        return this.g;
    }

    public final boolean equals(Object obj) {
        com.google.android.libraries.navigation.internal.ael.x xVar;
        if (obj == this) {
            return true;
        }
        if (obj instanceof ac) {
            ac acVar = (ac) obj;
            acVar.h();
            com.google.android.libraries.navigation.internal.tu.t tVar = this.f;
            if (tVar != null ? tVar.equals(acVar.c()) : acVar.c() == null) {
                com.google.android.libraries.navigation.internal.bp.ac acVar2 = this.a;
                if (acVar2 != null ? acVar2.equals(acVar.a()) : acVar.a() == null) {
                    com.google.android.libraries.navigation.internal.vn.c cVar = this.g;
                    if (cVar != null ? cVar.equals(acVar.e()) : acVar.e() == null) {
                        bw bwVar = this.b;
                        if (bwVar != null ? bwVar.equals(acVar.b()) : acVar.b() == null) {
                            com.google.android.libraries.navigation.internal.vn.a aVar = this.c;
                            if (aVar != null ? aVar.equals(acVar.d()) : acVar.d() == null) {
                                if (hx.i(this.d, acVar.f()) && ((xVar = this.e) != null ? xVar.equals(acVar.g()) : acVar.g() == null)) {
                                    return true;
                                }
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    @Override // com.google.android.libraries.navigation.internal.rw.ac
    public final ev f() {
        return this.d;
    }

    @Override // com.google.android.libraries.navigation.internal.rw.ac
    public final com.google.android.libraries.navigation.internal.ael.x g() {
        return this.e;
    }

    @Override // com.google.android.libraries.navigation.internal.rw.ac
    public final void h() {
    }

    public final String toString() {
        com.google.android.libraries.navigation.internal.ael.x xVar = this.e;
        ev evVar = this.d;
        com.google.android.libraries.navigation.internal.vn.a aVar = this.c;
        bw bwVar = this.b;
        com.google.android.libraries.navigation.internal.vn.c cVar = this.g;
        com.google.android.libraries.navigation.internal.bp.ac acVar = this.a;
        return "{null, " + String.valueOf(this.f) + ", " + String.valueOf(acVar) + ", " + String.valueOf(cVar) + ", " + String.valueOf(bwVar) + ", " + String.valueOf(aVar) + ", " + String.valueOf(evVar) + ", " + String.valueOf(xVar) + "}";
    }

    public final int hashCode() {
        com.google.android.libraries.navigation.internal.tu.t tVar = this.f;
        int iHashCode = tVar == null ? 0 : tVar.hashCode();
        com.google.android.libraries.navigation.internal.bp.ac acVar = this.a;
        int iHashCode2 = acVar == null ? 0 : acVar.hashCode();
        int i = iHashCode ^ (-721379959);
        com.google.android.libraries.navigation.internal.vn.c cVar = this.g;
        int iHashCode3 = cVar == null ? 0 : cVar.hashCode();
        int i2 = (i * 1000003) ^ iHashCode2;
        bw bwVar = this.b;
        int iHashCode4 = ((((i2 * 1000003) ^ iHashCode3) * 1000003) ^ (bwVar == null ? 0 : bwVar.hashCode())) * 1000003;
        com.google.android.libraries.navigation.internal.vn.a aVar = this.c;
        int iHashCode5 = (((iHashCode4 ^ (aVar == null ? 0 : aVar.hashCode())) * 1000003) ^ this.d.hashCode()) * 1000003;
        com.google.android.libraries.navigation.internal.ael.x xVar = this.e;
        return iHashCode5 ^ (xVar != null ? xVar.hashCode() : 0);
    }
}
