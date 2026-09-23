package com.google.android.libraries.navigation.internal.kk;

import com.google.android.libraries.navigation.internal.ky.an;
import com.google.android.libraries.navigation.internal.ky.ao;
import com.google.android.libraries.navigation.internal.ky.ap;
import java.io.Closeable;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class m implements Closeable {
    public final an a;

    public m() {
        this(null);
    }

    public m(an anVar) {
        this.a = anVar;
    }

    public final void a() {
        an anVar = this.a;
        if (anVar != null) {
            ao aoVar = anVar.a;
            aoVar.a(aoVar.g.a(anVar.a()), 1L, ap.c);
        }
    }

    public final void b() {
        an anVar = this.a;
        if (anVar != null) {
            anVar.b();
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        a();
    }
}
