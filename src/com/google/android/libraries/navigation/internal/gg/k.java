package com.google.android.libraries.navigation.internal.gg;

import com.google.android.libraries.navigation.internal.aac.ca;
import j$.time.Duration;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class k {
    public static final /* synthetic */ int B = 0;
    static final Duration a = Duration.ofSeconds(2);
    public final int A;
    public Duration b = l.b;
    public Duration c;
    public Duration d;
    public Duration e;
    public Duration f;
    public Duration g;
    public Duration h;
    public Duration i;
    public Duration j;
    public Duration k;
    public Duration l;
    public Duration m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public Duration f436n;
    public Duration o;
    public Duration p;
    public Duration q;
    public Duration r;
    public Duration s;
    public final AtomicReference t;
    public final AtomicReference u;
    public final AtomicReference v;
    public final AtomicReference w;
    public Duration x;
    public m y;
    public final ca z;

    public k(int i) {
        Duration duration = l.b;
        this.c = duration;
        this.d = duration;
        this.e = duration;
        this.f = duration;
        this.g = duration;
        this.h = duration;
        this.i = duration;
        this.j = duration;
        this.k = duration;
        this.l = duration;
        this.m = duration;
        this.f436n = duration;
        this.o = duration;
        this.p = duration;
        this.q = duration;
        this.r = duration;
        this.s = duration;
        this.t = new AtomicReference(Duration.ZERO);
        this.u = new AtomicReference(Duration.ZERO);
        this.v = new AtomicReference(Duration.ZERO);
        this.w = new AtomicReference(Duration.ZERO);
        this.x = Duration.ZERO;
        this.z = new ca();
        this.A = i;
        this.y = m.INITIALIZED;
    }

    public final void a() {
        if (this.z.isDone()) {
            return;
        }
        this.z.d(l.y(this));
    }

    public final void b(Duration duration) {
        this.v.set(duration);
        this.y = m.FIRST_BYTE_READ_FROM_WIRE;
    }

    public final void c(Duration duration) {
        this.t.set(duration);
        this.y = m.FIRST_BYTE_WRITTEN_TO_WIRE;
    }

    public final void d(Duration duration) {
        this.w.set(duration);
        this.y = m.LAST_BYTE_READ_FROM_WIRE;
    }

    public final void e(Duration duration) {
        this.u.set(duration);
        this.y = m.LAST_BYTE_WRITTEN_TO_WIRE;
    }
}
