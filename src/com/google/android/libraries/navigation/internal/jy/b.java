package com.google.android.libraries.navigation.internal.jy;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class b extends i {
    private final com.google.android.libraries.navigation.internal.zp.k a;
    private final com.google.android.libraries.navigation.internal.zp.r b;

    public b(com.google.android.libraries.navigation.internal.zp.k kVar, com.google.android.libraries.navigation.internal.zp.r rVar) {
        this.a = kVar;
        this.b = rVar;
    }

    @Override // com.google.android.libraries.navigation.internal.jy.i
    public final com.google.android.libraries.navigation.internal.zp.k a() {
        return this.a;
    }

    @Override // com.google.android.libraries.navigation.internal.jy.i
    public final com.google.android.libraries.navigation.internal.zp.r b() {
        return this.b;
    }

    @Override // com.google.android.libraries.navigation.internal.jy.i
    public final void c() {
    }

    @Override // com.google.android.libraries.navigation.internal.jy.i
    public final void d() {
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof i) {
            i iVar = (i) obj;
            if (this.a.equals(iVar.a())) {
                iVar.c();
                com.google.android.libraries.navigation.internal.zp.r rVar = this.b;
                if (rVar != null ? rVar.equals(iVar.b()) : iVar.b() == null) {
                    iVar.d();
                    return true;
                }
            }
        }
        return false;
    }

    public final String toString() {
        com.google.android.libraries.navigation.internal.zp.r rVar = this.b;
        return "{" + String.valueOf(this.a) + ", null, " + String.valueOf(rVar) + ", false}";
    }

    public final int hashCode() {
        int iN;
        int iHashCode = this.a.hashCode() ^ 1000003;
        com.google.android.libraries.navigation.internal.zp.r rVar = this.b;
        if (rVar == null) {
            iN = 0;
        } else if (rVar.H()) {
            iN = rVar.n();
        } else {
            int iN2 = rVar.ak;
            if (iN2 == 0) {
                iN2 = rVar.n();
                rVar.ak = iN2;
            }
            iN = iN2;
        }
        return (((iHashCode * (-721379959)) ^ iN) * 1000003) ^ 1237;
    }
}
