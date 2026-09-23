package com.mappls.sdk.navigation;

import java.util.Iterator;

/* JADX INFO: loaded from: classes4.dex */
final class b implements Runnable {
    final /* synthetic */ c a;

    b(c cVar) {
        this.a = cVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Iterator it2 = this.a.e.iterator();
        while (it2.hasNext()) {
            ((c.InterfaceC0094c) it2.next()).a();
        }
    }
}
