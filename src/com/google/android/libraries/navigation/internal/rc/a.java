package com.google.android.libraries.navigation.internal.rc;

import com.google.android.libraries.navigation.internal.adg.ef;
import com.google.android.libraries.navigation.internal.adg.fs;
import com.google.android.libraries.navigation.internal.oe.j;
import com.google.android.libraries.navigation.internal.px.dj;
import java.util.Objects;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class a extends d {
    private final ef a;
    private final fs b;
    private final boolean c;
    private final boolean d;
    private final dj e;
    private final j f;

    public a(ef efVar, fs fsVar, boolean z, boolean z2, dj djVar, j jVar) {
        Objects.requireNonNull(efVar);
        this.a = efVar;
        Objects.requireNonNull(fsVar);
        this.b = fsVar;
        this.c = z;
        this.d = z2;
        this.e = djVar;
        this.f = jVar;
    }

    @Override // com.google.android.libraries.navigation.internal.rc.d
    public final j a() {
        return this.f;
    }

    @Override // com.google.android.libraries.navigation.internal.rc.d
    public final dj b() {
        return this.e;
    }

    @Override // com.google.android.libraries.navigation.internal.rc.d
    @Deprecated
    public final ef c() {
        return this.a;
    }

    @Override // com.google.android.libraries.navigation.internal.rc.d
    public final fs d() {
        return this.b;
    }

    @Override // com.google.android.libraries.navigation.internal.rc.d
    public final boolean e() {
        return this.d;
    }

    public final boolean equals(Object obj) {
        dj djVar;
        j jVar;
        if (obj == this) {
            return true;
        }
        if (obj instanceof d) {
            d dVar = (d) obj;
            if (this.a.equals(dVar.c()) && this.b.equals(dVar.d()) && this.c == dVar.f() && this.d == dVar.e() && ((djVar = this.e) != null ? djVar.equals(dVar.b()) : dVar.b() == null) && ((jVar = this.f) != null ? jVar.equals(dVar.a()) : dVar.a() == null)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.android.libraries.navigation.internal.rc.d
    public final boolean f() {
        return this.c;
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
        int i = (((((((iN ^ 1000003) * 1000003) ^ iN2) * 1000003) ^ (true != this.c ? 1237 : 1231)) * 1000003) ^ (true == this.d ? 1231 : 1237)) * 1000003;
        dj djVar = this.e;
        int iHashCode = (i ^ (djVar == null ? 0 : djVar.hashCode())) * 1000003;
        j jVar = this.f;
        return iHashCode ^ (jVar != null ? jVar.hashCode() : 0);
    }

    public final String toString() {
        j jVar = this.f;
        dj djVar = this.e;
        fs fsVar = this.b;
        return "{" + String.valueOf(this.a) + ", " + String.valueOf(fsVar) + ", " + this.c + ", " + this.d + ", " + String.valueOf(djVar) + ", " + String.valueOf(jVar) + "}";
    }
}
