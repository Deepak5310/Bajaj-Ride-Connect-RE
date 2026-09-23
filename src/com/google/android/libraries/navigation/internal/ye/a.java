package com.google.android.libraries.navigation.internal.ye;

import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class a implements com.google.android.libraries.navigation.internal.xy.e {
    public boolean a = false;

    static {
        new AtomicInteger();
    }

    @Override // com.google.android.libraries.navigation.internal.xy.e
    public final /* bridge */ /* synthetic */ Object a(com.google.android.libraries.navigation.internal.xy.d dVar) throws IOException {
        if (this.a) {
            if (dVar.b.isEmpty()) {
                return dVar.a.c(dVar.e);
            }
            throw new com.google.android.libraries.navigation.internal.yb.f("Short circuit would skip transforms.");
        }
        com.google.android.libraries.navigation.internal.yb.e eVar = new com.google.android.libraries.navigation.internal.yb.e(c.b(dVar));
        try {
            Closeable closeable = eVar.a;
            if (!(closeable instanceof com.google.android.libraries.navigation.internal.yb.a)) {
                throw new IOException("Not convertible and fallback to pipe is disabled.");
            }
            File fileA = ((com.google.android.libraries.navigation.internal.yb.a) closeable).a();
            eVar.close();
            return fileA;
        } catch (Throwable th) {
            try {
                eVar.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }
}
