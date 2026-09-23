package com.google.android.libraries.navigation.internal.le;

import java.util.Arrays;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class af {
    public final i a;
    public final com.google.android.libraries.navigation.internal.lc.d b;

    public af(i iVar, com.google.android.libraries.navigation.internal.lc.d dVar) {
        this.a = iVar;
        this.b = dVar;
    }

    public final boolean equals(Object obj) {
        if (obj != null && (obj instanceof af)) {
            af afVar = (af) obj;
            if (com.google.android.libraries.navigation.internal.lh.az.a(this.a, afVar.a) && com.google.android.libraries.navigation.internal.lh.az.a(this.b, afVar.b)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.a, this.b});
    }

    public final String toString() {
        com.google.android.libraries.navigation.internal.lh.ay ayVar = new com.google.android.libraries.navigation.internal.lh.ay(this);
        ayVar.a("key", this.a);
        ayVar.a("feature", this.b);
        return ayVar.toString();
    }
}
