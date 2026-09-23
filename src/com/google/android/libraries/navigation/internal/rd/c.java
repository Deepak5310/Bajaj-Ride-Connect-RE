package com.google.android.libraries.navigation.internal.rd;

import com.google.android.libraries.navigation.internal.adg.ga;
import java.util.Objects;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class c extends f {
    private final ga a;

    public c(ga gaVar) {
        Objects.requireNonNull(gaVar);
        this.a = gaVar;
    }

    @Override // com.google.android.libraries.navigation.internal.rd.f
    public final ga a() {
        return this.a;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof f) {
            return this.a.equals(((f) obj).a());
        }
        return false;
    }

    public final int hashCode() {
        int iN;
        ga gaVar = this.a;
        if (gaVar.H()) {
            iN = gaVar.n();
        } else {
            int iN2 = gaVar.ak;
            if (iN2 == 0) {
                iN2 = gaVar.n();
                gaVar.ak = iN2;
            }
            iN = iN2;
        }
        return iN ^ 1000003;
    }

    public final String toString() {
        return "{" + String.valueOf(this.a) + "}";
    }
}
