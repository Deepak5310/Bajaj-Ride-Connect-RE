package com.google.android.libraries.navigation.internal.rd;

import com.google.android.libraries.navigation.internal.adg.es;
import java.util.Objects;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class b extends e {
    private final es a;

    public b(es esVar) {
        Objects.requireNonNull(esVar);
        this.a = esVar;
    }

    @Override // com.google.android.libraries.navigation.internal.rd.e
    public final es a() {
        return this.a;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof e) {
            return this.a.equals(((e) obj).a());
        }
        return false;
    }

    public final int hashCode() {
        int iN;
        es esVar = this.a;
        if (esVar.H()) {
            iN = esVar.n();
        } else {
            int iN2 = esVar.ak;
            if (iN2 == 0) {
                iN2 = esVar.n();
                esVar.ak = iN2;
            }
            iN = iN2;
        }
        return iN ^ 1000003;
    }

    public final String toString() {
        return "{" + String.valueOf(this.a) + "}";
    }
}
