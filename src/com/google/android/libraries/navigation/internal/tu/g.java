package com.google.android.libraries.navigation.internal.tu;

import java.util.Objects;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class g extends t {
    public final String a;
    public final com.google.android.libraries.navigation.internal.ael.x b;

    public g(String str, com.google.android.libraries.navigation.internal.ael.x xVar) {
        Objects.requireNonNull(str);
        this.a = str;
        this.b = xVar;
    }

    @Override // com.google.android.libraries.navigation.internal.tu.t
    public final com.google.android.libraries.navigation.internal.ael.x a() {
        return this.b;
    }

    @Override // com.google.android.libraries.navigation.internal.tu.t
    public final String b() {
        return this.a;
    }

    public final boolean equals(Object obj) {
        com.google.android.libraries.navigation.internal.ael.x xVar;
        if (obj == this) {
            return true;
        }
        if (obj instanceof t) {
            t tVar = (t) obj;
            if (this.a.equals(tVar.b()) && ((xVar = this.b) != null ? xVar.equals(tVar.a()) : tVar.a() == null)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int iHashCode = this.a.hashCode() ^ 1000003;
        com.google.android.libraries.navigation.internal.ael.x xVar = this.b;
        return (iHashCode * 1000003) ^ (xVar == null ? 0 : xVar.hashCode());
    }
}
