package com.google.android.libraries.navigation.internal.afx;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class cn implements Runnable {
    final /* synthetic */ co a;
    final /* synthetic */ Runnable b;
    final /* synthetic */ cq c;

    public cn(cq cqVar, co coVar, Runnable runnable) {
        this.a = coVar;
        this.b = runnable;
        this.c = cqVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.c.execute(this.a);
    }

    public final String toString() {
        return String.valueOf(this.b.toString()).concat("(scheduled in SynchronizationContext)");
    }
}
