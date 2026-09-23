package com.google.android.libraries.navigation.internal.xa;

import com.google.android.libraries.navigation.internal.fq.d;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public abstract class b {
    private static final String b = "b";
    public final Set a;
    private final int c;
    private ScheduledExecutorService d;
    private ScheduledFuture e;
    private final a f;

    public b(ScheduledExecutorService scheduledExecutorService, int i) {
        this.d = scheduledExecutorService;
        this.f = new a(this);
        this.c = i;
        this.a = new HashSet();
    }

    private final synchronized void d() {
        if (this.e != null || this.a.isEmpty()) {
            return;
        }
        this.e = this.d.scheduleAtFixedRate(this.f, 0L, this.c, TimeUnit.MILLISECONDS);
    }

    private final synchronized void e() {
        if (this.e == null || !this.a.isEmpty()) {
            return;
        }
        this.e.cancel(true);
        this.e = null;
    }

    public abstract Object a();

    public final synchronized void b(d dVar) {
        com.google.android.libraries.navigation.internal.xx.a.a(dVar != null);
        this.a.add(dVar);
        d();
    }

    public final synchronized void c(d dVar) {
        com.google.android.libraries.navigation.internal.xx.a.a(dVar != null);
        if (this.a.remove(dVar)) {
            e();
        }
    }

    public b(ThreadFactory threadFactory, int i) {
        this(Executors.newSingleThreadScheduledExecutor(), i);
    }
}
