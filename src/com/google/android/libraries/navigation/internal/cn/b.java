package com.google.android.libraries.navigation.internal.cn;

import com.google.android.libraries.navigation.internal.ady.al;
import com.google.android.libraries.navigation.internal.bp.bg;
import com.google.android.libraries.navigation.internal.ol.ax;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class b extends n {
    public final al a;
    public final boolean b;
    public final boolean c;
    public final boolean d;
    public final int e;
    public final ax f;
    public final com.google.android.libraries.navigation.internal.mj.a g;
    public final com.google.android.libraries.navigation.internal.fz.d h;
    public final com.google.android.libraries.navigation.internal.iv.f i;
    public final o j;
    public final bg k;
    private final com.google.android.libraries.navigation.internal.pi.s l;

    public b(al alVar, boolean z, boolean z2, boolean z3, int i, ax axVar, com.google.android.libraries.navigation.internal.mj.a aVar, com.google.android.libraries.navigation.internal.fz.d dVar, com.google.android.libraries.navigation.internal.iv.f fVar, com.google.android.libraries.navigation.internal.pi.s sVar, o oVar, bg bgVar) {
        this.a = alVar;
        this.b = z;
        this.c = z2;
        this.d = z3;
        this.e = i;
        this.f = axVar;
        this.g = aVar;
        this.h = dVar;
        this.i = fVar;
        this.l = sVar;
        this.j = oVar;
        this.k = bgVar;
    }

    @Override // com.google.android.libraries.navigation.internal.cn.n
    public final int a() {
        return this.e;
    }

    @Override // com.google.android.libraries.navigation.internal.cn.n
    public final bg b() {
        return this.k;
    }

    @Override // com.google.android.libraries.navigation.internal.cn.n
    public final o c() {
        return this.j;
    }

    @Override // com.google.android.libraries.navigation.internal.cn.n
    public final com.google.android.libraries.navigation.internal.fz.d d() {
        return this.h;
    }

    @Override // com.google.android.libraries.navigation.internal.cn.n
    public final com.google.android.libraries.navigation.internal.iv.f e() {
        return this.i;
    }

    public final boolean equals(Object obj) {
        ax axVar;
        com.google.android.libraries.navigation.internal.mj.a aVar;
        com.google.android.libraries.navigation.internal.fz.d dVar;
        if (obj == this) {
            return true;
        }
        if (obj instanceof n) {
            n nVar = (n) obj;
            if (this.a.equals(nVar.i()) && this.b == nVar.j() && this.c == nVar.k() && this.d == nVar.l() && this.e == nVar.a() && ((axVar = this.f) != null ? axVar.equals(nVar.g()) : nVar.g() == null) && ((aVar = this.g) != null ? aVar.equals(nVar.f()) : nVar.f() == null) && ((dVar = this.h) != null ? dVar.equals(nVar.d()) : nVar.d() == null)) {
                nVar.m();
                com.google.android.libraries.navigation.internal.iv.f fVar = this.i;
                if (fVar != null ? fVar.equals(nVar.e()) : nVar.e() == null) {
                    com.google.android.libraries.navigation.internal.pi.s sVar = this.l;
                    if (sVar != null ? sVar.equals(nVar.h()) : nVar.h() == null) {
                        o oVar = this.j;
                        if (oVar != null ? oVar.equals(nVar.c()) : nVar.c() == null) {
                            bg bgVar = this.k;
                            if (bgVar != null ? bgVar.equals(nVar.b()) : nVar.b() == null) {
                                return true;
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    @Override // com.google.android.libraries.navigation.internal.cn.n
    public final com.google.android.libraries.navigation.internal.mj.a f() {
        return this.g;
    }

    @Override // com.google.android.libraries.navigation.internal.cn.n
    public final ax g() {
        return this.f;
    }

    @Override // com.google.android.libraries.navigation.internal.cn.n
    public final com.google.android.libraries.navigation.internal.pi.s h() {
        return this.l;
    }

    public final int hashCode() {
        int iHashCode = this.a.hashCode() ^ 1000003;
        ax axVar = this.f;
        int iHashCode2 = ((((((((((iHashCode * 1000003) ^ (true != this.b ? 1237 : 1231)) * 1000003) ^ (true != this.c ? 1237 : 1231)) * 1000003) ^ (true == this.d ? 1231 : 1237)) * 1000003) ^ this.e) * 1000003) ^ (axVar == null ? 0 : axVar.hashCode())) * 1000003;
        com.google.android.libraries.navigation.internal.mj.a aVar = this.g;
        int iHashCode3 = (iHashCode2 ^ (aVar == null ? 0 : aVar.hashCode())) * 1000003;
        com.google.android.libraries.navigation.internal.fz.d dVar = this.h;
        int iHashCode4 = iHashCode3 ^ (dVar == null ? 0 : dVar.hashCode());
        com.google.android.libraries.navigation.internal.iv.f fVar = this.i;
        int iHashCode5 = ((iHashCode4 * (-721379959)) ^ (fVar == null ? 0 : fVar.hashCode())) * 1000003;
        com.google.android.libraries.navigation.internal.pi.s sVar = this.l;
        int iHashCode6 = (iHashCode5 ^ (sVar == null ? 0 : sVar.hashCode())) * 1000003;
        o oVar = this.j;
        int iHashCode7 = (iHashCode6 ^ (oVar == null ? 0 : oVar.hashCode())) * 1000003;
        bg bgVar = this.k;
        return iHashCode7 ^ (bgVar != null ? bgVar.hashCode() : 0);
    }

    @Override // com.google.android.libraries.navigation.internal.cn.n
    public final al i() {
        return this.a;
    }

    @Override // com.google.android.libraries.navigation.internal.cn.n
    public final boolean j() {
        return this.b;
    }

    @Override // com.google.android.libraries.navigation.internal.cn.n
    public final boolean k() {
        return this.c;
    }

    @Override // com.google.android.libraries.navigation.internal.cn.n
    public final boolean l() {
        return this.d;
    }

    @Override // com.google.android.libraries.navigation.internal.cn.n
    public final void m() {
    }

    public final String toString() {
        bg bgVar = this.k;
        o oVar = this.j;
        com.google.android.libraries.navigation.internal.pi.s sVar = this.l;
        com.google.android.libraries.navigation.internal.iv.f fVar = this.i;
        com.google.android.libraries.navigation.internal.fz.d dVar = this.h;
        com.google.android.libraries.navigation.internal.mj.a aVar = this.g;
        ax axVar = this.f;
        return "{" + String.valueOf(this.a) + ", " + this.b + ", " + this.c + ", " + this.d + ", " + this.e + ", " + String.valueOf(axVar) + ", " + String.valueOf(aVar) + ", " + String.valueOf(dVar) + ", null, " + String.valueOf(fVar) + ", " + String.valueOf(sVar) + ", " + String.valueOf(oVar) + ", " + String.valueOf(bgVar) + "}";
    }
}
