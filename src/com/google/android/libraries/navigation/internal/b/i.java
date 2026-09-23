package com.google.android.libraries.navigation.internal.b;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class i implements Runnable {
    private final t a;
    private final z b;
    private final Runnable c;

    public i(t tVar, z zVar, Runnable runnable) {
        this.a = tVar;
        this.b = zVar;
        this.c = runnable;
    }

    @Override // java.lang.Runnable
    public final void run() {
        x xVar;
        if (this.a.n()) {
            this.a.i("canceled-at-delivery");
            return;
        }
        z zVar = this.b;
        if (zVar.a()) {
            this.a.h(zVar.a);
        } else {
            t tVar = this.a;
            synchronized (tVar.e) {
                xVar = tVar.f;
            }
            if (xVar != null) {
                xVar.a(zVar.c);
            }
        }
        if (this.b.d) {
            this.a.f("intermediate-response");
        } else {
            this.a.i("done");
        }
        Runnable runnable = this.c;
        if (runnable != null) {
            runnable.run();
        }
    }
}
