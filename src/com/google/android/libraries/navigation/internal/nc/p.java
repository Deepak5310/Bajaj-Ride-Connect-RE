package com.google.android.libraries.navigation.internal.nc;

import android.content.Context;
import java.util.Arrays;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public abstract class p implements ap, ao {
    protected final Object[] c;

    protected p(Object[] objArr) {
        this.c = objArr;
    }

    public static ap b(ap apVar, Float f) {
        return new l(new Object[]{apVar, f}, apVar, f);
    }

    public static ap c(ap apVar, ap apVar2) {
        return new m(new Object[]{apVar, apVar2}, apVar, apVar2);
    }

    @Override // com.google.android.libraries.navigation.internal.nc.ap
    public final int d(Context context) {
        return (int) a(context);
    }

    @Override // com.google.android.libraries.navigation.internal.nc.ap
    public final int e(Context context) {
        float fA = a(context);
        int i = (int) (0.5f + fA);
        if (i != 0) {
            return i;
        }
        return fA == 0.0f ? 0 : 1;
    }

    public final boolean equals(Object obj) {
        if (obj == null || !getClass().equals(obj.getClass())) {
            return false;
        }
        return Arrays.equals(this.c, ((p) obj).c);
    }

    public final int hashCode() {
        return Arrays.hashCode(this.c);
    }
}
