package com.google.android.libraries.navigation.internal.ms;

import java.util.Arrays;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class bd {
    final Class a;
    public final Object[] b;

    public bd(Class cls, Object... objArr) {
        this.a = cls;
        this.b = objArr;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof bd)) {
            return false;
        }
        bd bdVar = (bd) obj;
        return this.a.equals(bdVar.a) && Arrays.deepEquals(this.b, bdVar.b);
    }

    public final int hashCode() {
        return this.a.hashCode() + (Arrays.deepHashCode(this.b) * 31);
    }

    public final String toString() {
        Object[] objArr = this.b;
        Class cls = this.a;
        return getClass().getSimpleName() + "{class: " + String.valueOf(cls) + ", args: " + Arrays.deepToString(objArr) + "}";
    }
}
