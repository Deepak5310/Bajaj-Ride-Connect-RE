package com.google.android.libraries.navigation.internal.hx;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final /* synthetic */ class af implements Runnable {
    public final /* synthetic */ ag a;

    public /* synthetic */ af(ag agVar) {
        this.a = agVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ag agVar = this.a;
        synchronized (agVar.b) {
            Runnable runnable = (Runnable) agVar.b.poll();
            if (runnable == null) {
                agVar.c = false;
            } else {
                runnable.run();
                agVar.a.execute(new af(agVar));
            }
        }
    }
}
