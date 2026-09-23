package com.google.android.libraries.navigation.internal.yx;

import java.io.Serializable;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class w extends y implements Serializable {
    public static final w a = new w();
    private static final long serialVersionUID = 1;

    private Object readResolve() {
        return a;
    }

    @Override // com.google.android.libraries.navigation.internal.yx.y
    protected final int a(Object obj) {
        return obj.hashCode();
    }

    @Override // com.google.android.libraries.navigation.internal.yx.y
    protected final boolean b(Object obj, Object obj2) {
        return obj.equals(obj2);
    }
}
