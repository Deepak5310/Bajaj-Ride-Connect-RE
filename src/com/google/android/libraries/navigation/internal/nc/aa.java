package com.google.android.libraries.navigation.internal.nc;

import android.content.Context;
import java.util.Arrays;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public class aa implements ao {
    private final Object a;
    private final Object b;

    protected aa(Object obj, Object obj2) {
        this.a = obj;
        this.b = obj2;
    }

    protected final Object c(Context context) {
        return (com.google.android.libraries.navigation.internal.ms.aq.c(context) || com.google.android.libraries.navigation.internal.nu.a.a(context)) ? this.a : this.b;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof aa) {
            aa aaVar = (aa) obj;
            if (com.google.android.libraries.navigation.internal.yx.am.a(this.a, aaVar.a) && com.google.android.libraries.navigation.internal.yx.am.a(this.b, aaVar.b)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.a, this.b});
    }
}
