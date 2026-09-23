package com.google.android.libraries.navigation.internal.px;

import java.util.Objects;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class k extends an {
    private final com.google.android.libraries.navigation.internal.qc.i a;
    private final com.google.android.libraries.navigation.internal.adg.p b;
    private final int c;
    private final am d;

    public k(com.google.android.libraries.navigation.internal.qc.i iVar, com.google.android.libraries.navigation.internal.adg.p pVar, int i, am amVar) {
        Objects.requireNonNull(iVar);
        this.a = iVar;
        Objects.requireNonNull(pVar);
        this.b = pVar;
        this.c = i;
        Objects.requireNonNull(amVar);
        this.d = amVar;
    }

    @Override // com.google.android.libraries.navigation.internal.px.an
    public final int a() {
        return this.c;
    }

    @Override // com.google.android.libraries.navigation.internal.px.an
    public final am b() {
        return this.d;
    }

    @Override // com.google.android.libraries.navigation.internal.px.an
    public final com.google.android.libraries.navigation.internal.qc.i c() {
        return this.a;
    }

    @Override // com.google.android.libraries.navigation.internal.px.an
    public final com.google.android.libraries.navigation.internal.adg.p d() {
        return this.b;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof an) {
            an anVar = (an) obj;
            if (this.a.equals(anVar.c()) && this.b.equals(anVar.d()) && this.c == anVar.a() && this.d.equals(anVar.b())) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int iN;
        int iHashCode = this.a.hashCode() ^ 1000003;
        com.google.android.libraries.navigation.internal.adg.p pVar = this.b;
        if (pVar.H()) {
            iN = pVar.n();
        } else {
            int iN2 = pVar.ak;
            if (iN2 == 0) {
                iN2 = pVar.n();
                pVar.ak = iN2;
            }
            iN = iN2;
        }
        return (((((iHashCode * 1000003) ^ iN) * 1000003) ^ this.c) * 1000003) ^ this.d.hashCode();
    }

    public final String toString() {
        am amVar = this.d;
        com.google.android.libraries.navigation.internal.adg.p pVar = this.b;
        return "{" + this.a.toString() + ", " + String.valueOf(pVar) + ", " + this.c + ", " + String.valueOf(amVar) + "}";
    }
}
