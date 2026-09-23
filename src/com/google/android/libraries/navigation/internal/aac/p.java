package com.google.android.libraries.navigation.internal.aac;

import androidx.concurrent.futures.AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0;
import java.util.Set;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class p extends o {
    final AtomicReferenceFieldUpdater a;
    final AtomicIntegerFieldUpdater b;

    public p(AtomicReferenceFieldUpdater atomicReferenceFieldUpdater, AtomicIntegerFieldUpdater atomicIntegerFieldUpdater) {
        this.a = atomicReferenceFieldUpdater;
        this.b = atomicIntegerFieldUpdater;
    }

    @Override // com.google.android.libraries.navigation.internal.aac.o
    public final int a(r rVar) {
        return this.b.decrementAndGet(rVar);
    }

    @Override // com.google.android.libraries.navigation.internal.aac.o
    public final void b(r rVar, Set set) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
        do {
            atomicReferenceFieldUpdater = this.a;
            if (AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0.m(atomicReferenceFieldUpdater, rVar, null, set)) {
                return;
            }
        } while (atomicReferenceFieldUpdater.get(rVar) == null);
    }
}
