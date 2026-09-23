package com.google.android.libraries.navigation.internal.kd;

import com.google.android.libraries.navigation.internal.zp.ce;
import com.google.android.libraries.navigation.internal.zr.cg;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class e extends l {
    public final ce a;
    public final cg b;

    public e(ce ceVar, cg cgVar) {
        this.a = ceVar;
        this.b = cgVar;
    }

    @Override // com.google.android.libraries.navigation.internal.kd.l
    public final ce a() {
        return this.a;
    }

    @Override // com.google.android.libraries.navigation.internal.kd.l
    public final cg b() {
        return this.b;
    }

    @Override // com.google.android.libraries.navigation.internal.kd.l
    public final void c() {
    }

    @Override // com.google.android.libraries.navigation.internal.kd.l
    public final void d() {
    }

    @Override // com.google.android.libraries.navigation.internal.kd.l
    public final void e() {
    }

    public final boolean equals(Object obj) {
        cg cgVar;
        if (obj == this) {
            return true;
        }
        if (obj instanceof l) {
            l lVar = (l) obj;
            if (this.a.equals(lVar.a()) && ((cgVar = this.b) != null ? cgVar.equals(lVar.b()) : lVar.b() == null)) {
                lVar.m();
                lVar.h();
                lVar.l();
                lVar.d();
                lVar.e();
                lVar.c();
                lVar.j();
                lVar.n();
                lVar.o();
                lVar.f();
                lVar.g();
                lVar.i();
                lVar.k();
                return true;
            }
        }
        return false;
    }

    @Override // com.google.android.libraries.navigation.internal.kd.l
    public final void f() {
    }

    @Override // com.google.android.libraries.navigation.internal.kd.l
    public final void g() {
    }

    @Override // com.google.android.libraries.navigation.internal.kd.l
    public final void h() {
    }

    @Override // com.google.android.libraries.navigation.internal.kd.l
    public final void i() {
    }

    @Override // com.google.android.libraries.navigation.internal.kd.l
    public final void j() {
    }

    @Override // com.google.android.libraries.navigation.internal.kd.l
    public final void k() {
    }

    @Override // com.google.android.libraries.navigation.internal.kd.l
    public final void l() {
    }

    @Override // com.google.android.libraries.navigation.internal.kd.l
    public final void m() {
    }

    @Override // com.google.android.libraries.navigation.internal.kd.l
    public final void n() {
    }

    @Override // com.google.android.libraries.navigation.internal.kd.l
    public final void o() {
    }

    public final String toString() {
        cg cgVar = this.b;
        return "{" + String.valueOf(this.a) + ", " + String.valueOf(cgVar) + ", null, null, null, null, null, null, null, null, null, null, null, null, null}";
    }

    public final int hashCode() {
        int iN;
        int iHashCode = this.a.hashCode() ^ 1000003;
        cg cgVar = this.b;
        if (cgVar == null) {
            iN = 0;
        } else if (cgVar.H()) {
            iN = cgVar.n();
        } else {
            int iN2 = cgVar.ak;
            if (iN2 == 0) {
                iN2 = cgVar.n();
                cgVar.ak = iN2;
            }
            iN = iN2;
        }
        return ((iHashCode * 1000003) ^ iN) * (-701661933);
    }
}
