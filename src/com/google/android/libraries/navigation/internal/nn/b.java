package com.google.android.libraries.navigation.internal.nn;

import com.google.android.libraries.navigation.internal.yx.ax;
import com.google.android.libraries.navigation.internal.yz.fd;
import com.google.android.libraries.navigation.internal.yz.nn;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class b {
    private final HashMap a = new HashMap();

    public final synchronized int a() {
        return this.a.size();
    }

    public final synchronized void b(Object obj, Executor executor) {
        Executor executor2 = (Executor) this.a.put(obj, executor);
        if (executor2 != null && executor2 != executor) {
            throw new IllegalArgumentException("Listener already registered with different executor.");
        }
    }

    public final synchronized void c() {
        this.a.clear();
    }

    public final void d(final ax axVar) {
        fd fdVarJ;
        synchronized (this) {
            fdVarJ = fd.j(this.a);
        }
        nn nnVarListIterator = fdVarJ.entrySet().listIterator();
        while (nnVarListIterator.hasNext()) {
            Map.Entry entry = (Map.Entry) nnVarListIterator.next();
            final Object key = entry.getKey();
            ((Executor) entry.getValue()).execute(new Runnable() { // from class: com.google.android.libraries.navigation.internal.nn.a
                @Override // java.lang.Runnable
                public final void run() {
                    axVar.a(key);
                }
            });
        }
    }

    public final synchronized void e(Object obj) {
        this.a.remove(obj);
    }
}
