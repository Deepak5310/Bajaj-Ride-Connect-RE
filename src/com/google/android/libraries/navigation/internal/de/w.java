package com.google.android.libraries.navigation.internal.de;

import com.google.android.libraries.navigation.internal.yx.ar;
import java.util.Iterator;
import java.util.WeakHashMap;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class w {
    public static final long a = TimeUnit.MINUTES.toMillis(10);
    public final com.google.android.libraries.navigation.internal.mj.a b;
    public long j;
    public float k;
    public Float l;
    public final l m;
    private int o;
    private int p;
    public final WeakHashMap c = new WeakHashMap();
    public int d = -1;
    public float e = Float.NaN;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private float f391n = Float.NaN;
    public float f = -1.0f;
    public float g = -1000.0f;
    public float h = -1.0f;
    public float i = Float.MAX_VALUE;

    public w(l lVar, com.google.android.libraries.navigation.internal.mj.a aVar) {
        this.m = lVar;
        ar.q(aVar);
        this.b = aVar;
    }

    public final com.google.android.libraries.navigation.internal.db.r a() {
        return this.m.a();
    }

    public final void b() {
        Iterator it2 = this.c.keySet().iterator();
        while (it2.hasNext()) {
            ((h) it2.next()).a(this.d);
        }
    }

    public final void c() {
        Iterator it2 = this.c.keySet().iterator();
        while (it2.hasNext()) {
            ((h) it2.next()).b(this.f, this.g, this.l, f() ? Float.valueOf(this.e) : null, this.o, this.p, this.h, this.i);
        }
    }

    public final void d() {
        this.e = Float.NaN;
    }

    public final void e(float f) {
        float f2 = this.f391n;
        int i = (int) f;
        if (Float.isNaN(f2) || Math.abs(f - f2) > 10.0f || com.google.android.libraries.navigation.internal.cw.o.a(i) >= 3) {
            this.d = com.google.android.libraries.navigation.internal.cw.o.a(i);
            b();
            this.f391n = f;
        }
        this.e = f;
    }

    public final boolean f() {
        return !Float.isNaN(this.e);
    }

    public final void g(int i, int i2) {
        this.o = i;
        this.p = i2;
    }
}
