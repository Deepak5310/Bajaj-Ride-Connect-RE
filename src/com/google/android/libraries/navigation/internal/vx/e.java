package com.google.android.libraries.navigation.internal.vx;

import com.google.android.libraries.navigation.internal.aac.bz;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class e {
    public com.google.android.libraries.navigation.internal.cw.c a;
    public final Executor c;
    public final ConcurrentLinkedDeque b = new ConcurrentLinkedDeque();
    public final AtomicBoolean d = new AtomicBoolean(false);

    public e(Executor executor) {
        this.c = new bz(executor);
    }
}
