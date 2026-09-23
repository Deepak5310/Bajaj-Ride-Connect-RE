package com.google.android.libraries.navigation.internal.aga;

import java.util.Arrays;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class r {
    public String a = "unknown-authority";
    public com.google.android.libraries.navigation.internal.afx.c b = com.google.android.libraries.navigation.internal.afx.c.a;
    public String c;
    public com.google.android.libraries.navigation.internal.afx.ac d;

    public final boolean equals(Object obj) {
        if (!(obj instanceof r)) {
            return false;
        }
        r rVar = (r) obj;
        if (this.a.equals(rVar.a) && this.b.equals(rVar.b)) {
            String str = rVar.c;
            if (com.google.android.libraries.navigation.internal.yx.am.a(null, null) && com.google.android.libraries.navigation.internal.yx.am.a(this.d, rVar.d)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.a, this.b, null, this.d});
    }
}
