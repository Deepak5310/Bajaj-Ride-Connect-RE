package com.mappls.sdk.navigation.routing;

import com.mappls.sdk.navigation.iface.INavigationListener;
import java.lang.ref.WeakReference;
import java.util.Iterator;

/* JADX INFO: loaded from: classes4.dex */
final class e implements Runnable {
    final /* synthetic */ d a;

    e(d dVar) {
        this.a = dVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.a.h != null) {
            Iterator it2 = this.a.h.iterator();
            while (it2.hasNext()) {
                INavigationListener iNavigationListener = (INavigationListener) ((WeakReference) it2.next()).get();
                if (iNavigationListener == null) {
                    it2.remove();
                } else {
                    iNavigationListener.onNavigationFinished();
                }
            }
        }
        Iterator it3 = this.a.f.iterator();
        while (it3.hasNext()) {
            d.c cVar = (d.c) ((WeakReference) it3.next()).get();
            if (cVar == null) {
                it3.remove();
            } else {
                cVar.c();
            }
        }
    }
}
