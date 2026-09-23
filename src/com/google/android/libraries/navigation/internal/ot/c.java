package com.google.android.libraries.navigation.internal.ot;

import com.google.android.libraries.navigation.internal.adl.ao;
import com.google.android.libraries.navigation.internal.yx.as;
import java.util.Objects;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class c extends k {
    private final as a;
    private final ao b;

    public c(as asVar, ao aoVar) {
        Objects.requireNonNull(asVar);
        this.a = asVar;
        this.b = aoVar;
    }

    @Override // com.google.android.libraries.navigation.internal.ot.k
    public final as a() {
        return this.a;
    }

    @Override // com.google.android.libraries.navigation.internal.ot.k
    public final ao b() {
        return this.b;
    }

    public final boolean equals(Object obj) {
        ao aoVar;
        if (obj == this) {
            return true;
        }
        if (obj instanceof k) {
            k kVar = (k) obj;
            if (this.a.equals(kVar.a()) && ((aoVar = this.b) != null ? aoVar.equals(kVar.b()) : kVar.b() == null)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int iN;
        int iHashCode = this.a.hashCode() ^ 1000003;
        ao aoVar = this.b;
        if (aoVar == null) {
            iN = 0;
        } else if (aoVar.H()) {
            iN = aoVar.n();
        } else {
            int iN2 = aoVar.ak;
            if (iN2 == 0) {
                iN2 = aoVar.n();
                aoVar.ak = iN2;
            }
            iN = iN2;
        }
        return (iHashCode * 1000003) ^ iN;
    }

    public final String toString() {
        ao aoVar = this.b;
        return "{" + this.a.toString() + ", " + String.valueOf(aoVar) + "}";
    }
}
