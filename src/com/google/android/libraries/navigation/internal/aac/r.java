package com.google.android.libraries.navigation.internal.aac;

import java.util.Set;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.logging.Level;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
abstract class r extends d.i {
    private static final bi Dp = new bi(r.class);
    public static final o a;
    public volatile int remaining;
    public volatile Set<Throwable> seenExceptions = null;

    static {
        Throwable th;
        o qVar;
        try {
            qVar = new p(AtomicReferenceFieldUpdater.newUpdater(r.class, Set.class, "seenExceptions"), AtomicIntegerFieldUpdater.newUpdater(r.class, "remaining"));
            th = null;
        } catch (Throwable th2) {
            th = th2;
            qVar = new q();
        }
        Throwable th3 = th;
        a = qVar;
        if (th3 != null) {
            Dp.a().logp(Level.SEVERE, "com.google.common.util.concurrent.AggregateFutureState", "<clinit>", "SafeAtomicHelper is broken!", th3);
        }
    }

    public r(int i) {
        this.remaining = i;
    }

    public abstract void f(Set set);
}
