package com.google.android.libraries.navigation.internal.me;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class h implements Runnable {
    final /* synthetic */ w a;
    final /* synthetic */ i b;

    public h(i iVar, w wVar) {
        this.a = wVar;
        this.b = iVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            w wVar = (w) this.b.a.a(this.a);
            if (wVar == null) {
                this.b.c(new NullPointerException("Continuation returned null"));
                return;
            }
            wVar.k(ad.b, this.b);
            wVar.i(ad.b, this.b);
            wVar.f(ad.b, this.b);
        } catch (v e) {
            if (!(e.getCause() instanceof Exception)) {
                this.b.b.l(e);
                return;
            }
            i iVar = this.b;
            iVar.b.l((Exception) e.getCause());
        } catch (Exception e2) {
            this.b.b.l(e2);
        }
    }
}
