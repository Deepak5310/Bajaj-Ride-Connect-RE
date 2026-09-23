package com.google.android.libraries.navigation.internal.yx;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public abstract class v implements aa {
    protected v() {
    }

    @Override // com.google.android.libraries.navigation.internal.yx.aa
    @Deprecated
    public final Object ak(Object obj) {
        return c(obj);
    }

    protected abstract Object b(Object obj);

    public final Object c(Object obj) {
        if (obj == null) {
            return null;
        }
        Object objB = b(obj);
        ar.q(objB);
        return objB;
    }
}
