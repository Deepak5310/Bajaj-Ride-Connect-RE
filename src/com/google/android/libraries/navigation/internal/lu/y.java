package com.google.android.libraries.navigation.internal.lu;

import android.os.WorkSource;
import com.google.android.libraries.navigation.internal.lh.be;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class y {
    public int a;
    public long b;
    public long c;
    public long d;
    public long e;
    public int f;
    public float g;
    public boolean h;
    public long i;
    public int j;
    public int k;
    public boolean l;
    public WorkSource m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public com.google.android.libraries.navigation.internal.lr.a f483n;

    public y(z zVar) {
        int i = zVar.a;
        long j = zVar.b;
        this.a = 102;
        this.c = -1L;
        this.d = 0L;
        this.e = Long.MAX_VALUE;
        this.f = Integer.MAX_VALUE;
        this.g = 0.0f;
        boolean z = true;
        this.h = true;
        this.i = -1L;
        this.j = 0;
        this.k = 0;
        this.l = false;
        this.m = null;
        this.f483n = null;
        be.b(j >= 0, "intervalMillis must be greater than or equal to 0");
        this.b = j;
        ae.b(i);
        this.a = i;
        long j2 = zVar.c;
        be.b(j2 == -1 || j2 >= 0, "minUpdateIntervalMillis must be greater than or equal to 0, or IMPLICIT_MIN_UPDATE_INTERVAL");
        this.c = j2;
        long j3 = zVar.d;
        be.b(j3 >= 0, "maxUpdateDelayMillis must be greater than or equal to 0");
        this.d = j3;
        long j4 = zVar.e;
        be.b(j4 > 0, "durationMillis must be greater than 0");
        this.e = j4;
        int i2 = zVar.f;
        be.b(i2 > 0, "maxUpdates must be greater than 0");
        this.f = i2;
        float f = zVar.g;
        be.b(f >= 0.0f, "minUpdateDistanceMeters must be greater than or equal to 0");
        this.g = f;
        this.h = zVar.h;
        b(zVar.i);
        a(zVar.j);
        c(zVar.k);
        this.l = zVar.l;
        this.m = zVar.m;
        com.google.android.libraries.navigation.internal.lr.a aVar = zVar.f484n;
        if (aVar != null && aVar.a()) {
            z = false;
        }
        be.a(z);
        this.f483n = aVar;
    }

    public final void a(int i) {
        int i2;
        boolean z = true;
        if (i == 0 || i == 1) {
            i2 = i;
        } else {
            i2 = 2;
            if (i != 2) {
                z = false;
                i2 = i;
            }
        }
        be.c(z, "granularity %d must be a Granularity.GRANULARITY_* constant", Integer.valueOf(i2));
        this.j = i;
    }

    public final void b(long j) {
        boolean z = true;
        if (j != -1 && j < 0) {
            z = false;
        }
        be.b(z, "maxUpdateAgeMillis must be greater than or equal to 0, or IMPLICIT_MAX_UPDATE_AGE");
        this.i = j;
    }

    public final void c(int i) {
        int i2;
        boolean z = true;
        if (i == 0 || i == 1) {
            i2 = i;
        } else {
            i2 = 2;
            if (i != 2) {
                z = false;
                i2 = i;
            }
        }
        be.c(z, "throttle behavior %d must be a ThrottleBehavior.THROTTLE_* constant", Integer.valueOf(i2));
        this.k = i;
    }
}
