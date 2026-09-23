package com.google.android.libraries.navigation.internal.sk;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class ei {
    public final com.google.android.libraries.navigation.internal.tv.c a;
    public final com.google.android.libraries.navigation.internal.sl.h b;
    private final com.google.android.libraries.navigation.internal.vn.d c;
    private dr d;

    public ei(com.google.android.libraries.navigation.internal.vn.d dVar, dr drVar, com.google.android.libraries.navigation.internal.tv.c cVar, com.google.android.libraries.navigation.internal.sl.h hVar) {
        this.c = dVar;
        this.d = drVar;
        this.a = cVar;
        this.b = hVar;
    }

    final com.google.android.libraries.navigation.internal.tu.t a() {
        return this.c.a;
    }

    final void b(c cVar) {
        dr drVar = this.d;
        if (drVar != null) {
            drVar.g();
            this.d = null;
        }
    }

    final void c() {
        b(null);
    }
}
