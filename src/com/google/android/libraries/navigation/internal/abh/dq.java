package com.google.android.libraries.navigation.internal.abh;

import android.os.Looper;
import android.os.WorkSource;
import org.apache.commons.lang3.time.DateUtils;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class dq extends Cdo {
    static final com.google.android.libraries.navigation.internal.lu.z a;
    public static final /* synthetic */ int c = 0;
    private static final String d = "dq";
    public com.google.android.libraries.navigation.internal.ly.ar b;
    private final com.google.android.libraries.navigation.internal.lu.m e;
    private boolean f;
    private final com.google.android.libraries.navigation.internal.lu.x g;
    private final id h;

    static {
        com.google.android.libraries.navigation.internal.lu.z zVar = new com.google.android.libraries.navigation.internal.lu.z(102, DateUtils.MILLIS_PER_HOUR, 600000L, 0L, Long.MAX_VALUE, Long.MAX_VALUE, Integer.MAX_VALUE, 0.0f, true, DateUtils.MILLIS_PER_HOUR, 0, 0, false, new WorkSource(), null);
        com.google.android.libraries.navigation.internal.lh.be.b(true, "intervalMillis must be greater than or equal to 0");
        long j = zVar.c;
        long j2 = zVar.b;
        if (j == j2 / 6) {
            zVar.c = 833L;
        }
        if (zVar.i == j2) {
            zVar.i = 5000L;
        }
        zVar.b = 5000L;
        com.google.android.libraries.navigation.internal.lh.be.c(true, "illegal fastest interval: %d", 16L);
        zVar.c = 16L;
        a = zVar;
    }

    public dq(com.google.android.libraries.navigation.internal.lu.m mVar, id idVar) {
        this.e = mVar;
        com.google.android.libraries.navigation.internal.abf.s.k(idVar, "versionManager");
        this.h = idVar;
        this.g = new dp(this);
    }

    private final void f() {
        this.e.a(this.g);
    }

    @Override // com.google.android.libraries.navigation.internal.ly.o
    public final void a(com.google.android.libraries.navigation.internal.ly.ar arVar) {
        com.google.android.libraries.navigation.internal.abf.s.d(this.b == null, "already activated");
        this.b = arVar;
        if (this.f) {
            e();
        }
    }

    @Override // com.google.android.libraries.navigation.internal.ly.o
    public final void b() {
        com.google.android.libraries.navigation.internal.abf.s.d(this.b != null, "already activated");
        this.b = null;
        if (this.f) {
            f();
        }
    }

    @Override // com.google.android.libraries.navigation.internal.abh.Cdo
    public final void c() {
        if (this.b != null) {
            f();
        }
        this.f = false;
    }

    @Override // com.google.android.libraries.navigation.internal.abh.Cdo
    public final void d() {
        this.f = true;
        if (this.b != null) {
            e();
        }
    }

    private final void e() {
        try {
            this.e.b(a, this.g, Looper.getMainLooper());
        } catch (SecurityException e) {
            com.google.android.libraries.navigation.internal.abf.p.f(d, 6);
            throw e;
        }
    }
}
