package com.google.android.libraries.navigation.internal.xa;

import com.google.android.libraries.navigation.internal.fq.d;
import java.util.Iterator;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class a implements Runnable {
    final /* synthetic */ b a;

    public a(b bVar) {
        this.a = bVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Object objA;
        synchronized (this.a) {
            if (!this.a.a.isEmpty()) {
                try {
                    objA = this.a.a();
                } catch (Exception unused) {
                    objA = null;
                }
                if (objA != null) {
                    Iterator it2 = this.a.a.iterator();
                    while (it2.hasNext()) {
                        ((d) it2.next()).a();
                    }
                }
            }
        }
    }
}
