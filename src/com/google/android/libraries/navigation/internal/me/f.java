package com.google.android.libraries.navigation.internal.me;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class f implements Runnable {
    final /* synthetic */ w a;
    final /* synthetic */ g b;

    public f(g gVar, w wVar) {
        this.a = wVar;
        this.b = gVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (((ae) this.a).d) {
            this.b.b.n();
            return;
        }
        try {
            this.b.b.m(this.b.a.a(this.a));
        } catch (v e) {
            if (!(e.getCause() instanceof Exception)) {
                this.b.b.l(e);
                return;
            }
            g gVar = this.b;
            gVar.b.l((Exception) e.getCause());
        } catch (Exception e2) {
            this.b.b.l(e2);
        }
    }
}
