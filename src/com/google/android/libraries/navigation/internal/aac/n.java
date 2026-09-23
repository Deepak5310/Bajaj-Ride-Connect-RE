package com.google.android.libraries.navigation.internal.aac;

import com.google.android.libraries.navigation.internal.yz.ek;
import com.google.android.libraries.navigation.internal.yz.mp;
import com.google.android.libraries.navigation.internal.yz.nn;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.logging.Level;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
abstract class n extends r {
    private static final bi b = new bi(n.class);
    private ek c;
    private final boolean d;
    private final boolean e;

    public n(ek ekVar, boolean z, boolean z2) {
        super(ekVar.size());
        com.google.android.libraries.navigation.internal.yx.ar.q(ekVar);
        this.c = ekVar;
        this.d = z;
        this.e = z2;
    }

    private final void t(int i, Future future) {
        try {
            g(i, ck.a(future));
        } catch (ExecutionException e) {
            u(e.getCause());
        } catch (Throwable th) {
            u(th);
        }
    }

    private final void u(Throwable th) {
        com.google.android.libraries.navigation.internal.yx.ar.q(th);
        if (this.d && !ap(th)) {
            Set<Throwable> set = this.seenExceptions;
            if (set == null) {
                Set setI = mp.i();
                f(setI);
                r.a.b(this, setI);
                set = (Set) Objects.requireNonNull(this.seenExceptions);
            }
            if (w(set, th)) {
                v(th);
                return;
            }
        }
        if (th instanceof Error) {
            v(th);
        }
    }

    private static void v(Throwable th) {
        b.a().logp(Level.SEVERE, "com.google.common.util.concurrent.AggregateFuture", "log", true != (th instanceof Error) ? "Got more than one input Future failure. Logging failures after the first" : "Input Future failed with Error", th);
    }

    private static boolean w(Set set, Throwable th) {
        while (th != null) {
            if (!set.add(th)) {
                return false;
            }
            th = th.getCause();
        }
        return true;
    }

    @Override // com.google.android.libraries.navigation.internal.aac.d
    protected final String ao() {
        ek ekVar = this.c;
        return ekVar != null ? "futures=".concat(ekVar.toString()) : super.ao();
    }

    @Override // com.google.android.libraries.navigation.internal.aac.d
    protected final void b() {
        ek ekVar = this.c;
        s(m.OUTPUT_FUTURE_DONE);
        if (isCancelled() && (ekVar != null)) {
            boolean zP = p();
            nn nnVarListIterator = ekVar.listIterator();
            while (nnVarListIterator.hasNext()) {
                ((Future) nnVarListIterator.next()).cancel(zP);
            }
        }
    }

    @Override // com.google.android.libraries.navigation.internal.aac.r
    public final void f(Set set) {
        com.google.android.libraries.navigation.internal.yx.ar.q(set);
        if (isCancelled()) {
            return;
        }
        w(set, (Throwable) Objects.requireNonNull(k()));
    }

    public abstract void g(int i, Object obj);

    public final void h(ek ekVar) {
        int iA = r.a.a(this);
        int i = 0;
        com.google.android.libraries.navigation.internal.yx.ar.l(iA >= 0, "Less than 0 remaining futures");
        if (iA == 0) {
            if (ekVar != null) {
                nn nnVarListIterator = ekVar.listIterator();
                while (nnVarListIterator.hasNext()) {
                    Future future = (Future) nnVarListIterator.next();
                    if (!future.isCancelled()) {
                        t(i, future);
                    }
                    i++;
                }
            }
            this.seenExceptions = null;
            i();
            s(m.ALL_INPUT_FUTURES_PROCESSED);
        }
    }

    public abstract void i();

    final void q() {
        Objects.requireNonNull(this.c);
        if (this.c.isEmpty()) {
            i();
            return;
        }
        if (this.d) {
            nn nnVarListIterator = this.c.listIterator();
            final int i = 0;
            while (nnVarListIterator.hasNext()) {
                final bj bjVar = (bj) nnVarListIterator.next();
                int i2 = i + 1;
                if (bjVar.isDone()) {
                    r(i, bjVar);
                } else {
                    bjVar.l(new Runnable() { // from class: com.google.android.libraries.navigation.internal.aac.k
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.a.r(i, bjVar);
                        }
                    }, ac.INSTANCE);
                }
                i = i2;
            }
            return;
        }
        ek ekVar = this.c;
        final ek ekVar2 = true != this.e ? null : ekVar;
        Runnable runnable = new Runnable() { // from class: com.google.android.libraries.navigation.internal.aac.l
            @Override // java.lang.Runnable
            public final void run() {
                this.a.h(ekVar2);
            }
        };
        nn nnVarListIterator2 = ekVar.listIterator();
        while (nnVarListIterator2.hasNext()) {
            bj bjVar2 = (bj) nnVarListIterator2.next();
            if (bjVar2.isDone()) {
                h(ekVar2);
            } else {
                bjVar2.l(runnable, ac.INSTANCE);
            }
        }
    }

    public final void r(int i, bj bjVar) {
        try {
            if (bjVar.isCancelled()) {
                this.c = null;
                cancel(false);
            } else {
                t(i, bjVar);
            }
        } finally {
            h((ek) null);
        }
    }

    public void s(m mVar) {
        com.google.android.libraries.navigation.internal.yx.ar.q(mVar);
        this.c = null;
    }
}
