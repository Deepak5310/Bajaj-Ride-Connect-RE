package com.google.android.libraries.navigation.internal.po;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class fj implements com.google.android.libraries.navigation.internal.nt.t {
    Runnable a;

    @Override // com.google.android.libraries.navigation.internal.nt.t
    public final void a(com.google.android.libraries.navigation.internal.nt.m mVar) {
        Runnable runnable;
        boolean z;
        synchronized (this) {
            runnable = this.a;
            Boolean bool = (Boolean) mVar.c();
            z = false;
            if (bool != null && bool.booleanValue()) {
                this.a = null;
                z = true;
            }
        }
        if (!z || runnable == null) {
            return;
        }
        runnable.run();
    }

    final synchronized void b(Runnable runnable) {
        this.a = runnable;
    }
}
