package com.google.android.libraries.navigation.internal.my;

import android.os.Process;
import androidx.collection.ArrayMap;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.util.Map;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class l {
    public static final ReferenceQueue a = new ReferenceQueue();
    private static final Thread c;
    public final Map b = new ArrayMap();
    private final j d = new j();

    static {
        Thread thread = new Thread(new Runnable() { // from class: com.google.android.libraries.navigation.internal.my.h
            @Override // java.lang.Runnable
            public final void run() {
                ReferenceQueue referenceQueue = l.a;
                try {
                    Process.setThreadPriority(10);
                    while (true) {
                        try {
                            Reference referenceRemove = l.a.remove();
                            if (referenceRemove instanceof k) {
                                ((k) referenceRemove).a();
                            }
                        } catch (InterruptedException unused) {
                            return;
                        }
                    }
                } catch (SecurityException e) {
                    System.out.println("SecurityException while setting priority for Curvular WeakIdentityMap.cleanupThread. Continuing with default priority: ".concat(e.toString()));
                }
            }
        }, "weak-identity-map-cleanup-thread");
        c = thread;
        thread.start();
    }

    public static boolean b(i iVar, i iVar2) {
        Object obj = iVar.get();
        return obj != null && obj == iVar2.get();
    }

    public final Object a(Object obj) {
        Object obj2;
        if (obj == null) {
            return null;
        }
        synchronized (this.b) {
            try {
                Map map = this.b;
                j jVar = this.d;
                jVar.a = obj;
                obj2 = map.get(jVar);
                this.d.a();
            } catch (Throwable th) {
                this.d.a();
                throw th;
            }
        }
        return obj2;
    }
}
