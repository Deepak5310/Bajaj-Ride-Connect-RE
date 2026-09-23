package com.google.android.libraries.navigation.internal.wl;

import com.google.android.libraries.navigation.internal.add.aw;
import com.google.android.libraries.navigation.internal.yz.fd;
import java.util.Objects;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class b extends d {
    public final aw a;
    public final fd b;

    public b(aw awVar, fd fdVar) {
        Objects.requireNonNull(awVar);
        this.a = awVar;
        Objects.requireNonNull(fdVar);
        this.b = fdVar;
    }

    @Override // com.google.android.libraries.navigation.internal.wl.d
    public final fd a() {
        return this.b;
    }

    @Override // com.google.android.libraries.navigation.internal.wl.d
    public final aw b() {
        return this.a;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof d) {
            d dVar = (d) obj;
            if (this.a.equals(dVar.b()) && this.b.equals(dVar.a())) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int iN;
        aw awVar = this.a;
        if (awVar.H()) {
            iN = awVar.n();
        } else {
            int iN2 = awVar.ak;
            if (iN2 == 0) {
                iN2 = awVar.n();
                awVar.ak = iN2;
            }
            iN = iN2;
        }
        return ((iN ^ 1000003) * 1000003) ^ this.b.hashCode();
    }

    public final String toString() {
        fd fdVar = this.b;
        return "{" + String.valueOf(this.a) + ", " + String.valueOf(fdVar) + "}";
    }
}
