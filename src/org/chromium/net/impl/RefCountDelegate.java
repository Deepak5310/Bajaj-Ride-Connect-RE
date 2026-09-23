package org.chromium.net.impl;

import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes5.dex */
public final class RefCountDelegate {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final AtomicInteger mCount = new AtomicInteger(1);
    private final Runnable mDelegate;

    public RefCountDelegate(Runnable runnable) {
        this.mDelegate = runnable;
    }

    public void increment() {
        this.mCount.incrementAndGet();
    }

    public void decrement() {
        if (this.mCount.decrementAndGet() == 0) {
            this.mDelegate.run();
        }
    }
}
