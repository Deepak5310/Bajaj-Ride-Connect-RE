package com.google.android.libraries.navigation.internal.nc;

import com.google.android.libraries.navigation.internal.ms.cw;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public class s implements cw, az {
    private final com.google.android.libraries.navigation.internal.ms.bd a;
    private final boolean b;

    protected s(boolean z, Object[] objArr) {
        this.a = new com.google.android.libraries.navigation.internal.ms.bd(getClass(), objArr);
        this.b = z;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    protected s(Object[] objArr) {
        boolean z = false;
        for (Object obj : objArr) {
            if (bi.b(obj)) {
                z = true;
                break;
            }
        }
        this(z, objArr);
    }

    public final boolean equals(Object obj) {
        return (obj instanceof s) && this.a.equals(((s) obj).a);
    }

    @Override // com.google.android.libraries.navigation.internal.nc.az
    public final boolean f() {
        return this.b;
    }

    public final int hashCode() {
        return this.a.hashCode();
    }
}
