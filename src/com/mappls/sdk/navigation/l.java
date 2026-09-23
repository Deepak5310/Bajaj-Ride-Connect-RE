package com.mappls.sdk.navigation;

/* JADX INFO: loaded from: classes4.dex */
final class l implements Runnable {
    final /* synthetic */ int a = 5001;
    final /* synthetic */ Runnable b;
    final /* synthetic */ NavigationContext c;

    l(NavigationContext navigationContext, Runnable runnable) {
        this.c = navigationContext;
        this.b = runnable;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.c.g.hasMessages(this.a)) {
            return;
        }
        this.b.run();
    }
}
