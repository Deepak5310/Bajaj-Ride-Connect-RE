package com.google.android.libraries.navigation.internal.ol;

import com.google.android.libraries.navigation.internal.adg.ef;
import com.google.android.libraries.navigation.internal.adg.fs;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class e extends ao {
    public final ef a;
    public final fs b;
    public final boolean c;
    public final int d;
    public final ap e;
    public final com.google.android.libraries.navigation.internal.yx.an f;
    public final com.google.android.libraries.navigation.internal.yx.an g;
    public final com.google.android.libraries.navigation.internal.yx.an h;

    public e(ef efVar, fs fsVar, boolean z, int i, ap apVar, com.google.android.libraries.navigation.internal.yx.an anVar, com.google.android.libraries.navigation.internal.yx.an anVar2, com.google.android.libraries.navigation.internal.yx.an anVar3) {
        this.a = efVar;
        this.b = fsVar;
        this.c = z;
        this.d = i;
        this.e = apVar;
        this.f = anVar;
        this.g = anVar2;
        this.h = anVar3;
    }

    @Override // com.google.android.libraries.navigation.internal.ol.ao
    public final int a() {
        return this.d;
    }

    @Override // com.google.android.libraries.navigation.internal.ol.ao
    public final an b() {
        return new d(this);
    }

    @Override // com.google.android.libraries.navigation.internal.ol.ao
    public final ap c() {
        return this.e;
    }

    @Override // com.google.android.libraries.navigation.internal.ol.ao
    public final com.google.android.libraries.navigation.internal.yx.an d() {
        return this.g;
    }

    @Override // com.google.android.libraries.navigation.internal.ol.ao
    public final com.google.android.libraries.navigation.internal.yx.an e() {
        return this.f;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof ao) {
            ao aoVar = (ao) obj;
            if (this.a.equals(aoVar.g()) && this.b.equals(aoVar.h()) && this.c == aoVar.i() && this.d == aoVar.a() && this.e.equals(aoVar.c()) && this.f.equals(aoVar.e()) && this.g.equals(aoVar.d()) && this.h.equals(aoVar.f())) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.android.libraries.navigation.internal.ol.ao
    public final com.google.android.libraries.navigation.internal.yx.an f() {
        return this.h;
    }

    @Override // com.google.android.libraries.navigation.internal.ol.ao
    public final ef g() {
        return this.a;
    }

    @Override // com.google.android.libraries.navigation.internal.ol.ao
    public final fs h() {
        return this.b;
    }

    @Override // com.google.android.libraries.navigation.internal.ol.ao
    public final boolean i() {
        return this.c;
    }

    public final String toString() {
        com.google.android.libraries.navigation.internal.yx.an anVar = this.h;
        com.google.android.libraries.navigation.internal.yx.an anVar2 = this.g;
        com.google.android.libraries.navigation.internal.yx.an anVar3 = this.f;
        ap apVar = this.e;
        fs fsVar = this.b;
        return "{" + String.valueOf(this.a) + ", " + String.valueOf(fsVar) + ", " + this.c + ", " + this.d + ", " + String.valueOf(apVar) + ", " + String.valueOf(anVar3) + ", " + String.valueOf(anVar2) + ", " + String.valueOf(anVar) + "}";
    }

    public final int hashCode() {
        int iN;
        int iN2;
        ef efVar = this.a;
        if (efVar.H()) {
            iN = efVar.n();
        } else {
            int iN3 = efVar.ak;
            if (iN3 == 0) {
                iN3 = efVar.n();
                efVar.ak = iN3;
            }
            iN = iN3;
        }
        fs fsVar = this.b;
        if (fsVar.H()) {
            iN2 = fsVar.n();
        } else {
            int iN4 = fsVar.ak;
            if (iN4 == 0) {
                iN4 = fsVar.n();
                fsVar.ak = iN4;
            }
            iN2 = iN4;
        }
        return ((((((((((((((iN ^ 1000003) * 1000003) ^ iN2) * 1000003) ^ (true != this.c ? 1237 : 1231)) * 1000003) ^ this.d) * 1000003) ^ this.e.hashCode()) * 1000003) ^ this.f.hashCode()) * 1000003) ^ this.g.hashCode()) * 1000003) ^ this.h.hashCode();
    }
}
