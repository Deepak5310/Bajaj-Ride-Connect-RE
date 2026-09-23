package com.google.android.libraries.navigation.internal.xe;

import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class g implements c {
    private static final com.google.android.libraries.navigation.internal.zb.j h = com.google.android.libraries.navigation.internal.zb.j.e("com.google.android.libraries.navigation.internal.xe.g");
    public final com.google.android.libraries.navigation.internal.ia.b a;
    public final Context b;
    public final ScheduledExecutorService c;
    public final h g;
    private final String i;
    public final AtomicBoolean d = new AtomicBoolean(false);
    public volatile boolean e = false;
    private volatile ScheduledFuture j = null;
    public final BroadcastReceiver f = new f(this);

    public g(Context context, com.google.android.libraries.navigation.internal.ia.b bVar, h hVar, ScheduledExecutorService scheduledExecutorService) {
        this.a = bVar;
        this.g = hVar;
        this.c = scheduledExecutorService;
        Application applicationA = com.google.android.libraries.navigation.internal.abf.b.a(context);
        this.b = applicationA;
        this.i = applicationA.getPackageName();
    }

    @Override // com.google.android.libraries.navigation.internal.xe.c
    public final void a() {
        if (this.d.compareAndSet(true, false)) {
            try {
                this.b.unregisterReceiver(this.f);
            } catch (RuntimeException unused) {
                ((com.google.android.libraries.navigation.internal.zb.h) com.google.android.libraries.navigation.internal.zb.j.b.F(1998)).p("Failed to unregister receiver");
            } finally {
                this.e = false;
                this.j = null;
            }
        }
    }

    public final Intent b(String str) {
        return new Intent(str).setPackage(this.i);
    }

    public final synchronized void c() {
        if (!this.e && this.d.get()) {
            try {
                if (this.j != null && !this.j.isDone()) {
                    this.j.cancel(false);
                }
                this.j = this.c.schedule(new Runnable() { // from class: com.google.android.libraries.navigation.internal.xe.d
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.a.d();
                    }
                }, 30L, TimeUnit.SECONDS);
            } catch (RejectedExecutionException unused) {
                ((com.google.android.libraries.navigation.internal.zb.h) com.google.android.libraries.navigation.internal.zb.j.b.F((char) 1996)).p("Failed to schedule broadcast self unregister task");
            }
        }
    }

    public final synchronized void d() {
        if (!this.e) {
            a();
        }
        this.j = null;
    }
}
