package com.google.android.libraries.navigation.internal.abg;

import androidx.collection.LruCache;
import com.google.android.libraries.navigation.internal.b.aa;
import com.google.android.libraries.navigation.internal.b.z;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class l extends com.google.android.libraries.navigation.internal.b.w {
    private static final Executor j = new Executor() { // from class: com.google.android.libraries.navigation.internal.abg.i
        @Override // java.util.concurrent.Executor
        public final void execute(Runnable runnable) {
            runnable.run();
        }
    };
    private final LruCache k;
    private final com.google.android.libraries.navigation.internal.b.j l;

    public l(com.google.android.libraries.navigation.internal.b.c cVar, com.google.android.libraries.navigation.internal.b.l lVar, LruCache lruCache, aa aaVar) {
        super(cVar, lVar, new k(lruCache, aaVar));
        this.k = lruCache;
        this.l = new com.google.android.libraries.navigation.internal.b.j(j);
    }

    @Override // com.google.android.libraries.navigation.internal.b.w
    public final com.google.android.libraries.navigation.internal.b.t a(com.google.android.libraries.navigation.internal.b.t tVar) {
        z zVar = (z) this.k.get(tVar.c);
        if (zVar != null) {
            this.l.b(tVar, zVar);
            return tVar;
        }
        super.a(tVar);
        return tVar;
    }
}
