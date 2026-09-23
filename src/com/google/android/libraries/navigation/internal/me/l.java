package com.google.android.libraries.navigation.internal.me;

import java.util.concurrent.Executor;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class l implements x {
    public final Object a = new Object();
    public final i b;
    private final Executor c;

    public l(Executor executor, i iVar) {
        this.c = executor;
        this.b = iVar;
    }

    @Override // com.google.android.libraries.navigation.internal.me.x
    public final void a(w wVar) {
        if (((ae) wVar).d) {
            synchronized (this.a) {
            }
            this.c.execute(new k(this));
        }
    }
}
