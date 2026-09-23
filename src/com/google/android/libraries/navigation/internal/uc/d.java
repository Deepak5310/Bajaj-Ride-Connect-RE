package com.google.android.libraries.navigation.internal.uc;

import com.google.android.libraries.navigation.internal.afl.ff;
import com.google.android.libraries.navigation.internal.zs.aq;
import com.google.android.libraries.navigation.internal.zs.ar;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class d extends n {
    public final com.google.android.libraries.navigation.internal.pd.i a;
    private final ff c;
    private final ar d;
    private final aq e;

    public d(ff ffVar, ar arVar, aq aqVar, com.google.android.libraries.navigation.internal.pd.i iVar) {
        this.c = ffVar;
        this.d = arVar;
        this.e = aqVar;
        this.a = iVar;
    }

    @Override // com.google.android.libraries.navigation.internal.uc.n
    public final com.google.android.libraries.navigation.internal.pd.i a() {
        return this.a;
    }

    @Override // com.google.android.libraries.navigation.internal.uc.n
    public final aq b() {
        return this.e;
    }

    @Override // com.google.android.libraries.navigation.internal.uc.n
    public final ar c() {
        return this.d;
    }

    @Override // com.google.android.libraries.navigation.internal.uc.n
    public final ff d() {
        return this.c;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof n) {
            n nVar = (n) obj;
            if (this.c.equals(nVar.d()) && this.d.equals(nVar.c()) && this.e.equals(nVar.b()) && this.a.equals(nVar.a())) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return ((((((this.c.hashCode() ^ 1000003) * 1000003) ^ this.d.hashCode()) * 1000003) ^ this.e.hashCode()) * 1000003) ^ this.a.hashCode();
    }

    public final String toString() {
        com.google.android.libraries.navigation.internal.pd.i iVar = this.a;
        aq aqVar = this.e;
        ar arVar = this.d;
        return "{" + String.valueOf(this.c) + ", " + String.valueOf(arVar) + ", " + String.valueOf(aqVar) + ", " + String.valueOf(iVar) + "}";
    }
}
