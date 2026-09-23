package com.google.android.libraries.navigation.internal.vm;

import com.google.android.libraries.navigation.internal.yx.ax;
import com.google.android.libraries.navigation.internal.yz.fd;
import com.google.android.libraries.navigation.internal.yz.nn;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
@Deprecated
public final class e {
    private final HashMap a = new HashMap();

    public final void a(final ax axVar) {
        fd fdVarJ;
        synchronized (this) {
            fdVarJ = fd.j(this.a);
        }
        nn nnVarListIterator = fdVarJ.entrySet().listIterator();
        while (nnVarListIterator.hasNext()) {
            final d dVar = (d) ((Map.Entry) nnVarListIterator.next()).getValue();
            dVar.b.execute(new Runnable() { // from class: com.google.android.libraries.navigation.internal.vm.c
                @Override // java.lang.Runnable
                public final void run() {
                    d dVar2 = dVar;
                    ax axVar2 = axVar;
                    synchronized (dVar2) {
                        if (!dVar2.c) {
                            axVar2.a(dVar2.a);
                        }
                    }
                }
            });
        }
    }

    public final void b(Object obj) {
        d dVar;
        synchronized (this) {
            dVar = (d) this.a.remove(obj);
        }
        if (dVar != null) {
            dVar.a();
        }
    }

    public final void c(Object obj, Executor executor) {
        d dVar = new d(obj, executor);
        synchronized (this) {
            if (this.a.put(obj, dVar) != null) {
                throw new IllegalArgumentException("Listener is already registered.");
            }
        }
    }
}
