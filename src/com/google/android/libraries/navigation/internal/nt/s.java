package com.google.android.libraries.navigation.internal.nt;

import com.google.android.libraries.navigation.internal.aac.bj;
import com.google.android.libraries.navigation.internal.yx.ar;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
abstract class s {
    private final ab a;
    public final ThreadLocal c = new q();
    private final ReadWriteLock b = new ReentrantReadWriteLock();
    private final Map d = new LinkedHashMap();
    private final ThreadLocal e = new r();

    public s(ab abVar) {
        this.a = abVar;
    }

    private final void c(u uVar, Executor executor) {
        ar.q(uVar);
        ar.q(executor);
        this.b.writeLock().lock();
        try {
            if (this.d.containsKey(uVar)) {
                throw new IllegalArgumentException("Observer already added");
            }
            this.d.put(uVar, new aa(uVar, executor, this.a));
            this.b.writeLock().unlock();
            k();
        } catch (Throwable th) {
            this.b.writeLock().unlock();
            throw th;
        }
    }

    protected abstract bj d();

    protected void k() {
    }

    protected final void o(u uVar, Executor executor) {
        u();
        this.b.writeLock().lock();
        try {
            c(uVar, executor);
            aa aaVar = (aa) this.d.get(uVar);
            this.b.writeLock().unlock();
            if (!d().isDone() || aaVar == null) {
                return;
            }
            aaVar.b(this);
        } catch (Throwable th) {
            this.b.writeLock().unlock();
            throw th;
        }
    }

    protected final void p(u uVar, Executor executor) {
        u();
        c(uVar, executor);
    }

    final void q(boolean z) {
        this.e.set(Boolean.valueOf(z));
    }

    public final void r() {
        ar.k(!((Boolean) this.e.get()).booleanValue());
        this.b.readLock().lock();
        try {
            ArrayList arrayList = null;
            for (Map.Entry entry : this.d.entrySet()) {
                u uVar = (u) entry.getKey();
                if (uVar instanceof ad) {
                    ar.k(true);
                    ad adVar = (ad) uVar;
                    u uVar2 = (u) adVar.a.get();
                    if ((uVar2 != null ? ad.b(uVar2) : null) == null) {
                        if (arrayList == null) {
                            arrayList = new ArrayList();
                        }
                        arrayList.add(adVar);
                    }
                }
                ((k) this.c.get()).a.offer((aa) entry.getValue());
            }
            this.b.readLock().unlock();
            if (arrayList != null) {
                this.b.writeLock().lock();
                try {
                    this.d.keySet().removeAll(arrayList);
                    this.b.writeLock().unlock();
                    k();
                } catch (Throwable th) {
                    this.b.writeLock().unlock();
                    throw th;
                }
            }
        } catch (Throwable th2) {
            this.b.readLock().unlock();
            throw th2;
        }
    }

    protected final void s(u uVar) {
        ar.q(uVar);
        this.b.writeLock().lock();
        try {
            aa aaVar = (aa) this.d.get(uVar);
            if (aaVar == null) {
                throw new IllegalArgumentException("removeObserver can only be called after addObserver is called");
            }
            aaVar.a();
            this.d.remove(uVar);
            this.b.writeLock().unlock();
            k();
        } catch (Throwable th) {
            this.b.writeLock().unlock();
            throw th;
        }
    }

    public final int t() {
        this.b.readLock().lock();
        try {
            return this.d.size();
        } finally {
            this.b.readLock().unlock();
        }
    }

    protected void u() {
    }
}
