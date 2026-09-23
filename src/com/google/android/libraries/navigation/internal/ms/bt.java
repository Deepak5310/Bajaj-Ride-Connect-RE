package com.google.android.libraries.navigation.internal.ms;

import androidx.collection.ArrayMap;
import com.google.android.libraries.navigation.internal.ms.cs;
import java.util.Arrays;
import java.util.Collections;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public abstract class bt<T extends cs> {
    private static final Object[] a = new Object[0];
    final bd e;

    static {
        Collections.synchronizedMap(new ArrayMap());
    }

    public bt() {
        this(a);
    }

    public bt(Object... objArr) {
        this.e = new bd(getClass(), objArr);
    }

    protected abstract com.google.android.libraries.navigation.internal.mx.g a();

    protected void d(int i, cs csVar, bs bsVar) {
        throw new com.google.android.libraries.navigation.internal.yx.cb("If layoutViewBinderListAdapter() is called, one of the createLayoutListAdapter methods needs to be overridden.");
    }

    @Deprecated
    protected final by e() {
        return new br(this, 0);
    }

    public final boolean equals(Object obj) {
        return (obj instanceof bt) && this.e.equals(((bt) obj).e);
    }

    public final String f() {
        bd bdVar = this.e;
        String name = bdVar.a.getName();
        Object[] objArr = bdVar.b;
        if (objArr.length == 0) {
            return name;
        }
        String strDeepToString = Arrays.deepToString(objArr);
        return name + "(" + strDeepToString.substring(1, strDeepToString.length() - 1) + ")";
    }

    public final boolean g() {
        return !bp.class.isAssignableFrom(this.e.a);
    }

    public final int hashCode() {
        return this.e.hashCode();
    }

    public final String toString() {
        return f();
    }
}
