package com.google.android.libraries.navigation.internal.b;

import android.os.Handler;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class j implements aa {
    public final Executor a;

    public j(Handler handler) {
        this.a = new h(handler);
    }

    public j(Executor executor) {
        this.a = executor;
    }

    @Override // com.google.android.libraries.navigation.internal.b.aa
    public final void a(t tVar, ad adVar) {
        throw null;
    }

    @Override // com.google.android.libraries.navigation.internal.b.aa
    public final void b(t tVar, z zVar) {
        c(tVar, zVar, null);
    }

    @Override // com.google.android.libraries.navigation.internal.b.aa
    public final void c(t tVar, z zVar, Runnable runnable) {
        tVar.j();
        tVar.f("post-response");
        this.a.execute(new i(tVar, zVar, runnable));
    }
}
