package com.google.android.libraries.navigation.internal.aga;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class eo implements Runnable {
    final /* synthetic */ ep a;
    final /* synthetic */ eq b;
    final /* synthetic */ Object c;
    final /* synthetic */ er d;

    public eo(er erVar, ep epVar, eq eqVar, Object obj) {
        this.a = epVar;
        this.b = eqVar;
        this.c = obj;
        this.d = erVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        synchronized (this.d) {
            if (this.a.b == 0) {
                try {
                    this.b.b(this.c);
                    this.d.a.remove(this.b);
                    if (this.d.a.isEmpty()) {
                        this.d.b.shutdown();
                        this.d.b = null;
                    }
                } catch (Throwable th) {
                    this.d.a.remove(this.b);
                    if (this.d.a.isEmpty()) {
                        this.d.b.shutdown();
                        this.d.b = null;
                    }
                    throw th;
                }
            }
        }
    }
}
