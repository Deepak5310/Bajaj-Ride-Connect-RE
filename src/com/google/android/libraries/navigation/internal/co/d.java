package com.google.android.libraries.navigation.internal.co;

import android.content.Context;
import com.google.android.libraries.navigation.internal.adr.el;
import com.google.android.libraries.navigation.internal.ol.ax;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class d extends j {
    public final el a;
    public final ax b;
    public final Context c;
    public final com.google.android.libraries.navigation.internal.mj.a d;
    public final com.google.android.libraries.navigation.internal.fz.d e;
    public final com.google.android.libraries.navigation.internal.iv.f f;
    public final com.google.android.libraries.navigation.internal.hf.c g = null;
    public final Integer h;
    public final boolean i;
    public final boolean j;
    public final com.google.android.libraries.navigation.internal.dx.i k;

    public d(el elVar, ax axVar, Context context, com.google.android.libraries.navigation.internal.mj.a aVar, com.google.android.libraries.navigation.internal.fz.d dVar, com.google.android.libraries.navigation.internal.iv.f fVar, com.google.android.libraries.navigation.internal.hf.c cVar, Integer num, boolean z, boolean z2, com.google.android.libraries.navigation.internal.dx.i iVar) {
        this.a = elVar;
        this.b = axVar;
        this.c = context;
        this.d = aVar;
        this.e = dVar;
        this.f = fVar;
        this.h = num;
        this.i = z;
        this.j = z2;
        this.k = iVar;
    }

    @Override // com.google.android.libraries.navigation.internal.co.j
    public final Context a() {
        return this.c;
    }

    @Override // com.google.android.libraries.navigation.internal.co.j
    public final com.google.android.libraries.navigation.internal.dx.i b() {
        return this.k;
    }

    @Override // com.google.android.libraries.navigation.internal.co.j
    public final com.google.android.libraries.navigation.internal.fz.d c() {
        return this.e;
    }

    @Override // com.google.android.libraries.navigation.internal.co.j
    public final com.google.android.libraries.navigation.internal.hf.c d() {
        return null;
    }

    @Override // com.google.android.libraries.navigation.internal.co.j
    public final com.google.android.libraries.navigation.internal.iv.f e() {
        return this.f;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof j) {
            j jVar = (j) obj;
            if (this.a.equals(jVar.h()) && this.b.equals(jVar.g()) && this.c.equals(jVar.a()) && this.d.equals(jVar.f()) && this.e.equals(jVar.c())) {
                jVar.l();
                com.google.android.libraries.navigation.internal.iv.f fVar = this.f;
                if (fVar != null ? fVar.equals(jVar.e()) : jVar.e() == null) {
                    jVar.d();
                    Integer num = this.h;
                    if (num != null ? num.equals(jVar.i()) : jVar.i() == null) {
                        if (this.i == jVar.j() && this.j == jVar.k() && this.k.equals(jVar.b())) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    @Override // com.google.android.libraries.navigation.internal.co.j
    public final com.google.android.libraries.navigation.internal.mj.a f() {
        return this.d;
    }

    @Override // com.google.android.libraries.navigation.internal.co.j
    public final ax g() {
        return this.b;
    }

    @Override // com.google.android.libraries.navigation.internal.co.j
    public final el h() {
        return this.a;
    }

    @Override // com.google.android.libraries.navigation.internal.co.j
    public final Integer i() {
        return this.h;
    }

    @Override // com.google.android.libraries.navigation.internal.co.j
    public final boolean j() {
        return this.i;
    }

    @Override // com.google.android.libraries.navigation.internal.co.j
    public final boolean k() {
        return this.j;
    }

    @Override // com.google.android.libraries.navigation.internal.co.j
    public final void l() {
    }

    public final String toString() {
        com.google.android.libraries.navigation.internal.dx.i iVar = this.k;
        com.google.android.libraries.navigation.internal.iv.f fVar = this.f;
        com.google.android.libraries.navigation.internal.fz.d dVar = this.e;
        com.google.android.libraries.navigation.internal.mj.a aVar = this.d;
        Context context = this.c;
        ax axVar = this.b;
        return "{" + String.valueOf(this.a) + ", " + String.valueOf(axVar) + ", " + String.valueOf(context) + ", " + String.valueOf(aVar) + ", " + String.valueOf(dVar) + ", null, " + String.valueOf(fVar) + ", null, " + this.h + ", " + this.i + ", " + this.j + ", " + String.valueOf(iVar) + "}";
    }

    public final int hashCode() {
        int iN;
        el elVar = this.a;
        if (elVar.H()) {
            iN = elVar.n();
        } else {
            int iN2 = elVar.ak;
            if (iN2 == 0) {
                iN2 = elVar.n();
                elVar.ak = iN2;
            }
            iN = iN2;
        }
        int iHashCode = ((((((((iN ^ 1000003) * 1000003) ^ this.b.hashCode()) * 1000003) ^ this.c.hashCode()) * 1000003) ^ this.d.hashCode()) * 1000003) ^ this.e.hashCode();
        com.google.android.libraries.navigation.internal.iv.f fVar = this.f;
        int iHashCode2 = fVar == null ? 0 : fVar.hashCode();
        int i = iHashCode * (-721379959);
        Integer num = this.h;
        return ((((((((i ^ iHashCode2) * (-721379959)) ^ (num != null ? num.hashCode() : 0)) * 1000003) ^ (true != this.i ? 1237 : 1231)) * 1000003) ^ (true == this.j ? 1231 : 1237)) * 1000003) ^ this.k.hashCode();
    }
}
