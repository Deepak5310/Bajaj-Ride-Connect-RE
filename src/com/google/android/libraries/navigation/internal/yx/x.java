package com.google.android.libraries.navigation.internal.yx;

import java.io.Serializable;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class x extends y implements Serializable {
    public static final x a = new x();
    private static final long serialVersionUID = 1;

    private Object readResolve() {
        return a;
    }

    @Override // com.google.android.libraries.navigation.internal.yx.y
    protected final int a(Object obj) {
        return System.identityHashCode(obj);
    }

    @Override // com.google.android.libraries.navigation.internal.yx.y
    protected final boolean b(Object obj, Object obj2) {
        return false;
    }
}
