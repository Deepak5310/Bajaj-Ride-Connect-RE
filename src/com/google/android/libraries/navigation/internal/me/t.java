package com.google.android.libraries.navigation.internal.me;

import java.util.concurrent.Executor;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class t implements x {
    public final Object a = new Object();
    public final u b;
    private final Executor c;

    public t(Executor executor, u uVar) {
        this.c = executor;
        this.b = uVar;
    }

    @Override // com.google.android.libraries.navigation.internal.me.x
    public final void a(w wVar) {
        if (wVar.e()) {
            synchronized (this.a) {
            }
            this.c.execute(new s(this, wVar));
        }
    }
}
