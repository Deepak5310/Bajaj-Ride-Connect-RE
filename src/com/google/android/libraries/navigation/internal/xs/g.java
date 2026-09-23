package com.google.android.libraries.navigation.internal.xs;

import com.google.android.libraries.navigation.internal.yz.gl;
import com.google.android.libraries.navigation.internal.yz.mc;
import com.google.android.libraries.navigation.internal.yz.mp;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class g {
    public static final g a = new g(mc.c);
    public final gl b;

    public g(gl glVar) {
        this.b = glVar;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof g) {
            return this.b.equals(((g) obj).b);
        }
        return false;
    }

    public final int hashCode() {
        return mp.a(this.b);
    }
}
