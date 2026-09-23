package com.google.android.libraries.navigation.internal.le;

import java.util.Arrays;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class i {
    public final com.google.android.libraries.navigation.internal.ld.k a;
    private final int b;
    private final com.google.android.libraries.navigation.internal.ld.g c;
    private final String d;

    public i(com.google.android.libraries.navigation.internal.ld.k kVar, com.google.android.libraries.navigation.internal.ld.g gVar, String str) {
        this.a = kVar;
        this.c = gVar;
        this.d = str;
        this.b = Arrays.hashCode(new Object[]{kVar, gVar, str});
    }

    public final boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof i)) {
            return false;
        }
        i iVar = (i) obj;
        return com.google.android.libraries.navigation.internal.lh.az.a(this.a, iVar.a) && com.google.android.libraries.navigation.internal.lh.az.a(this.c, iVar.c) && com.google.android.libraries.navigation.internal.lh.az.a(this.d, iVar.d);
    }

    public final int hashCode() {
        return this.b;
    }
}
