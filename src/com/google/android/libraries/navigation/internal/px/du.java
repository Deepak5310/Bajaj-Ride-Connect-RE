package com.google.android.libraries.navigation.internal.px;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class du {
    public final int a;
    public final com.google.android.libraries.navigation.internal.yx.an b;

    public du(int i, com.google.android.libraries.navigation.internal.yx.an anVar) {
        this.a = i;
        this.b = anVar;
    }

    public static du a(int i, eb ebVar) {
        return new du(i, com.google.android.libraries.navigation.internal.yx.an.j(ebVar));
    }

    public final String toString() {
        return "{renderId=" + this.a + ", placement=" + this.b.toString() + "}";
    }
}
