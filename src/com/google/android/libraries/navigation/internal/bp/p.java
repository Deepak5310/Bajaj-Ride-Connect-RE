package com.google.android.libraries.navigation.internal.bp;

import com.google.android.libraries.navigation.internal.adr.hs;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class p extends bs {
    private final com.google.android.libraries.navigation.internal.adr.bh a;
    private final hs b;

    public p(com.google.android.libraries.navigation.internal.adr.bh bhVar, hs hsVar) {
        this.a = bhVar;
        this.b = hsVar;
    }

    @Override // com.google.android.libraries.navigation.internal.bp.bs
    public final com.google.android.libraries.navigation.internal.adr.bh a() {
        return this.a;
    }

    @Override // com.google.android.libraries.navigation.internal.bp.bs
    public final hs b() {
        return this.b;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof bs) {
            bs bsVar = (bs) obj;
            if (this.a.equals(bsVar.a()) && this.b.equals(bsVar.b())) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int iN;
        com.google.android.libraries.navigation.internal.adr.bh bhVar = this.a;
        if (bhVar.H()) {
            iN = bhVar.n();
        } else {
            int iN2 = bhVar.ak;
            if (iN2 == 0) {
                iN2 = bhVar.n();
                bhVar.ak = iN2;
            }
            iN = iN2;
        }
        return ((iN ^ 1000003) * 1000003) ^ this.b.hashCode();
    }
}
