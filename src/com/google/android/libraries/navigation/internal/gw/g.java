package com.google.android.libraries.navigation.internal.gw;

import android.content.res.Resources;
import com.google.android.libraries.navigation.internal.yx.am;
import java.util.Arrays;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class g {
    public final Resources a;
    public final int b;
    private final byte[] c = null;

    public g(Resources resources, int i) {
        this.a = resources;
        this.b = i;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof g)) {
            return false;
        }
        g gVar = (g) obj;
        if (this.b == gVar.b) {
            byte[] bArr = gVar.c;
            if (am.a(this.a, gVar.a)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.a, Integer.valueOf(this.b), Integer.valueOf(System.identityHashCode(null))});
    }
}
