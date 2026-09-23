package com.google.android.libraries.navigation.internal.ia;

import androidx.tracing.Trace;
import com.google.android.libraries.navigation.internal.hx.ai;
import com.google.android.libraries.navigation.internal.hx.ap;
import com.google.android.libraries.navigation.internal.yx.an;
import com.google.android.libraries.navigation.internal.yx.ar;
import com.google.android.libraries.navigation.internal.yz.ee;
import com.google.android.libraries.navigation.internal.yz.ev;
import com.google.android.libraries.navigation.internal.yz.fw;
import com.google.android.libraries.navigation.internal.yz.gc;
import com.google.android.libraries.navigation.internal.yz.mh;
import com.google.android.libraries.navigation.internal.yz.no;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public class i implements e {
    private static final com.google.android.libraries.navigation.internal.zb.j a = com.google.android.libraries.navigation.internal.zb.j.e("com.google.android.libraries.navigation.internal.ia.i");
    private final n f;
    private final b g;
    private final mh b = new ee();
    private final Map c = new HashMap();
    private final ReadWriteLock d = new ReentrantReadWriteLock();
    private final ThreadLocal h = new f();
    private final ThreadLocal i = new g();
    private volatile boolean j = false;
    private final l e = new l(this);

    public i(ai aiVar, an anVar) {
        this.f = new n(aiVar, this);
        this.g = (b) anVar.f();
    }

    static final void h(com.google.android.libraries.navigation.internal.ic.a aVar, k kVar) {
        if (kVar.e) {
            return;
        }
        kVar.c(aVar);
    }

    private final void i() {
        if (((Boolean) this.i.get()).booleanValue()) {
            return;
        }
        this.i.set(true);
        try {
            Queue queue = (Queue) this.h.get();
            while (true) {
                h hVar = (h) queue.poll();
                if (hVar == null) {
                    this.i.remove();
                    return;
                }
                h(hVar.a, hVar.b);
            }
        } catch (Throwable th) {
            this.i.remove();
            throw th;
        }
    }

    @Override // com.google.android.libraries.navigation.internal.ia.e
    public final void a(com.google.android.libraries.navigation.internal.ic.a aVar) {
        if (this.j && aVar.aj() && !aVar.a()) {
            return;
        }
        b(aVar);
    }

    @Override // com.google.android.libraries.navigation.internal.ia.e
    public final void b(com.google.android.libraries.navigation.internal.ic.a aVar) {
        c cVar;
        if (this.g != null && aVar.aj()) {
            this.g.c(aVar);
        }
        Class<?> cls = aVar.getClass();
        synchronized (d.a) {
            cVar = (c) d.a.get(cls);
            if (cVar == null) {
                Set<Class> setH = new com.google.android.libraries.navigation.internal.zz.n(new com.google.android.libraries.navigation.internal.zz.h(cls)).h();
                fw fwVar = new fw();
                for (Class cls2 : setH) {
                    if (cls2.isAnnotationPresent(com.google.android.libraries.navigation.internal.ib.a.class)) {
                        fwVar.c(cls2);
                    }
                }
                c cVar2 = new c(setH, fwVar.i());
                d.a.put(cls, cVar2);
                cVar = cVar2;
            }
        }
        this.d.readLock().lock();
        try {
            if (!cVar.b.isEmpty()) {
                this.e.b(aVar, cVar.b);
            }
            boolean z = false;
            for (Class cls3 : cVar.a) {
                if (this.b.s(cls3)) {
                    Iterator it2 = this.b.c(cls3).iterator();
                    while (it2.hasNext()) {
                        g(aVar, (k) it2.next());
                    }
                    z = true;
                }
            }
            this.d.readLock().unlock();
            if (!z) {
                aVar.getClass();
            }
            i();
        } catch (Throwable th) {
            this.d.readLock().unlock();
            throw th;
        }
    }

    @Override // com.google.android.libraries.navigation.internal.ia.e
    public final void c(Object obj, gc gcVar) {
        com.google.android.libraries.navigation.internal.nw.d dVarD;
        Class<?> cls = obj.getClass();
        if (Trace.isEnabled()) {
            String name = cls.getName();
            String[] strArr = com.google.android.libraries.navigation.internal.nw.e.a;
            int length = 0;
            for (int i = 0; i < 4; i++) {
                String str = strArr[i];
                if (!name.startsWith(str, length)) {
                    break;
                }
                length += str.length();
            }
            dVarD = com.google.android.libraries.navigation.internal.nw.e.d("GmmEventBusImpl.register ".concat(String.valueOf(name.substring(length))));
        } else {
            dVarD = null;
        }
        try {
            ev evVarO = ev.o(gcVar.f());
            this.d.writeLock().lock();
            try {
                if (this.c.containsKey(obj)) {
                    ((com.google.android.libraries.navigation.internal.zb.h) a.d(com.google.android.libraries.navigation.internal.nl.a.a).F(717)).s("Tried to register %s twice.", obj);
                    this.d.writeLock().unlock();
                } else {
                    this.c.put(obj, evVarO);
                    this.b.B(gcVar);
                    this.e.a(gcVar);
                    this.d.writeLock().unlock();
                    i();
                }
                if (dVarD != null) {
                    Trace.endSection();
                }
            } catch (Throwable th) {
                this.d.writeLock().unlock();
                throw th;
            }
        } catch (Throwable th2) {
            if (dVarD != null) {
                try {
                    Trace.endSection();
                } catch (Throwable th3) {
                    th2.addSuppressed(th3);
                }
            }
            throw th2;
        }
    }

    @Override // com.google.android.libraries.navigation.internal.ia.e
    public final synchronized void d() {
        this.j = false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.libraries.navigation.internal.ia.e
    public final void e(Object obj) {
        this.d.writeLock().lock();
        try {
            ev evVar = (ev) this.c.remove(obj);
            if (evVar == null) {
                ((com.google.android.libraries.navigation.internal.zb.h) a.d(com.google.android.libraries.navigation.internal.nl.a.a).F(718)).s("Can't find handler to unregister. Was %s registered?", obj);
                this.d.writeLock().unlock();
                return;
            }
            no it2 = evVar.iterator();
            while (it2.hasNext()) {
                k kVar = (k) it2.next();
                ar.k(this.b.C(kVar.d, kVar));
                ar.k(!kVar.e);
                kVar.e = true;
            }
            this.d.writeLock().unlock();
            i();
        } catch (Throwable th) {
            this.d.writeLock().unlock();
            throw th;
        }
    }

    @Override // com.google.android.libraries.navigation.internal.ia.e
    public final synchronized void f() {
        if (this.j) {
            return;
        }
        this.j = true;
    }

    final void g(final com.google.android.libraries.navigation.internal.ic.a aVar, final k kVar) {
        ap apVar = kVar.a;
        if (ap.i(apVar) && !apVar.j()) {
            ((Queue) this.h.get()).offer(new h(aVar, kVar));
            return;
        }
        final n nVar = this.f;
        Executor executorA = kVar.b;
        if (executorA == null) {
            ar.o(n.a.contains(apVar), "Must pass Executor for Threads value '%s' to register()", apVar.name());
            executorA = nVar.b.a(apVar);
        }
        executorA.execute(new Runnable() { // from class: com.google.android.libraries.navigation.internal.ia.m
            @Override // java.lang.Runnable
            public final void run() {
                i.h(aVar, kVar);
            }
        });
    }
}
