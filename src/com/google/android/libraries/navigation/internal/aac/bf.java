package com.google.android.libraries.navigation.internal.aac;

import java.util.concurrent.locks.AbstractOwnableSynchronizer;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class bf extends AbstractOwnableSynchronizer implements Runnable {
    private final bh a;

    public bf(bh bhVar) {
        this.a = bhVar;
    }

    public final void a(Thread thread) {
        super.setExclusiveOwnerThread(thread);
    }

    @Override // java.lang.Runnable
    public final void run() {
    }

    public final String toString() {
        return this.a.toString();
    }
}
