package com.google.android.libraries.navigation.internal.po;

import com.google.android.libraries.navigation.internal.adg.id;
import java.util.Objects;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class e extends i {
    private final id a;
    private final com.google.android.libraries.geo.mapcore.internal.vector.gl.n b;
    private final com.google.android.libraries.geo.mapcore.internal.vector.gl.n c;
    private final com.google.android.libraries.geo.mapcore.internal.vector.gl.n d;

    public e(id idVar, com.google.android.libraries.geo.mapcore.internal.vector.gl.n nVar, com.google.android.libraries.geo.mapcore.internal.vector.gl.n nVar2, com.google.android.libraries.geo.mapcore.internal.vector.gl.n nVar3) {
        Objects.requireNonNull(idVar);
        this.a = idVar;
        this.b = nVar;
        this.c = nVar2;
        this.d = nVar3;
    }

    @Override // com.google.android.libraries.navigation.internal.po.i
    public final com.google.android.libraries.geo.mapcore.internal.vector.gl.n a() {
        return this.d;
    }

    @Override // com.google.android.libraries.navigation.internal.po.i
    public final com.google.android.libraries.geo.mapcore.internal.vector.gl.n b() {
        return this.b;
    }

    @Override // com.google.android.libraries.navigation.internal.po.i
    public final com.google.android.libraries.geo.mapcore.internal.vector.gl.n c() {
        return this.c;
    }

    @Override // com.google.android.libraries.navigation.internal.po.i
    public final id d() {
        return this.a;
    }

    public final boolean equals(Object obj) {
        com.google.android.libraries.geo.mapcore.internal.vector.gl.n nVar;
        com.google.android.libraries.geo.mapcore.internal.vector.gl.n nVar2;
        com.google.android.libraries.geo.mapcore.internal.vector.gl.n nVar3;
        if (obj == this) {
            return true;
        }
        if (obj instanceof i) {
            i iVar = (i) obj;
            if (this.a.equals(iVar.d()) && ((nVar = this.b) != null ? nVar.equals(iVar.b()) : iVar.b() == null) && ((nVar2 = this.c) != null ? nVar2.equals(iVar.c()) : iVar.c() == null) && ((nVar3 = this.d) != null ? nVar3.equals(iVar.a()) : iVar.a() == null)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int iN;
        id idVar = this.a;
        if (idVar.H()) {
            iN = idVar.n();
        } else {
            int iN2 = idVar.ak;
            if (iN2 == 0) {
                iN2 = idVar.n();
                idVar.ak = iN2;
            }
            iN = iN2;
        }
        com.google.android.libraries.geo.mapcore.internal.vector.gl.n nVar = this.b;
        int iHashCode = nVar == null ? 0 : nVar.hashCode();
        int i = iN ^ 1000003;
        com.google.android.libraries.geo.mapcore.internal.vector.gl.n nVar2 = this.c;
        int iHashCode2 = ((((i * 1000003) ^ iHashCode) * 1000003) ^ (nVar2 == null ? 0 : nVar2.hashCode())) * 1000003;
        com.google.android.libraries.geo.mapcore.internal.vector.gl.n nVar3 = this.d;
        return iHashCode2 ^ (nVar3 != null ? nVar3.hashCode() : 0);
    }

    public final String toString() {
        com.google.android.libraries.geo.mapcore.internal.vector.gl.n nVar = this.d;
        com.google.android.libraries.geo.mapcore.internal.vector.gl.n nVar2 = this.c;
        com.google.android.libraries.geo.mapcore.internal.vector.gl.n nVar3 = this.b;
        return "{" + String.valueOf(this.a) + ", " + String.valueOf(nVar3) + ", " + String.valueOf(nVar2) + ", " + String.valueOf(nVar) + "}";
    }
}
