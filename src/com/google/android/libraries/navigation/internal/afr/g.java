package com.google.android.libraries.navigation.internal.afr;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class g implements f, com.google.android.libraries.navigation.internal.afo.a {
    private static final g b = new g(null);
    public final Object a;

    private g(Object obj) {
        this.a = obj;
    }

    public static f b(Object obj) {
        j.c(obj, "instance cannot be null");
        return new g(obj);
    }

    public static f c(Object obj) {
        return obj == null ? b : new g(obj);
    }

    @Override // com.google.android.libraries.navigation.internal.agl.a, com.google.android.libraries.navigation.internal.agk.a
    public final Object a() {
        return this.a;
    }
}
