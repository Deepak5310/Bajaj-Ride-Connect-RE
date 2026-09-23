package com.google.android.libraries.navigation.internal.mc;

import com.google.android.libraries.navigation.internal.ld.g;
import com.google.android.libraries.navigation.internal.lh.az;
import java.util.Arrays;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class f implements g {
    public static final f b = new f();
    private final boolean c = false;
    private final boolean d = false;
    private final String e = null;
    private final boolean f = false;
    private final boolean i = false;
    private final String g = null;
    private final String h = null;
    private final Long j = null;
    private final Long k = null;

    private f() {
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof f)) {
            return false;
        }
        f fVar = (f) obj;
        boolean z = fVar.c;
        boolean z2 = fVar.d;
        String str = fVar.e;
        if (az.a(null, null)) {
            boolean z3 = fVar.f;
            boolean z4 = fVar.i;
            String str2 = fVar.g;
            if (az.a(null, null)) {
                String str3 = fVar.h;
                if (az.a(null, null)) {
                    Long l = fVar.j;
                    if (az.a(null, null)) {
                        Long l2 = fVar.k;
                        if (az.a(null, null)) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{false, false, null, false, false, null, null, null, null});
    }
}
